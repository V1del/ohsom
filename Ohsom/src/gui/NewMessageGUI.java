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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewMessageGUI {

	private JFrame frmNeueNachrichtVerfassen;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewMessageGUI window = new NewMessageGUI();
					window.frmNeueNachrichtVerfassen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewMessageGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNeueNachrichtVerfassen = new JFrame();
		frmNeueNachrichtVerfassen.setTitle("Neue Nachricht verfassen");
		frmNeueNachrichtVerfassen.setBounds(100, 100, 450, 300);
		frmNeueNachrichtVerfassen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Neue Nachricht", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frmNeueNachrichtVerfassen.getContentPane().add(panel, BorderLayout.CENTER);
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
		
		JComboBox comboBox = new JComboBox();
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
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 2;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNachricht = new JLabel("Nachricht");
		GridBagConstraints gbc_lblNachricht = new GridBagConstraints();
		gbc_lblNachricht.insets = new Insets(0, 0, 5, 5);
		gbc_lblNachricht.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNachricht.gridx = 1;
		gbc_lblNachricht.gridy = 3;
		panel.add(lblNachricht, gbc_lblNachricht);
		
		JTextArea textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 2;
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 4;
		gbc_textArea.gridy = 3;
		panel.add(textArea, gbc_textArea);
		
		JButton btnSubmit = new JButton("Submit");
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.insets = new Insets(0, 0, 0, 5);
		gbc_btnSubmit.gridx = 4;
		gbc_btnSubmit.gridy = 4;
		panel.add(btnSubmit, gbc_btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridx = 5;
		gbc_btnCancel.gridy = 4;
		panel.add(btnCancel, gbc_btnCancel);
	}

}
