package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.border.TitledBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import bl.BLUser;
import bo.Highscore;

public class LoginScreen extends JFrame implements ActionListener  {
	
	private JPanel loginGroup;
	private JTextField account, password;
	private JTextField txtNickname;
	private JPasswordField txtPasswort;
	private JTable table;
	private JLabel lblFehlermeldung;
	private JButton btnLogin;
	private BLUser blU = new BLUser();
	
	public LoginScreen() {
		super("Ohsom - Anmelden");
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblLogin = new JLabel("Login:");
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogin.anchor = GridBagConstraints.EAST;
		gbc_lblLogin.gridx = 0;
		gbc_lblLogin.gridy = 2;
		panel.add(lblLogin, gbc_lblLogin);
		
		txtNickname = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		panel.add(txtNickname, gbc_textField);
		txtNickname.setColumns(10);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		GridBagConstraints gbc_lblPasswort = new GridBagConstraints();
		gbc_lblPasswort.anchor = GridBagConstraints.EAST;
		gbc_lblPasswort.insets = new Insets(0, 0, 5, 5);
		gbc_lblPasswort.gridx = 0;
		gbc_lblPasswort.gridy = 3;
		panel.add(lblPasswort, gbc_lblPasswort);
		
		txtPasswort = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 3;
		panel.add(txtPasswort, gbc_passwordField);
		
		btnLogin = new JButton("Login");
		
		btnLogin.addActionListener(this);
		
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogin.anchor = GridBagConstraints.EAST;
		gbc_btnLogin.gridx = 1;
		gbc_btnLogin.gridy = 4;
		panel.add(btnLogin, gbc_btnLogin);
		
		lblFehlermeldung = new JLabel("");
		lblFehlermeldung.setForeground(Color.RED);
		
		GridBagConstraints gbc_lblFehlerFehler = new GridBagConstraints();
		gbc_lblFehlerFehler.gridwidth = 2;
		gbc_lblFehlerFehler.gridx = 0;
		gbc_lblFehlerFehler.gridy = 5;
		panel.add(lblFehlermeldung, gbc_lblFehlerFehler);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Highscore", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
				getHighscoreData(),
			new String[] {
				"Name", "Highscore"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(154);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(220);
		
		JLabel lblCreate = new JLabel("Account erstellen");
		getContentPane().add(lblCreate, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnLogin)
		{
			validateInput();
		}
	}

	public void validateInput()
	{
		if(!isUserInputValid())
		{
			lblFehlermeldung.setText("Passwort und Nickname, du Idiot!");
		}
		else
		{
			if(!blU.isUserDataValid(txtNickname.getText(), txtPasswort.getText()))
			{
				lblFehlermeldung.setText("Falsches Passwort für diesen Nickname.");
			}
			else
			{
				TamagotchiGUI tGui = new TamagotchiGUI(blU.getCurrentUser());
			}
		}
	}

	public boolean isUserInputValid()
	{
		return !(txtPasswort.getText().equals("") || txtNickname.getText().equals(""));
	}
	
	@SuppressWarnings("null")
	public Object[][] getHighscoreData()
	{
		Object[][] ObjectList = null;
		int i = 0;
		for(Highscore h : blU.getAllHighscores())
			{
				ObjectList[i][0] = h.getUser();
				ObjectList[i][1] = h.getPunkte();
				i++;
			};
			
			return ObjectList;
	}
	


}
