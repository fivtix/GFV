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

public class Suivi extends JPanel {
	private JTextField textFieldContact;
	private JTextField textFieldLieuDepart;
	private JTextField textFieldLieuArrivee;
	private JTextField textFieldHoraireDepartPrevue;
	private JTextField textFieldHoraireArriveePrevue;
	private JTextField textFieldHoraireDepartReelle;
	private JTextField textFieldHoraireArriveeReelle;
	private JTextField textFieldStatut;
	private JTextField textFieldEstimationRetard;
	private JTextField textFieldCauseRetard;
	private JTextField textFieldEstimationArret;
	private JTextField textFieldCauseArret;
	private JTextField textFieldEstimationAccident;
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
		gbl_panelList.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
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
		gbc_lblListeDesTransport.gridy = 5;
		panelList.add(lblListeDesTransport, gbc_lblListeDesTransport);
		
		JList list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 8;
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 6;
		panelList.add(list, gbc_list);
		
		JPanel panelInfos = new JPanel();
		add(panelInfos);
		panelInfos.setLayout(new GridLayout(8, 0, 0, 0));
		
		JPanel panelContact = new JPanel();
		panelInfos.add(panelContact);
		panelContact.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblContact = new JLabel("Contact : ");
		panelContact.add(lblContact);
		
		textFieldContact = new JTextField();
		textFieldContact.setEditable(false);
		panelContact.add(textFieldContact);
		textFieldContact.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		panelContact.add(lblNewLabel);
		
		JPanel panelLieuDepart = new JPanel();
		panelInfos.add(panelLieuDepart);
		panelLieuDepart.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblLieuDeDpart = new JLabel("Lieu de d\u00E9part : ");
		panelLieuDepart.add(lblLieuDeDpart);
		
		textFieldLieuDepart = new JTextField();
		textFieldLieuDepart.setEditable(false);
		panelLieuDepart.add(textFieldLieuDepart);
		textFieldLieuDepart.setColumns(10);
		
		JLabel label = new JLabel("");
		panelLieuDepart.add(label);
		
		JPanel panelLieuArrivee = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panelLieuArrivee.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panelInfos.add(panelLieuArrivee);
		
		JLabel lblLieuDarrive = new JLabel("Lieu d'arriv\u00E9e : ");
		panelLieuArrivee.add(lblLieuDarrive);
		
		textFieldLieuArrivee = new JTextField();
		textFieldLieuArrivee.setEditable(false);
		panelLieuArrivee.add(textFieldLieuArrivee);
		textFieldLieuArrivee.setColumns(10);
		
		JPanel panelHoraireDepartPrevue = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panelHoraireDepartPrevue.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panelInfos.add(panelHoraireDepartPrevue);
		
		JLabel lblHoraireDeDpart = new JLabel("Horaire de d\u00E9part pr\u00E9vue : ");
		panelHoraireDepartPrevue.add(lblHoraireDeDpart);
		
		textFieldHoraireDepartPrevue = new JTextField();
		textFieldHoraireDepartPrevue.setEditable(false);
		panelHoraireDepartPrevue.add(textFieldHoraireDepartPrevue);
		textFieldHoraireDepartPrevue.setColumns(10);
		
		JPanel panelHoraireArriveePrevue = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panelHoraireArriveePrevue.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panelInfos.add(panelHoraireArriveePrevue);
		
		JLabel lblHoraireDarrivePrvue = new JLabel("Horaire d'arriv\u00E9e pr\u00E9vue : ");
		panelHoraireArriveePrevue.add(lblHoraireDarrivePrvue);
		
		textFieldHoraireArriveePrevue = new JTextField();
		textFieldHoraireArriveePrevue.setEditable(false);
		panelHoraireArriveePrevue.add(textFieldHoraireArriveePrevue);
		textFieldHoraireArriveePrevue.setColumns(10);
		
		JPanel panelHoraireDepartReelle = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panelHoraireDepartReelle.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		panelInfos.add(panelHoraireDepartReelle);
		
