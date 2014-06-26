package gui;

import bl.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 * Hauptfenster GUI
 * @author Snatsch
 *
 */
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
	JPanel pnlHighscore = new JPanel(new BorderLayout());
	JTable tblHighscore = new JTable();
	JPanel pnlFooter = new JPanel();
	JButton btnCreate = new JButton("Create Account");
	JButton btnPasswordForget = new JButton("Forgot Password?");

	public HauptfensterGui() throws SQLException {
		super("Ohsom");
		this.setSize(750, 300);
		this.setLayout(new BorderLayout(20,20));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon("Sources/gfx/Icon_Ohsom.png").getImage());
		
		c.fill = GridBagConstraints.HORIZONTAL;
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.5;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(0, 0, 5, 5);
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
		
		tblHighscore.setModel((new DefaultTableModel(
				blU.getHighscoreData(),
			new String[] {
				"Platz", "Name", "Highscore"
			}
		)));
		
		
		JScrollPane scrollPane = new JScrollPane(tblHighscore);

		pnlHighscore.setBorder(new TitledBorder("Highscore"));
		pnlHighscore.add(scrollPane, BorderLayout.CENTER);

		this.add(pnlHighscore,BorderLayout.EAST);
		
		//Modify Button L'n'F to look like a Label
        btnCreate.setMargin(new Insets(0, 0, 0, 0));
        btnCreate.setContentAreaFilled(false);
        btnCreate.setBorderPainted(false);
        btnCreate.setOpaque(false);
        btnCreate.setHorizontalAlignment(SwingConstants.LEFT);
        
        btnCreate.addActionListener(this);

        pnlFooter.add(btnCreate);
        
      //Modify Button L'n'F to look like a Label
        btnPasswordForget.setMargin(new Insets(0, 0, 0, 0));
        btnPasswordForget.setContentAreaFilled(false);
        btnPasswordForget.setBorderPainted(false);
        btnPasswordForget.setOpaque(false);
        btnPasswordForget.setHorizontalAlignment(SwingConstants.LEFT);
        
        btnPasswordForget.addActionListener(this);
        
        pnlFooter.add(btnPasswordForget);
        
		this.add(pnlFooter, BorderLayout.SOUTH);
		
		//lbCreate.action(arg0, arg1)n(arg0, arg1); // fï¿½llen :D
		
		//this.pack();
		this.setVisible(true);
	}

	/**
	 * Actionevents des HauptfensterGuis
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnLogin)
		{
			try {
				validateInput();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource() == btnCreate)
		{
			AnmeldeGUI fenster = new AnmeldeGUI();
		}
		else
		{
			
		}
	}

	/**
	 * Prüfen, ob die Eingaben valide sind
	 * @throws SQLException
	 */
	public void validateInput() throws SQLException
	{
		if(!isUserInputValid())
		{
			lblFehlermeldung.setText("Passwort und Nickname, du Idiot!");
		}
		else
		{
			if(!blU.isUserDataValid(txtNickname.getText(), txtPasswort.getText()))
			{
				lblFehlermeldung.setText("Falsches Passwort fï¿½r diesen Nickname.");
			}
			else
			{
				this.dispose();
				TamagotchiGUI tGUI = new TamagotchiGUI();
			}
		}
	}

	/**
	 * Prüfen, ob alle notwendigen Eingaben gemacht wurden
	 * @return
	 */
	public boolean isUserInputValid()
	{
		return !(txtPasswort.getText().equals("") || txtNickname.getText().equals(""));
	}
	
}
