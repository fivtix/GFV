package ihmTransport;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JCheckBox;

public class NewUser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldLogin;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldConfirmation;


	/**
	 * Create the dialog.
	 */
	public NewUser() {
		setTitle("Nouvel Utilisateur");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] {30, 0, 48, 46, 0, 30, 30, 30, 30};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
			JLabel lblNom = new JLabel("Nom : ");
			GridBagConstraints gbc_lblNom = new GridBagConstraints();
			gbc_lblNom.insets = new Insets(0, 0, 5, 5);
			gbc_lblNom.anchor = GridBagConstraints.EAST;
			gbc_lblNom.gridx = 1;
			gbc_lblNom.gridy = 1;
			contentPanel.add(lblNom, gbc_lblNom);
		
		
			textFieldNom = new JTextField();
			GridBagConstraints gbc_textFieldNom = new GridBagConstraints();
			gbc_textFieldNom.gridwidth = 2;
			gbc_textFieldNom.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldNom.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldNom.gridx = 2;
			gbc_textFieldNom.gridy = 1;
			contentPanel.add(textFieldNom, gbc_textFieldNom);
			textFieldNom.setColumns(10);
		
		
			JLabel lblPrnom = new JLabel("Pr\u00E9nom : ");
			GridBagConstraints gbc_lblPrnom = new GridBagConstraints();
			gbc_lblPrnom.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrnom.anchor = GridBagConstraints.EAST;
			gbc_lblPrnom.gridx = 4;
			gbc_lblPrnom.gridy = 1;
			contentPanel.add(lblPrnom, gbc_lblPrnom);
		
		
			textFieldPrenom = new JTextField();
			GridBagConstraints gbc_textFieldPrenom = new GridBagConstraints();
			gbc_textFieldPrenom.gridwidth = 3;
			gbc_textFieldPrenom.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldPrenom.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldPrenom.gridx = 5;
			gbc_textFieldPrenom.gridy = 1;
			contentPanel.add(textFieldPrenom, gbc_textFieldPrenom);
			textFieldPrenom.setColumns(10);
		
		
			JLabel lblLogin = new JLabel("Login : ");
			GridBagConstraints gbc_lblLogin = new GridBagConstraints();
			gbc_lblLogin.anchor = GridBagConstraints.EAST;
			gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
			gbc_lblLogin.gridx = 1;
			gbc_lblLogin.gridy = 3;
			contentPanel.add(lblLogin, gbc_lblLogin);
		
		
			textFieldLogin = new JTextField();
			GridBagConstraints gbc_textFieldLogin = new GridBagConstraints();
			gbc_textFieldLogin.gridwidth = 2;
			gbc_textFieldLogin.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldLogin.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldLogin.gridx = 2;
			gbc_textFieldLogin.gridy = 3;
			contentPanel.add(textFieldLogin, gbc_textFieldLogin);
			textFieldLogin.setColumns(10);
		
		
			JLabel lblMotDePasse = new JLabel("Mot de passe : ");
			GridBagConstraints gbc_lblMotDePasse = new GridBagConstraints();
			gbc_lblMotDePasse.anchor = GridBagConstraints.EAST;
			gbc_lblMotDePasse.insets = new Insets(0, 0, 5, 5);
			gbc_lblMotDePasse.gridx = 4;
			gbc_lblMotDePasse.gridy = 3;
			contentPanel.add(lblMotDePasse, gbc_lblMotDePasse);
		
		
			passwordField = new JPasswordField();
			GridBagConstraints gbc_passwordField = new GridBagConstraints();
			gbc_passwordField.gridwidth = 3;
			gbc_passwordField.insets = new Insets(0, 0, 5, 0);
			gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
			gbc_passwordField.gridx = 5;
			gbc_passwordField.gridy = 3;
			contentPanel.add(passwordField, gbc_passwordField);
		
		
			JLabel lblConfirmation = new JLabel("Confirmation : ");
			GridBagConstraints gbc_lblConfirmation = new GridBagConstraints();
			gbc_lblConfirmation.anchor = GridBagConstraints.EAST;
			gbc_lblConfirmation.insets = new Insets(0, 0, 5, 5);
			gbc_lblConfirmation.gridx = 4;
			gbc_lblConfirmation.gridy = 4;
			contentPanel.add(lblConfirmation, gbc_lblConfirmation);
		
		
			passwordFieldConfirmation = new JPasswordField();
			GridBagConstraints gbc_passwordFieldConfirmation = new GridBagConstraints();
			gbc_passwordFieldConfirmation.gridwidth = 3;
			gbc_passwordFieldConfirmation.insets = new Insets(0, 0, 5, 0);
			gbc_passwordFieldConfirmation.fill = GridBagConstraints.HORIZONTAL;
			gbc_passwordFieldConfirmation.gridx = 5;
			gbc_passwordFieldConfirmation.gridy = 4;
			contentPanel.add(passwordFieldConfirmation, gbc_passwordFieldConfirmation);
		
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			
			
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			
		
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}

}
