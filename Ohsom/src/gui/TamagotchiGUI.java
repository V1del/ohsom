package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import bl.BLNachrichten;
import bl.BLTamagotchi;
import bl.BLUser;
import bo.Code;
import bo.InvaderGameThread;
import bo.Item;
import bo.Kategorie;
import bo.Tamagotchi;
import bo.TamagotchiConfig;
import bo.User;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * TamagotchiGUI is a GUI especially for playing with your Tamagotchi
 * @author Snatsch
 *
 */
public class TamagotchiGUI implements ActionListener, KeyListener{

	private Thread TamagotchiThread = new Thread(new TamagotchiThread(this));
	
	private Thread InvaderGameThread = new Thread(new InvaderGameThread());

	private BLTamagotchi blT = null;

	private BLNachrichten blN = null;
	
	private BLUser blU = null;

	private JFrame frmOhsom;

	private JButton lblNeueNachrichten = new JButton("Neue Nachrichten");

	private JButton lblNachrichtVerfassen = new JButton("Nachricht verfassen");

	private JButton btnPref = new JButton("pref");

	private JButton btnReset;

	private JButton btnHelp;

	private JLabel lblEreignis = new JLabel("Es ist etwas passiert!");

	private TamagotchiGfx pnlTamagotchi;

	private JPanel pnlTamagotchiButtons = new JPanel();

	private Map <JButton, Code> BtnTamagotchiMap = new HashMap<JButton, Code>();

	private JButton btnWerte = new JButton();

	private JButton btnFuettern = new JButton();

	private JButton btnTrinken = new JButton();

	private JButton btnWaschen = new JButton();

	private JButton btnSchlafen = new JButton();

	private JButton btnSpielen = new JButton();

	private JButton btnMedizin = new JButton();

	private JButton btnShop = new JButton();

	private JButton btnInventar = new JButton();

	private JPanel pnlCondition;

	private JLabel lblHunger;
	private JLabel lblHungerValue;
	private JLabel lblDurst;
	private JLabel lblDurstValue;
	private JLabel lblSchmutzigkeit;
	private JLabel lblSchmutzigkeitValue;
	private JLabel lblZustand;
	private JLabel lblZustandValue;
	private JLabel lblMuedigkeit;
	private JLabel lblMuedigkeitValue;
	private JLabel lblBoringState;
	private JLabel lblBoringStateValue;
	private JLabel lblMedizin;
	private JLabel lblMedizinValue;
	private JLabel lblEvolutionsstadium;
	private JLabel lblEvolutionsstadiumValue;

	private JPanel pnlInventar;

	private Map<JToggleButton, Item> btnInvListValue = new HashMap<JToggleButton, Item>();

	private JToggleButton[] btnInvList = {new JToggleButton("?"),new JToggleButton("?"),new JToggleButton("?"),new JToggleButton("?"),new JToggleButton("?"), new JToggleButton("?"),new JToggleButton("?"),new JToggleButton("?"),new JToggleButton("?"),new JToggleButton("?")};

