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

public class PlanificationPanel extends JPanel {
	private JTextField textFieldIdentifiant;

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
		panelData.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panelDataTransport = new JPanel();
		panelData.add(panelDataTransport);
		
		JLabel lblTransport = new JLabel("Transport : ");
		panelDataTransport.add(lblTransport);
		
		JComboBox comboBoxTransport = new JComboBox();
		panelDataTransport.add(comboBoxTransport);
		comboBoxTransport.setModel(new DefaultComboBoxModel(new String[] {"Camion", "Avion"}));
		
		JLabel lblIdentifiant = new JLabel("Identifiant : ");
		panelDataTransport.add(lblIdentifiant);
		
		textFieldIdentifiant = new JTextField();
		panelDataTransport.add(textFieldIdentifiant);
		textFieldIdentifiant.setColumns(10);
		
		JLabel lblContact = new JLabel("Contact : ");
		panelDataTransport.add(lblContact);
		
		JComboBox comboBoxContact = new JComboBox();
		panelDataTransport.add(comboBoxContact);
		
		JPanel panelDataLieu = new JPanel();
		panelData.add(panelDataLieu);
		
		JLabel lblLieuDeDpart = new JLabel("Lieu de d\u00E9part : ");
		panelDataLieu.add(lblLieuDeDpart);
		
		JComboBox comboBoxLieuDepart = new JComboBox();
		panelDataLieu.add(comboBoxLieuDepart);
		
		JLabel lblLieuDarrive = new JLabel("Lieu d'arriv\u00E9e : ");
		panelDataLieu.add(lblLieuDarrive);
		
		JComboBox comboBoxLieuArrivee = new JComboBox();
		panelDataLieu.add(comboBoxLieuArrivee);
		
		JLabel lblHeureDeDpart = new JLabel("Heure de d\u00E9part pr\u00E9vue : ");
		panelDataLieu.add(lblHeureDeDpart);
		
		JSpinner spinnerHeureDepartPrevue = new JSpinner();
		spinnerHeureDepartPrevue.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		panelDataLieu.add(spinnerHeureDepartPrevue);
		
		JSpinner spinnerMinuteDepartPrevue = new JSpinner();
		spinnerMinuteDepartPrevue.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		panelDataLieu.add(spinnerMinuteDepartPrevue);
		
		JLabel lblHeureDarrivePrvue = new JLabel("Heure d'arriv\u00E9e pr\u00E9vue : ");
		panelDataLieu.add(lblHeureDarrivePrvue);
		
		JSpinner spinnerHeureArriveePrevue = new JSpinner();
		spinnerHeureArriveePrevue.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		panelDataLieu.add(spinnerHeureArriveePrevue);
		
		JSpinner spinnerMinuteArriveePrevue = new JSpinner();
		spinnerMinuteArriveePrevue.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		panelDataLieu.add(spinnerMinuteArriveePrevue);
		
		JLabel lblHeureDeDpartReelle = new JLabel("Heure de d\u00E9part r\u00E9elle : ");
		panelDataLieu.add(lblHeureDeDpartReelle);
		
		JSpinner spinnerHeureDepartReelle = new JSpinner();
		spinnerHeureDepartReelle.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		panelDataLieu.add(spinnerHeureDepartReelle);
		
		JSpinner spinnerMinuteDepartReelle = new JSpinner();
		spinnerMinuteDepartReelle.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		panelDataLieu.add(spinnerMinuteDepartReelle);
		
		JLabel lblHeureDeDarriveRelle = new JLabel("Heure de d'arriv\u00E9e r\u00E9elle : ");
		panelDataLieu.add(lblHeureDeDarriveRelle);
		
		JSpinner spinnerHeureArriveeReelle = new JSpinner();
		spinnerHeureArriveeReelle.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		panelDataLieu.add(spinnerHeureArriveeReelle);
		
		JSpinner spinnerMinuteArriveeReelle = new JSpinner();
		spinnerMinuteArriveeReelle.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		panelDataLieu.add(spinnerMinuteArriveeReelle);
		
		JPanel panelInfos = new JPanel();
		panelData.add(panelInfos);

	}

}