		JLabel lblHoraireDeDpartReelle = new JLabel("Horaire de d\u00E9part r\u00E9elle : ");
		panelHoraireDepartReelle.add(lblHoraireDeDpartReelle);
		
		textFieldHoraireDepartReelle = new JTextField();
		textFieldHoraireDepartReelle.setEditable(false);
		panelHoraireDepartReelle.add(textFieldHoraireDepartReelle);
		textFieldHoraireDepartReelle.setColumns(10);
		
		JPanel panelHoraireArriveeReelle = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panelHoraireArriveeReelle.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		panelInfos.add(panelHoraireArriveeReelle);
		
		JLabel lblHoraireDarriveRelle = new JLabel("Horaire d'arriv\u00E9e r\u00E9elle : ");
		panelHoraireArriveeReelle.add(lblHoraireDarriveRelle);
		
		textFieldHoraireArriveeReelle = new JTextField();
		textFieldHoraireArriveeReelle.setEditable(false);
		panelHoraireArriveeReelle.add(textFieldHoraireArriveeReelle);
		textFieldHoraireArriveeReelle.setColumns(10);
		
		JPanel panelStatut = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panelStatut.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		panelInfos.add(panelStatut);
		
		JLabel lblStatut = new JLabel("Statut : ");
		panelStatut.add(lblStatut);
		
		textFieldStatut = new JTextField();
		textFieldStatut.setEditable(false);
		panelStatut.add(textFieldStatut);
		textFieldStatut.setColumns(10);
		
		JPanel panelModifStatut = new JPanel();
		add(panelModifStatut);
		panelModifStatut.setLayout(new GridLayout(7, 0, 0, 0));
		
		JLabel lblModifierLeStatut = new JLabel("Modifier le statut : ");
		panelModifStatut.add(lblModifierLeStatut);
		
		JPanel panelRetard = new JPanel();
		panelRetard.setSize(new Dimension(10, 100));
		panelRetard.setPreferredSize(new Dimension(10, 100));
		panelRetard.setMinimumSize(new Dimension(10, 100));
		panelModifStatut.add(panelRetard);
		panelRetard.setLayout(new GridLayout(3, 1, 0, 0));
		
		JCheckBox chckbxRetard = new JCheckBox("retard");
		panelRetard.add(chckbxRetard);
		
		JPanel panelEstimationRetard = new JPanel();
		FlowLayout fl_panelEstimationRetard = (FlowLayout) panelEstimationRetard.getLayout();
		fl_panelEstimationRetard.setAlignment(FlowLayout.LEFT);
		panelRetard.add(panelEstimationRetard);
		
		JLabel lblEstimationheuresRetard = new JLabel("Estimation (heures): ");
		panelEstimationRetard.add(lblEstimationheuresRetard);
		
		textFieldEstimationRetard = new JTextField();
		panelEstimationRetard.add(textFieldEstimationRetard);
		textFieldEstimationRetard.setColumns(10);
		
		JPanel panelCauseRetard = new JPanel();
		FlowLayout fl_panelCauseRetard = (FlowLayout) panelCauseRetard.getLayout();
		fl_panelCauseRetard.setAlignment(FlowLayout.LEFT);
		panelRetard.add(panelCauseRetard);
		
		JLabel lblCauseRetard = new JLabel("Cause : ");
		panelCauseRetard.add(lblCauseRetard);
		
		textFieldCauseRetard = new JTextField();
		panelCauseRetard.add(textFieldCauseRetard);
		textFieldCauseRetard.setColumns(10);
		
		JPanel panelArret = new JPanel();
		panelModifStatut.add(panelArret);
		panelArret.setLayout(new GridLayout(3, 1, 0, 0));
		
		JCheckBox chckbxArrt = new JCheckBox("arr\u00EAt\u00E9");
		panelArret.add(chckbxArrt);
		
		JPanel panelEstimationArret = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panelEstimationArret.getLayout();
		flowLayout_8.setAlignment(FlowLayout.LEFT);
		panelArret.add(panelEstimationArret);
		
		JLabel lblEstimationheuresArret = new JLabel("Estimation (heures) : ");
		panelEstimationArret.add(lblEstimationheuresArret);
		
