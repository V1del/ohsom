package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import bl.BLTamagotchi;
import bl.BLUser;
import bo.User;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

import java.awt.Canvas;

public class TamagotchiGUI {
	
	private BLTamagotchi blT = null;

	private JFrame frmOhsom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TamagotchiGUI window = new TamagotchiGUI();
					window.frmOhsom.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TamagotchiGUI() {
		initialize();
	}
	
	public TamagotchiGUI(User currentUser) {
		blT = new BLTamagotchi(currentUser);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOhsom = new JFrame();
		frmOhsom.setTitle("Ohsom");
		frmOhsom.setBounds(100, 100, 450, 300);
		frmOhsom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmOhsom.getContentPane().add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton button = new JButton("?");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 0;
		panel.add(button, gbc_button);
		
		JButton btnPref = new JButton("pref");
		GridBagConstraints gbc_btnPref = new GridBagConstraints();
		gbc_btnPref.insets = new Insets(0, 0, 5, 0);
		gbc_btnPref.gridx = 1;
		gbc_btnPref.gridy = 0;
		panel.add(btnPref, gbc_btnPref);
		
		JLabel lblNeueNachrichten = new JLabel("Neue Nachrichten");
		GridBagConstraints gbc_lblNeueNachrichten = new GridBagConstraints();
		gbc_lblNeueNachrichten.insets = new Insets(0, 0, 5, 0);
		gbc_lblNeueNachrichten.gridwidth = 2;
		gbc_lblNeueNachrichten.gridx = 0;
		gbc_lblNeueNachrichten.gridy = 1;
		panel.add(lblNeueNachrichten, gbc_lblNeueNachrichten);
		
		JLabel lblNachrichtVerfassen = new JLabel("Nachricht verfassen");
		GridBagConstraints gbc_lblNachrichtVerfassen = new GridBagConstraints();
		gbc_lblNachrichtVerfassen.insets = new Insets(0, 0, 5, 0);
		gbc_lblNachrichtVerfassen.gridwidth = 2;
		gbc_lblNachrichtVerfassen.gridx = 0;
		gbc_lblNachrichtVerfassen.gridy = 2;
		panel.add(lblNachrichtVerfassen, gbc_lblNachrichtVerfassen);
		
		JButton btnReset = new JButton("Reset");
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.anchor = GridBagConstraints.WEST;
		gbc_btnReset.gridwidth = 2;
		gbc_btnReset.insets = new Insets(0, 0, 0, 5);
		gbc_btnReset.gridx = 0;
		gbc_btnReset.gridy = 9;
		panel.add(btnReset, gbc_btnReset);
		
		JPanel panel_1 = new JPanel();
		frmOhsom.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		Canvas canvas = new Canvas();
		panel_1.add(canvas);
	}

}
