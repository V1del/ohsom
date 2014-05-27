package gui;

import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.ProgressBar;

import bo.User;


public class AnmeldeGUI implements SelectionListener {

	protected Shell shlCreateUser;
	private Text txtUsername;
	private Text txtPassword;
	private Text txtPasswordSecurity;
	private Text txtEMail;
	private Button btnCancel, btnCreate;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AnmeldeGUI window = new AnmeldeGUI();
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
		shlCreateUser.open();
		shlCreateUser.layout();
		while (!shlCreateUser.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlCreateUser = new Shell();
		shlCreateUser.setSize(613, 300);
		shlCreateUser.setText("Create User");
		
		Group grpCreateAccount = new Group(shlCreateUser, SWT.NONE);
		grpCreateAccount.setText("Create Account");
		grpCreateAccount.setBounds(10, 10, 577, 241);
		
		Label lblNewLabel = new Label(grpCreateAccount, SWT.NONE);
		lblNewLabel.setBounds(10, 35, 55, 15);
		lblNewLabel.setText("Username:");
		
		Label lblPassword = new Label(grpCreateAccount, SWT.NONE);
		lblPassword.setBounds(10, 63, 55, 15);
		lblPassword.setText("Password:");
		
		txtUsername = new Text(grpCreateAccount, SWT.BORDER);
		txtUsername.setBounds(71, 32, 183, 21);
		
		txtPassword = new Text(grpCreateAccount, SWT.BORDER);
		txtPassword.setBounds(71, 60, 183, 21);
		
		Label lblPassword_1 = new Label(grpCreateAccount, SWT.NONE);
		lblPassword_1.setBounds(10, 91, 55, 15);
		lblPassword_1.setText("Password:");
		
		txtPasswordSecurity = new Text(grpCreateAccount, SWT.BORDER);
		txtPasswordSecurity.setBounds(71, 87, 183, 21);
		
		Label lblEmail = new Label(grpCreateAccount, SWT.NONE);
		lblEmail.setBounds(10, 119, 55, 15);
		lblEmail.setText("EMail:");
		
		txtEMail = new Text(grpCreateAccount, SWT.BORDER);
		txtEMail.setBounds(71, 116, 183, 21);
		
		btnCancel = new Button(grpCreateAccount, SWT.NONE);
		btnCancel.setBounds(179, 143, 75, 25);
		btnCancel.setText("Cancel");
		
		btnCreate = new Button(grpCreateAccount, SWT.NONE);
		btnCreate.addSelectionListener(this);
		btnCreate.setBounds(98, 143, 75, 25);
		btnCreate.setText("Create");
		
		Group grpPasswordSafety = new Group(grpCreateAccount, SWT.NONE);
		grpPasswordSafety.setText("Password safety");
		grpPasswordSafety.setBounds(276, 24, 280, 110);
		
		Link lkSafetyDesc = new Link(grpPasswordSafety, SWT.NONE);
		lkSafetyDesc.setBounds(10, 30, 49, 15);
		lkSafetyDesc.setText("<a>Bad</a>");
		
		ProgressBar pbPWSafety = new ProgressBar(grpPasswordSafety, SWT.NONE);
		pbPWSafety.setBounds(10, 51, 170, 17);
	}

	public void widgetSelected(SelectionEvent e) {
		if(e.getSource() == btnCreate)
		{
			lblFehlermeldung.setText(ValidateUserFormData());
			if(!lblFehlermeldung.getText().equals(""))
			{
				// User muss erfolgreich erstellt werden k�nnen
				//TamagotchiGUI tGui = new TamagotchiGUI();
				lblFehlermeldung.setVisible(true);
			}
			else
			{	
				User newUser = new User(txtUsername.getText(), txtPassword.getText(), txtEMail.getText());
				
				if(blU.createUser(newUser))
				{
					if(blU.isUserDataValid(newUser.getNickname(), newUser.getPasswort()))
					{
						
					}
				}
			}
		}
		else
		{
			ClearForm();
		}
		
	}

	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void ClearForm()
	{
		txtUsername.setText("");
		txtPassword.setText("");
		txtPasswordSecurity.setText("");
		txtEMail.setText("");
	}
	
