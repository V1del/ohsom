package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;


public class HauptfensterGui {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			HauptfensterGui window = new HauptfensterGui();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(567, 408);
		shell.setText("SWT Application");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(174, 10, 367, 349);

	}
}


/*
import bl.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class HauptfensterGui extends JFrame implements ActionListener {

	BLUser blU = new BLUser();

	JPanel pnlLogin = new JPanel(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	
	JLabel lblNickname = new JLabel("Nickname:");
	JTextField txtNickname = new JTextField();
	JLabel lblPasswort = new JLabel("Passwort:");
	JPasswordField txtPasswort = new JPasswordField();
	JButton btnLogin = new JButton("Login");
	JLabel lblFehlermeldung = new JLabel("");	
	JPanel pnlHighscore = new JPanel();
	JTable tblHighscore = new JTable();
	JLabel lblCreate = new JLabel("Create Account");

	public HauptfensterGui() {
		super("Ohsom");
		//this.setSize(600, 400);
		this.setLayout(new BorderLayout(20,20));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.5;
		c.anchor = GridBagConstraints.LINE_START;
		pnlLogin.add(lblNickname, c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 0.5;
		c.anchor = GridBagConstraints.PAGE_START;
		
		pnlLogin.add(txtNickname, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 0.5;
		
		pnlLogin.add(lblPasswort, c);
		
		c.gridx = 1;
		c.gridy = 1;
		c.weightx = 0.5;
		
		pnlLogin.add(txtPasswort, c);

		btnLogin.addActionListener(this);
		
		c.gridx = 1;
		c.gridy = 2;
		c.weightx = 0.5;

		pnlLogin.add(btnLogin, c);

		lblFehlermeldung.setForeground(Color.red);
		
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 2;

		pnlLogin.add(lblFehlermeldung, c);

		pnlLogin.setBorder(new TitledBorder("Login"));
		this.add(pnlLogin, BorderLayout.CENTER);
		
		tblHighscore.setEnabled(false);
		tblHighscore.setFillsViewportHeight(false);
		
		tblHighscore.setModel(new DefaultTableModel(new String[] {"Platz", "Name", "Highscore"}, 
				10));
		
		
		JScrollPane scrollPane = new JScrollPane(tblHighscore);
//		tblHighscore.setFillsViewportHeight(true);
		pnlHighscore.setBorder(new TitledBorder("Highscore"));
		pnlHighscore.add(scrollPane);

		this.add(pnlHighscore,BorderLayout.EAST);

		this.add(lblCreate, BorderLayout.SOUTH);
		//lbCreate.action(arg0, arg1)n(arg0, arg1); // f�llen :D
		
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
				lblFehlermeldung.setText("Falsches Passwort f�r diesen Nickname.");
			}
			else
			{
				TamagotchiGUI tGui = new TamagotchiGUI(blU.getCurrentUser());
			}
		}
	}

	@SuppressWarnings("deprecation")
	public boolean isUserInputValid()
	{
		return !(txtPasswort.getText().equals("") || txtNickname.getText().equals(""));
	}

}*/