	private JButton btnItemVerwenden = new JButton();

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public TamagotchiGUI() throws SQLException {
		blT = new BLTamagotchi();
		blN = new BLNachrichten();
		blU = new BLUser();

		while(!blT.getCurrentUser().hasTamagotchi())
		{
			setTamagotchi(false);
		}

		BtnTamagotchiMap.put(btnWerte, Code.WERTE);
		BtnTamagotchiMap.put(btnFuettern, Code.FUETTERN);
		BtnTamagotchiMap.put(btnTrinken, Code.TRINKEN);
		BtnTamagotchiMap.put(btnWaschen, Code.WASCHEN);
		BtnTamagotchiMap.put(btnSchlafen, Code.SCHLAFENLEGEN);
		BtnTamagotchiMap.put(btnSpielen, Code.SPIELEN);
		BtnTamagotchiMap.put(btnMedizin, Code.MEDIZIN);
		BtnTamagotchiMap.put(btnShop, Code.SHOP);
		BtnTamagotchiMap.put(btnInventar, Code.INVENTAR);

		initialize();

		if(blT.getCurrentUser().hasTamagotchi())
		{
			TamagotchiThread.start();
		}

	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	@SuppressWarnings("deprecation")
	private void initialize() throws SQLException {
		frmOhsom = new JFrame();
		frmOhsom.setFocusable(true);
		//	frmOhsom.setResizable(false);
		frmOhsom.addKeyListener(this);
		frmOhsom.setTitle("Ohsom");
		frmOhsom.setBounds(100, 100, 780, 600);
		frmOhsom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOhsom.setLayout(new BorderLayout(20, 0));

		JPanel panel = new JPanel();
		frmOhsom.getContentPane().add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		btnHelp = new JButton("?");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 0;
		panel.add(btnHelp, gbc_button);

		btnPref = new JButton("pref");
		btnPref.addActionListener(this);
		GridBagConstraints gbc_btnPref = new GridBagConstraints();
		gbc_btnPref.insets = new Insets(0, 0, 5, 0);
		gbc_btnPref.gridx = 1;
		gbc_btnPref.gridy = 0;
		panel.add(btnPref, gbc_btnPref);

		//JLabel lblNeueNachrichten = new JLabel("Neue Nachrichten");

		lblNeueNachrichten.setMargin(new Insets(0, 0, 0, 0));
		lblNeueNachrichten.setContentAreaFilled(false);
		lblNeueNachrichten.setBorderPainted(false);
		lblNeueNachrichten.setOpaque(false);
		lblNeueNachrichten.setHorizontalAlignment(SwingConstants.LEADING);
		lblNeueNachrichten.addActionListener(this);

		GridBagConstraints gbc_lblNeueNachrichten = new GridBagConstraints();
		gbc_lblNeueNachrichten.insets = new Insets(0, 0, 5, 0);
		gbc_lblNeueNachrichten.gridwidth = 2;
		gbc_lblNeueNachrichten.gridx = 0;
		gbc_lblNeueNachrichten.gridy = 1;
		panel.add(lblNeueNachrichten, gbc_lblNeueNachrichten);

		//JLabel lblNachrichtVerfassen = new JLabel("Nachricht verfassen");
		lblNachrichtVerfassen.setMargin(new Insets(0, 0, 0, 0));
		lblNachrichtVerfassen.setContentAreaFilled(false);
		lblNachrichtVerfassen.setBorderPainted(false);
		lblNachrichtVerfassen.setOpaque(false);
		lblNachrichtVerfassen.setHorizontalAlignment(SwingConstants.LEADING);
		lblNachrichtVerfassen.addActionListener(this);

		GridBagConstraints gbc_lblNachrichtVerfassen = new GridBagConstraints();
		gbc_lblNachrichtVerfassen.insets = new Insets(0, 0, 5, 0);
		gbc_lblNachrichtVerfassen.gridwidth = 2;
		gbc_lblNachrichtVerfassen.gridx = 0;
		gbc_lblNachrichtVerfassen.gridy = 2;

		panel.add(lblNachrichtVerfassen, gbc_lblNachrichtVerfassen);

		btnReset = new JButton("Reset");
		btnReset.addActionListener(this);
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.anchor = GridBagConstraints.WEST;
		gbc_btnReset.gridwidth = 2;
		gbc_btnReset.insets = new Insets(0, 0, 0, 5);
		gbc_btnReset.gridx = 0;
		gbc_btnReset.gridy = 3;
		if(blT.getCurrentUser().hasTamagotchi() == false)
		{
			btnReset.disable();
		}
		panel.add(btnReset, gbc_btnReset);

		JPanel panel_1 = new JPanel(new BorderLayout());
		frmOhsom.getContentPane().add(panel_1, BorderLayout.CENTER);

		pnlTamagotchi = new TamagotchiGfx();
		panel_1.add(pnlTamagotchi, BorderLayout.CENTER);

		pnlTamagotchiButtons = new JPanel(new FlowLayout(FlowLayout.LEADING));

		fillButtonArea();

		panel_1.add(pnlTamagotchiButtons, BorderLayout.SOUTH);

		panel_1.add(lblEreignis, BorderLayout.NORTH);

		JPanel pnlInformations = new JPanel();

		pnlCondition = new JPanel();
		pnlCondition.setBorder(new TitledBorder(null, "Werte", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		frmOhsom.getContentPane().add(pnlInformations, BorderLayout.SOUTH);

		GridBagLayout gbl_pnlCondition = new GridBagLayout();
		gbl_pnlCondition.columnWidths = new int[]{0, 0, 30, 0, 0, 30, 0, 0, 30, 0, 0, 0};

		gbl_pnlCondition.rowHeights = new int[]{0, 0, 0, 0};

		gbl_pnlCondition.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};

		gbl_pnlCondition.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};

		pnlCondition.setLayout(gbl_pnlCondition);

		lblHunger = new JLabel("Hunger:");
		GridBagConstraints gbc_lblHunger = new GridBagConstraints();
		gbc_lblHunger.anchor = GridBagConstraints.WEST;
		gbc_lblHunger.insets = new Insets(0, 0, 5, 5);
		gbc_lblHunger.gridx = 0;
		gbc_lblHunger.gridy = 0;
		pnlCondition.add(lblHunger, gbc_lblHunger);

		lblHungerValue = new JLabel("valHunger");
		GridBagConstraints gbc_valHunger = new GridBagConstraints();
		gbc_valHunger.insets = new Insets(0, 0, 5, 5);
		gbc_valHunger.gridx = 1;
		gbc_valHunger.gridy = 0;
		pnlCondition.add(lblHungerValue, gbc_valHunger);

		lblDurst = new JLabel("Durst:");
		GridBagConstraints gbc_lblDurst = new GridBagConstraints();
		gbc_lblDurst.anchor = GridBagConstraints.WEST;
		gbc_lblDurst.insets = new Insets(0, 0, 5, 5);
		gbc_lblDurst.gridx = 3;
		gbc_lblDurst.gridy = 0;
		pnlCondition.add(lblDurst, gbc_lblDurst);

		lblDurstValue = new JLabel("valDurst");
		GridBagConstraints gbc_valDurst = new GridBagConstraints();
		gbc_valDurst.insets = new Insets(0, 0, 5, 5);
		gbc_valDurst.gridx = 4;
		gbc_valDurst.gridy = 0;
		pnlCondition.add(lblDurstValue, gbc_valDurst);

		lblSchmutzigkeit = new JLabel("schmutzig?:");
		GridBagConstraints gbc_lblSchmutzigkeit = new GridBagConstraints();
		gbc_lblSchmutzigkeit.anchor = GridBagConstraints.WEST;
		gbc_lblSchmutzigkeit.insets = new Insets(0, 0, 5, 5);
		gbc_lblSchmutzigkeit.gridx = 5;
		gbc_lblSchmutzigkeit.gridy = 0;
		pnlCondition.add(lblSchmutzigkeit, gbc_lblSchmutzigkeit);

		lblSchmutzigkeitValue = new JLabel("valSchmutz");
		GridBagConstraints gbc_valSchmutz = new GridBagConstraints();
		gbc_valSchmutz.insets = new Insets(0, 0, 5, 5);
		gbc_valSchmutz.gridx = 6;
		gbc_valSchmutz.gridy = 0;
		pnlCondition.add(lblSchmutzigkeitValue, gbc_valSchmutz);
		
		lblZustand = new JLabel("Zustand:");
		GridBagConstraints gbc_lblZustand = new GridBagConstraints();
		gbc_lblZustand.anchor = GridBagConstraints.WEST;
		gbc_lblZustand.insets = new Insets(0, 0, 5, 5);
		gbc_lblZustand.gridx = 7;
		gbc_lblZustand.gridy = 0;
		pnlCondition.add(lblZustand, gbc_lblZustand);

		lblZustandValue = new JLabel("valZustand");
		GridBagConstraints gbc_valZustand = new GridBagConstraints();
		gbc_valZustand.insets = new Insets(0, 0, 5, 0);
		gbc_valZustand.gridx = 8;
		gbc_valZustand.gridy = 0;
		pnlCondition.add(lblZustandValue, gbc_valZustand);

		lblBoringState = new JLabel("BoringState:");
		GridBagConstraints gbc_lblBoringState = new GridBagConstraints();
		gbc_lblBoringState.anchor = GridBagConstraints.WEST;
		gbc_lblBoringState.insets = new Insets(0, 0, 5, 5);
		gbc_lblBoringState.gridx = 0;
		gbc_lblBoringState.gridy = 1;
		pnlCondition.add(lblBoringState, gbc_lblBoringState);

		lblBoringStateValue = new JLabel("valBoringState");
		GridBagConstraints gbc_lblBoringStateValue = new GridBagConstraints();
		gbc_lblBoringStateValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblBoringStateValue.gridx = 1;
		gbc_lblBoringStateValue.gridy = 1;
		pnlCondition.add(lblBoringStateValue, gbc_lblBoringStateValue);

		lblMuedigkeit = new JLabel("müde?:");
		GridBagConstraints gbc_lblMuedigkeit = new GridBagConstraints();
		gbc_lblMuedigkeit.anchor = GridBagConstraints.WEST;
		gbc_lblMuedigkeit.insets = new Insets(0, 0, 5, 5);
		gbc_lblMuedigkeit.gridx = 3;
		gbc_lblMuedigkeit.gridy = 1;
		pnlCondition.add(lblMuedigkeit, gbc_lblMuedigkeit);

		lblMuedigkeitValue = new JLabel("valMüde");
		GridBagConstraints gbc_valMuede = new GridBagConstraints();
		gbc_valMuede.insets = new Insets(0, 0, 5, 5);
		gbc_valMuede.gridx = 4;
		gbc_valMuede.gridy = 1;
		pnlCondition.add(lblMuedigkeitValue, gbc_valMuede);
		
		lblMedizin = new JLabel("Medizin:");
		GridBagConstraints gbc_lblMedizin = new GridBagConstraints();
		gbc_lblMedizin.anchor = GridBagConstraints.WEST;
		gbc_lblMedizin.insets = new Insets(0, 0, 5, 5);
		gbc_lblMedizin.gridx = 5;
		gbc_lblMedizin.gridy = 1;
		pnlCondition.add(lblMedizin, gbc_lblMedizin);

		lblMedizinValue = new JLabel("valMedizin");
		GridBagConstraints gbc_lblMedizinValue = new GridBagConstraints();
		gbc_lblMedizinValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblMedizinValue.gridx = 6;
		gbc_lblMedizinValue.gridy = 1;
		pnlCondition.add(lblMedizinValue, gbc_lblMedizinValue);
		
		lblEvolutionsstadium = new JLabel("Evolutionsstadium:");
		GridBagConstraints gbc_lblEvolutionsstadium = new GridBagConstraints();
		gbc_lblEvolutionsstadium.anchor = GridBagConstraints.WEST;
		gbc_lblEvolutionsstadium.insets = new Insets(0, 0, 5, 5);
		gbc_lblEvolutionsstadium.gridx = 7;
		gbc_lblEvolutionsstadium.gridy = 1;
		pnlCondition.add(lblEvolutionsstadium, gbc_lblEvolutionsstadium);

		lblEvolutionsstadiumValue = new JLabel("valEvolutionsstadium");
		GridBagConstraints gbc_lblEvolutionsstadiumValue = new GridBagConstraints();
		gbc_lblEvolutionsstadiumValue.anchor = GridBagConstraints.WEST;
		gbc_lblEvolutionsstadiumValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblEvolutionsstadiumValue.gridx = 8;
		gbc_lblEvolutionsstadiumValue.gridy = 1;
		pnlCondition.add(lblEvolutionsstadiumValue, gbc_lblEvolutionsstadiumValue);


		pnlInventar = new JPanel();
		pnlInventar.setBorder(new TitledBorder(null, "Inventar", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		GridBagConstraints gbc_pnlInventar = new GridBagConstraints();
		gbc_pnlInventar.gridheight = 2;
		gbc_pnlInventar.gridwidth = 11;
		gbc_pnlInventar.insets = new Insets(0, 0, 5, 5);
		gbc_pnlInventar.fill = GridBagConstraints.BOTH;
		gbc_pnlInventar.gridx = 0;
		gbc_pnlInventar.gridy = 10;

		//pnlCondition.add(pnlInventar, gbc_pnlInventar);
		pnlInformations.add(pnlCondition);
		pnlInformations.add(pnlInventar, gbc_pnlInventar);

		pnlCondition.setVisible(false);

		pnlInventar.setVisible(false);

		frmOhsom.setVisible(true);
		frmOhsom.requestFocusInWindow();
	}

	/**
	 * Befüllen des TamagotchiButtons - Panels
	 * @throws SQLException
	 */
	public void fillButtonArea() throws SQLException
	{
		pnlTamagotchiButtons.removeAll();
		for(Map.Entry BtnEntry : BtnTamagotchiMap.entrySet())
		{
			JButton btnTamagotchi = (JButton) BtnEntry.getKey();
			Code btnCode = (Code) BtnEntry.getValue();
			btnTamagotchi.setText(btnCode.getCodeName());

			if(blT.getCurrentUser().getTamagotchi().isDead())
			{
				btnTamagotchi.setEnabled(false);
			}
			else
			{
				btnTamagotchi.setEnabled(true);
			}
			btnTamagotchi.addActionListener(this);
			pnlTamagotchiButtons.add(btnTamagotchi);

		}
	}

	/**
	 * Refresh Tamagotchi Panel nach Ablauf des Timers um immer wieder den Zustand zu überprüfen
	 * @throws SQLException
	 */
	public void refreshTamagotchiPanel() throws SQLException
	{
		Tamagotchi TamagotchiTemporary = blT.getCurrentUser().getTamagotchi();
		if(TamagotchiTemporary.isDead())
		{
			setEreignisLabel("Dein Tamagotchi ist gestorben :(");
			pnlTamagotchi.setDead(TamagotchiTemporary.isDead());
		}
		else
		{
			pnlTamagotchi.setShit(TamagotchiTemporary.isDirty());

			pnlTamagotchi.setSleeping(TamagotchiTemporary.isStillSleeping(), TamagotchiTemporary.isKrank(), TamagotchiTemporary.isGeschlechtw(), TamagotchiTemporary.getEvolutionsstadium());

			if(!TamagotchiTemporary.isStillSleeping())
			{
				pnlTamagotchi.moveTamagotchi(TamagotchiTemporary.isKrank(), TamagotchiTemporary.isGeschlechtw(), TamagotchiTemporary.getEvolutionsstadium());
			}
		}

		blT.changeTamagotchi(blT.getCurrentUser().getTamagotchi());

		lblNeueNachrichten.setText("Neue Nachrichten (" + blN.getCountOfUnreadNachrichten() + ")");

	}

	/**
	 * Befüllen des Wertepanels
	 * @throws SQLException
	 */
	public void showCondition() throws SQLException
	{
		pnlCondition.setVisible(true);

		Tamagotchi currentTamagotchi = blT.getCurrentUser().getTamagotchi();
		lblDurstValue.setText(String.valueOf(currentTamagotchi.getThirst()) + "/5");
		lblHungerValue.setText(String.valueOf(currentTamagotchi.getHunger()) + "/5");
		lblBoringStateValue.setText(String.valueOf(currentTamagotchi.getBoringState()) + "/3");
		lblSchmutzigkeitValue.setText((currentTamagotchi.isDirty())? "ja" : "nein");
		lblMuedigkeitValue.setText((currentTamagotchi.isTired())? "ja" : "nein");
		lblZustandValue.setText(currentTamagotchi.getGesundheitszustand().name());
		lblEvolutionsstadiumValue.setText(currentTamagotchi.getEvolutionsstadium().name());
		lblMedizinValue.setText(currentTamagotchi.getMedizin() + "/100");
	}

	/**
	 * 
	 * @param katInv
	 * @throws SQLException
	 */
	public void showInventar(Kategorie katInv) throws SQLException
	{
		int InventarIndex = 0;

		pnlInventar.removeAll();
		btnInvListValue.clear();

		for(Item Item: blT.getInventory(katInv))
		{
			JToggleButton currentItemButton = btnInvList[InventarIndex];
			btnInvListValue.put(currentItemButton, Item);
			currentItemButton.setIcon(new ImageIcon("Sources/Shopartikel/" + Item.getShopartikel().getArtikelImage()));
			currentItemButton.setText("");
			currentItemButton.addActionListener(this);
			pnlInventar.add(currentItemButton);

			InventarIndex++;
		}

		pnlInventar.add(btnItemVerwenden);
		btnItemVerwenden.setVisible(false);

		pnlInventar.setVisible(true);
	}

	/**
	 * GUI - Logik zum Reseting des Tamagotchis
	 * @throws SQLException
	 */
	public void setTamagotchi(boolean reseting) throws SQLException
	{
		boolean successfullSetting = false;
		String askForName = (String)JOptionPane.showInputDialog(
				new JFrame(),
				"Type in Name of Tamagotchi (not > 10 letters)",
				"Ohsom - Tamagotchi Name",
				JOptionPane.PLAIN_MESSAGE,
				null,
				null, 
				"Name...");

		if(askForName == null)
		{
			askForName = "";
		}

		if(reseting)
		{
			resetTamagotchi(askForName);
		}
		else
		{
			createNewTamagotchi(askForName);
		}
	}

	/**
	 * Tamagotchi zurücksetzen
	 * @param resetName
	 * @throws SQLException
	 */
	public void resetTamagotchi(String resetName) throws SQLException
	{
		if(blT.resetTamagotchi(resetName))
		{
			setEreignisLabel("Du hast dein Tamagotchi erfolgreich resetet");
			fillButtonArea();
		}
		else
		{
			setEreignisLabel("Dein Tamagotchi konnte nicht resetet werden.");
		}
	}

	/**
	 * Neues Tamagotchi erstellen
	 * @throws SQLException 
	 * 
	 */
	public void createNewTamagotchi(String newName) throws SQLException
	{
		if(blT.addTamagotchi(newName))
		{
			setEreignisLabel("Du hast dein Tamagotchi " + newName + " erfolgreich erstellt.");
			fillButtonArea();
		}
		else
		{
			setEreignisLabel("Dein Tamagotchi konnte nicht erstellt werden :(");
		}
	}

	/**
	 * ActionEvents für TamagotchiGui
	 */
	public void actionPerformed(ActionEvent ae) {
		try {
			if (ae.getSource() == lblNeueNachrichten)
			{
				MessagesGUI msggui = new MessagesGUI();
			}
			else if(ae.getSource() == btnReset)
			{
				setTamagotchi(true);
			}
			else if (ae.getSource() == lblNachrichtVerfassen)
			{
				try {
					NewMessageGUI nmgui = new NewMessageGUI(null);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if (ae.getSource() == btnPref)
			{
				ConfigurationGUI cgui = new ConfigurationGUI(blT.getCurrentUser());	
				frmOhsom.requestFocus();
			}
			else if(ae.getSource() == btnHelp)
			{
				// TODO: Hier sollte ein Handbuch aufgerufen werden
			}
			else if(BtnTamagotchiMap.get(ae.getSource()) != null)
			{
				reactToAction((Code) BtnTamagotchiMap.get(ae.getSource()));
			}
			else if(btnInvListValue.get(ae.getSource()) != null)
			{
				Item usedItem = (Item) btnInvListValue.get(ae.getSource());
				giveItToTamagotchi(usedItem);
			}

			frmOhsom.requestFocus();
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * Tamagotchi Item geben
	 * @param Item
	 * @throws SQLException
	 */
	private void giveItToTamagotchi(Item Item) throws SQLException {
		if(Item.getShopartikel().getKategorie() == Kategorie.FUTTER)
		{
			if(blT.feedTamagotchi(Item))
			{
				setEreignisLabel("Dein Tamagotchi hat nun keinen Hunger mehr.");
				pnlInventar.setVisible(false);
			}
			else
			{
				setEreignisLabel("Dein Tamagotchi hat noch keinen Hunger.");
			}
		}
		else
		{
			if(blT.giveTamagotchiADrink(Item))
			{
				setEreignisLabel("Dein Tamagotchi hat nun keinen Durst mehr.");
				pnlInventar.setVisible(false);
			}
			else
			{
				setEreignisLabel("Dein Tamagotchi hat noch keinen Durst.");
			}
		}

	}

	/**
	 * Methode, um das Tamagotchi zu waschen und es danach auf dem GUI auszugeben
	 * @throws SQLException
	 */
	public void washTamagotchi() throws SQLException
	{
		if(blT.washTamagotchi())
		{
			pnlTamagotchi.setShit(false);
			setEreignisLabel("Dein Tamagotchi ist nun schön sauber");
		}
		else
		{
			setEreignisLabel("Dein Tamagotchi ist bereits sauber");
		}
	}

	/**
	 * Tamagotchi schlafenlegen
	 * @throws SQLException
	 */
	public void layTamagotchiToSleep() throws SQLException
	{
		if(blT.layTamagotchiToSleep()) {
			setEreignisLabel("Dein Tamagotchi schläft nun");
		}
		else
		{
			setEreignisLabel("Dein Tamagotchi ist nicht müde");
		}
	}

	/**
	 * Tamagotchi Medizin geben
	 * @throws SQLException
	 */
	public void gibMedizin() throws SQLException
	{
		if(blT.gibMedizin())
		{
			setEreignisLabel("Dein Tamagotchi ist nun wieder gesund");
		}
		else
		{
			setEreignisLabel("Du kannst jetzt keine Medizin verabreichen (keine Medizin oder gesundes Tamagotchi)");
		}
	}

	/**
	 * Setzen des Ereignislabels bei jeder Veränderung
	 * @param Meldung
	 */
	public void setEreignisLabel(String Meldung) 
	{
		lblEreignis.setText("Ereignis: " + Meldung);		
	}

	/**
	 * Code - Actions ausführen
	 * @param CodeAction
	 * @throws SQLException
	 */
	public void reactToAction(Code CodeAction) throws SQLException
	{
		pnlCondition.setVisible(false);
		pnlInventar.setVisible(false);
		if(blT.getCurrentUser().getTamagotchi().isDead() == false) {
			switch(CodeAction)
			{
			case FUETTERN:
				showInventar(Kategorie.FUTTER);
				break;
			case SCHLAFENLEGEN:
				layTamagotchiToSleep();
				break;
			case SHOP:
				ShopGUI sGUI = new ShopGUI();
				break;
			case INVENTAR:
				showInventar(null);
				break;
			case SPIELEN:
				//InvaderGameThread.start();
				break;
			case TRINKEN:
				showInventar(Kategorie.GETRAENK);
				break;
			case MEDIZIN:
				gibMedizin();
				break;
			case WASCHEN:
				washTamagotchi();
				break;
			case WERTE:
				showCondition();
				break;
			}}
	}

	/**
	 * 
	 * @param e
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		try {
			Tamagotchi currentTamagotchiTemporary = blT.getCurrentUser().getTamagotchi(); 

			for(TamagotchiConfig TamagotchiConfig : blU.getTamagotchiConfig())
			{
				char specialChar = e.getKeyText(e.getKeyCode()).charAt(0);

				if(specialChar == TamagotchiConfig.getHotkey())
				{
					reactToAction(TamagotchiConfig.getCode());
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//lblEreignis.setText(e.getKeyChar() + "");

	}

	@Override
	public void keyTyped(KeyEvent e) {
		//lblEreignis.setText(e.getKeyChar() + "");

	}
}