		textFieldEstimationArret = new JTextField();
		panelEstimationArret.add(textFieldEstimationArret);
		textFieldEstimationArret.setColumns(10);
		
		JPanel panelCauseArret = new JPanel();
		FlowLayout flowLayout_9 = (FlowLayout) panelCauseArret.getLayout();
		flowLayout_9.setAlignment(FlowLayout.LEFT);
		panelArret.add(panelCauseArret);
		
		JLabel lblCauseArret = new JLabel("Cause : ");
		panelCauseArret.add(lblCauseArret);
		
		textFieldCauseArret = new JTextField();
		panelCauseArret.add(textFieldCauseArret);
		textFieldCauseArret.setColumns(10);
		
		JPanel panelAccident = new JPanel();
		panelModifStatut.add(panelAccident);
		panelAccident.setLayout(new GridLayout(3, 0, 0, 0));
		
		JCheckBox chckbxAccident = new JCheckBox("Accident\u00E9");
		panelAccident.add(chckbxAccident);
		
		JPanel panelEstimationAccident = new JPanel();
		FlowLayout flowLayout_10 = (FlowLayout) panelEstimationAccident.getLayout();
		flowLayout_10.setAlignment(FlowLayout.LEFT);
		panelAccident.add(panelEstimationAccident);
		
		JLabel lblEstimationheuresAccident = new JLabel("Estimation (heures) : ");
		panelEstimationAccident.add(lblEstimationheuresAccident);
		
		textFieldEstimationAccident = new JTextField();
		panelEstimationAccident.add(textFieldEstimationAccident);
		textFieldEstimationAccident.setColumns(10);
		
		JPanel panelCauseAccident = new JPanel();
		FlowLayout flowLayout_11 = (FlowLayout) panelCauseAccident.getLayout();
		flowLayout_11.setAlignment(FlowLayout.LEFT);
		panelAccident.add(panelCauseAccident);
		
		JLabel lblCauseAccident = new JLabel("Cause : ");
		panelCauseAccident.add(lblCauseAccident);
		
		textFieldCauseAccident = new JTextField();
		panelCauseAccident.add(textFieldCauseAccident);
		textFieldCauseAccident.setColumns(10);
		
		JPanel panelPosition = new JPanel();
		FlowLayout fl_panelPosition = (FlowLayout) panelPosition.getLayout();
		fl_panelPosition.setAlignment(FlowLayout.LEFT);
		panelModifStatut.add(panelPosition);
		
		JLabel lblPositionActuelle = new JLabel("Position actuelle : ");
		panelPosition.add(lblPositionActuelle);
		
		JButton btnCarte = new JButton("Carte");
		btnCarte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PositionOnMap posmap = new PositionOnMap();
			}
		});
		panelPosition.add(btnCarte);
		
		JPanel panelRevenu = new JPanel();
		panelModifStatut.add(panelRevenu);
		panelRevenu.setLayout(new GridLayout(2, 1, 0, 0));
		
		JCheckBox chckbxRevenu = new JCheckBox("Revenu");
		panelRevenu.add(chckbxRevenu);
		
		JPanel panelHoraireRetour = new JPanel();
		FlowLayout flowLayout_12 = (FlowLayout) panelHoraireRetour.getLayout();
		flowLayout_12.setAlignment(FlowLayout.LEFT);
		panelRevenu.add(panelHoraireRetour);
		
		JLabel lblHeureDeRetour = new JLabel("Heure de retour : ");
		panelHoraireRetour.add(lblHeureDeRetour);
		
		JSpinner spinnerHeureRetour = new JSpinner();
		spinnerHeureRetour.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		panelHoraireRetour.add(spinnerHeureRetour);
		
		JSpinner spinnerMinuteRetour = new JSpinner();
		spinnerMinuteRetour.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		panelHoraireRetour.add(spinnerMinuteRetour);
		
		JPanel panelButton = new JPanel();
		panelModifStatut.add(panelButton);
		
		JButton btnMiseJour = new JButton("Mise \u00E0 jour");
		panelButton.add(btnMiseJour);

	}

}
