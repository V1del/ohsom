package gui;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;

import bl.BLUser;
import bo.Code;
import bo.TamagotchiConfig;
import bo.User;

import java.awt.FlowLayout;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Snatsch
 *
 */
public class ConfigurationGUI extends JDialog implements ActionListener, KeyListener {
	private BLUser blU;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel pnlOptionen;
	private JLabel lblWerteAnzeigen;
	private JLabel lblFuettern;
	private JLabel lblSchlafenlegen;
	private JLabel lblZuTrinkenGeben;
	private JLabel lblSpielen;
	private JLabel lblShop;
	private JLabel lblWaschen;
	private JLabel lblInventar;
	private JLabel lblMedizin;
	private Map<Code, JTextField> txtFieldMap = new HashMap<Code, JTextField>();
	private JTextField txtWerteAnzeigen;
	private JTextField txtFuettern;
	private JTextField txtSchlafenlegen;
	private JTextField txtZuTrinkenGeben;
	private JTextField txtSpielen;
	private JTextField txtShop;
	private JTextField txtWaschen;
	private JTextField txtInventar;
	private JTextField txtMedizin;
	private JPanel panel_2;
	private JButton btnSpeichern;
	private JButton btnAbbrechen;
	private JPanel panel_3;
	private JLabel lblOwnTamagotchi;
	private JTextField txtDurchsuchen;
	private Canvas chosenImg;
	private JLabel lblFehlermeldung;

	public ConfigurationGUI(User currentUser) throws SQLException {
		new JDialog();
		setTitle("Konfigurationseinstellung");

		setModal(true);
		blU = new BLUser();
		blU.setCurrentUser(currentUser);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		panel = new JPanel();
		tabbedPane.addTab("Hotkeys", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));

