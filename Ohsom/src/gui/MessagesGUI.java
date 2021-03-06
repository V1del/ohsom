package gui;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;

import javax.swing.SwingConstants;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import bl.BLNachrichten;
import bo.Nachricht;

import com.mysql.jdbc.Constants;

/**
 * Gui f�r die Nachrichten�bersicht
 * @author Snatsch
 *
 */
public class MessagesGUI extends JDialog implements ActionListener, ListSelectionListener {
	private BLNachrichten blN = new BLNachrichten();
	private JPanel pnlHeaderMessages;
	private JLabel lblWarning = new JLabel("Warning: Dein Postfach ist voll!");
	private JPanel pnlNachrichten;
	private JPanel panel_2;
	private JButton btnNachrichtVerfassen;
	private JScrollPane scrollPane;
	private JTable tblNachrichten;
	private Map<Integer, Nachricht> Messages = new HashMap<Integer, Nachricht>(); 

	private MessageThread mThread = new MessageThread(this);

	private JPanel pnlMessageOptions;
	private JButton btnDelete, btnRead;

	private int currentlySelectedNachrichtIndex = 0;

	private JPanel panel_3;

	public MessagesGUI() throws SQLException
	{	
		initialize();	
	}

	public void initialize() throws SQLException {
		new JDialog();
		setTitle("Nachrichten");
		setModal(true);
		this.setIconImage(new ImageIcon("Sources/gfx/Icon_Ohsom.png").getImage());

		pnlHeaderMessages = new JPanel();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		FlowLayout flowLayout = (FlowLayout) pnlHeaderMessages.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		getContentPane().add(pnlHeaderMessages, BorderLayout.NORTH);

		lblWarning.setVisible(false);
		lblWarning.setForeground(Color.red);
		pnlHeaderMessages.add(lblWarning);

		pnlNachrichten = new JPanel();
	
		//
		
		int allMessages = blN.getCountOfAllNachrichten();
		int unreadMessages = blN.getCountOfUnreadNachrichten();
		pnlNachrichten.setBorder(new TitledBorder(null, "Posteingang ("+ unreadMessages +"/" + allMessages + ")", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(pnlNachrichten, BorderLayout.CENTER);
		pnlNachrichten.setLayout(new BorderLayout(0, 20));

		if(allMessages == 20)
		{
			lblWarning.setVisible(true);
		}

		scrollPane = new JScrollPane();
		pnlNachrichten.add(scrollPane, BorderLayout.CENTER);

		tblNachrichten = new JTable();
		tblNachrichten.setModel(new DefaultTableModel(
				blN.getNachrichtenData(),
				new String[] {
					"id", "Schreiber", "gelesen", "Titel", "Zeitpunkt"
				}
				));

		tblNachrichten.getColumnModel().getColumn(0).setMinWidth(0);
		tblNachrichten.getColumnModel().getColumn(0).setMaxWidth(0);
		tblNachrichten.getColumnModel().getColumn(0).setWidth(0);

		tblNachrichten.getColumnModel().getColumn(2).setPreferredWidth(240);
		tblNachrichten.getColumnModel().getColumn(3).setPreferredWidth(182);
		tblNachrichten.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblNachrichten.getSelectionModel().addListSelectionListener(this);
		scrollPane.setViewportView(tblNachrichten);

		mThread.start();
		
		panel_3 = new JPanel();
		panel_3.setLayout(new BorderLayout());
		//FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		//flowLayout_2.setHgap(30);
		pnlNachrichten.add(panel_3, BorderLayout.SOUTH);

		pnlMessageOptions = new JPanel();
		pnlMessageOptions.setVisible(false);
		pnlMessageOptions.setBorder(new TitledBorder(null, "Was ist mit dieser Nachricht zu tun?", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		panel_3.add(pnlMessageOptions, BorderLayout.NORTH);

		btnDelete = new JButton("Delete");	
		btnDelete.addActionListener(this);
		pnlMessageOptions.add(btnDelete);

		btnRead = new JButton("Lesen");
		btnRead.addActionListener(this);
		pnlMessageOptions.add(btnRead);


		panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panel_2, BorderLayout.SOUTH);

		btnNachrichtVerfassen = new JButton("Nachricht verfassen");
		btnNachrichtVerfassen.addActionListener(this);
		btnNachrichtVerfassen.setMargin(new Insets(0, 0, 0, 0));
		btnNachrichtVerfassen.setContentAreaFilled(false);
		btnNachrichtVerfassen.setBorderPainted(false);
		btnNachrichtVerfassen.setOpaque(false);

		panel_2.add(btnNachrichtVerfassen);

		this.pack();
		this.setVisible(true);
		this.requestFocusInWindow();
	}

	/**
	 * Refresh alles, was mit den Nachrichten zu tun hat
	 * @throws SQLException
	 */
	public void refreshDialog() throws SQLException
	{
		int allMessages = blN.getCountOfAllNachrichten();
		int unreadMessages = blN.getCountOfUnreadNachrichten();
		pnlNachrichten.setBorder(new TitledBorder(null, "Posteingang ("+ unreadMessages +"/" + allMessages + ")", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		lblWarning.setVisible(allMessages == 20);
		
		tblNachrichten.setModel(new DefaultTableModel(
				blN.getNachrichtenData(),
				new String[] {
					"id", "Schreiber", "gelesen", "Titel", "Zeitpunkt"
				}
				));
		tblNachrichten.getColumnModel().getColumn(0).setMinWidth(0);
		tblNachrichten.getColumnModel().getColumn(0).setMaxWidth(0);
		tblNachrichten.getColumnModel().getColumn(0).setWidth(0);

		tblNachrichten.getColumnModel().getColumn(2).setPreferredWidth(240);
		tblNachrichten.getColumnModel().getColumn(3).setPreferredWidth(182);
		
/*
		this.repaint();*/
	}

	/**
	 * Actionevents f�r die Nachrichten
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			if(ae.getSource() == btnNachrichtVerfassen)
			{
				new NewMessageGUI(null);
			}
			else if(ae.getSource() == btnDelete)
			{
				if(currentlySelectedNachrichtIndex != 0)
				{
					if(blN.deleteNachricht(blN.getNachricht(currentlySelectedNachrichtIndex)))
					{
						refreshDialog();
					}
				}
			}
			else if(ae.getSource() == btnRead)
			{
				if(currentlySelectedNachrichtIndex != 0)
				{
					NachrichtLesenGUI nlGui = new NachrichtLesenGUI(blN.getNachricht(currentlySelectedNachrichtIndex));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * �berpr�fen ob eine andere Reihe gew�hlt wurde
	 */
	@Override
	public void valueChanged(ListSelectionEvent lse) {
		int indexRow = tblNachrichten.getSelectedRow();
		if(tblNachrichten.getModel().getRowCount() > 0)
		{
			Object RowValues = tblNachrichten.getModel().getValueAt(indexRow, 0);
			currentlySelectedNachrichtIndex = Integer.valueOf(String.valueOf(RowValues));

			pnlMessageOptions.setVisible(true);
		}
		else
		{
			pnlMessageOptions.setVisible(false);
		}
	}
}
