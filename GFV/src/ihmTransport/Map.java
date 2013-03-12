package ihmTransport;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JEditorPane;

public class Map extends JPanel {
	private JTextField textFieldNom;
	private JTextField textFieldAdr;
	private JTextField textFieldXCoord;
	private JTextField textFieldYCoord;
	private JTextField textFieldZCoord;

	/**
	 * Create the panel.
	 */
	public Map() {
		setMinimumSize(new Dimension(700, 300));
		setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panelMap = new JPanel();
		add(panelMap);
		panelMap.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCarte = new JLabel("Carte : ");
		panelMap.add(lblCarte, BorderLayout.NORTH);
		
		JEditorPane editorPane = new JEditorPane();
		panelMap.add(editorPane, BorderLayout.CENTER);
		
		JPanel panelList = new JPanel();
		add(panelList);
		panelList.setLayout(new GridLayout(2, 0, 0, 0));
		
		JLabel lblListeDesDpts = new JLabel("Liste des d\u00E9p\u00F4ts : ");
		panelList.add(lblListeDesDpts);
		
		JList listDepot = new JList();
		listDepot.setModel(new AbstractListModel() {
			String[] values = new String[] {"d\u00E9p\u00F4t 1", "d\u00E9p\u00F4t 2"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panelList.add(listDepot);
		
		JPanel panelAdd = new JPanel();
		add(panelAdd);
		panelAdd.setLayout(new GridLayout(5, 0, 0, 0));
		
		JLabel lblAjouterUnDpt = new JLabel("Ajouter un d\u00E9p\u00F4t : ");
		panelAdd.add(lblAjouterUnDpt);
		
		JPanel panelNom = new JPanel();
		panelNom.setMaximumSize(new Dimension(100, 30));
		panelAdd.add(panelNom);
		panelNom.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNom = new JLabel("Nom : ");
		panelNom.add(lblNom);
		
		textFieldNom = new JTextField();
		textFieldNom.setMaximumSize(new Dimension(6, 20));
		panelNom.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		JPanel panelCoord = new JPanel();
		panelAdd.add(panelCoord);
		panelCoord.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panelAdr = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelAdr.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelCoord.add(panelAdr);
		
		JLabel lblAdresse = new JLabel("Adresse : ");
		panelAdr.add(lblAdresse);
		
		textFieldAdr = new JTextField();
		panelAdr.add(textFieldAdr);
		textFieldAdr.setColumns(10);
		
		JPanel panelGPS = new JPanel();
		panelCoord.add(panelGPS);
		panelGPS.setLayout(new GridLayout(3, 4, 0, 0));
		
		JLabel lblNewLabelGPS = new JLabel("GPS : ");
		panelGPS.add(lblNewLabelGPS);
		
		JLabel lblX = new JLabel("x : ");
		panelGPS.add(lblX);
		
		textFieldXCoord = new JTextField();
		panelGPS.add(textFieldXCoord);
		textFieldXCoord.setColumns(10);
		
		JLabel label = new JLabel("");
		panelGPS.add(label);
		
		JLabel label_1 = new JLabel("");
		panelGPS.add(label_1);
		
		JLabel lblY = new JLabel("y : ");
		panelGPS.add(lblY);
		
		textFieldYCoord = new JTextField();
		panelGPS.add(textFieldYCoord);
		textFieldYCoord.setColumns(10);
		
		JLabel label_2 = new JLabel("");
		panelGPS.add(label_2);
		
		JLabel label_3 = new JLabel("");
		panelGPS.add(label_3);
		
		JLabel lblZ = new JLabel("z : ");
		panelGPS.add(lblZ);
		
		textFieldZCoord = new JTextField();
		panelGPS.add(textFieldZCoord);
		textFieldZCoord.setColumns(10);
		
		JLabel label_4 = new JLabel("");
		panelGPS.add(label_4);
		
		JPanel panelType = new JPanel();
		panelAdd.add(panelType);
		panelType.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 15));
		
		JLabel lblType = new JLabel("Type : ");
		panelType.add(lblType);
		
		JComboBox comboBoxType = new JComboBox();
		panelType.add(comboBoxType);
		
		JPanel panelSave = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelSave.getLayout();
		flowLayout_1.setVgap(15);
		panelAdd.add(panelSave);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		panelSave.add(btnEnregistrer);

	}

}
