package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class NachrichtLesenGUI extends JFrame {
	private JPanel panel;
	private JLabel lblTitel;
	private JLabel lblTitelData;
	private JLabel lblZeitpunkt;
	private JLabel label;
	private JLabel lblNachricht;
	private JLabel lblOhsomIstEin;
	private JPanel panel_1;
	private JButton btnAntworten;
	private JButton btnLoeschen;
	
	public NachrichtLesenGUI() {
		super("Nachricht lesen");
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Nachricht von $USER", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		
		lblTitelData = new JLabel("Änderungen");
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
		
		lblOhsomIstEin = new JLabel("Ohsom ist ein schrecklicher Name für ein Tamagotchi");
		lblOhsomIstEin.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblOhsomIstEin = new GridBagConstraints();
		gbc_lblOhsomIstEin.anchor = GridBagConstraints.WEST;
		gbc_lblOhsomIstEin.ipady = 10;
		gbc_lblOhsomIstEin.gridwidth = 10;
		gbc_lblOhsomIstEin.insets = new Insets(0, 0, 0, 5);
		gbc_lblOhsomIstEin.gridx = 1;
		gbc_lblOhsomIstEin.gridy = 4;
		panel.add(lblOhsomIstEin, gbc_lblOhsomIstEin);
		
		panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		btnAntworten = new JButton("Antworten");
		panel_1.add(btnAntworten);
		
		btnLoeschen = new JButton("Löschen");
		panel_1.add(btnLoeschen);
	}

}
