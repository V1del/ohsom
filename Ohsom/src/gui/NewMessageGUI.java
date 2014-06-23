package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.border.TitledBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import bl.BLNachrichten;
import bl.BLUser;
import bo.Nachricht;
import bo.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * GUI um eine Nachricht an einen anderen User zu versenden
 * @author Snatsch
 *
 */
public class NewMessageGUI extends JFrame implements ActionListener {

	private Map<String, Integer> comboBoxValues = new HashMap<String, Integer>();
	private BLUser blU = new BLUser();
	private BLNachrichten blN = null;
	private JTextField txtTitle;
	JComboBox<String> comboBox;
	JButton btnSubmit, btnCancel;
	JTextArea Text;
	JLabel lblFehlermeldung;

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public NewMessageGUI() throws SQLException {
		blN = new BLNachrichten();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		new JFrame();
		setTitle("Neue Nachricht verfassen");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Neue Nachricht", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		JLabel lblAn = new JLabel("An");
		GridBagConstraints gbc_lblAn = new GridBagConstraints();
		gbc_lblAn.anchor = GridBagConstraints.WEST;
		gbc_lblAn.insets = new Insets(0, 0, 5, 5);
		gbc_lblAn.gridx = 1;
		gbc_lblAn.gridy = 1;
		panel.add(lblAn, gbc_lblAn);

		comboBox = new JComboBox();
		setUserItems();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 1;
		panel.add(comboBox, gbc_comboBox);

		JLabel lblTitel = new JLabel("Titel");
		GridBagConstraints gbc_lblTitel = new GridBagConstraints();
		gbc_lblTitel.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitel.anchor = GridBagConstraints.WEST;
		gbc_lblTitel.gridx = 1;
		gbc_lblTitel.gridy = 2;
		panel.add(lblTitel, gbc_lblTitel);

		txtTitle = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 2;
		panel.add(txtTitle, gbc_textField);
		txtTitle.setColumns(10);

		JLabel lblNachricht = new JLabel("Nachricht");
		GridBagConstraints gbc_lblNachricht = new GridBagConstraints();
		gbc_lblNachricht.insets = new Insets(0, 0, 5, 5);
		gbc_lblNachricht.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNachricht.gridx = 1;
		gbc_lblNachricht.gridy = 3;
		panel.add(lblNachricht, gbc_lblNachricht);

		Text = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 2;
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 4;
		gbc_textArea.gridy = 3;
		panel.add(Text, gbc_textArea);

		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(this);
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.insets = new Insets(0, 0, 0, 5);
		gbc_btnSubmit.gridx = 4;
		gbc_btnSubmit.gridy = 4;
		panel.add(btnSubmit, gbc_btnSubmit);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridx = 5;
		gbc_btnCancel.gridy = 4;
		panel.add(btnCancel, gbc_btnCancel);

		lblFehlermeldung = new JLabel("");
		panel.add(lblFehlermeldung);

		setVisible(true);
	}

	/** 
	 * Setzen der User in der DropdownList
	 * @throws SQLException
	 */
	public void setUserItems() throws SQLException
	{
		for(User UserItem : blU.getAllUsers())
		{
			if(!UserItem.getNickname().equalsIgnoreCase(blN.getCurrentUser().getNickname()))
			{
				comboBox.addItem(UserItem.getNickname());
				comboBoxValues.put(UserItem.getNickname(), UserItem.getId());
			}
		}
	}

	/**
	 * Überprüfung der Validität der Nachrichtendaten => GUI - Logik
	 * @return
	 */
	public boolean isMessageInputValid()
	{
		if(txtTitle.getText().equalsIgnoreCase(""))
		{
			return false;
		}

		if(Text.getText().equalsIgnoreCase(""))
		{
			return false;
		}

		return true;
	}

	/**
	 * Nachricht vorbereiten zum Verarbeiten in der Businesslogik
	 */
	public void sendNachricht() throws SQLException
	{

		Nachricht neueNachricht = new Nachricht(txtTitle.getText(), Text.getText(), comboBoxValues.get(comboBox.getSelectedItem().toString()), blN.getCurrentUser().getId());
		if(blN.sendNachricht(neueNachricht))
		{
			txtTitle.setText("");
			Text.setText("");
		}
	}

	/**
	 * Methode zur Verarbeitung der Button Klicks (Senden und Abbrechen)
	 */
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == btnSubmit)
			{
				sendNachricht();
			}
			else
			{
				this.dispose();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
