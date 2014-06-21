package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import bl.BLNachrichten;
import bl.BLTamagotchi;
import bl.BLUser;
import bo.Code;
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

/**
 * TamagotchiGUI is a GUI especially for playing with your Tamagotchi
 * @author Snatsch
 *
 */
public class TamagotchiGUI implements ActionListener, KeyListener{

	private Thread TamagotchiThread = new Thread(new TamagotchiThread());

	private BLTamagotchi blT = null;

	private BLNachrichten blN = null;

	private JFrame frmOhsom;

	private static JButton lblNeueNachrichten = new JButton("Neue Nachrichten");

	private JButton lblNachrichtVerfassen = new JButton("Nachricht verfassen");

	private JButton btnPref = new JButton("pref");

	private JButton btnReset;

	private JButton btnHelp;

	private JLabel lblEreignis = new JLabel("Es ist etwas passiert!");

	private TamagotchiGfx pnlTamagotchi;

	private JPanel pnlTamagotchiButtons;

	private JButton btnWerte;

	private JButton btnFuettern;

	private JButton btnTrinken;

	private JButton btnWaschen;

	private JButton btnSchlafen;

	private JButton btnSpielen;
	
	private JButton btnMedizin;

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public TamagotchiGUI() throws SQLException {
		blT = new BLTamagotchi();
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
		frmOhsom.setResizable(false);
		frmOhsom.addKeyListener(this);
		frmOhsom.setTitle("Ohsom");
		frmOhsom.setBounds(100, 100, 750, 600);
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
		gbc_btnReset.gridy = 9;
		if(blT.getCurrentUser().hasTamagotchi() == false)
		{
			btnReset.disable();
		}
		panel.add(btnReset, gbc_btnReset);

		/*JPanel pnlTamagotchi = new JPanel();
		frmOhsom.getContentPane().add(pnlTamagotchi, BorderLayout.CENTER);*/

		JPanel panel_1 = new JPanel(new BorderLayout());
		frmOhsom.getContentPane().add(panel_1, BorderLayout.CENTER);

		pnlTamagotchi = new TamagotchiGfx();
		panel_1.add(pnlTamagotchi, BorderLayout.CENTER);

		pnlTamagotchiButtons = new JPanel(new FlowLayout(FlowLayout.LEADING));

		btnWerte = new JButton("Werte");
		pnlTamagotchiButtons.add(btnWerte);

		btnFuettern = new JButton("Füttern");
		pnlTamagotchiButtons.add(btnFuettern);

		btnTrinken = new JButton("Trinken");
		pnlTamagotchiButtons.add(btnTrinken);

		btnWaschen = new JButton("Waschen");
		pnlTamagotchiButtons.add(btnWaschen);

		btnSchlafen = new JButton("Schlafen");
		pnlTamagotchiButtons.add(btnSchlafen);

		btnSpielen = new JButton("Spielen");
		pnlTamagotchiButtons.add(btnSpielen);
		
		btnMedizin = new JButton("Medizin");
		pnlTamagotchiButtons.add(btnMedizin);

		panel_1.add(pnlTamagotchiButtons, BorderLayout.SOUTH);

		panel_1.add(lblEreignis, BorderLayout.NORTH);

		frmOhsom.setVisible(true);
		frmOhsom.requestFocusInWindow();
	}

	public static void refreshTamagotchiArea()
	{
		//lblNeueNachrichten.setText("Neue Nachrichten (" + blN.getCountOfUnreadNachrichten() + ")");
	}

	public void resetTamagotchi() throws SQLException
	{
		String Name = null;
		while((Name == null) || (Name).length() == 0 || (Name).length() > 10) {
			String askForName = (String)JOptionPane.showInputDialog(
					new JFrame(),
					"Type in the Name of your Tamagotchi (not longer than 10 letters)",
					"Ohsom - Tamagotchi Name",
					JOptionPane.PLAIN_MESSAGE,
					null,
					null, 
					"Name...");
			Name = askForName;
		}
		
		if(blT.resetTamagotchi(Name))
		{
			setEreignisLabel("Du hast dein Tamagotchi erfolgreich resetet");
		}

	}

	/**
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == lblNeueNachrichten)
			{
				MessagesGUI msggui = new MessagesGUI();
			}
			else if(e.getSource() == btnReset)
			{
				resetTamagotchi();
			}
			else if (e.getSource() == lblNachrichtVerfassen)
			{
				try {
					NewMessageGUI nmgui = new NewMessageGUI();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if (e.getSource() == btnPref)
			{

				ConfigurationGUI cgui = new ConfigurationGUI(blT.getCurrentUser());	

			}
			else if(e.getSource() == btnHelp)
			{
				// TODO: Hier sollte ein Handbuch aufgerufen werden
			}
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void washTamagotchi() throws SQLException
	{
		if(blT.washTamagotchi())
		{
			setEreignisLabel("Dein Tamagotchi ist nun schön sauber");
		}
	}
	
	public void layTamagotchiToSleep() throws SQLException
	{
		if(blT.layTamagotchiToSleep()) {
			setEreignisLabel("Dein Tamagotchi schläft nun");
		}
	}

	public void gibMedizin() throws SQLException
	{
		if(blT.gibMedizin())
		{
			setEreignisLabel("Dein Tamagotchi ist nun wieder gesund");
		}
		else
		{
			setEreignisLabel("He, dein Tamagotchi ist schon gesund!");
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

	@Override
	public void keyPressed(KeyEvent e) {
		try {
			Tamagotchi currentTamagotchiTemporary = blT.getCurrentUser().getTamagotchi(); 

			Timestamp Today = new Timestamp(new java.util.Date().getTime());
			for(TamagotchiConfig TamagotchiConfig : blT.getCurrentUser().getConfig())
			{
				char specialChar = e.getKeyText(e.getKeyCode()).charAt(0);

				if(specialChar == TamagotchiConfig.getHotkey())
				{
					switch(TamagotchiConfig.getCode())
					{
					case FUETTERN:
						setEreignisLabel("Dein Tamagotchi hat nun keinen Hunger mehr :)");
						break;
					case SCHLAFENLEGEN:
						layTamagotchiToSleep();
						break;
					case SHOP:
						ShopGUI sGUI = new ShopGUI();
						break;
					case INVENTAR:
						setEreignisLabel("Dein Tamagotchi hat nun keinen Hunger mehr :)");
						break;
					case SPIELEN:
						setEreignisLabel("Dein Tamagotchi hat nun keinen Hunger mehr :)");
						break;
					case TRINKEN:
						setEreignisLabel("Dein Tamagotchi hat nun keinen Hunger mehr :)");
						break;
					case MEDIZIN:
						gibMedizin();
						break;
					case WASCHEN:
						washTamagotchi();
						break;
					case WERTE:
						setEreignisLabel("Dein Tamagotchi hat nun keinen Hunger mehr :)");
						break;
					}
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
