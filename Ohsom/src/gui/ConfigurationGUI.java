package gui;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
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
 * Gui f�r die Configurationgui
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
	private JPanel pnlresetPassword;
	private JPanel pnlSplit;
	private JPanel panel_4;
	private JLabel lblAltesPasswort;
	private JPasswordField txtPwOld;
	private JLabel lblNeuesPasswort;
	private JLabel lblNeuesPasswortWdh;
	private JPasswordField txtPwNew;
	private JPasswordField txtNewPwWdh;
	private JPanel pnlPasswordSecurity;
	private JLabel lblvalue;
	private JProgressBar progressBar;

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
		GridBagLayout gbl_Passwortändern = new GridBagLayout();
		gbl_Passwortändern.columnWidths = new int[]{30, 0, 30, 30, 30, 30, 30, 30, 0, 0, 0};
		gbl_Passwortändern.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Passwortändern.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_Passwortändern.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlOptionen.setLayout(gbl_Passwortändern);

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

		lblOwnTamagotchi = new JLabel("Eigenes Tamagotchi wählen");
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
		
		pnlresetPassword = new JPanel();
		tabbedPane.addTab("Passwort", null, pnlresetPassword, null);
		pnlresetPassword.setLayout(new BorderLayout(20, 20));
		
		pnlSplit = new JPanel();
		pnlresetPassword.add(pnlSplit, BorderLayout.CENTER);
		pnlSplit.setLayout(new GridLayout(1, 2, 10, 0));
		
		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Passwort \u00E4ndern", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlSplit.add(panel_4);
		GridBagLayout gbl_pnlPasswordSecurity = new GridBagLayout();
		gbl_pnlPasswordSecurity.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pnlPasswordSecurity.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlPasswordSecurity.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlPasswordSecurity.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_pnlPasswordSecurity);
		
		lblAltesPasswort = new JLabel("Altes Passwort:");
		GridBagConstraints gbc_lblAltesPasswort = new GridBagConstraints();
		gbc_lblAltesPasswort.anchor = GridBagConstraints.WEST;
		gbc_lblAltesPasswort.insets = new Insets(0, 0, 5, 5);
		gbc_lblAltesPasswort.gridx = 1;
		gbc_lblAltesPasswort.gridy = 1;
		panel_4.add(lblAltesPasswort, gbc_lblAltesPasswort);
		
		txtPwOld = new JPasswordField();
		GridBagConstraints gbc_txtPwOld = new GridBagConstraints();
		gbc_txtPwOld.insets = new Insets(0, 0, 5, 0);
		gbc_txtPwOld.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPwOld.gridx = 2;
		gbc_txtPwOld.gridy = 1;
		panel_4.add(txtPwOld, gbc_txtPwOld);
		
		lblNeuesPasswort = new JLabel("Neues Passwort: ");
		GridBagConstraints gbc_lblNeuesPasswort = new GridBagConstraints();
		gbc_lblNeuesPasswort.anchor = GridBagConstraints.WEST;
		gbc_lblNeuesPasswort.insets = new Insets(0, 0, 5, 5);
		gbc_lblNeuesPasswort.gridx = 1;
		gbc_lblNeuesPasswort.gridy = 2;
		panel_4.add(lblNeuesPasswort, gbc_lblNeuesPasswort);
		
		txtPwNew = new JPasswordField();
		GridBagConstraints gbc_txtPwNew = new GridBagConstraints();
		gbc_txtPwNew.insets = new Insets(0, 0, 5, 0);
		gbc_txtPwNew.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPwNew.gridx = 2;
		gbc_txtPwNew.gridy = 2;
		panel_4.add(txtPwNew, gbc_txtPwNew);
		
		lblNeuesPasswortWdh = new JLabel("Neues Passwort wdh.: ");
		GridBagConstraints gbc_lblNeuesPasswortWdh = new GridBagConstraints();
		gbc_lblNeuesPasswortWdh.anchor = GridBagConstraints.WEST;
		gbc_lblNeuesPasswortWdh.insets = new Insets(0, 0, 5, 5);
		gbc_lblNeuesPasswortWdh.gridx = 1;
		gbc_lblNeuesPasswortWdh.gridy = 3;
		panel_4.add(lblNeuesPasswortWdh, gbc_lblNeuesPasswortWdh);
		
		txtNewPwWdh = new JPasswordField();
		GridBagConstraints gbc_txtNewPwWdh = new GridBagConstraints();
		gbc_txtNewPwWdh.insets = new Insets(0, 0, 5, 0);
		gbc_txtNewPwWdh.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNewPwWdh.gridx = 2;
		gbc_txtNewPwWdh.gridy = 3;
		panel_4.add(txtNewPwWdh, gbc_txtNewPwWdh);
		
		pnlPasswordSecurity = new JPanel();
		pnlPasswordSecurity.setBorder(new TitledBorder(null, "Passwortsicherheit", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlSplit.add(pnlPasswordSecurity);
		GridBagLayout gbl_pnlPasswordSecurity = new GridBagLayout();
		gbl_pnlPasswordSecurity.columnWidths = new int[]{0, 0, 0};
		gbl_pnlPasswordSecurity.rowHeights = new int[]{0, 0, 0};
		gbl_pnlPasswordSecurity.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlPasswordSecurity.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pnlPasswordSecurity.setLayout(gbl_pnlPasswordSecurity);
		
		lblvalue = new JLabel("lblValue");
		GridBagConstraints gbc_lblvalue = new GridBagConstraints();
		gbc_lblvalue.insets = new Insets(0, 0, 5, 5);
		gbc_lblvalue.gridx = 0;
		gbc_lblvalue.gridy = 0;
		pnlPasswordSecurity.add(lblvalue, gbc_lblvalue);
		
		progressBar = new JProgressBar();
		progressBar.setMaximum(4);
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.insets = new Insets(0, 0, 0, 5);
		gbc_progressBar.gridx = 0;
		gbc_progressBar.gridy = 1;
		pnlPasswordSecurity.add(progressBar, gbc_progressBar);
		
		fillMap();
		pack();
		setVisible(true);
	}

	/**
	 * F�llen der Map mit den Values
	 * @throws SQLException
	 */
	public void fillMap() throws SQLException
	{
		ArrayList<TamagotchiConfig> TamagotchiConfigList = blU.getTamagotchiConfig();

		for(TamagotchiConfig TamagotchiConfig : TamagotchiConfigList)
		{
			// existiert bereits ein Code mit diesem Hotkey
			JTextField CurrentConfigField = txtFieldMap.get(TamagotchiConfig.getCode());	
			CurrentConfigField.setText(TamagotchiConfig.getHotkey() + "");
		}
	}

	/**
	 * 
	 */
	@Override
	public void keyPressed(KeyEvent ke) {
		//
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		//
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		JTextField currentTextField = (JTextField) ke.getSource();

		if(ke.getKeyText(ke.getKeyCode()).length() == 1) {currentTextField.setText(ke.getKeyText(ke.getKeyCode()));} else { currentTextField.setText("");}
	}

	/**
	 * Methode zur Speicherung der Config-Einstellungen
	 * @throws SQLException
	 */
	public void saveConfigData() throws SQLException
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


			if(!alreadyExistsHotkey(txtConfigField))
			{
				if(blU.editConfigData(TamagotchiConfig))
				{
					saveData = true;
				}
			}
		}


		if(!saveData)
		{
			lblFehlermeldung.setText("Die Daten konnten nicht gespeichert werden.");
		}
		else 
		{
			this.dispose();
		}
	}

	/**
	 * Pr�fen ob eines der Textfelder bereits diesen Hotkey enth�lt
	 * @param hotkey
	 * @return
	 */
	public boolean alreadyExistsHotkey(JTextField txtHotkey)
	{
		boolean alreadyExisting = false;

		for(Map.Entry ConfigEntry : txtFieldMap.entrySet() )
		{
			JTextField txtConfigField = (JTextField) ConfigEntry.getValue();
			if(txtConfigField != txtHotkey && (txtConfigField.getText().equals(txtHotkey.getText()) && txtConfigField.getText().equals("") == false))
			{
				alreadyExisting = true;
			}
		}

		return alreadyExisting;
	}

	/**
	 * Actionevents f�r das TamagotchiGUI
	 * @param ae ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			if(ae.getSource() == btnSpeichern)
			{
				saveConfigData();
			}
			else
			{
				this.dispose();
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
