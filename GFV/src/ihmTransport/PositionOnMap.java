package ihmTransport;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JEditorPane;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

public class PositionOnMap extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldXCoord;
	private JTextField textFieldYCoord;
	private JTextField textFieldZCoord;
	private JTextField textFieldAdresse;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		try {
			PositionOnMap dialog = new PositionOnMap();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public PositionOnMap() {
		setBounds(100, 100, 598, 489);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10};
		gbl_contentPanel.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10};
		gbl_contentPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JEditorPane editorPane = new JEditorPane();
			GridBagConstraints gbc_editorPane = new GridBagConstraints();
			gbc_editorPane.gridwidth = 10;
			gbc_editorPane.gridheight = 10;
			gbc_editorPane.insets = new Insets(0, 0, 5, 5);
			gbc_editorPane.fill = GridBagConstraints.BOTH;
			gbc_editorPane.gridx = 0;
			gbc_editorPane.gridy = 0;
			contentPanel.add(editorPane, gbc_editorPane);
		}
		{
			JLabel lblX = new JLabel("x : ");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.anchor = GridBagConstraints.EAST;
			gbc_lblX.gridx = 0;
			gbc_lblX.gridy = 11;
			contentPanel.add(lblX, gbc_lblX);
		}
		{
			textFieldXCoord = new JTextField();
			GridBagConstraints gbc_textFieldXCoord = new GridBagConstraints();
			gbc_textFieldXCoord.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldXCoord.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldXCoord.gridx = 1;
			gbc_textFieldXCoord.gridy = 11;
			contentPanel.add(textFieldXCoord, gbc_textFieldXCoord);
			textFieldXCoord.setColumns(10);
		}
		{
			JLabel lblY = new JLabel("y : ");
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.anchor = GridBagConstraints.EAST;
			gbc_lblY.gridx = 4;
			gbc_lblY.gridy = 11;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			textFieldYCoord = new JTextField();
			GridBagConstraints gbc_textFieldYCoord = new GridBagConstraints();
			gbc_textFieldYCoord.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldYCoord.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldYCoord.gridx = 5;
			gbc_textFieldYCoord.gridy = 11;
			contentPanel.add(textFieldYCoord, gbc_textFieldYCoord);
			textFieldYCoord.setColumns(10);
		}
		{
			JLabel lblZ = new JLabel("z : ");
			GridBagConstraints gbc_lblZ = new GridBagConstraints();
			gbc_lblZ.insets = new Insets(0, 0, 5, 5);
			gbc_lblZ.anchor = GridBagConstraints.EAST;
			gbc_lblZ.gridx = 8;
			gbc_lblZ.gridy = 11;
			contentPanel.add(lblZ, gbc_lblZ);
		}
		{
			textFieldZCoord = new JTextField();
			GridBagConstraints gbc_textFieldZCoord = new GridBagConstraints();
			gbc_textFieldZCoord.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldZCoord.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldZCoord.gridx = 9;
			gbc_textFieldZCoord.gridy = 11;
			contentPanel.add(textFieldZCoord, gbc_textFieldZCoord);
			textFieldZCoord.setColumns(10);
		}
		{
			JLabel lblAdresse = new JLabel("Adresse : ");
			GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
			gbc_lblAdresse.anchor = GridBagConstraints.EAST;
			gbc_lblAdresse.insets = new Insets(0, 0, 0, 5);
			gbc_lblAdresse.gridx = 0;
			gbc_lblAdresse.gridy = 12;
			contentPanel.add(lblAdresse, gbc_lblAdresse);
		}
		{
			textFieldAdresse = new JTextField();
			GridBagConstraints gbc_textFieldAdresse = new GridBagConstraints();
			gbc_textFieldAdresse.gridwidth = 9;
			gbc_textFieldAdresse.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldAdresse.gridx = 1;
			gbc_textFieldAdresse.gridy = 12;
			contentPanel.add(textFieldAdresse, gbc_textFieldAdresse);
			textFieldAdresse.setColumns(10);
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
