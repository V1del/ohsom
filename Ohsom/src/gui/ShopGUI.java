package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JToggleButton;

public class ShopGUI {

	private JFrame frmShop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopGUI window = new ShopGUI();
					//window.frmShop.pack();
					window.frmShop.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShopGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmShop = new JFrame();
		frmShop.setTitle("Shop");
		frmShop.setBounds(100, 100, 450, 300);
		frmShop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmShop.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Medizin", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblMedizin = new JLabel("Medizin: ");
		GridBagConstraints gbc_lblMedizin = new GridBagConstraints();
		gbc_lblMedizin.insets = new Insets(0, 0, 5, 5);
		gbc_lblMedizin.gridx = 1;
		gbc_lblMedizin.gridy = 1;
		panel.add(lblMedizin, gbc_lblMedizin);
		
		JLabel label = new JLabel("10");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 1;
		panel.add(label, gbc_label);
		
		JLabel lblGeld = new JLabel("Geld: ");
		GridBagConstraints gbc_lblGeld = new GridBagConstraints();
		gbc_lblGeld.insets = new Insets(0, 0, 5, 5);
		gbc_lblGeld.gridx = 4;
		gbc_lblGeld.gridy = 1;
		panel.add(lblGeld, gbc_lblGeld);
		
		JLabel label_1 = new JLabel("100");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 5;
		gbc_label_1.gridy = 1;
		panel.add(label_1, gbc_label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Medizin kaufen", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridwidth = 6;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 3;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{70, 266, 0};
		gbl_panel_1.rowHeights = new int[]{15, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblWieVielMedizin = new JLabel("Wie viel Medizin möchtest du kaufen?");
		GridBagConstraints gbc_lblWieVielMedizin = new GridBagConstraints();
		gbc_lblWieVielMedizin.insets = new Insets(0, 0, 5, 0);
		gbc_lblWieVielMedizin.gridwidth = 2;
		gbc_lblWieVielMedizin.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblWieVielMedizin.gridx = 0;
		gbc_lblWieVielMedizin.gridy = 0;
		panel_1.add(lblWieVielMedizin, gbc_lblWieVielMedizin);
		
		JSpinner spAnzahl = new JSpinner();
		spAnzahl.setModel(new SpinnerNumberModel(new Integer(15), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_spAnzahl = new GridBagConstraints();
		gbc_spAnzahl.insets = new Insets(0, 0, 5, 5);
		gbc_spAnzahl.gridx = 0;
		gbc_spAnzahl.gridy = 1;
		panel_1.add(spAnzahl, gbc_spAnzahl);
		
		JButton btnKaufen = new JButton("Kaufen");
		GridBagConstraints gbc_btnKaufen = new GridBagConstraints();
		gbc_btnKaufen.insets = new Insets(0, 0, 5, 0);
		gbc_btnKaufen.anchor = GridBagConstraints.WEST;
		gbc_btnKaufen.gridx = 1;
		gbc_btnKaufen.gridy = 1;
		panel_1.add(btnKaufen, gbc_btnKaufen);
		
		JLabel lblKosten = new JLabel("Kosten: ");
		GridBagConstraints gbc_lblKosten = new GridBagConstraints();
		gbc_lblKosten.insets = new Insets(0, 0, 5, 5);
		gbc_lblKosten.gridx = 0;
		gbc_lblKosten.gridy = 2;
		panel_1.add(lblKosten, gbc_lblKosten);
		
		JLabel lblNewLabel = new JLabel("150");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblFehlermeldung = new JLabel("Fehlermeldung");
		lblFehlermeldung.setForeground(Color.RED);
		GridBagConstraints gbc_lblFehlermeldung = new GridBagConstraints();
		gbc_lblFehlermeldung.anchor = GridBagConstraints.WEST;
		gbc_lblFehlermeldung.gridwidth = 2;
		gbc_lblFehlermeldung.insets = new Insets(0, 0, 0, 5);
		gbc_lblFehlermeldung.gridx = 0;
		gbc_lblFehlermeldung.gridy = 4;
		panel_1.add(lblFehlermeldung, gbc_lblFehlermeldung);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Essen", null, panel_2, null);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{35, 0, 0, 0, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{30, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblGeld2 = new JLabel("Geld: ");
		GridBagConstraints gbc_lblGold = new GridBagConstraints();
		gbc_lblGold.insets = new Insets(0, 0, 5, 5);
		gbc_lblGold.gridx = 2;
		gbc_lblGold.gridy = 1;
		panel_2.add(lblGeld2, gbc_lblGold);
		
		JLabel label_2 = new JLabel("10");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 3;
		gbc_label_2.gridy = 1;
		panel_2.add(label_2, gbc_label_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.gridwidth = 12;
		gbc_panel_4.anchor = GridBagConstraints.NORTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 2;
		panel_2.add(panel_4, gbc_panel_4);
		
		JToggleButton btnEssen1 = new JToggleButton("?");
		panel_4.add(btnEssen1);
		
		JToggleButton btnEssen2 = new JToggleButton("?");
		panel_4.add(btnEssen2);
		
		JToggleButton btnEssen3 = new JToggleButton("?");
		panel_4.add(btnEssen3);
		
		JToggleButton btnEssen4 = new JToggleButton("?");
		panel_4.add(btnEssen4);
		
		JToggleButton btnEssen5 = new JToggleButton("?");
		panel_4.add(btnEssen5);
		
		JButton btnNewButton = new JButton("Essen kaufen");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 4;
		panel_2.add(btnNewButton, gbc_btnNewButton);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Inventar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.gridwidth = 6;
		gbc_panel_5.insets = new Insets(0, 0, 0, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 4;
		gbc_panel_5.gridy = 6;
		panel_2.add(panel_5, gbc_panel_5);
		
		JButton button = new JButton("?");
		panel_5.add(button);
		
		JButton button_1 = new JButton("?");
		panel_5.add(button_1);
		
		JButton button_2 = new JButton("?");
		panel_5.add(button_2);
		
		JButton button_3 = new JButton("?");
		panel_5.add(button_3);
		
		JButton button_4 = new JButton("?");
		panel_5.add(button_4);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Getränke", null, panel_3, null);
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{35, 0, 0, 0, 0, 0, 44, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_6.rowHeights = new int[]{30, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		JLabel label_3 = new JLabel("Geld: ");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 2;
		gbc_label_3.gridy = 1;
		panel_6.add(label_3, gbc_label_3);
		
		JLabel label_4 = new JLabel("10");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 3;
		gbc_label_4.gridy = 1;
		panel_6.add(label_4, gbc_label_4);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.anchor = GridBagConstraints.NORTH;
		gbc_panel_7.gridwidth = 6;
		gbc_panel_7.insets = new Insets(0, 0, 5, 5);
		gbc_panel_7.gridx = 4;
		gbc_panel_7.gridy = 2;
		panel_6.add(panel_7, gbc_panel_7);
		
		JToggleButton button_5 = new JToggleButton("?");
		panel_7.add(button_5);
		
		JToggleButton button_6 = new JToggleButton("?");
		panel_7.add(button_6);
		
		JToggleButton button_7 = new JToggleButton("?");
		panel_7.add(button_7);
		
		JToggleButton button_8 = new JToggleButton("?");
		panel_7.add(button_8);
		
		JToggleButton button_9 = new JToggleButton("?");
		panel_7.add(button_9);
		
		JButton btnTrinkenKaufen = new JButton("Getränk kaufen");
		GridBagConstraints gbc_btnTrinkenKaufen = new GridBagConstraints();
		gbc_btnTrinkenKaufen.insets = new Insets(0, 0, 5, 5);
		gbc_btnTrinkenKaufen.gridx = 8;
		gbc_btnTrinkenKaufen.gridy = 4;
		panel_6.add(btnTrinkenKaufen, gbc_btnTrinkenKaufen);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(null, "Inventar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridwidth = 4;
		gbc_panel_8.insets = new Insets(0, 0, 5, 5);
		gbc_panel_8.gridx = 5;
		gbc_panel_8.gridy = 6;
		panel_6.add(panel_8, gbc_panel_8);
		
		JButton button_11 = new JButton("?");
		panel_8.add(button_11);
		
		JButton button_12 = new JButton("?");
		panel_8.add(button_12);
		
		JButton button_13 = new JButton("?");
		panel_8.add(button_13);
		
		JButton button_14 = new JButton("?");
		panel_8.add(button_14);
		
		JButton button_15 = new JButton("?");
		panel_8.add(button_15);
	}
}
