package gui;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.border.TitledBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

import javax.swing.JButton;

import bl.BLNachrichten;
import bl.BLUser;
import bo.Nachricht;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * GUI um Nachrichten zu lesen
 * @author Snatsch
 *
 */
public class NachrichtLesenGUI extends JDialog implements ActionListener {

	private BLNachrichten blN = null;
	private BLUser blU = null;
	
	private Nachricht currentNachrichtTemporary = null;

	private JPanel panel;
	private JLabel lblTitel;
	private JLabel lblTitelData;
	private JLabel lblZeitpunkt;
	private JLabel label;
	private JLabel lblNachricht;
	private JLabel lblNachrichtValue;
	private JPanel pnlNachrichtenControls;
	private JButton btnAntworten;
	private JButton btnLoeschen;

	public NachrichtLesenGUI(Nachricht Nachricht) throws SQLException {
		new JDialog();
		setTitle("Nachricht lesen");
		setModal(true);
		
		blN = new BLNachrichten();
		blU = new BLUser();
		currentNachrichtTemporary = Nachricht;
		
		if(blN.changeNachricht(currentNachrichtTemporary))
		{
			// Konnte erfolgreich gelesen werden
		}
		
		this.setIconImage(new ImageIcon("Sources/gfx/Icon_Ohsom.png").getImage());
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Nachricht von " + Nachricht.getSender().getNickname(), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		lblTitel = new JLabel("Titel");
		GridBagConstraints gbc_lblTitel = new GridBagConstraints();
		gbc_lblTitel.ipady = 10;
		gbc_lblTitel.anchor = GridBagConstraints.WEST;
		gbc_lblTitel.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitel.gridx = 1;
		gbc_lblTitel.gridy = 1;
		panel.add(lblTitel, gbc_lblTitel);

		lblTitelData = new JLabel(Nachricht.getTitel());
		lblTitelData.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblTitelData = new GridBagConstraints();
		gbc_lblTitelData.ipady = 10;
		gbc_lblTitelData.anchor = GridBagConstraints.WEST;
		gbc_lblTitelData.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitelData.gridx = 5;
		gbc_lblTitelData.gridy = 1;
		panel.add(lblTitelData, gbc_lblTitelData);

		lblZeitpunkt = new JLabel("Zeitpunkt");
		GridBagConstraints gbc_lblZeitpunkt = new GridBagConstraints();
		gbc_lblZeitpunkt.ipady = 10;
		gbc_lblZeitpunkt.anchor = GridBagConstraints.WEST;
		gbc_lblZeitpunkt.insets = new Insets(0, 0, 5, 5);
		gbc_lblZeitpunkt.gridx = 1;
		gbc_lblZeitpunkt.gridy = 2;
		panel.add(lblZeitpunkt, gbc_lblZeitpunkt);

		label = new JLabel("10.01.2014 - 10:24");
		label.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.ipady = 10;
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.gridx = 5;
		gbc_label.gridy = 2;
		panel.add(label, gbc_label);

		lblNachricht = new JLabel("Nachricht");
		GridBagConstraints gbc_lblNachricht = new GridBagConstraints();
		gbc_lblNachricht.anchor = GridBagConstraints.WEST;
		gbc_lblNachricht.ipady = 10;
		gbc_lblNachricht.insets = new Insets(0, 0, 5, 5);
		gbc_lblNachricht.gridx = 1;
		gbc_lblNachricht.gridy = 3;
		panel.add(lblNachricht, gbc_lblNachricht);

		lblNachrichtValue = new JLabel(Nachricht.getNachricht());
		lblNachrichtValue.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNachrichtValue = new GridBagConstraints();
		gbc_lblNachrichtValue.anchor = GridBagConstraints.WEST;
		gbc_lblNachrichtValue.ipady = 10;
		gbc_lblNachrichtValue.gridwidth = 10;
		gbc_lblNachrichtValue.insets = new Insets(0, 0, 0, 5);
		gbc_lblNachrichtValue.gridx = 1;
		gbc_lblNachrichtValue.gridy = 4;
		panel.add(lblNachrichtValue, gbc_lblNachrichtValue);

		pnlNachrichtenControls = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlNachrichtenControls.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		getContentPane().add(pnlNachrichtenControls, BorderLayout.SOUTH);

		btnAntworten = new JButton("Antworten");
		btnAntworten.addActionListener(this);
		pnlNachrichtenControls.add(btnAntworten);

		btnLoeschen = new JButton("Löschen");
		btnLoeschen.addActionListener(this);
		pnlNachrichtenControls.add(btnLoeschen);
		
		this.pack();
		this.setVisible(true);
	}	
	
	/**
	 * Methode zur Verarbeitung der Button Klicks (LÃ¶schen und Antworten)
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		try {

			if(ae.getSource() == btnAntworten)
			{
					NewMessageGUI nmg = new NewMessageGUI(currentNachrichtTemporary);
			}
			else
			{
				if(blN.deleteNachricht(currentNachrichtTemporary))
				{
					this.dispose();
				}
			} 
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
