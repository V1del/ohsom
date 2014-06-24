package gui;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import java.awt.BorderLayout;
import java.awt.Insets;

import javax.swing.SwingConstants;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import bl.BLNachrichten;

import com.mysql.jdbc.Constants;

public class MessagesGUI extends JDialog implements ActionListener, MouseListener {
	private BLNachrichten blN = new BLNachrichten();
	private JButton btnHelp;
	private JPanel panel;
	private JPanel pnlNachrichten;
	private JPanel panel_2;
	private JButton btnNachrichtVerfassen;
	private JScrollPane scrollPane;
	private JTable tblNachrichten;
	private JPanel panel_3;
	private JLabel lblSeite;
	private JButton btnZurueck;
	private JButton btnVorwaerts;

	public MessagesGUI() throws SQLException {
		new JDialog();
		setTitle("Nachrichten");

		panel = new JPanel();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panel, BorderLayout.NORTH);

		btnHelp = new JButton("?");
		panel.add(btnHelp);
		btnHelp.setHorizontalAlignment(SwingConstants.LEFT);

		pnlNachrichten = new JPanel();
		countNachrichten();
		getContentPane().add(pnlNachrichten, BorderLayout.CENTER);
		pnlNachrichten.setLayout(new BorderLayout(0, 20));

		scrollPane = new JScrollPane();
		pnlNachrichten.add(scrollPane, BorderLayout.CENTER);

		tblNachrichten = new JTable();
		tblNachrichten.setModel(new DefaultTableModel(
				blN.getNachrichtenData(),
				new String[] {
					"Schreiber", "gelesen", "Titel", "Zeitpunkt"
				}
				));

		tblNachrichten.getColumnModel().getColumn(2).setPreferredWidth(240);
		tblNachrichten.getColumnModel().getColumn(3).setPreferredWidth(182);
		tblNachrichten.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblNachrichten.addMouseListener(this);
		scrollPane.setViewportView(tblNachrichten);

		panel_3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setHgap(30);
		pnlNachrichten.add(panel_3, BorderLayout.SOUTH);

		btnZurueck = new JButton("<< zurückblättern");

		btnZurueck.setMargin(new Insets(0, 0, 0, 0));
		btnZurueck.setContentAreaFilled(false);
		btnZurueck.setBorderPainted(false);
		btnZurueck.setOpaque(false);

		panel_3.add(btnZurueck);

		lblSeite = new JLabel("S 1 / 1");
		panel_3.add(lblSeite);

		btnVorwaerts = new JButton("vorwärtsblättern>>");

		btnVorwaerts.setMargin(new Insets(0, 0, 0, 0));
		btnVorwaerts.setContentAreaFilled(false);
		btnVorwaerts.setBorderPainted(false);
		btnVorwaerts.setOpaque(false);

		panel_3.add(btnVorwaerts);

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
	}

	public void countNachrichten() throws SQLException
	{
		int allMessages = blN.getCountOfAllNachrichten();
		int unreadMessages = blN.getCountOfUnreadNachrichten();
		pnlNachrichten.setBorder(new TitledBorder(null, "Posteingang ("+ unreadMessages +"/" + allMessages + ")", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			if(ae.getSource() == btnNachrichtVerfassen)
			{
				new NewMessageGUI();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
