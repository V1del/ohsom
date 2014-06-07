package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Spinner;


public class ShopGUI {

	protected Shell shlShop;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ShopGUI window = new ShopGUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlShop.open();
		shlShop.layout();
		while (!shlShop.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlShop = new Shell();
		shlShop.setSize(450, 300);
		shlShop.setText("Shop");
		
		TabFolder tabFolder = new TabFolder(shlShop, SWT.NONE);
		tabFolder.setBounds(0, 0, 434, 261);
		// Add an event listener to write the selected tab to stdout
		tabFolder.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		TabItem tbtmMedicin = new TabItem(tabFolder, SWT.NONE);
		tbtmMedicin.setText("Medicin");
		
		Composite cmpMedicin = new Composite(tabFolder, SWT.NONE);
		tbtmMedicin.setControl(cmpMedicin);
		
		Label lblMedicine = new Label(cmpMedicin, SWT.NONE);
		lblMedicine.setBounds(10, 10, 55, 15);
		lblMedicine.setText("Medicine:");
		
		Label lblCurrentMedicine = new Label(cmpMedicin, SWT.NONE);
		lblCurrentMedicine.setBounds(71, 10, 28, 15);
		lblCurrentMedicine.setText("0");
		
		Label lblNewLabel = new Label(cmpMedicin, SWT.NONE);
		lblNewLabel.setBounds(127, 10, 55, 15);
		lblNewLabel.setText("Money:");
		
		Label lblCurrentMoney = new Label(cmpMedicin, SWT.NONE);
		lblCurrentMoney.setBounds(188, 10, 55, 15);
		lblCurrentMoney.setText("0 \u00A5");
		
		Group grpBuyMedicine = new Group(cmpMedicin, SWT.NONE);
		grpBuyMedicine.setText("Buy Medicine");
		grpBuyMedicine.setBounds(10, 31, 406, 192);
		
		Label lblHowMuchMedicine = new Label(grpBuyMedicine, SWT.NONE);
		lblHowMuchMedicine.setBounds(10, 24, 240, 15);
		lblHowMuchMedicine.setText("How much medicine do want to buy?");
		
		Spinner spnAmount = new Spinner(grpBuyMedicine, SWT.BORDER);
		spnAmount.setBounds(10, 45, 47, 22);
		
		Button btnBuyMedicin = new Button(grpBuyMedicine, SWT.NONE);
		btnBuyMedicin.setBounds(63, 43, 75, 25);
		btnBuyMedicin.setText("Buy");
		
		Label lblCostsMedicine = new Label(grpBuyMedicine, SWT.NONE);
		lblCostsMedicine.setBounds(10, 86, 55, 15);
		lblCostsMedicine.setText("Costs: 0 \u00A5");
		
		TabItem tbtmFood = new TabItem(tabFolder, SWT.NONE);
		tbtmFood.setText("Food");
		
		Composite cmpFood = new Composite(tabFolder, SWT.NONE);
		tbtmFood.setControl(cmpFood);
		
		TabItem tbtmDrinks = new TabItem(tabFolder, SWT.NONE);
		tbtmDrinks.setText("Drinks");
		
		Composite cmpDrink = new Composite(tabFolder, SWT.NONE);
		tbtmDrinks.setControl(cmpDrink);
		
		TabItem tbtmOthers = new TabItem(tabFolder, SWT.NONE);
		tbtmOthers.setText("Others");
		
		Composite cmpOthers = new Composite(tabFolder, SWT.NONE);
		tbtmOthers.setControl(cmpOthers);

	}
}

