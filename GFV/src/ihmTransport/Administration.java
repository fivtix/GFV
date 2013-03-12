package ihmTransport;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JList;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Administration extends JPanel {
	private JLabel lblListeDesUtilisateurs;
	private JList list;
	private JButton btnNouvelUtilisateur;
	private JLabel lblDroitsAssocies;
	private JCheckBox chckbxConsultation;
	private JCheckBox chckbxCrationDeTransports;
	private JButton btnMiseJour;
	private JComboBox comboBox;
	private JLabel lblRle;

	/**
	 * Create the panel.
	 */
	public Administration() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		/*****************/
		lblListeDesUtilisateurs = new JLabel("Liste des utilisateurs :");
		GridBagConstraints gbc_lblListeDesUtilisateurs = new GridBagConstraints();
		gbc_lblListeDesUtilisateurs.anchor = GridBagConstraints.WEST;
		gbc_lblListeDesUtilisateurs.insets = new Insets(0, 0, 5, 5);
		gbc_lblListeDesUtilisateurs.gridx = 0;
		gbc_lblListeDesUtilisateurs.gridy = 0;
		add(lblListeDesUtilisateurs, gbc_lblListeDesUtilisateurs);
		/*****************/
		/*****************/
		lblRle = new JLabel("R\u00F4le : ");
		GridBagConstraints gbc_lblRle = new GridBagConstraints();
		gbc_lblRle.anchor = GridBagConstraints.WEST;
		gbc_lblRle.gridwidth = 2;
		gbc_lblRle.insets = new Insets(0, 0, 5, 5);
		gbc_lblRle.gridx = 2;
		gbc_lblRle.gridy = 0;
		add(lblRle, gbc_lblRle);
		lblDroitsAssocies = new JLabel("Droits associ\u00E9s :");
		GridBagConstraints gbc_lblDroitsAssocies = new GridBagConstraints();
		gbc_lblDroitsAssocies.anchor = GridBagConstraints.WEST;
		gbc_lblDroitsAssocies.insets = new Insets(0, 0, 5, 0);
		gbc_lblDroitsAssocies.gridx = 5;
		gbc_lblDroitsAssocies.gridy = 0;
		add(lblDroitsAssocies, gbc_lblDroitsAssocies);
		list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"grtgrt", "htyhtyh", "sg", "t('ty-yh", "rgrtgrtg", "egferger", "g(tgrtgrt", "ghhhrthrt"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 4;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 1;
		add(list, gbc_list);
		/*****************/
		btnNouvelUtilisateur = new JButton("Nouvel utilisateur");
		btnNouvelUtilisateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new NewUser();
			}
		});
		/*****************/
		chckbxConsultation = new JCheckBox("Consultation");
		GridBagConstraints gbc_chckbxConsultation = new GridBagConstraints();
		gbc_chckbxConsultation.anchor = GridBagConstraints.NORTHWEST;
		gbc_chckbxConsultation.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxConsultation.gridx = 5;
		gbc_chckbxConsultation.gridy = 1;
		add(chckbxConsultation, gbc_chckbxConsultation);
		/*****************/
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Administrateur", "Logisticien", "Consultant"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		add(comboBox, gbc_comboBox);
		chckbxCrationDeTransports = new JCheckBox("Cr\u00E9ation de transports");
		GridBagConstraints gbc_chckbxCrationDeTransports = new GridBagConstraints();
		gbc_chckbxCrationDeTransports.anchor = GridBagConstraints.WEST;
		gbc_chckbxCrationDeTransports.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxCrationDeTransports.gridx = 5;
		gbc_chckbxCrationDeTransports.gridy = 2;
		add(chckbxCrationDeTransports, gbc_chckbxCrationDeTransports);
		GridBagConstraints gbc_btnNouvelUtilisateur = new GridBagConstraints();
		gbc_btnNouvelUtilisateur.insets = new Insets(0, 0, 0, 5);
		gbc_btnNouvelUtilisateur.gridx = 0;
		gbc_btnNouvelUtilisateur.gridy = 6;
		add(btnNouvelUtilisateur, gbc_btnNouvelUtilisateur);
		/*****************/
		btnMiseJour = new JButton("Mise \u00E0 jour");
		btnMiseJour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnMiseJour = new GridBagConstraints();
		gbc_btnMiseJour.insets = new Insets(0, 0, 0, 5);
		gbc_btnMiseJour.gridx = 3;
		gbc_btnMiseJour.gridy = 6;
		add(btnMiseJour, gbc_btnMiseJour);

	}

}
