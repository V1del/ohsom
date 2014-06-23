package gui;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Insets;

import javax.swing.SwingConstants;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import bl.BLNachrichten;

import com.mysql.jdbc.Constants;

public class MessagesGUI extends JFrame implements ActionListener {
	private BLNachrichten blN = new BLNachrichten();
	private JButton btnHelp;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnNachrichtVerfassen;
	private JScrollPane scrollPane;
	private JTable tblNachrichten;
	private JPanel panel_3;
	private JLabel lblSeite;
	private JButton btnZurueck;
	private JButton btnVorwaerts;

	public MessagesGUI() throws SQLException {
		super("Nachrichten");

		panel = new JPanel();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panel, BorderLayout.NORTH);

		btnHelp = new JButton("?");
		panel.add(btnHelp);
		btnHelp.setHorizontalAlignment(SwingConstants.LEFT);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Posteingang (0/2)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 20));

		scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);

		tblNachrichten = new JTable();
		tblNachrichten.setModel(new DefaultTableModel(
				blN.getNachrichtenData(),
				new String[] {
					"Schreiber", "gelesen", "Titel", "Zeitpunkt", "lesen?", "l\u00F6schen"
				}
				));

		tblNachrichten.getColumnModel().getColumn(2).setPreferredWidth(240);
		tblNachrichten.getColumnModel().getColumn(3).setPreferredWidth(182);
		scrollPane.setViewportView(tblNachrichten);

		panel_3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setHgap(30);
		panel_1.add(panel_3, BorderLayout.SOUTH);

		btnZurueck = new JButton("<< zur�ckbl�ttern");

		btnZurueck.setMargin(new Insets(0, 0, 0, 0));
		btnZurueck.setContentAreaFilled(false);
		btnZurueck.setBorderPainted(false);
		btnZurueck.setOpaque(false);

		panel_3.add(btnZurueck);

		lblSeite = new JLabel("S 1 / 1");
		panel_3.add(lblSeite);

		btnVorwaerts = new JButton("vorw�rtsbl�ttern >>");

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
}