	public String ValidateUserFormData()
	{
		String UserFormDataValidateResult = "";
		
		if(!txtUsername.getText().equalsIgnoreCase("") && !txtPassword.getText().equalsIgnoreCase("") && !txtPasswordSecurity.getText().equalsIgnoreCase("") && !txtEMail.getText().equalsIgnoreCase(""))
		{
			if(txtPassword.getText().equals(txtPasswordSecurity.getText()))
			{
				if(!txtEMail.getText().contains(".") || !txtEMail.getText().contains("@"))
				{
					UserFormDataValidateResult += "Dies ist kein zul�ssiges Mailformat\n";
				}
			}
			else
			{
				UserFormDataValidateResult += "Die beiden Passw�rter stimmen nicht �berein\n";				
			}
		
		}
		else
		{
			UserFormDataValidateResult += "Du hast nicht alle Felder ausgef�llt\n";
		}
			return UserFormDataValidateResult;
	}	
	}
	
	/*public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnCancel)
		{
			ClearForm();
		}
		else
		{
			lblFehlermeldung.setText(ValidateUserFormData());
			if(!lblFehlermeldung.getText().equals(""))
			{
				// User muss erfolgreich erstellt werden k�nnen
				//TamagotchiGUI tGui = new TamagotchiGUI();
				lblFehlermeldung.setVisible(true);
			}
			else
			{	
				User newUser = new User(txtUsername.getText(), txtPassword.getText(), txtEmail.getText());
				
				if(blU.createUser(newUser))
				{
					if(blU.isUserDataValid(newUser.getNickname(), newUser.getPasswort()))
					{
						
					}
				}
			}
		}
		
	}

	public void ClearForm()
	{
		txtUsername.setText("");
		txtPassword.setText("");
		txtPasswordSecurity.setText("");
		txtEmail.setText("");
	}
	
	public String ValidateUserFormData()
	{
		String UserFormDataValidateResult = "";
		
		if(!txtUsername.getText().equalsIgnoreCase("") && !txtPassword.getText().equalsIgnoreCase("") && !txtPasswordSecurity.getText().equalsIgnoreCase("") && !txtEmail.getText().equalsIgnoreCase(""))
		{
			if(txtPassword.getText().equals(txtPasswordSecurity.getText()))
			{
				if(!txtEmail.getText().contains(".") || !txtEmail.getText().contains("@"))
				{
					UserFormDataValidateResult += "Dies ist kein zul�ssiges Mailformat\n";
				}
			}
			else
			{
				UserFormDataValidateResult += "Die beiden Passw�rter stimmen nicht �berein\n";				
			}
		
		}
		else
		{
			UserFormDataValidateResult += "Du hast nicht alle Felder ausgef�llt\n";
		}
			return UserFormDataValidateResult;
	}
}

package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import bl.BLUser;
import bo.User;

public class AnmeldeGUI extends JFrame implements ActionListener {

	BLUser blU = new BLUser();
	
	JButton btnHelp = new JButton(); //TODO: Add help icon
	JPanel pnlNewAccount = new JPanel(new GridBagLayout());
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtPasswordSecurity;
	private JTextField txtEmail;
	private JButton btnCreate;
	private JButton btnCancel;
	private JLabel lblFehlermeldung;
	
	
	
	
	
	
	public AnmeldeGUI() {
		super("Account erstellen");
		getContentPane().setLayout(new BorderLayout(20,20));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Neuer Account", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 2, 10, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNickname = new JLabel("Nickname:");
		GridBagConstraints gbc_lblNickname = new GridBagConstraints();
		gbc_lblNickname.anchor = GridBagConstraints.WEST;
		gbc_lblNickname.insets = new Insets(0, 0, 5, 5);
		gbc_lblNickname.gridx = 1;
		gbc_lblNickname.gridy = 1;
		panel_1.add(lblNickname, gbc_lblNickname);
		
		txtUsername = new JTextField();
		lblNickname.setLabelFor(txtUsername);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		panel_1.add(txtUsername, gbc_textField);
		txtUsername.setColumns(10);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		GridBagConstraints gbc_lblPasswort = new GridBagConstraints();
		gbc_lblPasswort.anchor = GridBagConstraints.WEST;
		gbc_lblPasswort.insets = new Insets(0, 0, 5, 5);
		gbc_lblPasswort.gridx = 1;
		gbc_lblPasswort.gridy = 2;
		panel_1.add(lblPasswort, gbc_lblPasswort);
		
		txtPassword = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		panel_1.add(txtPassword, gbc_textField_1);
		txtPassword.setColumns(10);
		
		JLabel lblPasswortWdh = new JLabel("Passwort wdh:");
		GridBagConstraints gbc_lblPasswortWdh = new GridBagConstraints();
		gbc_lblPasswortWdh.anchor = GridBagConstraints.WEST;
		gbc_lblPasswortWdh.insets = new Insets(0, 0, 5, 5);
		gbc_lblPasswortWdh.gridx = 1;
		gbc_lblPasswortWdh.gridy = 3;
		panel_1.add(lblPasswortWdh, gbc_lblPasswortWdh);
		
		txtPasswordSecurity = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 3;
		panel_1.add(txtPasswordSecurity, gbc_textField_2);
		txtPasswordSecurity.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 4;
		panel_1.add(lblEmail, gbc_lblEmail);
		
		txtEmail = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 4;
		panel_1.add(txtEmail, gbc_textField_3);
		txtEmail.setColumns(10);
		
		btnCreate = new JButton("Create");
		btnCreate.addActionListener(this);
		GridBagConstraints gbc_btnCreate_1 = new GridBagConstraints();
		gbc_btnCreate_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreate_1.gridx = 1;
		gbc_btnCreate_1.gridy = 6;
		panel_1.add(btnCreate, gbc_btnCreate_1);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);
		GridBagConstraints gbc_btnCreate = new GridBagConstraints();
		gbc_btnCreate.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreate.gridx = 2;
		gbc_btnCreate.gridy = 6;
		panel_1.add(btnCreate, gbc_btnCreate);
		
		JLabel lblFehlermeldung = new JLabel("Fehlermeldung");
		lblFehlermeldung.setForeground(Color.RED);
		lblFehlermeldung.setVisible(false);
		GridBagConstraints gbc_lblFehlermeldung = new GridBagConstraints();
		gbc_lblFehlermeldung.anchor = GridBagConstraints.WEST;
		gbc_lblFehlermeldung.gridwidth = 2;
		gbc_lblFehlermeldung.insets = new Insets(0, 0, 0, 5);
		gbc_lblFehlermeldung.gridx = 1;
		gbc_lblFehlermeldung.gridy = 8;
		panel_1.add(lblFehlermeldung, gbc_lblFehlermeldung);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Passwortsicherheit", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		panel_2.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{148, 0};
		gbl_panel_3.rowHeights = new int[]{15, 14, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNichtVorhanden = new JLabel("nicht vorhanden");
		lblNichtVorhanden.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNichtVorhanden = new GridBagConstraints();
		gbc_lblNichtVorhanden.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNichtVorhanden.insets = new Insets(0, 0, 5, 0);
		gbc_lblNichtVorhanden.gridx = 0;
		gbc_lblNichtVorhanden.gridy = 0;
		panel_3.add(lblNichtVorhanden, gbc_lblNichtVorhanden);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setMaximum(4);
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.anchor = GridBagConstraints.NORTHWEST;
		gbc_progressBar.gridx = 0;
		gbc_progressBar.gridy = 1;
		panel_3.add(progressBar, gbc_progressBar);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.pack();
		this.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnCancel)
		{
			ClearForm();
		}
		else
		{
			lblFehlermeldung.setText(ValidateUserFormData());
			if(!lblFehlermeldung.getText().equals(""))
			{
				// User muss erfolgreich erstellt werden k�nnen
				//TamagotchiGUI tGui = new TamagotchiGUI();
				lblFehlermeldung.setVisible(true);
			}
			else
			{	
				User newUser = new User(txtUsername.getText(), txtPassword.getText(), txtEmail.getText());
				
				if(blU.createUser(newUser))
				{
					if(blU.isUserDataValid(newUser.getNickname(), newUser.getPasswort()))
					{
						
					}
				}
			}
		}
		
	}

	public void ClearForm()
	{
		txtUsername.setText("");
		txtPassword.setText("");
		txtPasswordSecurity.setText("");
		txtEmail.setText("");
	}
	
	public String ValidateUserFormData()
	{
		String UserFormDataValidateResult = "";
		
		if(!txtUsername.getText().equalsIgnoreCase("") && !txtPassword.getText().equalsIgnoreCase("") && !txtPasswordSecurity.getText().equalsIgnoreCase("") && !txtEmail.getText().equalsIgnoreCase(""))
		{
			if(txtPassword.getText().equals(txtPasswordSecurity.getText()))
			{
				if(!txtEmail.getText().contains(".") || !txtEmail.getText().contains("@"))
				{
					UserFormDataValidateResult += "Dies ist kein zul�ssiges Mailformat\n";
				}
			}
			else
			{
				UserFormDataValidateResult += "Die beiden Passw�rter stimmen nicht �berein\n";				
			}
		
		}
		else
		{
			UserFormDataValidateResult += "Du hast nicht alle Felder ausgef�llt\n";
		}
			return UserFormDataValidateResult;
	}
	
}
*/