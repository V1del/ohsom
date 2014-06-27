package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JToggleButton;

import bl.BLShopartikel;
import bl.BLTamagotchi;
import bo.Item;
import bo.Kategorie;
import bo.Shopartikel;
import bo.Tamagotchi;
import bo.User;

/**
 * GUI für den Shop
 * @author Snatsch
 *
 */
public class ShopGUI extends JDialog implements ActionListener, ChangeListener{

	private BLShopartikel blS = null;
	private BLTamagotchi blT = null;

	private JSpinner spAnzahlMedizin;
	private JButton btnMedizinKaufen, btnEssenKaufen, btnTrinkenKaufen;
	private Map<String, JToggleButton> BtnAuswahlMap = new HashMap<String, JToggleButton>();
	private Map<JToggleButton, Integer> BtnAuswahlValuesMap = new HashMap<JToggleButton, Integer>();
	private JPanel pnlEssenAuswahl, pnlGetraenkeAuswahl, pnlInventarEssen, pnlInventarTrinken;

	private Map<String, JButton> BtnInventarMap = new HashMap<String, JButton>();
	private Map<JButton, Item> BtnInventarValuesMap = new HashMap<JButton, Item>();

	JToggleButton btnEssen1 = new JToggleButton("?");
	JToggleButton btnEssen2 = new JToggleButton("?");
	JToggleButton btnEssen3 = new JToggleButton("?");
	JToggleButton btnEssen4 = new JToggleButton("?"); 
	JToggleButton btnEssen5 = new JToggleButton("?");
	JToggleButton btnGetraenk1 = new JToggleButton("?");
	JToggleButton btnGetraenk2 = new JToggleButton("?");
	JToggleButton btnGetraenk3 = new JToggleButton("?"); 
	JToggleButton btnGetraenk4 = new JToggleButton("?"); 
	JToggleButton btnGetraenk5 = new JToggleButton("?");

	JButton btnItemEssen1 = new JButton("?");
	JButton btnItemEssen2 = new JButton("?");
	JButton btnItemEssen3 = new JButton("?");
	JButton btnItemEssen4 = new JButton("?");
	JButton btnItemEssen5 = new JButton("?");
	JButton btnItemGetraenk1 = new JButton("?");
	JButton btnItemGetraenk2 = new JButton("?");
	JButton btnItemGetraenk3 = new JButton("?");
	JButton btnItemGetraenk4 = new JButton("?");
	JButton btnItemGetraenk5 = new JButton("?");

	JLabel lblGeldValue, lblMedizin, lblMedizinValue, lblKostenValue, lblFehlermeldung;
	
	private JLabel[][] lblGeld = new JLabel[3][2];
	private JLabel[][] lblKosten = new JLabel[3][2];
	private JLabel lblGeldTrinken, lblKostenTrinken;
	private JLabel lblGeldEssen, lblKostenEssen;

	
	private JLabel lblFehlermeldungTrinken;
	private JLabel lblFehlermeldungEssen;
	private JLabel lblGeldMedizinValue;
	private JLabel lblKosten_1;
	private JLabel lblKostenValue_1;
	private JLabel lblKosten_2;
	private JLabel lblkostenvalue_2;
	