		pnlOptionen = new JPanel();
		pnlOptionen.setBorder(new TitledBorder(null, "Optionen", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(pnlOptionen, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{30, 0, 30, 30, 30, 30, 30, 30, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlOptionen.setLayout(gbl_panel_1);

		lblWerteAnzeigen = new JLabel("Werte anzeigen");
		GridBagConstraints gbc_lblWerteAnzeigen = new GridBagConstraints();
		gbc_lblWerteAnzeigen.anchor = GridBagConstraints.WEST;
		gbc_lblWerteAnzeigen.insets = new Insets(0, 0, 5, 5);
		gbc_lblWerteAnzeigen.gridx = 1;
		gbc_lblWerteAnzeigen.gridy = 0;
		pnlOptionen.add(lblWerteAnzeigen, gbc_lblWerteAnzeigen);

		txtWerteAnzeigen = new JTextField();
		txtWerteAnzeigen.addKeyListener(this);
		GridBagConstraints gbc_txtWerteAnzeigen = new GridBagConstraints();
		gbc_txtWerteAnzeigen.insets = new Insets(0, 0, 5, 5);
		gbc_txtWerteAnzeigen.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtWerteAnzeigen.gridx = 8;
		gbc_txtWerteAnzeigen.gridy = 0;
		pnlOptionen.add(txtWerteAnzeigen, gbc_txtWerteAnzeigen);
		txtWerteAnzeigen.setColumns(10);

		lblFuettern = new JLabel("Füttern");
		GridBagConstraints gbc_lblFuettern = new GridBagConstraints();
		gbc_lblFuettern.anchor = GridBagConstraints.WEST;
		gbc_lblFuettern.insets = new Insets(0, 0, 5, 5);
		gbc_lblFuettern.gridx = 1;
		gbc_lblFuettern.gridy = 1;
		pnlOptionen.add(lblFuettern, gbc_lblFuettern);

		txtFuettern = new JTextField();
		txtFuettern.addKeyListener(this);
		txtFuettern.setColumns(10);
		GridBagConstraints gbc_txtFuettern = new GridBagConstraints();
		gbc_txtFuettern.insets = new Insets(0, 0, 5, 5);
		gbc_txtFuettern.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFuettern.gridx = 8;
		gbc_txtFuettern.gridy = 1;
		pnlOptionen.add(txtFuettern, gbc_txtFuettern);

		lblSchlafenlegen = new JLabel("Schlafenlegen");
		GridBagConstraints gbc_lblSchlafenlegen = new GridBagConstraints();
		gbc_lblSchlafenlegen.anchor = GridBagConstraints.WEST;
		gbc_lblSchlafenlegen.insets = new Insets(0, 0, 5, 5);
		gbc_lblSchlafenlegen.gridx = 1;
		gbc_lblSchlafenlegen.gridy = 2;
		pnlOptionen.add(lblSchlafenlegen, gbc_lblSchlafenlegen);

		txtSchlafenlegen = new JTextField();
		txtSchlafenlegen.addKeyListener(this);
		txtSchlafenlegen.setColumns(10);
		GridBagConstraints gbc_txtSchlafenlegen = new GridBagConstraints();
		gbc_txtSchlafenlegen.insets = new Insets(0, 0, 5, 5);
		gbc_txtSchlafenlegen.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSchlafenlegen.gridx = 8;
		gbc_txtSchlafenlegen.gridy = 2;
		pnlOptionen.add(txtSchlafenlegen, gbc_txtSchlafenlegen);

		lblZuTrinkenGeben = new JLabel("zu Trinken geben");
		GridBagConstraints gbc_lblZuTrinkenGeben = new GridBagConstraints();
		gbc_lblZuTrinkenGeben.anchor = GridBagConstraints.WEST;
		gbc_lblZuTrinkenGeben.insets = new Insets(0, 0, 5, 5);
		gbc_lblZuTrinkenGeben.gridx = 1;
		gbc_lblZuTrinkenGeben.gridy = 3;
		pnlOptionen.add(lblZuTrinkenGeben, gbc_lblZuTrinkenGeben);

		txtZuTrinkenGeben = new JTextField();
		txtZuTrinkenGeben.addKeyListener(this);
		txtZuTrinkenGeben.setColumns(10);
		GridBagConstraints gbc_txtZuTrinkenGeben = new GridBagConstraints();
		gbc_txtZuTrinkenGeben.insets = new Insets(0, 0, 5, 5);
		gbc_txtZuTrinkenGeben.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtZuTrinkenGeben.gridx = 8;
		gbc_txtZuTrinkenGeben.gridy = 3;
		pnlOptionen.add(txtZuTrinkenGeben, gbc_txtZuTrinkenGeben);

		lblSpielen = new JLabel("Spielen");
		GridBagConstraints gbc_lblSpielen = new GridBagConstraints();
		gbc_lblSpielen.anchor = GridBagConstraints.WEST;
		gbc_lblSpielen.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpielen.gridx = 1;
		gbc_lblSpielen.gridy = 4;
		pnlOptionen.add(lblSpielen, gbc_lblSpielen);

		txtSpielen = new JTextField();
		txtSpielen.addKeyListener(this);
		txtSpielen.setColumns(10);
		GridBagConstraints gbc_txtSpielen = new GridBagConstraints();
		gbc_txtSpielen.insets = new Insets(0, 0, 5, 5);
		gbc_txtSpielen.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSpielen.gridx = 8;
		gbc_txtSpielen.gridy = 4;
		pnlOptionen.add(txtSpielen, gbc_txtSpielen);

		lblShop = new JLabel("Shop");
		GridBagConstraints gbc_lblShop = new GridBagConstraints();
		gbc_lblShop.anchor = GridBagConstraints.WEST;
		gbc_lblShop.insets = new Insets(0, 0, 5, 5);
		gbc_lblShop.gridx = 1;
		gbc_lblShop.gridy = 5;
		pnlOptionen.add(lblShop, gbc_lblShop);

		txtShop = new JTextField();
		txtShop.addKeyListener(this);
		txtShop.setColumns(10);
		GridBagConstraints gbc_txtShop = new GridBagConstraints();
		gbc_txtShop.insets = new Insets(0, 0, 5, 5);
		gbc_txtShop.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShop.gridx = 8;
		gbc_txtShop.gridy = 5;
		pnlOptionen.add(txtShop, gbc_txtShop);

		lblWaschen = new JLabel("Waschen");
		GridBagConstraints gbc_lblWaschen = new GridBagConstraints();
		gbc_lblWaschen.anchor = GridBagConstraints.WEST;
		gbc_lblWaschen.insets = new Insets(0, 0, 5, 5);
		gbc_lblWaschen.gridx = 1;
		gbc_lblWaschen.gridy = 6;
		pnlOptionen.add(lblWaschen, gbc_lblWaschen);

		txtWaschen = new JTextField();
		txtWaschen.addKeyListener(this);
		txtWaschen.setColumns(10);
		GridBagConstraints gbc_txtWaschen = new GridBagConstraints();
		gbc_txtWaschen.insets = new Insets(0, 0, 5, 5);
		gbc_txtWaschen.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtWaschen.gridx = 8;
		gbc_txtWaschen.gridy = 6;
		pnlOptionen.add(txtWaschen, gbc_txtWaschen);

		lblInventar = new JLabel("Inventar");
		GridBagConstraints gbc_lblInventar = new GridBagConstraints();
		gbc_lblInventar.anchor = GridBagConstraints.WEST;
		gbc_lblInventar.insets = new Insets(0, 0, 0, 5);
		gbc_lblInventar.gridx = 1;
		gbc_lblInventar.gridy = 7;
		pnlOptionen.add(lblInventar, gbc_lblInventar);

		txtInventar = new JTextField();
		txtInventar.addKeyListener(this);
		txtInventar.setColumns(10);
		GridBagConstraints gbc_txtInventar = new GridBagConstraints();
		gbc_txtInventar.insets = new Insets(0, 0, 0, 5);
		gbc_txtInventar.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInventar.gridx = 8;
		gbc_txtInventar.gridy = 7;
		pnlOptionen.add(txtInventar, gbc_txtInventar);

		lblMedizin = new JLabel("Medizin");
		GridBagConstraints gbc_lblMedizin = new GridBagConstraints();
		gbc_lblMedizin.anchor = GridBagConstraints.WEST;
		gbc_lblMedizin.insets = new Insets(0, 0, 5, 5);
		gbc_lblMedizin.gridx = 1;
		gbc_lblMedizin.gridy = 8;
		pnlOptionen.add(lblMedizin, gbc_lblMedizin);

		txtMedizin = new JTextField();
		txtMedizin.addKeyListener(this);
		txtMedizin.setColumns(10);
		GridBagConstraints gbc_txtMedizin = new GridBagConstraints();
		gbc_txtMedizin.insets = new Insets(0, 0, 5, 5);
		gbc_txtMedizin.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMedizin.gridx = 8;
		gbc_txtMedizin.gridy = 8;
		pnlOptionen.add(txtMedizin, gbc_txtMedizin);

		
		panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setHgap(20);
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.add(panel_2, BorderLayout.SOUTH);

		btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(this);
		panel_2.add(btnSpeichern);

		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(this);
		panel_2.add(btnAbbrechen);
		
		lblFehlermeldung = new JLabel("Fehlermeldung");
		lblFehlermeldung.setForeground(Color.RED);
		lblFehlermeldung.setVisible(false);
		panel_2.add(lblFehlermeldung);

		panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setHgap(50);
		tabbedPane.addTab("Tamagotchi", null, panel_3, null);

		lblOwnTamagotchi = new JLabel("Eigenes Tamagotchi wÃ¤hlen");
		panel_3.add(lblOwnTamagotchi);

		txtDurchsuchen = new JTextField();
		txtDurchsuchen.setText("Durchsuchen");
		panel_3.add(txtDurchsuchen);
		txtDurchsuchen.setColumns(10);

		chosenImg = new Canvas();
		panel_3.add(chosenImg);

		txtFieldMap.put(Code.FUETTERN, txtFuettern);
		txtFieldMap.put(Code.TRINKEN, txtZuTrinkenGeben);
		txtFieldMap.put(Code.INVENTAR, txtInventar);
		txtFieldMap.put(Code.SCHLAFENLEGEN, txtSchlafenlegen);
		txtFieldMap.put(Code.SHOP, txtShop);
		txtFieldMap.put(Code.WERTE, txtWerteAnzeigen);
		txtFieldMap.put(Code.WASCHEN, txtWaschen);
		txtFieldMap.put(Code.SPIELEN, txtSpielen);

		fillMap();
		pack();
		setVisible(true);
	}

	/**
	 * Füllen der Map mit den Values
	 * @throws SQLException
	 */
	public void fillMap() throws SQLException
	{
		ArrayList<TamagotchiConfig> TamagotchiConfigList = blU.getCurrentUser().getConfig();

		for(TamagotchiConfig TamagotchiConfig : TamagotchiConfigList)
		{
			JTextField CurrentConfigField = txtFieldMap.get(TamagotchiConfig.getCode());	
			CurrentConfigField.setText(TamagotchiConfig.getHotkey() + "");
		}
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		JTextField currentTextField = (JTextField) ke.getSource();

		if(ke.getKeyText(ke.getKeyCode()).length() == 1) {currentTextField.setText(ke.getKeyText(ke.getKeyCode()));} else { currentTextField.setText("");}

	}

	@Override
	public void keyReleased(KeyEvent ke) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent ke) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btnSpeichern)
		{
			boolean saveData = false;
			for(Map.Entry ConfigEntry : txtFieldMap.entrySet() )
			{
				JTextField txtConfigField = (JTextField) ConfigEntry.getValue();
				TamagotchiConfig TamagotchiConfig = null;
				
				if(!txtConfigField.getText().equals(""))
				{
					TamagotchiConfig = new TamagotchiConfig(blU.getCurrentUser().getId(), String.valueOf(ConfigEntry.getKey()), txtConfigField.getText().charAt(0));
				}
				else
				{
					TamagotchiConfig = new TamagotchiConfig(blU.getCurrentUser().getId(), String.valueOf(ConfigEntry.getKey()));
				}
				
				try {
					if(blU.editConfigData(TamagotchiConfig))
					{
						saveData = true;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(!saveData)
			{
				lblFehlermeldung.setText("Die Daten konnten nicht gespeichert werden.");
			}
		}
		else
		{
			this.dispose();
		}

	}
}
