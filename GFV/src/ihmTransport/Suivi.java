package ihmTransport;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

public class Suivi extends JPanel {
	private JTextField textFieldContact;
	private JTextField textFieldChauffeur;
	private JTextField textFieldLieuDepart;
	private JTextField textFieldLieuArrivee;
	private JTextField textFieldStatut;
	private JTextField textFieldRetardCause;
	private JTextField textFieldCauseArrete;
	private JTextField textFieldCauseAccident;

	/**
	 * Create the panel.
	 */
	public Suivi() {
		setMinimumSize(new Dimension(700, 300));
		setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panelList = new JPanel();
		add(panelList);
		GridBagLayout gbl_panelList = new GridBagLayout();
		gbl_panelList.columnWidths = new int[]{233, 0};
		gbl_panelList.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 55, 55, 55};
		gbl_panelList.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelList.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panelList.setLayout(gbl_panelList);
		
		JLabel lblSuivi = new JLabel("Suivi des transports : ");
		GridBagConstraints gbc_lblSuivi = new GridBagConstraints();
		gbc_lblSuivi.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblSuivi.insets = new Insets(0, 0, 5, 0);
		gbc_lblSuivi.gridx = 0;
		gbc_lblSuivi.gridy = 0;
		panelList.add(lblSuivi, gbc_lblSuivi);
		
		JLabel lblListeDesTransport = new JLabel("Liste des transport : ");
		GridBagConstraints gbc_lblListeDesTransport = new GridBagConstraints();
		gbc_lblListeDesTransport.anchor = GridBagConstraints.WEST;
		gbc_lblListeDesTransport.insets = new Insets(0, 0, 5, 0);
		gbc_lblListeDesTransport.gridx = 0;
		gbc_lblListeDesTransport.gridy = 2;
		panelList.add(lblListeDesTransport, gbc_lblListeDesTransport);
		
