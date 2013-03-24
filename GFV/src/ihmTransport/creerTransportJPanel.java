package ihmTransport;

import ihmTransport.Lieux.lieuxJPanel1;
import ihmTransport.List.List;
import ihmTransport.Trajet.creerTrajet;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import modelTransport.Adresse;
import modelTransport.Entreprise;
import modelTransport.Item;
import modelTransport.Lieux;
import modelTransport.Transport;
import erreur.TransportException;

import transportDAO.objetDAO;

public class creerTransportJPanel extends JPanel{
	private ihmTransports ihmtransports;
	private Insets insets = new Insets(10, 2, 2, 10);	
	private JComboBox entrepriseBox ,departBox,arriveBox,typevehiculeBox,marchandiseBox,naturemarchandiseBox;
	private JTextField  dateDeparte,dateArrivee,cout;
	private objetDAO dao;
	private JLabel decriptionent,decriptiondepart,decriptionarrive;
	private JPanel JPanelPrincipal;
	private JButton enregistrerlieux;
	private Transport transport;
	private lieuxJPanel1 lieuxJPanel;
	private HashMap<Integer,Adresse> adresses; 
	public creerTransportJPanel(ihmTransports ihmtransports) {
		setLayout(new BorderLayout());
		transport = new Transport();
		lieuxJPanel=new lieuxJPanel1();
		adresses = new  HashMap<Integer,Adresse>();
		enregistrerlieux = new JButton("Enregistrer:");
		JPanelPrincipal = new JPanel();
		JPanelPrincipal.setLayout(new BorderLayout());
		this.ihmtransports=ihmtransports;
		new objetDAO(ihmtransports.getJdbctool());
		entrepriseBox  = new JComboBox();
		entrepriseBox.addActionListener(new actionCombox("entreprise"));
		departBox =  new JComboBox();
		departBox.addActionListener(new actionCombox("depart"));
		arriveBox =  new JComboBox();
		arriveBox.addActionListener(new actionCombox("arrive"));
		typevehiculeBox= new JComboBox();;
		marchandiseBox= new JComboBox();;
		naturemarchandiseBox= new JComboBox();
		dateDeparte= new JTextField(10);
		dateArrivee = new JTextField(10);
		cout=new JTextField(10);
		cout.setText("0");
		// TODO Auto-generated constructor stub
		setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
		JPanelPrincipal.add(transportJPanel(),BorderLayout.NORTH);
		JPanelPrincipal.add(jpanelbutton(),BorderLayout.CENTER);
		add(JPanelPrincipal,BorderLayout.NORTH);
		initData();
	}
	public void init(){
		entrepriseBox.setSelectedIndex(0);
		departBox.setSelectedIndex(0);
		arriveBox.setSelectedIndex(0);
		typevehiculeBox.setSelectedIndex(0);
		marchandiseBox.setSelectedIndex(0);
		naturemarchandiseBox.setSelectedIndex(0);
		cout.setText("0");
		dateDeparte.setText("");
		dateArrivee.setText("");
		decriptionarrive.setText("");
		decriptionent.setText("");
		decriptiondepart.setText("");
	}
	public void ajouterJPanel(Component comp){
		removeAll();
		add(comp,BorderLayout.NORTH);
		validate();
		revalidate();
	}
	public void initData(){
		adresses.clear();
		entrepriseBox.removeAllItems();
		entrepriseBox.addItem(new Item(0,""));
		departBox.removeAllItems();
		departBox.addItem(new Item(0,""));
		arriveBox.removeAllItems();
		arriveBox.addItem(new Item(0,""));
		typevehiculeBox.removeAllItems();
		typevehiculeBox.addItem("");
		marchandiseBox.removeAllItems();
		marchandiseBox.addItem("");
		naturemarchandiseBox.removeAllItems();
		naturemarchandiseBox.addItem("");
		try {
			ArrayList<Entreprise> entreprises = (ArrayList<Entreprise>) ihmtransports.getEntDAO().toutEntreprise();
			int size=entreprises.size();
			for(int i=0;i<size;i++){
				Entreprise ent=entreprises.get(i);
				entrepriseBox.addItem(new Item(ent.getId(),ent.getNom()));
				adresses.put(new Integer(ent.getId()),ent.getAdresse());
			}
			ArrayList<Lieux> lieuxs = (ArrayList<Lieux>) ihmtransports.getLieuxdao().toutLieux();
			size =lieuxs.size();
			for(int i=0;i<size;i++){
				Lieux lieux = lieuxs.get(i);
				departBox.addItem(new Item(lieux.getId(),lieux.getNom()));
				arriveBox.addItem(new Item(lieux.getId(),lieux.getNom()));
				adresses.put(new Integer(lieux.getId()),lieux.getAdr());
			}

			ArrayList<String> typevehicules = (ArrayList<String>) ihmtransports.getDao().toutvehicule();
			ArrayList<String> marchandises = (ArrayList<String>) ihmtransports.getDao().toutMarchandise();
			ArrayList<String> natMarchandises = (ArrayList<String>) ihmtransports.getDao().toutNatureMarchandise();

			size=typevehicules.size();
			for(int i=0;i<size;i++){
				typevehiculeBox.addItem(typevehicules.get(i));
			}

			size=marchandises .size();
			for(int i=0;i<size;i++){
				marchandiseBox.addItem(typevehicules.get(i));
			}
			size= natMarchandises.size();
			for(int i=0;i<size;i++){
				naturemarchandiseBox.addItem(typevehicules.get(i));
			}

		} catch (TransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Transport getTransport() {
		Item itemEnt = (Item) entrepriseBox .getSelectedItem();
		Item itemDepart = (Item) departBox.getSelectedItem();
		Item itemArrive = (Item) arriveBox.getSelectedItem();
		try {
			transport.setEnt(ihmtransports.getEntDAO().chercher(itemEnt.getId()));
			transport.setDepart(ihmtransports.getLieuxdao().chercher(itemDepart .getId()));
			transport.setArrivee(ihmtransports.getLieuxdao().chercher(itemArrive.getId()));
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		transport.setTypeVehicule((String) typevehiculeBox.getSelectedItem());
		transport.setMarch((String) naturemarchandiseBox.getSelectedItem());
		transport.setDateDepart(dateDeparte.getText());
		transport.setDateArrivee(dateArrivee.getText());
		transport.setNat_March((String) naturemarchandiseBox.getSelectedItem());
		transport.setEstimationCout(Integer.parseInt(cout.getText()));
		System.out.println(transport.getId());
		System.out.println(transport.getDateArrivee());
		System.out.println(transport.getDateArrivee());
		System.out.println(transport.getEstimationCout());
		System.out.println(transport.getTypeVehicule());
		System.out.println(transport.getNat_March());
		
		return transport;
	}
	public void setTransport(Transport transport) {
		this.transport = transport;
		entrepriseBox .setSelectedItem(new Item(transport.getEnt().getId(),transport.getEnt().getNom()));
		departBox.setSelectedItem(new Item(transport.getDepart().getId(),transport.getDepart().getNom()));
		arriveBox.setSelectedItem(new Item(transport.getArrivee().getId(),transport.getArrivee().getNom()));
		dateDeparte.setText(transport.getDateDepart());
		dateArrivee.setText(transport.getDateArrivee());
		cout.setText(transport.getEstimationCout()+"");
		typevehiculeBox.setSelectedItem(transport.getTypeVehicule());
		marchandiseBox.setSelectedItem(transport.getMarch());
		naturemarchandiseBox.setSelectedItem(transport.getNat_March());
	}
	public JPanel transportJPanel(){
		JPanel transportjpanel = new JPanel();
		transportjpanel.setBorder(BorderFactory.createEtchedBorder());
		transportjpanel.setLayout(new GridBagLayout());
		transportjpanel.setPreferredSize(new Dimension(785,250));
		transportjpanel.setMaximumSize(new Dimension(785,250));
		addComponent(transportjpanel,new JLabel("Entreprise:"), 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH);
		addComponent(transportjpanel,entrepriseBox , 1, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH);
		JButton entrepriseB= new JButton("Ent...");
		addComponent(transportjpanel,entrepriseB, 2, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH);
		entrepriseB.addActionListener(new actionDialog("entreprise"));
		decriptionent = new JLabel("");decriptionent.setPreferredSize(new Dimension(350,20));
		decriptionent.setMaximumSize(new Dimension(200,25)); 
		addComponent(transportjpanel,decriptionent,4, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH);
		//Ligne 1
		addComponent(transportjpanel,new JLabel("Lieux Depart:"),0,1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		addComponent(transportjpanel,departBox, 1,1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH);
		JButton departb = new JButton("Lieux...");
		departb.addActionListener(new actionDialog("lieuxdepart"));
		addComponent(transportjpanel,departb,2,1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH);
		decriptiondepart = new JLabel("");
		addComponent(transportjpanel,decriptiondepart,4,1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL);
		//ligne 2
		addComponent(transportjpanel,new JLabel("Lieux Arrive:"),0,2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH);
		addComponent(transportjpanel,arriveBox,1,2, 1, 1, GridBagConstraints.EAST, GridBagConstraints.BOTH);
		JButton arriveb = new JButton("Lieux...");
		arriveb.addActionListener(new actionDialog("lieuxarrive"));
		addComponent(transportjpanel,arriveb,2,2, 1, 1, GridBagConstraints.EAST, GridBagConstraints.BOTH);
		decriptionarrive = new JLabel("");
		addComponent(transportjpanel,decriptionarrive,4,2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL);
		//ligne 3
		JPanel jpaneldatedepart= new JPanel(); jpaneldatedepart.setLayout(new FlowLayout(FlowLayout.LEFT));jpaneldatedepart.add(dateDeparte);jpaneldatedepart.add(new JLabel("JJ/MM/YYYY"));
		jpaneldatedepart.setBorder(BorderFactory.createEmptyBorder(-1,-1,-1,-1));
		addComponent(transportjpanel,new JLabel("Date departe:"),0,3, 1, 1, GridBagConstraints.EAST, GridBagConstraints.BOTH);
		addComponent(transportjpanel,jpaneldatedepart, 1,3, 1, 1, GridBagConstraints.EAST, GridBagConstraints.BOTH);
		JPanel jpaneldatearrive= new JPanel(); jpaneldatearrive.setLayout(new FlowLayout(FlowLayout.LEFT));jpaneldatearrive.add(dateArrivee);jpaneldatearrive.add(new JLabel("JJ/MM/YYYY"));
		addComponent(transportjpanel,new JLabel("Date Arrivee:"), 2,3, 1, 1, GridBagConstraints.EAST, GridBagConstraints.BOTH);
		addComponent(transportjpanel,jpaneldatearrive,4,3, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH);
		//Ling 4
		addComponent(transportjpanel,new JLabel("Transport:"),0,4, 1, 1, GridBagConstraints.EAST, GridBagConstraints.BOTH);
		addComponent(transportjpanel,typevehiculeBox,1,4, 1, 1, GridBagConstraints.EAST, GridBagConstraints.BOTH);
		//Ligne 5
		addComponent(transportjpanel,new JLabel("Transport:"),0,4, 1, 1, GridBagConstraints.EAST, GridBagConstraints.BOTH);
		addComponent(transportjpanel,typevehiculeBox,1,4, 1, 1, GridBagConstraints.EAST, GridBagConstraints.BOTH);
		// ligne 6
		addComponent(transportjpanel,new JLabel("Marchandise:"),0,5, 1, 1, GridBagConstraints.EAST, GridBagConstraints.BOTH);
		addComponent(transportjpanel,marchandiseBox,1,5, 1, 1, GridBagConstraints.EAST, GridBagConstraints.BOTH);
		//lign6
		naturemarchandiseBox.setPreferredSize(new Dimension(160,20));
		addComponent(transportjpanel,new JLabel("Nat-March:"),2,5, 1, 1, GridBagConstraints.EAST, GridBagConstraints.BOTH);
		addComponent(transportjpanel,naturemarchandiseBox,4,5, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
		//lign7
		addComponent(transportjpanel,new JLabel(""),0,6, 1, 1, GridBagConstraints.EAST, GridBagConstraints.BOTH);
		this.setEnabled(false);
		return transportjpanel;
	}
	public JPanel jpanelbutton(){
		JPanel jpaneltransport = new JPanel();
		jpaneltransport.setLayout(new BorderLayout());
		JPanel buttonjpanel = new JPanel();
		buttonjpanel .setBorder(BorderFactory.createEtchedBorder());
		buttonjpanel .setLayout(new GridBagLayout());
		JButton annuler = new JButton("Annuler:");
		annuler.addActionListener(new actionEnregistrerAnnuler("annuler"));
		JButton enregistrer = new JButton("Enregistrer ");
		enregistrer.addActionListener(new actionEnregistrerAnnuler("enregistrer"));
		addComponent(buttonjpanel,enregistrer,1,0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.VERTICAL);
		addComponent(buttonjpanel,annuler,0,0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
		addComponent(buttonjpanel,new JLabel(""),0,1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.VERTICAL);

		jpaneltransport.add(buttonjpanel,BorderLayout.NORTH);
		return jpaneltransport;
	}
	private  void addComponent(Container container, Component component, int gridx, int gridy,
			int gridwidth, int gridheight, int anchor, int fill) {
		GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, 1.0, 1.0,
				anchor, fill, insets, 0, 0);
		container.add(component, gbc);
	}
	public JPanel ButtonControlLieux(){
		JPanel buttonJPanel = new JPanel();
		buttonJPanel.setBorder(BorderFactory.createEtchedBorder());
		buttonJPanel.setLayout(new GridBagLayout());
		JButton annuler = new JButton(" Transport ");
		annuler.addActionListener(new actionDialog("annulerlieux"));
		addComponent(buttonJPanel,annuler, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
		enregistrerlieux.addActionListener(new actionDialog("enregistrerlieux"));
		addComponent(buttonJPanel,enregistrerlieux, 1, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.VERTICAL);
		return  buttonJPanel;
	}

	class actionCombox implements ActionListener{
		private String nom;
		public actionCombox(String nomAction){
			this.nom = nomAction;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JComboBox cb = (JComboBox)e.getSource();
			Item item = (Item)cb.getSelectedItem();
			if(item.getId()>0){
				if(nom.equals("entreprise")){
					Adresse adr =adresses.get(item.getId());
					decriptionent.setText("Adrese: "+adr.getNumero_rue()+" "+adr.getNom_rue()+", "+adr.getCode_postal()+", "+adr.getPays());
					//decriptionent.validate();
				}else if(nom.equals("depart")){
					Adresse adr =adresses.get(item.getId());
					decriptiondepart.setText("Adrese: "+adr.getNumero_rue()+" "+adr.getNom_rue()+", "+adr.getCode_postal()+", "+adr.getPays());
					//decriptiondepart.validate();
				}if(nom.equals("arrive")){
					Adresse adr =adresses.get(item.getId());
					decriptionarrive.setText("Adrese: "+adr.getNumero_rue()+" "+adr.getNom_rue()+", "+adr.getCode_postal()+", "+adr.getPays());
					//decriptionarrive.validate();
				}
			}

		}
	}
	// sauveger der et annuler
	class  actionEnregistrerAnnuler implements ActionListener{
		private String nom ;
		public  actionEnregistrerAnnuler(String nomAction){
			this.nom=nomAction;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(nom.equals("enregistrer")){
				try {
					if(transport.getId()<=0)
						ihmtransports.getTransportsDAO().sauvegarde(getTransport());
					else
						ihmtransports.getTransportsDAO().miseAjour(getTransport());
					    init();
				} catch (TransportException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(nom.equals("annuler")){
				    init();
			}
		}

	}

	// action de lieux 
	class  actionDialog implements ActionListener{
		private String nom ;
		public  actionDialog(String nomAction){
			this.nom=nomAction;
		}
		public void actionPerformed(ActionEvent arg0) {
			if(nom.equals("lieuxdepart")){
				enregistrerlieux.setActionCommand("lieuxdepart");
				lieuxJPanel.ajouterControlButton(ButtonControlLieux());
				if(transport.getId()>0)
					lieuxJPanel.setLieux(transport.getDepart());
				ajouterJPanel(lieuxJPanel);
			}else if(nom.equals("annulerlieux")){
				lieuxJPanel.init();
				ajouterJPanel(JPanelPrincipal);
			}else if(nom.equals("lieuxarrive")){
				enregistrerlieux.setActionCommand("lieuxarrive");
				lieuxJPanel.ajouterControlButton(ButtonControlLieux());
				if(transport.getId()>0)
					lieuxJPanel.setLieux(transport.getArrivee());
				ajouterJPanel(lieuxJPanel);
			}else if(nom.equals("enregistrerlieux")){
				try {
					if(transport.getId()>0)
						ihmtransports.getLieuxdao().miseAjour(lieuxJPanel.getLieux());
					else{
						int idlieux =ihmtransports.getLieuxdao().sauvegarde(lieuxJPanel.getLieux());
						lieuxJPanel.getLieux().setId(idlieux);
					}
				} catch (TransportException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(enregistrerlieux.getActionCommand().equals("lieuxarrive")){
					transport.setArrivee(lieuxJPanel.getLieux());
					enregistrerlieux.setActionCommand("");
				}else if(enregistrerlieux.getActionCommand().equals("lieuxdepart")){
					transport.setDepart(lieuxJPanel.getLieux());
					enregistrerlieux.setActionCommand("");
				}
				lieuxJPanel.init();
				ajouterJPanel(JPanelPrincipal);
			}
		}


	}
}