/*
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JToggleButton;

public class ShopGUI implements ActionListener{

	private JFrame frmShop;

	
	private JSpinner spAnzahl;
	private JButton btnMedizinKaufen, btnTrinkenKaufen, btnNewButton;
	
	JToggleButton btnEssen1, btnEssen2, btnEssen3, btnEssen4, btnEssen5, btnGetraenk1, btnGetraenk2, btnGetraenk3, btnGetraenk4, btnGetraenk5;
	JLabel lblGeld, lblGeldValue, lblMedizin, lblMedizinValue, lblKostenValue;
	
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

	public ShopGUI() {
		initialize();
	}
	private void initialize() {
		frmShop = new JFrame();
		frmShop.setTitle("Shop");
		frmShop.setBounds(100, 100, 450, 300);
		frmShop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmShop.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
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
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 1;
		pnlMedizin.add(lblMedizinValue, gbc_label);
		
		lblGeld = new JLabel("Geld: ");
		GridBagConstraints gbc_lblGeld = new GridBagConstraints();
		gbc_lblGeld.insets = new Insets(0, 0, 5, 5);
		gbc_lblGeld.gridx = 4;
		gbc_lblGeld.gridy = 1;
		pnlMedizin.add(lblGeld, gbc_lblGeld);
		
		lblGeldValue = new JLabel("100");
		GridBagConstraints gbc_lblGeldValue = new GridBagConstraints();
		gbc_lblGeldValue.insets = new Insets(0, 0, 5, 0);
		gbc_lblGeldValue.gridx = 5;
		gbc_lblGeldValue.gridy = 1;
		pnlMedizin.add(lblGeldValue, gbc_lblGeldValue);
		
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
		
		JLabel lblWieVielMedizin = new JLabel("Wie viel Medizin möchtest du kaufen?");
		GridBagConstraints gbc_lblWieVielMedizin = new GridBagConstraints();
		gbc_lblWieVielMedizin.insets = new Insets(0, 0, 5, 0);
		gbc_lblWieVielMedizin.gridwidth = 2;
		gbc_lblWieVielMedizin.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblWieVielMedizin.gridx = 0;
		gbc_lblWieVielMedizin.gridy = 0;
		panel_1.add(lblWieVielMedizin, gbc_lblWieVielMedizin);
		
		spAnzahl = new JSpinner();
		spAnzahl.setModel(new SpinnerNumberModel(new Integer(15), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_spAnzahl = new GridBagConstraints();
		gbc_spAnzahl.insets = new Insets(0, 0, 5, 5);
		gbc_spAnzahl.gridx = 0;
		gbc_spAnzahl.gridy = 1;
		panel_1.add(spAnzahl, gbc_spAnzahl);
		
		btnMedizinKaufen = new JButton("Kaufen");
		btnMedizinKaufen.addActionListener(this);
		GridBagConstraints gbc_btnKaufen = new GridBagConstraints();
		gbc_btnKaufen.insets = new Insets(0, 0, 5, 0);
		gbc_btnKaufen.anchor = GridBagConstraints.WEST;
		gbc_btnKaufen.gridx = 1;
		gbc_btnKaufen.gridy = 1;
		panel_1.add(btnMedizinKaufen, gbc_btnKaufen);
		
		JLabel lblKosten = new JLabel("Kosten: ");
		GridBagConstraints gbc_lblKosten = new GridBagConstraints();
		gbc_lblKosten.insets = new Insets(0, 0, 5, 5);
		gbc_lblKosten.gridx = 0;
		gbc_lblKosten.gridy = 2;
		panel_1.add(lblKosten, gbc_lblKosten);
		
		lblKostenValue = new JLabel("150");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		panel_1.add(lblKostenValue, gbc_lblNewLabel);
		
		JLabel lblFehlermeldung = new JLabel("Fehlermeldung");
		lblFehlermeldung.setForeground(Color.RED);
		GridBagConstraints gbc_lblFehlermeldung = new GridBagConstraints();
		gbc_lblFehlermeldung.anchor = GridBagConstraints.WEST;
		gbc_lblFehlermeldung.gridwidth = 2;
		gbc_lblFehlermeldung.insets = new Insets(0, 0, 0, 5);
		gbc_lblFehlermeldung.gridx = 0;
		gbc_lblFehlermeldung.gridy = 4;
		panel_1.add(lblFehlermeldung, gbc_lblFehlermeldung);
		
		JPanel pnlEssen = new JPanel();
		tabbedPane.addTab("Essen", null, pnlEssen, null);
		GridBagLayout gbl_pnlEssen = new GridBagLayout();
		gbl_pnlEssen.columnWidths = new int[]{35, 0, 0, 0, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlEssen.rowHeights = new int[]{30, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlEssen.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlEssen.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		pnlEssen.setLayout(gbl_pnlEssen);
		
		JLabel lblGeld2 = new JLabel("Geld: ");
		GridBagConstraints gbc_lblGeld2 = new GridBagConstraints();
		gbc_lblGeld2.insets = new Insets(0, 0, 5, 5);
		gbc_lblGeld2.gridx = 2;
		gbc_lblGeld2.gridy = 1;
		pnlEssen.add(lblGeld, gbc_lblGeld2);
		
		JLabel label_2 = new JLabel("10"); 
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 3;
		gbc_label_2.gridy = 1;
		pnlEssen.add(lblGeldValue, gbc_label_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.gridwidth = 12;
		gbc_panel_4.anchor = GridBagConstraints.NORTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 2;
		pnlEssen.add(panel_4, gbc_panel_4);
		
		btnEssen1 = new JToggleButton("?");
		panel_4.add(btnEssen1);
		
		btnEssen2 = new JToggleButton("?");
		panel_4.add(btnEssen2);
		
		btnEssen3 = new JToggleButton("?");
		panel_4.add(btnEssen3);
		
		btnEssen4 = new JToggleButton("?");
		panel_4.add(btnEssen4);
		
		btnEssen5 = new JToggleButton("?");
		panel_4.add(btnEssen5);
		
		btnNewButton = new JButton("Essen kaufen");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 4;
		pnlEssen.add(btnNewButton, gbc_btnNewButton);
		
		JPanel pnlInventar = new JPanel();
		pnlInventar.setBorder(new TitledBorder(null, "Inventar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.gridwidth = 6;
		gbc_panel_5.insets = new Insets(0, 0, 0, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 4;
		gbc_panel_5.gridy = 6;
		pnlEssen.add(pnlInventar, gbc_panel_5);
		
		JButton button = new JButton("?");
		pnlInventar.add(button);
		
		JButton button_1 = new JButton("?");
		pnlInventar.add(button_1);
		
		JButton button_2 = new JButton("?");
		pnlInventar.add(button_2);
		
		JButton button_3 = new JButton("?");
		pnlInventar.add(button_3);
		
		JButton button_4 = new JButton("?");
		pnlInventar.add(button_4);
		
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
		panel_6.add(lblGeld, gbc_label_3);
		
		JLabel label_4 = new JLabel("10");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 3;
		gbc_label_4.gridy = 1;
		panel_6.add(lblGeldValue, gbc_label_4);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.anchor = GridBagConstraints.NORTH;
		gbc_panel_7.gridwidth = 6;
		gbc_panel_7.insets = new Insets(0, 0, 5, 5);
		gbc_panel_7.gridx = 4;
		gbc_panel_7.gridy = 2;
		panel_6.add(panel_7, gbc_panel_7);
		
		btnGetraenk1 = new JToggleButton("?");
		panel_7.add(btnGetraenk1);
		
		btnGetraenk2 = new JToggleButton("?");
		panel_7.add(btnGetraenk2);
		
		btnGetraenk3 = new JToggleButton("?");
		panel_7.add(btnGetraenk3);
		
		btnGetraenk4 = new JToggleButton("?");
		panel_7.add(btnGetraenk4);
		
		btnGetraenk5 = new JToggleButton("?");
		panel_7.add(btnGetraenk5);
		
		btnTrinkenKaufen = new JButton("Getränk kaufen");
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
		
		frmShop.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnMedizinKaufen)
		{
			spAnzahl.getValue();
		}
		
	}
}*/
