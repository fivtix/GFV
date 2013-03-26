package ihmTransport;

import ihmTransport.Entreprise.EntrepriseJPanel;
import ihmTransport.Lieux.lieuxJPanel1;
import ihmTransport.List.List;
import ihmTransport.Trajet.creerTrajet;
import ihmTransport.controlleur.Observable;
import ihmTransport.controlleur.Observer;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
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

public class creerTransportJPanel extends JPanel {
	private ihmTransports ihmtransports;
	private Insets insets = new Insets(10, 2, 2, 10);	
	private JComboBox entrepriseBox ,departBox,arriveBox,typevehiculeBox,marchandiseBox,naturemarchandiseBox;
	private JTextField  dateDeparte,dateArrivee,cout;
	private objetDAO dao;
	private JLabel decriptionent,decriptiondepart,decriptionarrive;
	private JPanel JPanelPrincipal;
	private JButton enregistrerControleButton;
	private Transport transport;
	private lieuxJPanel1 lieuxJPanel;
	private EntrepriseJPanel entjpanel;
	private HashMap<Integer,Adresse> adresses; 
	private JButton nouvelle;
	public creerTransportJPanel(ihmTransports ihmtransports) {
		setLayout(new BorderLayout());
		transport = new Transport();
		lieuxJPanel=new lieuxJPanel1();
		entjpanel = new EntrepriseJPanel();
		adresses = new  HashMap<Integer,Adresse>();
		enregistrerControleButton = new JButton("Enregistrer:");
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
		typevehiculeBox= new JComboBox();
		marchandiseBox= new JComboBox();	
		naturemarchandiseBox= new JComboBox();
		dateDeparte= new JTextField();
		dateArrivee = new JTextField();
		nouvelle = new JButton("Nouvelle:");
		cout=new JTextField();
		cout.setText("0");
		// TODO Auto-generated constructor stub
		setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
		JPanelPrincipal.add(transportJPanel(),BorderLayout.NORTH);
		JPanelPrincipal.add(jpanelbutton(),BorderLayout.CENTER);
		add(JPanelPrincipal,BorderLayout.NORTH);
		entjpanel.ajouterControlButton(ButtonControlLieux());
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
		transport=new Transport();
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
	public void initDataEntreprise(){
		entrepriseBox.removeAllItems();
		entrepriseBox.addItem(new Item(0,""));
		try {
			ArrayList<Entreprise> entreprises = (ArrayList<Entreprise>) ihmtransports.getEntDAO().toutEntreprise();
			int size=entreprises.size();
			for(int i=0;i<size;i++){
				Entreprise ent=entreprises.get(i);
				entrepriseBox.addItem(new Item(ent.getId(),ent.getNom()));
				adresses.put(new Integer(ent.getId()),ent.getAdresse());
				if(!adresses.containsKey(ent.getId()));
				adresses.put(new Integer(ent.getId()),ent.getAdresse());
			}

		} catch (TransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void initDataLieux(){
		departBox.removeAllItems();
		departBox.addItem(new Item(0,""));
		arriveBox.removeAllItems();
		arriveBox.addItem(new Item(0,""));
		try {
			ArrayList<Lieux> lieuxs = (ArrayList<Lieux>) ihmtransports.getLieuxdao().toutLieux();
			int size =lieuxs.size();
			for(int i=0;i<size;i++){
				Lieux lieux = lieuxs.get(i);
				departBox.addItem(new Item(lieux.getId(),lieux.getNom()));
				arriveBox.addItem(new Item(lieux.getId(),lieux.getNom()));
				if(!adresses.containsKey(lieux.getId()));
				adresses.put(new Integer(lieux.getId()),lieux.getAdr());
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
		return transport;
	}
	public void setTransport(Transport transport) {
		this.transport = transport;
		int size =entrepriseBox.getItemCount();
		
		for(int i=0;i<size;i++){
			Item item =(Item) entrepriseBox.getItemAt(i);
			if(item.getId()==transport.getEnt().getId()){
				entrepriseBox.setSelectedIndex(i);
				break;
			}
		}
		size =departBox.getItemCount();
		for(int i=0;i<size;i++){
			Item item =(Item) departBox.getItemAt(i);
			if(item.getId()==transport.getDepart().getId()){
				departBox.setSelectedIndex(i);
				break;
			}
		}
		size =arriveBox.getItemCount();
		for(int i=0;i<size;i++){
			Item item =(Item) arriveBox.getItemAt(i);
			if(item.getId()==transport.getArrivee().getId()){
				arriveBox.setSelectedIndex(i);
				break;
			}
		}
		dateDeparte.setText(transport.getDateDepart());
		dateArrivee.setText(transport.getDateArrivee());
		cout.setText(transport.getEstimationCout()+"");
		typevehiculeBox.setSelectedItem(transport.getTypeVehicule());
		marchandiseBox.setSelectedItem(transport.getMarch());
		naturemarchandiseBox.setSelectedItem(transport.getNat_March());
		if( transport.getId()>0){
			nouvelle.setText("List Transport");
			nouvelle.setActionCommand("modifier");
		}else{
			nouvelle.setText("Nouvelle");
		}
	}
	public JPanel transportJPanel(){
		JPanel transportjpanel = new JPanel();
		transportjpanel.setBorder(BorderFactory.createEtchedBorder());
		transportjpanel.setLayout(new GridBagLayout());
	//	transportjpanel.setPreferredSize(new Dimension(785,140));
		//transportjpanel.setMaximumSize(new Dimension(785,200));
		JPanel gril1 = new JPanel();
		gril1.setPreferredSize(new Dimension(100,120));
		gril1.setLayout(new GridLayout(6,1,5,5));
		gril1.add(new JLabel("Entreprise:"));
		gril1.add(new JLabel("Départ:"));
		gril1.add(new JLabel("Arivée:"));
		gril1.add(new JLabel("Date départ:"));
		gril1.add(new JLabel("Type Transport:"));
		gril1.add(new JLabel("Nat-March:"));
		//JLabel labelEnt = new JLabel("Entreprise:");labelEnt.setPreferredSize(new Dimension(60,25));
		addComponent(transportjpanel,gril1, 0, 0, 1, 1, GridBagConstraints.WEST,GridBagConstraints.VERTICAL);
		 JPanel jpaneldatedepart= new JPanel(); jpaneldatedepart.setLayout(new BorderLayout());jpaneldatedepart.add(dateDeparte,BorderLayout.CENTER);jpaneldatedepart.add(new JLabel("JJ/MM/YYYY"),BorderLayout.EAST);
		JPanel gril2 = new JPanel();
		gril2.setLayout(new GridLayout(6,1,10,10));
		gril2.setPreferredSize(new Dimension(200,120));
		gril2.add(entrepriseBox);
		gril2.add(departBox);
		gril2.add(arriveBox);
		gril2.add(typevehiculeBox);
		gril2.add(jpaneldatedepart);
		gril2.add(typevehiculeBox);
		gril2.add(naturemarchandiseBox);
		addComponent(transportjpanel,gril2, 1, 0, 1, 1, GridBagConstraints.WEST,GridBagConstraints.BOTH);
		JPanel gril3 = new JPanel();
		gril3.setLayout(new GridLayout(6,1,5,5));
		JButton entrepriseB= new JButton("Ent...");
		entrepriseB.addActionListener(new actionDialog("entreprise"));
		JButton departb = new JButton("Lieux...");
		departb.addActionListener(new actionDialog("lieuxdepart"));
		JButton arriveb = new JButton("Lieux...");
		arriveb.addActionListener(new actionDialog("lieuxarrive"));
		gril3.add(entrepriseB);
		gril3.add(departb);
		gril3.add(arriveb);
		gril3.add(new JLabel("Date Arrivee:"));
		gril3.add(new JLabel("Marchandise:"));
		gril3.add(new JLabel("Cout:"));
		addComponent(transportjpanel,gril3 ,2, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
		JPanel gril4 = new JPanel();
		gril4.setLayout(new GridLayout(6,1,5,5));
		gril4.setPreferredSize(new Dimension(365,200));
		decriptionent = new JLabel("");
		decriptiondepart = new JLabel("");
		decriptionarrive = new JLabel("");
		dateArrivee.setPreferredSize(new Dimension(150,20));
		JPanel jpaneldatearrive= new JPanel(); jpaneldatearrive.setLayout(new BorderLayout());jpaneldatearrive.add(dateArrivee,BorderLayout.WEST);jpaneldatearrive.add(new JLabel("JJ/MM/YYYY"),BorderLayout.CENTER);
		gril4.add(decriptionent);
		gril4.add(decriptiondepart);
		gril4.add(decriptionarrive);
		gril4.add(jpaneldatearrive);
		JPanel marbox = new JPanel();
		marbox.setLayout(new FlowLayout(FlowLayout.LEFT));
		marchandiseBox.setPreferredSize(new Dimension(200,25));
		marbox.add(marchandiseBox);
		marbox.setBorder(BorderFactory.createEmptyBorder(-1,-1,-1,-1));
		gril4.add(marbox);
		JPanel jpanelcout = new JPanel();
		cout.setPreferredSize(new Dimension(200,25));
		 jpanelcout.add(cout);
		 jpanelcout.setLayout(new FlowLayout(FlowLayout.LEFT));
		gril4.add(jpanelcout);
		addComponent(transportjpanel,gril4 , 3, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH);
		return transportjpanel;
	}
	public JPanel jpanelbutton(){
		JPanel jpaneltransport = new JPanel();
		jpaneltransport.setLayout(new BorderLayout());
		JPanel buttonjpanel = new JPanel();
		buttonjpanel .setBorder(BorderFactory.createEtchedBorder());
		buttonjpanel .setLayout(new GridBagLayout());
		nouvelle.addActionListener(new actionEnregistrerAnnuler("annuler"));
		JButton enregistrer = new JButton("Enregistrer ");
		enregistrer.addActionListener(new actionEnregistrerAnnuler("enregistrer"));
		addComponent(buttonjpanel,enregistrer,1,0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.VERTICAL);
		addComponent(buttonjpanel,nouvelle,0,0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
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
		enregistrerControleButton.addActionListener(new actionDialog("enregistrer"));
		addComponent(buttonJPanel,enregistrerControleButton, 1, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.VERTICAL);
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
					else{
						ihmtransports.getTransportsDAO().miseAjour(getTransport());
						ihmtransports.ajouterComponnentJPanelCentre(ihmtransports.getListtransports());
						nouvelle.setActionCommand("");
						nouvelle.setText("Annuler");
					}
				} catch (TransportException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(nom.equals("annuler")){
				if(nouvelle.getActionCommand().equals("modifier")){
					ihmtransports.ajouterComponnentJPanelCentre(ihmtransports.getListtransports());
					nouvelle.setActionCommand("");
					nouvelle.setText("Annuler");
				}
			}
			init();
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
				enregistrerControleButton.setActionCommand("lieuxdepart");
				lieuxJPanel.ajouterControlButton(ButtonControlLieux());
				if(transport.getId()>0)
					lieuxJPanel.setLieux(transport.getDepart());
				ajouterJPanel(lieuxJPanel);
			}else if(nom.equals("annulerlieux")){
				lieuxJPanel.init();
				ajouterJPanel(JPanelPrincipal);
			}else if(nom.equals("lieuxarrive")){
				enregistrerControleButton.setActionCommand("lieuxarrive");
				lieuxJPanel.ajouterControlButton(ButtonControlLieux());
				if(transport.getId()>0)
					lieuxJPanel.setLieux(transport.getArrivee());
				ajouterJPanel(lieuxJPanel);
			}else if(nom.equals("enregistrer")){
				
				if(enregistrerControleButton.getActionCommand().equals("lieuxarrive")){
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
					Item item =new Item(lieuxJPanel.getLieux().getId(),lieuxJPanel.getLieux().getNom());
					adresses.put(new Integer(item.getId()),lieuxJPanel.getLieux().getAdr());
					arriveBox.addItem(item);
					arriveBox.setSelectedItem(item);
					enregistrerControleButton.setActionCommand("");
					ihmtransports.misaAjourData("lieuxtransport");
					lieuxJPanel.init();
					ajouterJPanel(JPanelPrincipal);
				}else if(enregistrerControleButton.getActionCommand().equals("lieuxdepart")){
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
					Item item =new Item(lieuxJPanel.getLieux().getId(),lieuxJPanel.getLieux().getNom());
					adresses.put(new Integer(item.getId()),lieuxJPanel.getLieux().getAdr());
					departBox.addItem(item);
					departBox.setSelectedItem(item);
					enregistrerControleButton.setActionCommand("");
					ihmtransports.misaAjourData("lieuxtransport");
					lieuxJPanel.init();
					ajouterJPanel(JPanelPrincipal);
					ihmtransports.misaAjourData("lieuxtransport");
				}else if(enregistrerControleButton.getActionCommand().equals("enregistrerEnt")){
					try {
						if(transport.getId()>0)
							ihmtransports.getEntDAO().miseAjour(entjpanel.getEnt());
						else{
							int ident =ihmtransports.getEntDAO().sauvegarde(entjpanel.getEnt());
							entjpanel.getEnt().setId(ident);
							Item item =new Item(entjpanel.getEnt().getId(),entjpanel.getEnt().getNom());
							adresses.put(new Integer(item.getId()),entjpanel.getEnt().getAdresse());
							entrepriseBox.addItem(item);
							entrepriseBox.setSelectedItem(item);
							entjpanel.init();
							ajouterJPanel(JPanelPrincipal);
							ihmtransports.misaAjourData("entreprisetransport");
							enregistrerControleButton.setActionCommand("");
						}
					} catch (TransportException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
			}else if(nom.equals("entreprise")){
				enregistrerControleButton.setActionCommand("enregistrerEnt");
				if(transport.getId()>0)
					entjpanel.setEnt(transport.getEnt());
					ajouterJPanel(entjpanel);
			}
		}
	}

	
}
