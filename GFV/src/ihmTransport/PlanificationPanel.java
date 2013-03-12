package ihmTransport;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;

public class PlanificationPanel extends JPanel {
	private JTextField textFieldDestination;
	private JTextField textFieldBeneficiaire;
	private JTextField textFieldDescContenu;
	private JTextField textFieldNumSuivi;
	private JTextField textFieldVehiculeIdent;
	private JTextField textFieldNumRequisition;

	/**
	 * Create the panel.
	 */
	public PlanificationPanel() {
		setMinimumSize(new Dimension(700, 300));
		setLayout(new BorderLayout(0, 0));
		
		JPanel PlanifLabelPanel = new JPanel();
		add(PlanifLabelPanel, BorderLayout.NORTH);
		PlanifLabelPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPlanification = new JLabel("Planification");
		PlanifLabelPanel.add(lblPlanification, BorderLayout.WEST);
		
		JPanel ButtonPanel = new JPanel();
		ButtonPanel.setMinimumSize(new Dimension(600, 10));
		add(ButtonPanel, BorderLayout.SOUTH);
		
		JButton btnItinraire = new JButton("Itin\u00E9raire");
		ButtonPanel.add(btnItinraire);
		
		JButton btnImporterTrajet = new JButton("Importer Trajet");
		ButtonPanel.add(btnImporterTrajet);
		
		JButton btnExporterTrajet = new JButton("Exporter Trajet");
		ButtonPanel.add(btnExporterTrajet);
		
		JButton btnImporterDonnes = new JButton("Importer Donn\u00E9es");
		ButtonPanel.add(btnImporterDonnes);
		
		JButton btnExporterDonnes = new JButton("Exporter Donn\u00E9es");
		ButtonPanel.add(btnExporterDonnes);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		ButtonPanel.add(btnEnregistrer);
		
		JPanel panelData = new JPanel();
		add(panelData, BorderLayout.CENTER);
		GridBagLayout gbl_panelData = new GridBagLayout();
		gbl_panelData.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelData.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelData.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelData.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelData.setLayout(gbl_panelData);
		/*****************/
		JLabel lblDestinationEtBnficiaire = new JLabel("Destination et b\u00E9n\u00E9ficiaire :");
		GridBagConstraints gbc_lblDestinationEtBnficiaire = new GridBagConstraints();
		gbc_lblDestinationEtBnficiaire.insets = new Insets(0, 0, 5, 5);
		gbc_lblDestinationEtBnficiaire.gridx = 0;
		gbc_lblDestinationEtBnficiaire.gridy = 0;
		panelData.add(lblDestinationEtBnficiaire, gbc_lblDestinationEtBnficiaire);
		/*****************/
		/*****************/
		JLabel lblVehicule = new JLabel("V\u00E9hicule :");
		GridBagConstraints gbc_lblVehicule = new GridBagConstraints();
		gbc_lblVehicule.anchor = GridBagConstraints.WEST;
		gbc_lblVehicule.insets = new Insets(0, 0, 5, 5);
		gbc_lblVehicule.gridx = 3;
		gbc_lblVehicule.gridy = 0;
		panelData.add(lblVehicule, gbc_lblVehicule);
		/*****************/
		JComboBox comboBoxVehicule = new JComboBox();
		GridBagConstraints gbc_comboBoxVehicule = new GridBagConstraints();
		gbc_comboBoxVehicule.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxVehicule.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxVehicule.gridx = 4;
		gbc_comboBoxVehicule.gridy = 0;
		panelData.add(comboBoxVehicule, gbc_comboBoxVehicule);
		JLabel lblDestination = new JLabel("Destination :");
		GridBagConstraints gbc_lblDestination = new GridBagConstraints();
		gbc_lblDestination.insets = new Insets(0, 0, 5, 5);
		gbc_lblDestination.anchor = GridBagConstraints.WEST;
		gbc_lblDestination.gridx = 0;
		gbc_lblDestination.gridy = 1;
		panelData.add(lblDestination, gbc_lblDestination);
		/*****************/
		textFieldDestination = new JTextField();
		GridBagConstraints gbc_textFieldDestination = new GridBagConstraints();
		gbc_textFieldDestination.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDestination.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDestination.gridx = 1;
		gbc_textFieldDestination.gridy = 1;
		panelData.add(textFieldDestination, gbc_textFieldDestination);
		textFieldDestination.setColumns(10);
		/*****************/
		/*****************/
		JLabel lblIdentifiant = new JLabel("Identifiant :");
		GridBagConstraints gbc_lblIdentifiant = new GridBagConstraints();
		gbc_lblIdentifiant.anchor = GridBagConstraints.WEST;
		gbc_lblIdentifiant.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdentifiant.gridx = 3;
		gbc_lblIdentifiant.gridy = 1;
		panelData.add(lblIdentifiant, gbc_lblIdentifiant);
		/*****************/
		textFieldVehiculeIdent = new JTextField();
		GridBagConstraints gbc_textFieldVehiculeIdent = new GridBagConstraints();
		gbc_textFieldVehiculeIdent.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldVehiculeIdent.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldVehiculeIdent.gridx = 4;
		gbc_textFieldVehiculeIdent.gridy = 1;
		panelData.add(textFieldVehiculeIdent, gbc_textFieldVehiculeIdent);
		textFieldVehiculeIdent.setColumns(10);
		JLabel lblBnficiaire = new JLabel("B\u00E9n\u00E9ficiaire :");
		GridBagConstraints gbc_lblBnficiaire = new GridBagConstraints();
		gbc_lblBnficiaire.anchor = GridBagConstraints.WEST;
		gbc_lblBnficiaire.insets = new Insets(0, 0, 5, 5);
		gbc_lblBnficiaire.gridx = 0;
		gbc_lblBnficiaire.gridy = 2;
		panelData.add(lblBnficiaire, gbc_lblBnficiaire);
		/*****************/
		textFieldBeneficiaire = new JTextField();
		GridBagConstraints gbc_textFieldBeneficiaire = new GridBagConstraints();
		gbc_textFieldBeneficiaire.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldBeneficiaire.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBeneficiaire.gridx = 1;
		gbc_textFieldBeneficiaire.gridy = 2;
		panelData.add(textFieldBeneficiaire, gbc_textFieldBeneficiaire);
		textFieldBeneficiaire.setColumns(10);
		/*****************/
		/*****************/
		JLabel lblNumroDeRequisition = new JLabel("Num\u00E9ro de requisition :");
		GridBagConstraints gbc_lblNumroDeRequisition = new GridBagConstraints();
		gbc_lblNumroDeRequisition.anchor = GridBagConstraints.EAST;
		gbc_lblNumroDeRequisition.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumroDeRequisition.gridx = 3;
		gbc_lblNumroDeRequisition.gridy = 2;
		panelData.add(lblNumroDeRequisition, gbc_lblNumroDeRequisition);
		/*****************/
		textFieldNumRequisition = new JTextField();
		GridBagConstraints gbc_textFieldNumRequisition = new GridBagConstraints();
		gbc_textFieldNumRequisition.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNumRequisition.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNumRequisition.gridx = 4;
		gbc_textFieldNumRequisition.gridy = 2;
		panelData.add(textFieldNumRequisition, gbc_textFieldNumRequisition);
		textFieldNumRequisition.setColumns(10);
		JLabel lblDescriptionDuContenu = new JLabel("Description du contenu :");
		GridBagConstraints gbc_lblDescriptionDuContenu = new GridBagConstraints();
		gbc_lblDescriptionDuContenu.anchor = GridBagConstraints.WEST;
		gbc_lblDescriptionDuContenu.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescriptionDuContenu.gridx = 0;
		gbc_lblDescriptionDuContenu.gridy = 3;
		panelData.add(lblDescriptionDuContenu, gbc_lblDescriptionDuContenu);
		/*****************/
		textFieldDescContenu = new JTextField();
		GridBagConstraints gbc_textFieldDescContenu = new GridBagConstraints();
		gbc_textFieldDescContenu.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDescContenu.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDescContenu.gridx = 1;
		gbc_textFieldDescContenu.gridy = 3;
		panelData.add(textFieldDescContenu, gbc_textFieldDescContenu);
		textFieldDescContenu.setColumns(10);
		/*****************/
		/*****************/
		JLabel lblMoyensDeTransport = new JLabel("Moyens de transport :");
		GridBagConstraints gbc_lblMoyensDeTransport = new GridBagConstraints();
		gbc_lblMoyensDeTransport.anchor = GridBagConstraints.WEST;
		gbc_lblMoyensDeTransport.insets = new Insets(0, 0, 5, 5);
		gbc_lblMoyensDeTransport.gridx = 3;
		gbc_lblMoyensDeTransport.gridy = 3;
		panelData.add(lblMoyensDeTransport, gbc_lblMoyensDeTransport);
		/*****************/
		JCheckBox chckbxRoute = new JCheckBox("Route");
		GridBagConstraints gbc_chckbxRoute = new GridBagConstraints();
		gbc_chckbxRoute.anchor = GridBagConstraints.WEST;
		gbc_chckbxRoute.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxRoute.gridx = 4;
		gbc_chckbxRoute.gridy = 3;
		panelData.add(chckbxRoute, gbc_chckbxRoute);
		JLabel lblNumroDeSuivi = new JLabel("Num\u00E9ro de suivi :");
		GridBagConstraints gbc_lblNumroDeSuivi = new GridBagConstraints();
		gbc_lblNumroDeSuivi.anchor = GridBagConstraints.WEST;
		gbc_lblNumroDeSuivi.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumroDeSuivi.gridx = 0;
		gbc_lblNumroDeSuivi.gridy = 4;
		panelData.add(lblNumroDeSuivi, gbc_lblNumroDeSuivi);
		/*****************/
		textFieldNumSuivi = new JTextField();
		GridBagConstraints gbc_textFieldNumSuivi = new GridBagConstraints();
		gbc_textFieldNumSuivi.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNumSuivi.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNumSuivi.gridx = 1;
		gbc_textFieldNumSuivi.gridy = 4;
		panelData.add(textFieldNumSuivi, gbc_textFieldNumSuivi);
		textFieldNumSuivi.setColumns(10);
		/*****************/
		/*****************/
		JCheckBox chckbxTrain = new JCheckBox("Rail");
		GridBagConstraints gbc_chckbxTrain = new GridBagConstraints();
		gbc_chckbxTrain.anchor = GridBagConstraints.WEST;
		gbc_chckbxTrain.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxTrain.gridx = 4;
		gbc_chckbxTrain.gridy = 4;
		panelData.add(chckbxTrain, gbc_chckbxTrain);
		JLabel lblCommentaire = new JLabel("Commentaire :");
		GridBagConstraints gbc_lblCommentaire = new GridBagConstraints();
		gbc_lblCommentaire.anchor = GridBagConstraints.WEST;
		gbc_lblCommentaire.insets = new Insets(0, 0, 5, 5);
		gbc_lblCommentaire.gridx = 0;
		gbc_lblCommentaire.gridy = 5;
		panelData.add(lblCommentaire, gbc_lblCommentaire);
		/*****************/
		/*****************/
		JCheckBox chckbxAir = new JCheckBox("Air");
		GridBagConstraints gbc_chckbxAir = new GridBagConstraints();
		gbc_chckbxAir.anchor = GridBagConstraints.WEST;
		gbc_chckbxAir.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxAir.gridx = 4;
		gbc_chckbxAir.gridy = 5;
		panelData.add(chckbxAir, gbc_chckbxAir);
		JTextArea textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.gridheight = 3;
		gbc_textArea.gridwidth = 2;
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 6;
		panelData.add(textArea, gbc_textArea);
		/*****************/
		JCheckBox chckbxMer = new JCheckBox("Mer");
		GridBagConstraints gbc_chckbxMer = new GridBagConstraints();
		gbc_chckbxMer.anchor = GridBagConstraints.WEST;
		gbc_chckbxMer.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxMer.gridx = 4;
		gbc_chckbxMer.gridy = 6;
		panelData.add(chckbxMer, gbc_chckbxMer);
		/*****************/
		/*****************/
		JLabel lblChauffeur = new JLabel("Chauffeur :");
		GridBagConstraints gbc_lblChauffeur = new GridBagConstraints();
		gbc_lblChauffeur.anchor = GridBagConstraints.WEST;
		gbc_lblChauffeur.insets = new Insets(0, 0, 5, 5);
		gbc_lblChauffeur.gridx = 3;
		gbc_lblChauffeur.gridy = 7;
		panelData.add(lblChauffeur, gbc_lblChauffeur);
		/*****************/
		JComboBox comboBoxChauffeur = new JComboBox();
		GridBagConstraints gbc_comboBoxChauffeur = new GridBagConstraints();
		gbc_comboBoxChauffeur.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxChauffeur.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxChauffeur.gridx = 4;
		gbc_comboBoxChauffeur.gridy = 7;
		panelData.add(comboBoxChauffeur, gbc_comboBoxChauffeur);
		JLabel lblDateDeDpart = new JLabel("Date de d\u00E9part pr\u00E9vue :");
		GridBagConstraints gbc_lblDateDeDpart = new GridBagConstraints();
		gbc_lblDateDeDpart.anchor = GridBagConstraints.WEST;
		gbc_lblDateDeDpart.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateDeDpart.gridx = 0;
		gbc_lblDateDeDpart.gridy = 10;
		panelData.add(lblDateDeDpart, gbc_lblDateDeDpart);
		/*****************/
		JSpinner spinnerDateDepartPrevue = new JSpinner();
		spinnerDateDepartPrevue.setModel(new SpinnerDateModel(new Date(1363042800000L), null, null, Calendar.DAY_OF_YEAR));
		GridBagConstraints gbc_spinnerDateDepartPrevue = new GridBagConstraints();
		gbc_spinnerDateDepartPrevue.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerDateDepartPrevue.gridx = 1;
		gbc_spinnerDateDepartPrevue.gridy = 10;
		panelData.add(spinnerDateDepartPrevue, gbc_spinnerDateDepartPrevue);
		/*****************/
		/*****************/
		JLabel lblDateDarrivePrvue = new JLabel("Date d'arriv\u00E9e pr\u00E9vue :");
		GridBagConstraints gbc_lblDateDarrivePrvue = new GridBagConstraints();
		gbc_lblDateDarrivePrvue.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateDarrivePrvue.gridx = 3;
		gbc_lblDateDarrivePrvue.gridy = 10;
		panelData.add(lblDateDarrivePrvue, gbc_lblDateDarrivePrvue);
		/*****************/
		JSpinner spinnerDateArriveePrevue = new JSpinner();
		spinnerDateArriveePrevue.setModel(new SpinnerDateModel(new Date(1363042800000L), null, null, Calendar.DAY_OF_YEAR));
		GridBagConstraints gbc_spinnerDateArriveePrevue = new GridBagConstraints();
		gbc_spinnerDateArriveePrevue.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerDateArriveePrevue.gridx = 4;
		gbc_spinnerDateArriveePrevue.gridy = 10;
		panelData.add(spinnerDateArriveePrevue, gbc_spinnerDateArriveePrevue);
		JLabel lblDateDeDpartReelle = new JLabel("Date de d\u00E9part r\u00E9elle :");
		GridBagConstraints gbc_lblDateDeDpartReelle = new GridBagConstraints();
		gbc_lblDateDeDpartReelle.anchor = GridBagConstraints.WEST;
		gbc_lblDateDeDpartReelle.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateDeDpartReelle.gridx = 0;
		gbc_lblDateDeDpartReelle.gridy = 11;
		panelData.add(lblDateDeDpartReelle, gbc_lblDateDeDpartReelle);
		/*****************/
		JSpinner spinnerDateDepartReelle = new JSpinner();
		spinnerDateDepartReelle.setModel(new SpinnerDateModel(new Date(1363042800000L), null, null, Calendar.DAY_OF_YEAR));
		GridBagConstraints gbc_spinnerDateDepartReelle = new GridBagConstraints();
		gbc_spinnerDateDepartReelle.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerDateDepartReelle.gridx = 1;
		gbc_spinnerDateDepartReelle.gridy = 11;
		panelData.add(spinnerDateDepartReelle, gbc_spinnerDateDepartReelle);
		/*****************/
		JLabel lblLieuDeDpart = new JLabel("Lieu de d\u00E9part :");
		GridBagConstraints gbc_lblLieuDeDpart = new GridBagConstraints();
		gbc_lblLieuDeDpart.anchor = GridBagConstraints.WEST;
		gbc_lblLieuDeDpart.insets = new Insets(0, 0, 5, 5);
		gbc_lblLieuDeDpart.gridx = 0;
		gbc_lblLieuDeDpart.gridy = 13;
		panelData.add(lblLieuDeDpart, gbc_lblLieuDeDpart);
		/*****************/
		/*****************/
		JComboBox comboBoxLieuDepart = new JComboBox();
		GridBagConstraints gbc_comboBoxLieuDepart = new GridBagConstraints();
		gbc_comboBoxLieuDepart.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxLieuDepart.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxLieuDepart.gridx = 1;
		gbc_comboBoxLieuDepart.gridy = 13;
		panelData.add(comboBoxLieuDepart, gbc_comboBoxLieuDepart);
		JLabel lblLieuDarrive = new JLabel("Lieu d'arriv\u00E9e :");
		GridBagConstraints gbc_lblLieuDarrive = new GridBagConstraints();
		gbc_lblLieuDarrive.anchor = GridBagConstraints.WEST;
		gbc_lblLieuDarrive.insets = new Insets(0, 0, 5, 5);
		gbc_lblLieuDarrive.gridx = 3;
		gbc_lblLieuDarrive.gridy = 13;
		panelData.add(lblLieuDarrive, gbc_lblLieuDarrive);
		/*****************/
		JComboBox comboBoxLieuArrivee = new JComboBox();
		GridBagConstraints gbc_comboBoxLieuArrivee = new GridBagConstraints();
		gbc_comboBoxLieuArrivee.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxLieuArrivee.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxLieuArrivee.gridx = 4;
		gbc_comboBoxLieuArrivee.gridy = 13;
		panelData.add(comboBoxLieuArrivee, gbc_comboBoxLieuArrivee);

	}

}