	/**
	 * Konstruktor, der die Map fÃ¼llt => Ersatz zu variablen Variablen
	 * @throws SQLException
	 */
	public ShopGUI() throws SQLException {
		blS = new BLShopartikel();
		blT = new BLTamagotchi();

		BtnAuswahlMap.put("btnEssen1", btnEssen1);
		BtnAuswahlMap.put("btnEssen2", btnEssen2);
		BtnAuswahlMap.put("btnEssen3", btnEssen3);
		BtnAuswahlMap.put("btnEssen4", btnEssen4);
		BtnAuswahlMap.put("btnEssen5", btnEssen5);
		BtnAuswahlMap.put("btnGetraenk1", btnGetraenk1);
		BtnAuswahlMap.put("btnGetraenk2", btnGetraenk2);
		BtnAuswahlMap.put("btnGetraenk3", btnGetraenk3);
		BtnAuswahlMap.put("btnGetraenk4", btnGetraenk4);
		BtnAuswahlMap.put("btnGetraenk5", btnGetraenk5);

		BtnInventarMap.put("btnItemEssen1", btnItemEssen1);
		BtnInventarMap.put("btnItemEssen2", btnItemEssen2);
		BtnInventarMap.put("btnItemEssen3", btnItemEssen3);
		BtnInventarMap.put("btnItemEssen4", btnItemEssen4);
		BtnInventarMap.put("btnItemEssen5", btnItemEssen5);
		BtnInventarMap.put("btnItemGetraenk1", btnItemGetraenk1);
		BtnInventarMap.put("btnItemGetraenk2", btnItemGetraenk2);
		BtnInventarMap.put("btnItemGetraenk3", btnItemGetraenk3);
		BtnInventarMap.put("btnItemGetraenk4", btnItemGetraenk4);
		BtnInventarMap.put("btnItemGetraenk5", btnItemGetraenk5);

		initialize();
	}
	private void initialize() throws SQLException {
		new JDialog();
		setModal(true);
		setTitle("Shop");
		this.setIconImage(new ImageIcon("Sources/gfx/Icon_Ohsom.png").getImage());
		setBounds(100, 100, 450, 350);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel pnlMedizin = new JPanel();
		tabbedPane.addTab("Medizin", null, pnlMedizin, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		pnlMedizin.setLayout(gbl_panel);

		lblMedizin = new JLabel("Medizin: ");
		GridBagConstraints gbc_lblMedizin = new GridBagConstraints();
		gbc_lblMedizin.insets = new Insets(0, 0, 5, 5);
		gbc_lblMedizin.gridx = 1;
		gbc_lblMedizin.gridy = 1;
		pnlMedizin.add(lblMedizin, gbc_lblMedizin);

		lblMedizinValue = new JLabel("10");
		GridBagConstraints gbc_lblMedizinValue;
		gbc_lblMedizinValue = new GridBagConstraints();
		gbc_lblMedizinValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblMedizinValue.gridx = 2;
		gbc_lblMedizinValue.gridy = 1;
		pnlMedizin.add(lblMedizinValue, gbc_lblMedizinValue);

		lblGeld[0][0] = new JLabel("Geld: ");
		GridBagConstraints gbc_lblGeld = new GridBagConstraints();
		gbc_lblGeld.insets = new Insets(0, 0, 5, 5);
		gbc_lblGeld.gridx = 4;
		gbc_lblGeld.gridy = 1;
		pnlMedizin.add(lblGeld[0][0], gbc_lblGeld);

		lblGeld[0][1] = new JLabel("100");
		GridBagConstraints gbc_lblGeldValue = new GridBagConstraints();
		gbc_lblGeldValue.insets = new Insets(0, 0, 5, 0);
		gbc_lblGeldValue.gridx = 5;
		gbc_lblGeldValue.gridy = 1;
		pnlMedizin.add(lblGeld[0][1], gbc_lblGeldValue);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Medizin kaufen", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridwidth = 6;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 3;
		pnlMedizin.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{70, 266, 0};
		gbl_panel_1.rowHeights = new int[]{15, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);

		JLabel lblWieVielMedizin = new JLabel("Wie viel Medizin m�chtest du kaufen?");
		GridBagConstraints gbc_lblWieVielMedizin = new GridBagConstraints();
		gbc_lblWieVielMedizin.insets = new Insets(0, 0, 5, 0);
		gbc_lblWieVielMedizin.gridwidth = 2;
		gbc_lblWieVielMedizin.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblWieVielMedizin.gridx = 0;
		gbc_lblWieVielMedizin.gridy = 0;
		panel_1.add(lblWieVielMedizin, gbc_lblWieVielMedizin);

		spAnzahlMedizin = new JSpinner();
		spAnzahlMedizin.addChangeListener(this);
		spAnzahlMedizin.setModel(new SpinnerNumberModel(new Integer(15), new Integer(0), new Integer(100), new Integer(1)));
		GridBagConstraints gbc_spAnzahl = new GridBagConstraints();
		gbc_spAnzahl.insets = new Insets(0, 0, 5, 5);
		gbc_spAnzahl.gridx = 0;
		gbc_spAnzahl.gridy = 1;
		panel_1.add(spAnzahlMedizin, gbc_spAnzahl);

		btnMedizinKaufen = new JButton("Kaufen");
		btnMedizinKaufen.addActionListener(this);
		GridBagConstraints gbc_btnKaufen = new GridBagConstraints();
		gbc_btnKaufen.insets = new Insets(0, 0, 5, 0);
		gbc_btnKaufen.anchor = GridBagConstraints.WEST;
		gbc_btnKaufen.gridx = 1;
		gbc_btnKaufen.gridy = 1;
		panel_1.add(btnMedizinKaufen, gbc_btnKaufen);

		lblKosten[0][0] = new JLabel("Kosten: ");
		GridBagConstraints gbc_lblKosten = new GridBagConstraints();
		gbc_lblKosten.insets = new Insets(0, 0, 5, 5);
		gbc_lblKosten.gridx = 0;
		gbc_lblKosten.gridy = 2;
		panel_1.add(lblKosten[0][0], gbc_lblKosten);

		lblKosten[0][1] = new JLabel("150");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		panel_1.add(lblKosten[0][1], gbc_lblNewLabel);

		lblFehlermeldung = new JLabel("Fehlermeldung");
		lblFehlermeldung.setForeground(Color.RED);
		GridBagConstraints gbc_lblFehlermeldung = new GridBagConstraints();
		gbc_lblFehlermeldung.anchor = GridBagConstraints.WEST;
		gbc_lblFehlermeldung.gridwidth = 2;
		gbc_lblFehlermeldung.insets = new Insets(0, 0, 0, 5);
		gbc_lblFehlermeldung.gridx = 0;
		gbc_lblFehlermeldung.gridy = 4;
		panel_1.add(lblFehlermeldung, gbc_lblFehlermeldung);

		lblFehlermeldung.setVisible(false);

		JPanel pnlEssen = new JPanel();
		tabbedPane.addTab("Essen", null, pnlEssen, null);
		GridBagLayout gbl_pnlEssen = new GridBagLayout();
		gbl_pnlEssen.columnWidths = new int[]{35, 0, 0, 0, 44, 0, 0, 0};
		gbl_pnlEssen.rowHeights = new int[]{30, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlEssen.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlEssen.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlEssen.setLayout(gbl_pnlEssen);
		
		lblGeld[1][0] = new JLabel("Geld: ");
		GridBagConstraints gbc_lblGeld2 = new GridBagConstraints();
		gbc_lblGeld2.insets = new Insets(0, 0, 5, 5);
		gbc_lblGeld2.gridx = 2;
		gbc_lblGeld2.gridy = 1;
		pnlEssen.add(lblGeld[1][0], gbc_lblGeld2);

		lblGeld[1][1] = new JLabel("0");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 3;
		gbc_label_2.gridy = 1;
		pnlEssen.add(lblGeld[1][1], gbc_label_2);

		pnlEssenAuswahl = new JPanel();
		pnlEssenAuswahl.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.gridwidth = 5;
		gbc_panel_4.anchor = GridBagConstraints.NORTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 2;
		pnlEssen.add(pnlEssenAuswahl, gbc_panel_4);

		fillFood(pnlEssenAuswahl);

		btnEssenKaufen = new JButton("Essen kaufen");
		btnEssenKaufen.addActionListener(this);
		
		lblKosten[1][0] = new JLabel("Kosten: ");
		GridBagConstraints gbc_lblKosten_1 = new GridBagConstraints();
		gbc_lblKosten_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblKosten_1.gridx = 1;
		gbc_lblKosten_1.gridy = 4;
		pnlEssen.add(lblKosten[1][0], gbc_lblKosten_1);
		
		lblKosten[1][1] = new JLabel("0");
		GridBagConstraints gbc_lblKostenValue_1 = new GridBagConstraints();
		gbc_lblKostenValue_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblKostenValue_1.gridx = 2;
		gbc_lblKostenValue_1.gridy = 4;
		pnlEssen.add(lblKosten[1][1], gbc_lblKostenValue_1);
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 4;
		pnlEssen.add(btnEssenKaufen, gbc_btnNewButton);

		pnlInventarEssen = new JPanel();
		pnlInventarEssen.setBorder(new TitledBorder(null, "Inventar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pnlInventarEssen = new GridBagConstraints();
		gbc_pnlInventarEssen.gridwidth = 6;
		gbc_pnlInventarEssen.insets = new Insets(0, 0, 5, 0);
		gbc_pnlInventarEssen.fill = GridBagConstraints.BOTH;
		gbc_pnlInventarEssen.gridx = 1;
		gbc_pnlInventarEssen.gridy = 6;
		pnlEssen.add(pnlInventarEssen, gbc_pnlInventarEssen);

		fillFoodInventarPanel(pnlInventarEssen);

		lblFehlermeldungEssen = new JLabel("Fehlermeldung");
		lblFehlermeldungEssen.setForeground(Color.RED);
		GridBagConstraints gbc_lblFehlermeldungEssen = new GridBagConstraints();
		gbc_lblFehlermeldungEssen.anchor = GridBagConstraints.WEST;
		gbc_lblFehlermeldungEssen.gridwidth = 6;
		gbc_lblFehlermeldungEssen.insets = new Insets(0, 0, 0, 5);
		gbc_lblFehlermeldungEssen.gridx = 1;
		gbc_lblFehlermeldungEssen.gridy = 7;
		pnlEssen.add(lblFehlermeldungEssen, gbc_lblFehlermeldungEssen);

		lblFehlermeldungEssen.setVisible(false);

		JPanel pnlGetraenke = new JPanel();
		tabbedPane.addTab("Getränke", null, pnlGetraenke, null);
		GridBagLayout gbl_pnlGetraenke = new GridBagLayout();
		gbl_pnlGetraenke.columnWidths = new int[]{35, 0, 0, 0, 44, 0, 0, 0};
		gbl_pnlGetraenke.rowHeights = new int[]{30, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlGetraenke.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlGetraenke.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlGetraenke.setLayout(gbl_pnlGetraenke);

		btnTrinkenKaufen = new JButton("Getränk kaufen");
		btnTrinkenKaufen.addActionListener(this);
		//panel_6.add(lblGeldValue, gbc_label_4);
		
		btnTrinkenKaufen = new JButton("Getränk kaufen");
		btnTrinkenKaufen.addActionListener(this);
		//panel_6.add(lblGeldValue, gbc_label_4);
		
		pnlGetraenkeAuswahl = new JPanel();
		pnlGetraenkeAuswahl.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.anchor = GridBagConstraints.NORTH;
		gbc_panel_7.gridwidth = 5;
		gbc_panel_7.insets = new Insets(0, 0, 5, 5);
		gbc_panel_7.gridx = 1;
		gbc_panel_7.gridy = 2;
		pnlGetraenke.add(pnlGetraenkeAuswahl, gbc_panel_7);

		fillDrinks(pnlGetraenkeAuswahl);
		
		lblKosten[2][0] = new JLabel("Kosten: ");
		GridBagConstraints gbc_lblKosten_2 = new GridBagConstraints();
		gbc_lblKosten_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblKosten_2.gridx = 1;
		gbc_lblKosten_2.gridy = 4;
		pnlGetraenke.add(lblKosten[2][0], gbc_lblKosten_2);
		
		lblKosten[2][1] = new JLabel("100");
		GridBagConstraints gbc_lblkostenvalue_2 = new GridBagConstraints();
		gbc_lblkostenvalue_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblkostenvalue_2.gridx = 2;
		gbc_lblkostenvalue_2.gridy = 4;
		pnlGetraenke.add(lblKosten[2][1], gbc_lblkostenvalue_2);
		GridBagConstraints gbc_btnTrinkenKaufen = new GridBagConstraints();
		gbc_btnTrinkenKaufen.insets = new Insets(0, 0, 5, 5);
		gbc_btnTrinkenKaufen.gridx = 5;
		gbc_btnTrinkenKaufen.gridy = 4;
		pnlGetraenke.add(btnTrinkenKaufen, gbc_btnTrinkenKaufen);

		pnlInventarTrinken = new JPanel();
		pnlInventarTrinken.setBorder(new TitledBorder(null, "Inventar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pnlInventarTrinken = new GridBagConstraints();
		gbc_pnlInventarTrinken.fill = GridBagConstraints.BOTH;
		gbc_pnlInventarTrinken.gridwidth = 6;
		gbc_pnlInventarTrinken.insets = new Insets(0, 0, 5, 0);
		gbc_pnlInventarTrinken.gridx = 1;
		gbc_pnlInventarTrinken.gridy = 6;
		pnlGetraenke.add(pnlInventarTrinken, gbc_pnlInventarTrinken);

		fillDrinkInventarPanel(pnlInventarTrinken);

		lblFehlermeldungTrinken = new JLabel("Fehlermeldung");
		lblFehlermeldungTrinken.setForeground(Color.RED);
		GridBagConstraints gbc_lblFehlermeldungTrinken;
		gbc_lblFehlermeldungTrinken = new GridBagConstraints();
		gbc_lblFehlermeldungTrinken.anchor = GridBagConstraints.WEST;
		gbc_lblFehlermeldungTrinken.gridwidth = 6;
		gbc_lblFehlermeldungTrinken.insets = new Insets(0, 0, 0, 5);
		gbc_lblFehlermeldungTrinken.gridx = 1;
		gbc_lblFehlermeldungTrinken.gridy = 7;
		pnlGetraenke.add(lblFehlermeldungTrinken, gbc_lblFehlermeldungTrinken);

		lblFehlermeldungTrinken.setVisible(false);

		lblGeld[2][0] = new JLabel("Geld: ");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 2;
		gbc_label_3.gridy = 1;
		pnlGetraenke.add(lblGeld[2][0], gbc_label_3);

		lblGeld[2][1] = new JLabel("100");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 3;
		gbc_label_4.gridy = 1;
		pnlGetraenke.add(lblGeld[2][1], gbc_label_4);
		
		RefreshMoneyLabels();

		setVisible(true);
	}

	/**
	 * Filler der Articlepanels (Essen und Trinken - Auswahl)
	 * @param pnlArticle
	 * @param katArticle
	 * @throws SQLException
	 */
	public void fillArticlePanel(JPanel pnlArticle, Kategorie katArticle) throws SQLException
	{
		int ArticleIndex = 1; 
	
		for(Shopartikel Artikel : blS.getFilteredShopartikel(katArticle))
		{	
			JToggleButton btnArticle = BtnAuswahlMap.get("btn" + katArticle.getBtnName() + ArticleIndex);
			BtnAuswahlValuesMap.put(btnArticle, Artikel.getId());
			btnArticle.setText("");
			btnArticle.setIcon(new ImageIcon("Sources/Shopartikel/" + Artikel.getArtikelImage()));
			pnlArticle.add(btnArticle);
			
			ArticleIndex++;
		}
	}
	
	/**
	 * Befüllen des Inventarpanels
	 * @param pnlInventar
	 * @param katItem
	 * @throws SQLException
	 */
	public void fillInventarPanel(JPanel pnlInventar, Kategorie katItem) throws SQLException
	{
		int Index = 1;
		
		pnlInventar.removeAll();

		for(int i = 1; i < 6; i++)
		{
			JButton btnItemEmpty = BtnInventarMap.get("btnItem" + katItem.getBtnName() + i);
			btnItemEmpty.setText("?");
			btnItemEmpty.setIcon(null);
			pnlInventar.add(btnItemEmpty);
		}
		
		for(Item Item : blT.getInventory(katItem))
		{
			JButton btnItem = BtnInventarMap.get("btnItem" + katItem.getBtnName() + Index);
			BtnInventarValuesMap.put(btnItem, Item);
			btnItem.setText("");
			btnItem.setIcon(new ImageIcon("Sources/Shopartikel/" + Item.getShopartikel().getArtikelImage()));
			btnItem.addActionListener(this);
			
			Index++;
		}
	}
	/**
	 * Befüllen des Panels mit Item aus dem Inventar => Essen
	 * @param pnlInventar
	 * @throws SQLException
	 */
	public void fillFoodInventarPanel(JPanel pnlInventar) throws SQLException
	{
		fillInventarPanel(pnlInventar, Kategorie.FUTTER);
	}
	
	/**
	 * Befüllen des Panels mit Items aus dem Inventar => Getränke
	 * @param pnlInventar => welches Panel
	 * @throws SQLException
	 */
	public void fillDrinkInventarPanel(JPanel pnlInventar) throws SQLException
	{
		fillInventarPanel(pnlInventar, Kategorie.GETRAENK);
	}

	/**
	 * 
	 * @throws SQLException
	 */
	public void RefreshMoneyLabels() throws SQLException
	{
		Tamagotchi currentTamagotchi = blT.getCurrentUser().getTamagotchi();
		for (int i = 0; i < 3; i++)
		{
			lblGeld[i][1].setText(String.valueOf(currentTamagotchi.getGeld()));
		}
		lblMedizinValue.setText(String.valueOf(currentTamagotchi.getMedizin()));
	}

	/**
	 * Befüllen des Panels mit den Artikeln => Essen
	 * @param pnlEssen => welches Panel
	 * @throws SQLException
	 */
	public void fillFood(JPanel pnlEssen) throws SQLException
	{
		fillArticlePanel(pnlEssen, Kategorie.FUTTER);
	}
	
	/**
	 * Befüllen des Panels mit den Artikeln => Getränke
	 * @param pnlTrinken => welches Panel
	 * @throws SQLException
	 */
	public void fillDrinks(JPanel pnlTrinken) throws SQLException
	{
		fillArticlePanel(pnlTrinken, Kategorie.GETRAENK);
	}
	
	/**
	 * Methode zur Verarbeitung (Gui - Logik) des Kaufs eines Shopartikels
	 * @return
	 * @throws SQLException
	 */
	public boolean BuyingItems() throws SQLException
	{
		boolean BuyingSuccessfully = false;

		for(Map.Entry BtnValueEntry : BtnAuswahlValuesMap.entrySet())
		{
			JToggleButton btnNeu = (JToggleButton) BtnValueEntry.getKey();
			if(btnNeu.isSelected())
			{
				BuyingSuccessfully = blT.kaufeItem(blS.getArticle((int)BtnValueEntry.getValue()));
			}
		}
		return BuyingSuccessfully; 
	}

	public void feedTamagotchi(Item Item) throws SQLException
	{
		if(blT.feedTamagotchi(Item))
		{
			fillFoodInventarPanel(pnlInventarEssen);
		}
		else
		{
			lblFehlermeldungEssen.setText("Dein Tamagotchi hat keinen Hunger.");
			lblFehlermeldungEssen.setVisible(true);
		}
	}
	
	public void giveTamagotchiADrink(Item Item) throws SQLException
	{
		if(blT.giveTamagotchiADrink(Item))
		{
			fillDrinkInventarPanel(pnlInventarTrinken);
		}
		else
		{
			lblFehlermeldungTrinken.setText("Dein Tamagotchi hat keinen Durst.");
			lblFehlermeldungTrinken.setVisible(true);
		}
	}
	
	/**
	 * ActionEvents für das Shopgui
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		try {	
			lblFehlermeldung.setVisible(false);
			lblFehlermeldungTrinken.setVisible(false);
			lblFehlermeldungEssen.setVisible(false);
			
			if(e.getSource() == btnMedizinKaufen)
			{
				if(!blT.kaufeMedizin((int)spAnzahlMedizin.getValue(), blS.getMedicinePrice((int)spAnzahlMedizin.getValue())))
				{
					lblFehlermeldung.setText("Die Medizin konnte nicht gekauft werden.");
					lblFehlermeldung.setVisible(true);
				}
			}
			else if(e.getSource() == btnEssenKaufen)
			{
				if(BuyingItems())
				{
					fillFoodInventarPanel(pnlInventarEssen);
				}
				else
				{
					lblFehlermeldungEssen.setText("Das Item konnte nicht gekauft werden.");
					lblFehlermeldungEssen.setVisible(true);
				}
			}
			else if(e.getSource() == btnTrinkenKaufen)
			{
				if(BuyingItems()){
					fillDrinkInventarPanel(pnlInventarTrinken);
				}
				else
				{
					lblFehlermeldungTrinken.setText("Das Trinken konnte nicht gekauft werden.");
					lblFehlermeldungTrinken.setVisible(true);
				}
			}
			else if(BtnInventarValuesMap.get(e.getSource()) != null)
			{				
				Item usedItem = BtnInventarValuesMap.get(e.getSource());
				if(usedItem.getShopartikel().getKategorie() == Kategorie.FUTTER)
				{
					feedTamagotchi(usedItem);
				}
				else
				{
					giveTamagotchiADrink(usedItem);
				}
			}

			RefreshMoneyLabels();
		}
		catch(Exception ex)
		{

		}
		finally{}
	}

	/**
	 * VerÃ¤nderung des Spinners wird sofort überprüft
	 * @param ce
	 */
	@Override
	public void stateChanged(ChangeEvent ce) {
		try {
			if(ce.getSource() == spAnzahlMedizin)
			{
				JSpinner Spinner = (JSpinner) ce.getSource();

				lblKosten[0][1].setText("" + blS.getMedicinePrice((int) Spinner.getValue()) + "");

			}
			if(BtnAuswahlValuesMap.get(ce.getSource()) != null)
			{
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