		JList list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 0);
		gbc_list.gridheight = 9;
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 4;
		panelList.add(list, gbc_list);
		
		JPanel panelInfos = new JPanel();
		add(panelInfos);
		GridBagLayout gbl_panelInfos = new GridBagLayout();
		gbl_panelInfos.columnWidths = new int[]{0, 0, 0};
		gbl_panelInfos.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelInfos.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelInfos.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelInfos.setLayout(gbl_panelInfos);
		/*****************/
		JLabel lblContact = new JLabel("Contact :");
		GridBagConstraints gbc_lblContact = new GridBagConstraints();
		gbc_lblContact.insets = new Insets(0, 0, 5, 5);
		gbc_lblContact.anchor = GridBagConstraints.WEST;
		gbc_lblContact.gridx = 0;
		gbc_lblContact.gridy = 0;
		panelInfos.add(lblContact, gbc_lblContact);
		/*****************/
		textFieldContact = new JTextField();
		textFieldContact.setEditable(false);
		GridBagConstraints gbc_textFieldContact = new GridBagConstraints();
		gbc_textFieldContact.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldContact.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldContact.gridx = 1;
		gbc_textFieldContact.gridy = 0;
		panelInfos.add(textFieldContact, gbc_textFieldContact);
		textFieldContact.setColumns(10);
		/*****************/
		JLabel lblChauffeur = new JLabel("Chauffeur :");
		GridBagConstraints gbc_lblChauffeur = new GridBagConstraints();
		gbc_lblChauffeur.anchor = GridBagConstraints.WEST;
		gbc_lblChauffeur.insets = new Insets(0, 0, 5, 5);
		gbc_lblChauffeur.gridx = 0;
		gbc_lblChauffeur.gridy = 1;
		panelInfos.add(lblChauffeur, gbc_lblChauffeur);
		/*****************/
		textFieldChauffeur = new JTextField();
		textFieldChauffeur.setEditable(false);
		GridBagConstraints gbc_textFieldChauffeur = new GridBagConstraints();
		gbc_textFieldChauffeur.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldChauffeur.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldChauffeur.gridx = 1;
		gbc_textFieldChauffeur.gridy = 1;
		panelInfos.add(textFieldChauffeur, gbc_textFieldChauffeur);
		textFieldChauffeur.setColumns(10);
		/*****************/
		JLabel lblLieuDeDpart = new JLabel("Lieu de d\u00E9part :");
		GridBagConstraints gbc_lblLieuDeDpart = new GridBagConstraints();
		gbc_lblLieuDeDpart.anchor = GridBagConstraints.WEST;
		gbc_lblLieuDeDpart.insets = new Insets(0, 0, 5, 5);
		gbc_lblLieuDeDpart.gridx = 0;
		gbc_lblLieuDeDpart.gridy = 3;
		panelInfos.add(lblLieuDeDpart, gbc_lblLieuDeDpart);
		/*****************/
		textFieldLieuDepart = new JTextField();
		textFieldLieuDepart.setEditable(false);
		GridBagConstraints gbc_textFieldLieuDepart = new GridBagConstraints();
		gbc_textFieldLieuDepart.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldLieuDepart.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldLieuDepart.gridx = 1;
		gbc_textFieldLieuDepart.gridy = 3;
		panelInfos.add(textFieldLieuDepart, gbc_textFieldLieuDepart);
		textFieldLieuDepart.setColumns(10);
		/*****************/
		JLabel lblLieuDarrive = new JLabel("Lieu d'arriv\u00E9e :");
		GridBagConstraints gbc_lblLieuDarrive = new GridBagConstraints();
		gbc_lblLieuDarrive.anchor = GridBagConstraints.WEST;
		gbc_lblLieuDarrive.insets = new Insets(0, 0, 5, 5);
		gbc_lblLieuDarrive.gridx = 0;
		gbc_lblLieuDarrive.gridy = 4;
		panelInfos.add(lblLieuDarrive, gbc_lblLieuDarrive);
		/*****************/
		textFieldLieuArrivee = new JTextField();
		textFieldLieuArrivee.setEditable(false);
		GridBagConstraints gbc_textFieldLieuArrivee = new GridBagConstraints();
		gbc_textFieldLieuArrivee.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldLieuArrivee.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldLieuArrivee.gridx = 1;
		gbc_textFieldLieuArrivee.gridy = 4;
		panelInfos.add(textFieldLieuArrivee, gbc_textFieldLieuArrivee);
		textFieldLieuArrivee.setColumns(10);
		/*****************/
		JLabel lblDateDeDpart = new JLabel("Date de d\u00E9part pr\u00E9vue :");
		GridBagConstraints gbc_lblDateDeDpart = new GridBagConstraints();
		gbc_lblDateDeDpart.anchor = GridBagConstraints.WEST;
		gbc_lblDateDeDpart.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateDeDpart.gridx = 0;
		gbc_lblDateDeDpart.gridy = 6;
		panelInfos.add(lblDateDeDpart, gbc_lblDateDeDpart);
		/*****************/
		JSpinner spinnerDateDepartPrevue = new JSpinner();
		spinnerDateDepartPrevue.setModel(new SpinnerDateModel(new Date(1363042800000L), null, null, Calendar.DAY_OF_YEAR));
		GridBagConstraints gbc_spinnerDateDepartPrevue = new GridBagConstraints();
		gbc_spinnerDateDepartPrevue.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerDateDepartPrevue.gridx = 1;
		gbc_spinnerDateDepartPrevue.gridy = 6;
		panelInfos.add(spinnerDateDepartPrevue, gbc_spinnerDateDepartPrevue);
		/*****************/
		JLabel lblDateDeDpart_1 = new JLabel("Date de d\u00E9part r\u00E9elle :");
		GridBagConstraints gbc_lblDateDeDpart_1 = new GridBagConstraints();
		gbc_lblDateDeDpart_1.anchor = GridBagConstraints.WEST;
		gbc_lblDateDeDpart_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateDeDpart_1.gridx = 0;
		gbc_lblDateDeDpart_1.gridy = 7;
		panelInfos.add(lblDateDeDpart_1, gbc_lblDateDeDpart_1);
		/*****************/
		JSpinner spinnerDateDepartReelle = new JSpinner();
		spinnerDateDepartReelle.setModel(new SpinnerDateModel(new Date(1363042800000L), null, null, Calendar.DAY_OF_YEAR));
		GridBagConstraints gbc_spinnerDateDepartReelle = new GridBagConstraints();
		gbc_spinnerDateDepartReelle.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerDateDepartReelle.gridx = 1;
		gbc_spinnerDateDepartReelle.gridy = 7;
		panelInfos.add(spinnerDateDepartReelle, gbc_spinnerDateDepartReelle);
		/*****************/
		JLabel lblDateDarrivePrvue = new JLabel("Date d'arriv\u00E9e pr\u00E9vue :");
		GridBagConstraints gbc_lblDateDarrivePrvue = new GridBagConstraints();
		gbc_lblDateDarrivePrvue.anchor = GridBagConstraints.WEST;
		gbc_lblDateDarrivePrvue.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateDarrivePrvue.gridx = 0;
		gbc_lblDateDarrivePrvue.gridy = 8;
		panelInfos.add(lblDateDarrivePrvue, gbc_lblDateDarrivePrvue);
		/*****************/
		JSpinner spinnerDateArriveePrevue = new JSpinner();
		spinnerDateArriveePrevue.setModel(new SpinnerDateModel(new Date(1363042800000L), null, null, Calendar.DAY_OF_YEAR));
		GridBagConstraints gbc_spinnerDateArriveePrevue = new GridBagConstraints();
		gbc_spinnerDateArriveePrevue.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerDateArriveePrevue.gridx = 1;
		gbc_spinnerDateArriveePrevue.gridy = 8;
		panelInfos.add(spinnerDateArriveePrevue, gbc_spinnerDateArriveePrevue);
		/*****************/
		JLabel lblDateDarriveRelle = new JLabel("Date d'arriv\u00E9e r\u00E9elle :");
		GridBagConstraints gbc_lblDateDarriveRelle = new GridBagConstraints();
		gbc_lblDateDarriveRelle.anchor = GridBagConstraints.WEST;
		gbc_lblDateDarriveRelle.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateDarriveRelle.gridx = 0;
		gbc_lblDateDarriveRelle.gridy = 9;
		panelInfos.add(lblDateDarriveRelle, gbc_lblDateDarriveRelle);
		/*****************/
		JSpinner spinnerDateArriveeReelle = new JSpinner();
		spinnerDateArriveeReelle.setModel(new SpinnerDateModel(new Date(1363042800000L), null, null, Calendar.DAY_OF_YEAR));
		GridBagConstraints gbc_spinnerDateArriveeReelle = new GridBagConstraints();
		gbc_spinnerDateArriveeReelle.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerDateArriveeReelle.gridx = 1;
		gbc_spinnerDateArriveeReelle.gridy = 9;
		panelInfos.add(spinnerDateArriveeReelle, gbc_spinnerDateArriveeReelle);
		/*****************/
		JLabel lblStatut = new JLabel("Statut :");
		GridBagConstraints gbc_lblStatut = new GridBagConstraints();
		gbc_lblStatut.anchor = GridBagConstraints.WEST;
		gbc_lblStatut.insets = new Insets(0, 0, 0, 5);
		gbc_lblStatut.gridx = 0;
		gbc_lblStatut.gridy = 11;
		panelInfos.add(lblStatut, gbc_lblStatut);
		/*****************/
		textFieldStatut = new JTextField();
		textFieldStatut.setEditable(false);
		GridBagConstraints gbc_textFieldStatut = new GridBagConstraints();
		gbc_textFieldStatut.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldStatut.gridx = 1;
		gbc_textFieldStatut.gridy = 11;
		panelInfos.add(textFieldStatut, gbc_textFieldStatut);
		textFieldStatut.setColumns(10);
		
		JPanel panelModifStatut = new JPanel();
		add(panelModifStatut);
		GridBagLayout gbl_panelModifStatut = new GridBagLayout();
		gbl_panelModifStatut.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panelModifStatut.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelModifStatut.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelModifStatut.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelModifStatut.setLayout(gbl_panelModifStatut);
		/*****************/
		JLabel lblModificationDuStatut = new JLabel("Modification du statut :");
		GridBagConstraints gbc_lblModificationDuStatut = new GridBagConstraints();
		gbc_lblModificationDuStatut.gridwidth = 2;
		gbc_lblModificationDuStatut.insets = new Insets(0, 0, 5, 5);
		gbc_lblModificationDuStatut.gridx = 0;
		gbc_lblModificationDuStatut.gridy = 0;
		panelModifStatut.add(lblModificationDuStatut, gbc_lblModificationDuStatut);
		/*****************/
		JCheckBox chckbxEnRetard = new JCheckBox("En retard");
		GridBagConstraints gbc_chckbxEnRetard = new GridBagConstraints();
		gbc_chckbxEnRetard.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxEnRetard.anchor = GridBagConstraints.WEST;
		gbc_chckbxEnRetard.gridx = 0;
		gbc_chckbxEnRetard.gridy = 1;
		panelModifStatut.add(chckbxEnRetard, gbc_chckbxEnRetard);
		/*****************/
		JLabel lblEstimationheuresRetard = new JLabel("Estimation (heures) :");
		GridBagConstraints gbc_lblEstimationheuresRetard = new GridBagConstraints();
		gbc_lblEstimationheuresRetard.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstimationheuresRetard.gridx = 2;
		gbc_lblEstimationheuresRetard.gridy = 1;
		panelModifStatut.add(lblEstimationheuresRetard, gbc_lblEstimationheuresRetard);
		/*****************/
		JSpinner spinnerEstimationRetard = new JSpinner();
		spinnerEstimationRetard.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		GridBagConstraints gbc_spinnerEstimationRetard = new GridBagConstraints();
		gbc_spinnerEstimationRetard.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerEstimationRetard.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerEstimationRetard.gridx = 3;
		gbc_spinnerEstimationRetard.gridy = 1;
		panelModifStatut.add(spinnerEstimationRetard, gbc_spinnerEstimationRetard);
		/*****************/
		JLabel lblCauseRetard = new JLabel("Cause :");
		GridBagConstraints gbc_lblCauseRetard = new GridBagConstraints();
		gbc_lblCauseRetard.anchor = GridBagConstraints.WEST;
		gbc_lblCauseRetard.insets = new Insets(0, 0, 5, 5);
		gbc_lblCauseRetard.gridx = 0;
		gbc_lblCauseRetard.gridy = 2;
		panelModifStatut.add(lblCauseRetard, gbc_lblCauseRetard);
		/*****************/
		textFieldRetardCause = new JTextField();
		GridBagConstraints gbc_textFieldRetardCause = new GridBagConstraints();
		gbc_textFieldRetardCause.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldRetardCause.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRetardCause.gridwidth = 3;
		gbc_textFieldRetardCause.gridx = 1;
		gbc_textFieldRetardCause.gridy = 2;
		panelModifStatut.add(textFieldRetardCause, gbc_textFieldRetardCause);
		textFieldRetardCause.setColumns(10);
		/*****************/
		JCheckBox chckbxArrt = new JCheckBox("Arr\u00EAt\u00E9");
		GridBagConstraints gbc_chckbxArrt = new GridBagConstraints();
		gbc_chckbxArrt.anchor = GridBagConstraints.WEST;
		gbc_chckbxArrt.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxArrt.gridx = 0;
		gbc_chckbxArrt.gridy = 4;
		panelModifStatut.add(chckbxArrt, gbc_chckbxArrt);
		/*****************/
		JLabel lblEstimationheuresArrete = new JLabel("Estimation (heures) :");
		GridBagConstraints gbc_lblEstimationheuresArrete = new GridBagConstraints();
		gbc_lblEstimationheuresArrete.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstimationheuresArrete.gridx = 2;
		gbc_lblEstimationheuresArrete.gridy = 4;
		panelModifStatut.add(lblEstimationheuresArrete, gbc_lblEstimationheuresArrete);
		/*****************/
		JSpinner spinnerEstimationArrete = new JSpinner();
		GridBagConstraints gbc_spinnerEstimationArrete = new GridBagConstraints();
		gbc_spinnerEstimationArrete.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerEstimationArrete.gridx = 3;
		gbc_spinnerEstimationArrete.gridy = 4;
		panelModifStatut.add(spinnerEstimationArrete, gbc_spinnerEstimationArrete);
		/*****************/
		JLabel lblCauseArrete = new JLabel("Cause :");
		GridBagConstraints gbc_lblCauseArrete = new GridBagConstraints();
		gbc_lblCauseArrete.anchor = GridBagConstraints.WEST;
		gbc_lblCauseArrete.insets = new Insets(0, 0, 5, 5);
		gbc_lblCauseArrete.gridx = 0;
		gbc_lblCauseArrete.gridy = 5;
		panelModifStatut.add(lblCauseArrete, gbc_lblCauseArrete);
		/*****************/
		textFieldCauseArrete = new JTextField();
		GridBagConstraints gbc_textFieldCauseArrete = new GridBagConstraints();
		gbc_textFieldCauseArrete.gridwidth = 3;
		gbc_textFieldCauseArrete.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCauseArrete.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCauseArrete.gridx = 1;
		gbc_textFieldCauseArrete.gridy = 5;
		panelModifStatut.add(textFieldCauseArrete, gbc_textFieldCauseArrete);
		textFieldCauseArrete.setColumns(10);
		/*****************/
		JCheckBox chckbxAccident = new JCheckBox("Accident\u00E9");
		GridBagConstraints gbc_chckbxAccident = new GridBagConstraints();
		gbc_chckbxAccident.anchor = GridBagConstraints.WEST;
		gbc_chckbxAccident.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAccident.gridx = 0;
		gbc_chckbxAccident.gridy = 7;
		panelModifStatut.add(chckbxAccident, gbc_chckbxAccident);
		/*****************/
		JLabel lblEstimationheuresAccidente = new JLabel("Estimation (heures) :");
		GridBagConstraints gbc_lblEstimationheuresAccidente = new GridBagConstraints();
		gbc_lblEstimationheuresAccidente.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstimationheuresAccidente.gridx = 2;
		gbc_lblEstimationheuresAccidente.gridy = 7;
		panelModifStatut.add(lblEstimationheuresAccidente, gbc_lblEstimationheuresAccidente);
		/*****************/
		JSpinner spinnerEstimationAccident = new JSpinner();
		GridBagConstraints gbc_spinnerEstimationAccident = new GridBagConstraints();
		gbc_spinnerEstimationAccident.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerEstimationAccident.gridx = 3;
		gbc_spinnerEstimationAccident.gridy = 7;
		panelModifStatut.add(spinnerEstimationAccident, gbc_spinnerEstimationAccident);
		/*****************/
		JLabel lblCauseAccidente = new JLabel("Cause :");
		GridBagConstraints gbc_lblCauseAccidente = new GridBagConstraints();
		gbc_lblCauseAccidente.anchor = GridBagConstraints.WEST;
		gbc_lblCauseAccidente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCauseAccidente.gridx = 0;
		gbc_lblCauseAccidente.gridy = 8;
		panelModifStatut.add(lblCauseAccidente, gbc_lblCauseAccidente);
		/*****************/
		textFieldCauseAccident = new JTextField();
		GridBagConstraints gbc_textFieldCauseAccident = new GridBagConstraints();
		gbc_textFieldCauseAccident.gridwidth = 3;
		gbc_textFieldCauseAccident.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCauseAccident.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCauseAccident.gridx = 1;
		gbc_textFieldCauseAccident.gridy = 8;
		panelModifStatut.add(textFieldCauseAccident, gbc_textFieldCauseAccident);
		textFieldCauseAccident.setColumns(10);
		/*****************/
		JLabel lblPositionActuelle = new JLabel("Position actuelle :");
		GridBagConstraints gbc_lblPositionActuelle = new GridBagConstraints();
		gbc_lblPositionActuelle.anchor = GridBagConstraints.WEST;
		gbc_lblPositionActuelle.insets = new Insets(0, 0, 5, 5);
		gbc_lblPositionActuelle.gridx = 0;
		gbc_lblPositionActuelle.gridy = 10;
		panelModifStatut.add(lblPositionActuelle, gbc_lblPositionActuelle);
		/*****************/
		JButton btnCarte = new JButton("Carte");
		GridBagConstraints gbc_btnCarte = new GridBagConstraints();
		gbc_btnCarte.insets = new Insets(0, 0, 5, 5);
		gbc_btnCarte.gridx = 2;
		gbc_btnCarte.gridy = 10;
		panelModifStatut.add(btnCarte, gbc_btnCarte);
		/*****************/
		JCheckBox chckbxRevenu = new JCheckBox("Revenu");
		GridBagConstraints gbc_chckbxRevenu = new GridBagConstraints();
		gbc_chckbxRevenu.anchor = GridBagConstraints.WEST;
		gbc_chckbxRevenu.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxRevenu.gridx = 0;
		gbc_chckbxRevenu.gridy = 12;
		panelModifStatut.add(chckbxRevenu, gbc_chckbxRevenu);
		/*****************/
		JLabel lblDateDeRetour = new JLabel("Date de retour :");
		GridBagConstraints gbc_lblDateDeRetour = new GridBagConstraints();
		gbc_lblDateDeRetour.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateDeRetour.gridx = 0;
		gbc_lblDateDeRetour.gridy = 13;
		panelModifStatut.add(lblDateDeRetour, gbc_lblDateDeRetour);
		/*****************/
		JSpinner spinnerDateRetour = new JSpinner();
		spinnerDateRetour.setModel(new SpinnerDateModel(new Date(1363042800000L), null, null, Calendar.DAY_OF_YEAR));
		GridBagConstraints gbc_spinnerDateRetour = new GridBagConstraints();
		gbc_spinnerDateRetour.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerDateRetour.gridx = 2;
		gbc_spinnerDateRetour.gridy = 13;
		panelModifStatut.add(spinnerDateRetour, gbc_spinnerDateRetour);
		/*****************/
		JButton btnMiseJour = new JButton("Mise \u00E0 jour");
		GridBagConstraints gbc_btnMiseJour = new GridBagConstraints();
		gbc_btnMiseJour.insets = new Insets(0, 0, 0, 5);
		gbc_btnMiseJour.gridx = 0;
		gbc_btnMiseJour.gridy = 15;
		panelModifStatut.add(btnMiseJour, gbc_btnMiseJour);

	}

}
