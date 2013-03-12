package ihmTransport;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Dialog.ModalityType;
import java.awt.ComponentOrientation;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldLogin;
	private JPasswordField passwordField;


	/**
	 * Create the dialog.
	 */
	public Login() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Connexion");
		setBounds(100, 100, 202, 176);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(2, 0, 0, 0));
		{
			JPanel panelLogin = new JPanel();
			panelLogin.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			FlowLayout flowLayout = (FlowLayout) panelLogin.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			contentPanel.add(panelLogin);
			{
				JLabel lblLogin = new JLabel("Login : ");
				panelLogin.add(lblLogin);
			}
			{
				textFieldLogin = new JTextField();
				panelLogin.add(textFieldLogin);
				textFieldLogin.setColumns(10);
			}
		}
		{
			JPanel panelPass = new JPanel();
			panelPass.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			FlowLayout flowLayout = (FlowLayout) panelPass.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			contentPanel.add(panelPass);
			{
				JLabel lblMotDePasse = new JLabel("Mot de passe : ");
				panelPass.add(lblMotDePasse);
			}
			{
				passwordField = new JPasswordField();
				passwordField.setColumns(10);
				panelPass.add(passwordField);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}

}
