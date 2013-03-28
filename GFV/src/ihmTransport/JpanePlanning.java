package ihmTransport;

import ihmTransport.creerTransportJPanel.actionEnregistrerAnnuler;
import ihmTransport.List.List;
import ihmTransport.tables.tableHoraire;
import ihmTransport.tables.tableLigneTransport;
import interTransport.utils.Combox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import modelTransport.GestionTransport;
import modelTransport.Item;

public class JpanePlanning extends JPanel{ 
	private Insets insets = new Insets(2, 2, 2, 2);
	private Combox trajets,vehicules,chauffeurs;
	private JTextField  nom,typeaccident,dateheuredebut,dateheureterminal;
	private tableLigneTransport modelligneTransport;
	private tableHoraire modeltablehoraire;
	private JTable tableHoraires,tableligneTransport;
	private JPanel jpanelaccident;
	private JTextArea  decriptionaccident;
	private JPanel controlButton;
	private GestionTransport gTransport;
	private List listdocument;
	public  JpanePlanning() {
		setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		setLayout(new BorderLayout());
		gTransport = new GestionTransport();
		listdocument = new List();
		trajets = new Combox();
		trajets.addItem(new Item(0,""));
		vehicules =new Combox();
		vehicules.addItem(new Item(0,""));
		chauffeurs = new Combox();
		chauffeurs.addItem(new Item(0,""));
		dateheuredebut= new  JTextField();
		dateheureterminal=new  JTextField();
		typeaccident =new  JTextField();
		decriptionaccident = new JTextArea();
		nom = new  JTextField();
		modeltablehoraire  = new tableHoraire();
		tableHoraires = new JTable(modeltablehoraire);
		modelligneTransport =new tableLigneTransport();
		tableligneTransport = new JTable(modelligneTransport );
		jpanelaccident = new JPanel();
		jpanelaccident.setLayout(new BorderLayout());
		jpanelaccident.add( jpanelaccidentdoucument());
		controlButton = new JPanel();
		controlButton.setLayout(new BorderLayout()); 
		// TODO Auto-generated constructor stub
		add(descriptionPlanning(),BorderLayout.NORTH);
		add(jpanelLigneTransport(),BorderLayout.CENTER);
		add(controlButton,BorderLayout.SOUTH);
		init();
	}
	public void init(){
		controlButton.removeAll();
		if(gTransport.getId()<=0){
			controlButton.add(jpanelbuttonCreerPlanning(),BorderLayout.NORTH);
			controlButton.validate();
			controlButton.revalidate();
		}else{
			controlButton.add(jpanelbuttonModifierPlanning(),BorderLayout.NORTH);
			controlButton.validate();
			controlButton.revalidate();
		}
		gTransport = new GestionTransport();
		nom.setText("");
		trajets.setSelectedIndex(0);
		vehicules.setSelectedIndex(0);
		chauffeurs.setSelectedIndex(0);
		dateheuredebut.setText("");
		dateheureterminal.setText("");
		decriptionaccident.selectAll();
		modelligneTransport.removeAllLigne_Transport();
		modeltablehoraire.removeAllhoraires(); 
		typeaccident.setText("");
		listdocument.getModel().removeAllElements();
	}
	public JPanel descriptionPlanning(){
		JPanel jpanel1 = new JPanel();
		jpanel1.setLayout(new BorderLayout());
		jpanel1.setBorder(BorderFactory.createEtchedBorder());
		jpanel1.setPreferredSize(new Dimension(795,210));
		JPanel decriptplanning = new JPanel();
		decriptplanning.setLayout(new GridBagLayout());
		JPanel gril1 = new JPanel();
		gril1.setLayout(new GridLayout(2,1,5,5));
		gril1.setPreferredSize(new Dimension(70,60));
		gril1.add(new JLabel("Nom: "));
		gril1.add(new JLabel("Chauffeur: "));
		addComponent(decriptplanning,gril1, 0, 0, 1, 1,GridBagConstraints.WEST,GridBagConstraints.VERTICAL);

		JPanel gril2 = new JPanel();
		gril2.setLayout(new GridLayout(2,1,5,5));
		gril2.setPreferredSize(new Dimension(250,60));
		gril2.add(nom);
		gril2.add(chauffeurs);
		addComponent(decriptplanning,gril2, 1, 0, 1, 1,GridBagConstraints.WEST,GridBagConstraints.BOTH);

		JPanel gril3 = new JPanel();
		gril3.setLayout(new GridLayout(2,1,5,5));
		gril3.setPreferredSize(new Dimension(70,60));
		gril3.add(new JLabel("Trajet: "));
		gril3.add(new JLabel("Vehicules:"));
		addComponent(decriptplanning,gril3,2, 0, 1, 1,GridBagConstraints.WEST,GridBagConstraints.VERTICAL);

		JPanel gril4 = new JPanel();
		gril4.setLayout(new GridLayout(2,1,5,5));
		gril4.setPreferredSize(new Dimension(250,60));
		gril4.add(trajets);
		gril4.add(vehicules);
		addComponent(decriptplanning,gril4,3, 0, 1, 1,GridBagConstraints.WEST,GridBagConstraints.BOTH);

		addComponent(decriptplanning,new JLabel("Début:"),0,3, 1, 1,GridBagConstraints.WEST,GridBagConstraints.VERTICAL);
		addComponent(decriptplanning,new JLabel("Terminer"),2,3, 1, 1,GridBagConstraints.WEST,GridBagConstraints.VERTICAL);
		dateheuredebut.setPreferredSize(new Dimension(150,25));
		JPanel datedebut = new JPanel();
		datedebut.setBorder(BorderFactory.createEmptyBorder(0,-4,0,0));
		JPanel dateterminal = new JPanel();
		dateterminal.setLayout(new FlowLayout(FlowLayout.LEFT));
		dateterminal.add(dateheureterminal);
		dateterminal.add(new JLabel("jj/mm/yyyy hh:mm"));
		dateterminal.setBorder(BorderFactory.createEmptyBorder(0,-4,0,0));
		datedebut.setLayout(new FlowLayout(FlowLayout.LEFT));
		datedebut.add(dateheuredebut);
		datedebut.add(new JLabel("jj/mm/yyyy hh:mm"));

		addComponent(decriptplanning,datedebut,1,3, 1, 1,GridBagConstraints.WEST,GridBagConstraints.VERTICAL);
		dateheureterminal.setPreferredSize(new Dimension(150,25));
		addComponent(decriptplanning,dateterminal,3,3, 1, 1,GridBagConstraints.WEST,GridBagConstraints.VERTICAL);


		jpanel1.add(decriptplanning,BorderLayout.NORTH);
		JPanel horaire = new JPanel();
		horaire.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
		tableHoraires.setPreferredScrollableViewportSize(new Dimension(770,150));
		tableHoraires.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(tableHoraires);
		scrollPane.setPreferredSize(new Dimension(790,150));
		horaire.add(scrollPane);
		jpanel1.add(horaire,BorderLayout.CENTER);
		return jpanel1;
	}
	public JPanel jpanelLigneTransport(){
		JPanel jpanel1 = new JPanel();
		jpanel1.setLayout(new BorderLayout());
		jpanel1.setBorder(BorderFactory.createEtchedBorder());
		JPanel description = new JPanel();
		description.setLayout(new GridBagLayout());
		JButton transports = new JButton("Transports");
		addComponent(description,new JLabel("Ligne les transports"),1, 0, 1, 1,GridBagConstraints.WEST,GridBagConstraints.VERTICAL);
		addComponent(description,transports,1, 0, 1, 1,GridBagConstraints.EAST,GridBagConstraints.VERTICAL);
		jpanel1.add(description,BorderLayout.NORTH);

		JPanel lignetransport = new JPanel();
		lignetransport.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
		tableligneTransport.setPreferredScrollableViewportSize(new Dimension(780,250));
		tableligneTransport.setFillsViewportHeight(true);
		tableligneTransport.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableligneTransport.getColumnModel().getColumn(0).setPreferredWidth(80);
		tableligneTransport.getColumnModel().getColumn(1).setPreferredWidth(230);
		tableligneTransport.getColumnModel().getColumn(2).setPreferredWidth(250);
		tableligneTransport.getColumnModel().getColumn(3).setPreferredWidth(250);
		JScrollPane scrollPane = new JScrollPane(tableligneTransport);
		scrollPane.setPreferredSize(new Dimension(790,250));
		lignetransport.add(scrollPane);
		jpanel1.add(lignetransport,BorderLayout.CENTER);
		jpanel1.setPreferredSize(new Dimension(795,240));
		return jpanel1;
	}
	public JPanel jpanelaccidentdoucument(){
		JPanel jpanel1 = new JPanel();
		jpanel1.setLayout(new BorderLayout());
		jpanel1.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		jpanel1.setPreferredSize(new Dimension(795,130));
		JPanel accident = new JPanel();
		JPanel jpaneltypeaccident = new JPanel();
		jpaneltypeaccident.setLayout(new FlowLayout(FlowLayout.LEFT)); 
		jpaneltypeaccident.add(new JLabel("Type Accidents:"));
		typeaccident.setPreferredSize(new Dimension(200,25));
		jpaneltypeaccident.add(typeaccident);
		accident.setLayout(new GridBagLayout());
		decriptionaccident.setPreferredSize(new Dimension(400,78));
		decriptionaccident.setVisible(true);  
		decriptionaccident.setBorder(BorderFactory.createLineBorder(Color.gray));  
		decriptionaccident.setLineWrap(true); // at the end of line goes to new line  
		JScrollPane scrollPane = new JScrollPane(decriptionaccident);
		scrollPane.setPreferredSize(new Dimension(400,78));
		listdocument.setPreferredSize(50,78) ;
		listdocument.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
		addComponent( accident ,jpaneltypeaccident, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH);
		addComponent( accident,new JLabel("Document Réçus"),1,0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL);
		addComponent( accident,scrollPane, 0,1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH);
		addComponent( accident ,listdocument, 1, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.BOTH);
		jpanel1.add(accident,BorderLayout.NORTH);
		return  jpanel1;
	}
	public JPanel jpanelbuttonCreerPlanning(){
		JPanel jpanel1 = new JPanel();
		jpanel1.setLayout(new BorderLayout());
		JPanel buttonjpanel = new JPanel();
		buttonjpanel .setBorder(BorderFactory.createEtchedBorder());
		buttonjpanel .setLayout(new GridBagLayout());
		JButton nouvelle = new JButton("Nouvelle");
		//annuler.addActionListener(new actionEnregistrerAnnuler("annuler"));
		JButton enregistrer = new JButton("Enregistrer ");
		//enregistrer.addActionListener(new actionEnregistrerAnnuler("enregistrer"));
		addComponent(buttonjpanel,nouvelle,0,0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
		addComponent(buttonjpanel,enregistrer,1,0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.VERTICAL);
		addComponent(buttonjpanel,new JLabel(""),0,1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.VERTICAL);
		jpanel1.add(buttonjpanel,BorderLayout.CENTER);
		return jpanel1;
	}
	public JPanel jpanelbuttonModifierPlanning(){
		JPanel jpanel1 = new JPanel();
		jpanel1.setLayout(new BorderLayout());
		JPanel buttonjpanel = new JPanel();
		buttonjpanel .setBorder(BorderFactory.createEtchedBorder());
		buttonjpanel .setLayout(new GridBagLayout());
		JButton annuler = new JButton("List Planning");
		JButton nouvelle = new JButton("Nouvelle");
		//annuler.addActionListener(new actionEnregistrerAnnuler("annuler"));
		JButton enregistrer = new JButton("Enregistrer ");
		//enregistrer.addActionListener(new actionEnregistrerAnnuler("enregistrer"));

		JButton importex = new JButton("Import..");
		//annuler.addActionListener(new actionEnregistrerAnnuler("annuler"));
		JButton exportex = new JButton("Export..");
		JButton print = new JButton("Print..");
		exportex.setEnabled(false);
		importex.setEnabled(false);
		print.setEnabled(false);
		//enregistrer.addActionListener(new actionEnregistrerAnnuler("enregistrer"));
		addComponent(buttonjpanel,annuler,0,0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
		addComponent(buttonjpanel,nouvelle,1,0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
		addComponent(buttonjpanel,importex,2,0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL);
		addComponent(buttonjpanel,exportex,3,0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL);
		addComponent(buttonjpanel,print,4,0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL);
		addComponent(buttonjpanel,enregistrer,5,0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL);
		addComponent(buttonjpanel,new JLabel(""),0,1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.VERTICAL);
		//jpanel1.add(jpanelaccident,BorderLayout.NORTH);
		jpanel1.add(buttonjpanel,BorderLayout.CENTER);
		return jpanel1;
	}
	private  void addComponent(Container container, Component component, int gridx, int gridy,
			int gridwidth, int gridheight, int anchor, int fill) {
		GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, 1.0, 1.0,
				anchor, fill, insets, 0, 0);
		container.add(component, gbc);
	}
	public GestionTransport getgTransport() {
		return gTransport;
	}
	public void setgTransport(GestionTransport gTransport) {
		this.gTransport = gTransport;
	}

	class ActionEnregistrerNouvelle implements ActionListener{
		private String nom;
		public  ActionEnregistrerNouvelle(String nomAction){
			nom=nomAction;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(nom.equals("enregistrer")){
				
			}

		}

	}

}
