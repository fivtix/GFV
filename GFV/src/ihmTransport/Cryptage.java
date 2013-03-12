package ihmTransport;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cryptage extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JButton btnActiver;
	JLabel lblStatutCryptage;


	/**
	 * Create the dialog.
	 */
	public Cryptage() {
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{132, 157, 52, 0};
		gbl_contentPanel.rowHeights = new int[]{16, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblLeCryptageEst = new JLabel("Le cryptage est actuellement :");
			GridBagConstraints gbc_lblLeCryptageEst = new GridBagConstraints();
			gbc_lblLeCryptageEst.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblLeCryptageEst.insets = new Insets(0, 0, 5, 5);
			gbc_lblLeCryptageEst.gridx = 1;
			gbc_lblLeCryptageEst.gridy = 1;
			contentPanel.add(lblLeCryptageEst, gbc_lblLeCryptageEst);
		}
		
			lblStatutCryptage = new JLabel("Activ\u00E9");
			GridBagConstraints gbc_lblStatutCryptage = new GridBagConstraints();
			gbc_lblStatutCryptage.insets = new Insets(0, 0, 5, 0);
			gbc_lblStatutCryptage.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblStatutCryptage.gridx = 2;
			gbc_lblStatutCryptage.gridy = 1;
			contentPanel.add(lblStatutCryptage, gbc_lblStatutCryptage);
		
		
			btnActiver = new JButton("D\u00E9sactiver");
			btnActiver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(btnActiver.getText().equals("Désactiver"))
					{
						btnActiver.setText("Activer");
						lblStatutCryptage.setText("Désactivé");
						lblStatutCryptage.setBackground(Color.RED);
					}
					else
					{
						btnActiver.setText("Désactiver");
						lblStatutCryptage.setText("Activé");
						lblStatutCryptage.setBackground(Color.GREEN);
					}
				}
			});
			GridBagConstraints gbc_btnActiver = new GridBagConstraints();
			gbc_btnActiver.insets = new Insets(0, 0, 0, 5);
			gbc_btnActiver.gridx = 1;
			gbc_btnActiver.gridy = 3;
			contentPanel.add(btnActiver, gbc_btnActiver);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

}
