package ihmTransport.Trajet;

import ihmTransport.ihmTransports;
import ihmTransport.Actions.trajet.lieuxActions;
import ihmTransport.Lieux.lieuxJpanel;
import ihmTransport.List.List;
import ihmTransport.controlleur.Observable;
import ihmTransport.controlleur.Observer;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import modelTransport.Adresse;
import modelTransport.Item;
import modelTransport.Lieux;
import modelTransport.Parcours;
import modelTransport.Trajet;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import erreur.TransportException;

public class creerTrajet extends JPanel  {
	private Trajet trajet;
	private List list,listItineraire;
	Insets insets = new Insets(2, 2, 2, 2);
	private JPanel trajetJPanel,parcoursJPanel,itineraireJPanel,ButtonJpane;
	private  imagePanel carteJPanel ;
	private JPopupMenu popupMenu;
	private ihmTransports ihmtransports;
	private JComboBox ListlieuxComboBox ;
	private JTextField nomtext;
	private JTextField textDistance;
	private JButton annuler;
	public creerTrajet(ihmTransports ihmtransports) throws TransportException{
		setLayout(new BorderLayout());
		trajet=new Trajet();
		trajetJPanel = new JPanel();
		parcoursJPanel = new JPanel();
		itineraireJPanel = new JPanel();
		list= new List();
		listItineraire = new List();
		carteJPanel =new imagePanel();
		ButtonJpane = new JPanel();
		this.ihmtransports=ihmtransports;
		popupMenu = new JPopupMenu("Trajet de transport");
		trajetJPanel();
		parcoursJPanel();
		JpanelCarte();
		button();
		add(trajetJPanel,BorderLayout.NORTH);
		add(parcoursJPanel,BorderLayout.WEST);
		add(carteJPanel,BorderLayout.CENTER);
		add(ButtonJpane,BorderLayout.SOUTH);
		setBorder(BorderFactory.createEtchedBorder());
	}
	public void init(){
		list.getModel().removeAllElements();
		annuler.setText("Annuler");
		nomtext.setText("");
		textDistance.setText("0.0");
		carteJPanel.setImage(null);
		carteJPanel.repaint();
		trajet = new Trajet();
		listItineraire.getModel().removeAllElements();
		itineraireJPanel.removeAll();
		itineraireJPanel.revalidate();
	}
	public void button(){
		ButtonJpane.setLayout(new GridBagLayout());
		ButtonJpane.setBorder(BorderFactory.createEtchedBorder());
		annuler = new JButton("Annuler");
		JButton enregistrer = new JButton("Enregistrer");
		enregistrer.addActionListener(new actionEregistrerAnnullerTrajet("enregistrer"));
		annuler.addActionListener(new actionEregistrerAnnullerTrajet("annuler"));
		addComponent(ButtonJpane,annuler, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
		addComponent(ButtonJpane,enregistrer, 1, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.VERTICAL);
	}
	public void initDataLieux() throws TransportException{
		ArrayList<Lieux> listlieuxDAO=(ArrayList<Lieux>) ihmtransports.getLieuxdao().toutLieux();
		ListlieuxComboBox.removeAllItems();
		for(int i=0;i<listlieuxDAO.size();i++){
			ListlieuxComboBox.addItem( new Item(listlieuxDAO.get(i).getId(), listlieuxDAO.get(i).getNom() ) );
		}
	}
	public void trajetJPanel() throws TransportException{

		trajetJPanel.setLayout(new GridBagLayout());
		trajetJPanel.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
		JLabel nomJLabel = new JLabel("Nom de Trajet* :");
		addComponent(trajetJPanel,nomJLabel, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
		nomtext = new JTextField(25);
		nomtext.setPreferredSize(new Dimension(250,30));
		addComponent(trajetJPanel, nomtext, 1, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.BOTH);
		ListlieuxComboBox = new JComboBox();
		ArrayList<Lieux> listlieuxDAO=(ArrayList<Lieux>) ihmtransports.getLieuxdao().toutLieux();
		for(int i=0;i<listlieuxDAO.size();i++){
			ListlieuxComboBox.addItem( new Item(listlieuxDAO.get(i).getId(), listlieuxDAO.get(i).getNom() ) );
		}
		ListlieuxComboBox.addActionListener(new actionCombox());
		addComponent(trajetJPanel,ListlieuxComboBox, 0, 1,2, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH);
		JButton lieux = new JButton("Lieux..");
		lieux.addActionListener(new lieuxActions(this,null,"lieux"));
		addComponent(trajetJPanel,lieux, 2,1,1,1,GridBagConstraints.EAST, GridBagConstraints.BOTH);
		addComponent(trajetJPanel,new JLabel("    "),3,1,1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH);
		addComponent(trajetJPanel,new JLabel("Distance* :"),4,1,2, 1, GridBagConstraints.EAST, GridBagConstraints.BOTH);
		textDistance = new JTextField(10);
		textDistance.setPreferredSize(new Dimension(100,30));
		addComponent(trajetJPanel, textDistance,6,1,1, 1, GridBagConstraints.EAST, GridBagConstraints.BOTH);
		addComponent(trajetJPanel, new JLabel(" KM "),7,1,1, 1, GridBagConstraints.EAST, GridBagConstraints.BOTH);
	}
	public void parcoursJPanel(){
		parcoursJPanel.setLayout(new BorderLayout());
		parcoursJPanel.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
		parcoursJPanel.setPreferredSize(new Dimension(200,500));
		parcoursJPanel.add(list,BorderLayout.NORTH);
		popupMenu.removeAll();
		JMenuItem lieuxMenuItem = new JMenuItem("Lieux...");
		lieuxMenuItem.addActionListener(new lieuxActions(this,list,"lieux..."));
		popupMenu.add(lieuxMenuItem);
		popupMenu.addSeparator();
		JMenuItem supprimer = new JMenuItem("Supprimer");
		supprimer.addActionListener(new lieuxActions(this,list,"supprimer"));
		popupMenu.add(supprimer);
		list.getJlist().setComponentPopupMenu(popupMenu);
		JPanel itineraireJPanelLocal = new JPanel();
		itineraireJPanelLocal.setLayout(new BorderLayout());
		JButton itineraireButton = new JButton("Itineraire");
		itineraireButton.addActionListener(new actionItineraire());
		itineraireJPanelLocal.add(itineraireButton,BorderLayout.NORTH);
		itineraireJPanelLocal.add(itineraireJPanel,BorderLayout.CENTER);
		parcoursJPanel.add(itineraireJPanelLocal,BorderLayout.CENTER);
	}
	public int  trajet(){
		int id=0;
		trajet.setNom(nomtext.getText());
		trajet.setDistance(Double.parseDouble(textDistance.getText()));
		trajet.setCarte(carteJPanel.getImage());
		ArrayList<Parcours> parcours = new ArrayList<Parcours>();
		int size = list.getModel().size();
		for(int i=0;i<size-1;i++){
			Item item1=(Item) list.getModel().getElementAt(i);
			Item item2=(Item) list.getModel().getElementAt(i+1);
			try {
				parcours.add(new Parcours(chercherLieux(item1.getId()),chercherLieux(item2.getId())));
			} catch (TransportException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		trajet.setParcours(parcours);
		try {
			if(trajet.getId()==0)
				id =ihmtransports.getTrajetdao().sauvegarde(trajet)	;
			else
				ihmtransports.getTrajetdao().miseAjour(trajet);
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	public void JpanelCarte(){
		carteJPanel.setBorder(BorderFactory.createEtchedBorder());
		carteJPanel.setPreferredSize(new Dimension(600,400));
	}
	public void CreerTrajet(){
		ihmtransports.ajouterComponnentJPanelCentre(this);
	}
	public Trajet getTrajet() {
		return trajet;
	}
	public void setTrajet(Trajet trajet) {
		textDistance.setText(trajet.getDistance()+"") ;
		nomtext.setText(trajet.getNom());nomtext.setText(trajet.getNom());
		ArrayList<Parcours> parcours=trajet.getParcours();
		list.getModel().removeAllElements();
		for(int i=0;i< parcours.size();i++){
			list.ajouterLigne(new Item( parcours.get(i).getDepart().getId(), parcours.get(i).getDepart().getNom()));
			list.ajouterLigne(new Item( parcours.get(i).getArrive().getId(), parcours.get(i).getArrive().getNom()));
		}
		carteJPanel.setImage(trajet.getCarte());
		carteJPanel.repaint();
		if(trajet.getId()>0)
			annuler.setText("list trajets");
		itineraireJPanel.removeAll();
		this.trajet = trajet;
	}
	public void creerLieux(){
		lieuxJpanel lieuxjpanel= new lieuxJpanel(this);
		lieuxjpanel.setLieux(new Lieux());
		lieuxjpanel.init();
		ihmtransports.ajouterComponnentJPanelCentre(lieuxjpanel);
	}
	public void creerLieux(Lieux lieux){
		lieuxJpanel lieuxjpanel= new lieuxJpanel(this);
		lieuxjpanel.setLieux(lieux);
		lieuxjpanel.init();
		ihmtransports.ajouterComponnentJPanelCentre(lieuxjpanel);
	}
	public Lieux chercherLieux(int id) throws TransportException{
		return ihmtransports.getLieuxdao().chercher(id);
	}
	private  void addComponent(Container container, Component component, int gridx, int gridy,
			int gridwidth, int gridheight, int anchor, int fill) {
		GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, 1.0, 1.0,
				anchor, fill, insets, 0, 0);
		container.add(component, gbc);
	}
	public void setLieux(Lieux lieux) throws TransportException {
		if(lieux.getId()>0)
			ihmtransports.getLieuxdao().miseAjour(lieux);
		else {
			lieux.setId(ihmtransports.getLieuxdao().sauvegarde(lieux));
			Item item =new Item(lieux.getId(),lieux.getNom());
			ListlieuxComboBox.addItem(item);
			ListlieuxComboBox.setSelectedItem(item);
		}

	}
	class actionEregistrerAnnullerTrajet implements ActionListener{
		private String nom;
		public actionEregistrerAnnullerTrajet(String nom){
			this.nom= nom;
		}
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(nom.equals("enregistrer")){
				int id =trajet();
				if (id>0){
					init();
				}else{
					try {
						ihmtransports.getListtrajetJPanel().updateListTrajet();
					} catch (TransportException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}else{
				if(nom.equals("annuler")){
					if(trajet.getId()>0){
						try {
							init();
							ihmtransports.getListtrajetJPanel().init();
						} catch (TransportException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else{
						init();
					}

				}
			}
		}

	}
	class actionItineraire implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			int size= list.getModel().size();
			if(size>1){
				itineraireJPanel.removeAll();
				itineraireJPanel.validate();
				itineraireJPanel.revalidate();
				listItineraire.setPreferredSize(250,300);
				itineraireJPanel.add(listItineraire);
				listItineraire.getModel().removeAllElements();
				try {
					GoogleMap map = new GoogleMap();
					ArrayList<Adresse> adresses = new ArrayList<Adresse>();
					listItineraire.getModel().removeAllElements();
					Item item2 = (Item) list.getJlist().getModel().getElementAt(size-1);
					for(int i=0;i<size;i++){
						Item item = (Item) list.getJlist().getModel().getElementAt(i);
						adresses.add(chercherLieux(item.getId()).getAdr());
					}
					carteJPanel.setImage( map.GoogleMap(adresses));
					textDistance.setText(""+(map.getTotalkm()/1000));
				} catch (TransportException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				carteJPanel.repaint();
			}else {
				itineraireJPanel.removeAll();
				carteJPanel.setImage(null);
				carteJPanel.repaint();
			}
		}
	}
	class actionCombox implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JComboBox cb = (JComboBox)e.getSource();
			Item item =(Item)cb.getSelectedItem();
			list.ajouterLigne(item);
			list.getJlist().setSelectedValue(item,false);
			int size =list.getJlist().getModel().getSize();
			for(int i=0;i<size-1;i++){
				if(list.getJlist().getModel().getElementAt(i)==null){
					list.removeElement(i);
					size =list.getJlist().getModel().getSize();
				}else{
					if(list.getJlist().getModel().getElementAt(i).equals(item)){
						list.removeElement(size-1);
						size =list.getJlist().getModel().getSize();
						break;
					}
				}

			}
		}
	}

	class GoogleMap {
		private Adresse sADR,dADR;
		private URL url;
		private ArrayList<Float> lats ,lngs;
		private Double totalkm;
		public  GoogleMap(Adresse sADR,Adresse dADR){
			this.sADR=sADR;
			this.dADR=dADR;
			url=null;
			lats = new ArrayList<Float>(); 
			lngs = new ArrayList<Float>();
			totalkm=0.0;
		}
		public  GoogleMap(URL url){
			this.url=url;
			lats = new ArrayList<Float>(); 
			lngs = new ArrayList<Float>();
			totalkm=0.0;
		}
		public  GoogleMap(){
			lats = new ArrayList<Float>(); 
			lngs = new ArrayList<Float>();
			totalkm=0.0;
		}

		public String urlADR(Adresse adr){
			String rue =adr.getNom_rue().trim();
			rue=rue.replaceAll(" ","%20");
			String ville = adr.getVille().trim();
			ville =ville.replaceAll(" ","%20");
			String pays = adr.getPays().trim();
			pays=pays.replaceAll(" ","%20");
			String codepostal =adr.getCode_postal().trim();
			codepostal = codepostal.replaceAll(" ","%20");
			String adresseurl=adr.getNumero_rue()+",+"+rue+",+"+codepostal+",+"+ville+",+"+pays;
			return  adresseurl;
		}
		public URL getUrl() {
			return url;
		}
		public void setUrl(URL url) {
			this.url = url;
		}
		public InputStream connect(){
			String origin =urlADR(sADR);
			String destination=urlADR(dADR);

			java.io.InputStream is=null;
			try {
				if(url==null)
					url=new URL("http://maps.googleapis.com/maps/api/directions/xml?origin="+origin+"&destination="+destination+"&sensor=false");
				// instantiate the HttpURLConnection with the URL object - A new connection is opened every time by calling the openConnection method of the protocol handler for this URL.
				// 1. This is the point where the connection is opened.
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				// set connection output to true
				connection.setDoOutput(true);
				connection.setDoInput(true);  
				connection.setUseCaches(false);  
				// instead of a GET, we're going to send using method="POST"
				// instantiate OutputStreamWriter using the output stream, returned from getOutputStream, that writes to this connection.
				// 2. This is the point where you'll know if the connection was successfully established. If an I/O error occurs while creating the output stream, you'll see an IOException.
				// if there is a response code AND that response code is 200 OK, do stuff in the first if block
				if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
					is=connection.getInputStream();
					// otherwise, if any other status code is returned, or no status code is returned, do stuff in the else block
				} else {
					System.out.println("Not file");
					// Server returned HTTP error code.
				}
			} catch (MalformedURLException e) {
				// ...
			} catch (IOException e) {
				// ...
			}
			return is;
		}
		public Adresse getsADR() {
			return sADR;
		}
		public void setsADR(Adresse sADR) {
			this.sADR = sADR;
		}
		public Adresse getdADR() {
			return dADR;
		}
		public void setdADR(Adresse dADR) {
			this.dADR = dADR;
		}
		public BufferedImage imageGoogleMap(String url){
			//"http://maps.googleapis.com/maps/api/staticmap?center="+mapgoogle.urlADR(sadr)+"&zoom=13&size=600x600&maptype=roadmap&markers=color:blue|label:S|"+lats.get(0)+","+lngs.get(0)+"&markers=color:green|label:d|"+lats.get(lats.size()-1)+","+lngs.get(lngs.size()-1)+"&format=map.pnp&sensor=false");
			URL urllocal;
			BufferedImage image=null;
			try {
				urllocal = new URL(url);
				image = ImageIO.read(urllocal);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return image;
		}
		public BufferedImage GoogleMap(ArrayList<Adresse> adresses){
			ArrayList<InputStream> rd= new ArrayList<InputStream>();
			for(int i=0;i<adresses.size()-1;i++){
				setsADR(adresses.get(i));
				setdADR(adresses.get(i+1));
				rd.add(connect());
			}
			org.w3c.dom.Document document = null;
			DocumentBuilderFactory factory = null;
			BufferedImage image =null;
			for(int k=0;k<rd.size();k++)
				try {
					factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder = factory.newDocumentBuilder();
					document =  builder.parse(rd.get(k));
					NodeList Routenodes = document.getElementsByTagName("route");
					for (int i = 0; i <  Routenodes.getLength(); i++) {
						Node routenode= Routenodes.item(i);
						if (routenode.getNodeType() == Node.ELEMENT_NODE) {
							Element elementRoute = (Element) routenode;
							NodeList nodeListshtml_instructions =elementRoute.getElementsByTagName("html_instructions");
							for(int in =0;in<nodeListshtml_instructions.getLength();in++){
								listItineraire.ajouterLigne(new Item(0,nodeListshtml_instructions.item(in).getTextContent()));
							}

							NodeList nodeListsdistance =elementRoute.getElementsByTagName("distance");
							for(int d=0;d<nodeListsdistance.getLength();d++ ){
								Node nodedistance=  nodeListsdistance.item(d);
								if(nodedistance.getNodeType()==Node.ELEMENT_NODE){
									Element elementdistance = (Element)nodedistance;
									NodeList nodevalue =elementdistance.getElementsByTagName("value");
									totalkm+=Double.parseDouble(nodevalue.item(0).getTextContent().trim());
								}
							}

							NodeList boundsnodeLists =elementRoute.getElementsByTagName("bounds");
							for(int j=0;j<  boundsnodeLists.getLength();j++){
								Node bounds=  boundsnodeLists.item(j);
								if( bounds.getNodeType()==Node.ELEMENT_NODE){
									Element elementbounds = (Element)  bounds;
									NodeList nodeListsouthwest =elementbounds.getElementsByTagName("southwest");
									Node nodesouthwest =nodeListsouthwest.item(0);
									if(nodesouthwest.getNodeType()==Node.ELEMENT_NODE){
										Element elementsouthwest = (Element)nodesouthwest;
										NodeList nodeLislat = elementsouthwest.getElementsByTagName("lat");
										NodeList nodeLislng = elementsouthwest.getElementsByTagName("lng");
										lats.add(Float.parseFloat(nodeLislat.item(0).getTextContent()));
										lngs.add(Float.parseFloat(nodeLislng.item(0).getTextContent()));
									}
									NodeList nodeListnortheast =elementbounds.getElementsByTagName("northeast");
									Node nodenortheast =nodeListnortheast.item(0);
									if(nodenortheast.getNodeType()==Node.ELEMENT_NODE){
										Element elementnortheast = (Element)nodenortheast;
										NodeList nodeLislat = elementnortheast.getElementsByTagName("lat");
										NodeList nodeLislng = elementnortheast.getElementsByTagName("lng");
										lats.add(Float.parseFloat(nodeLislat.item(0).getTextContent()));
										lngs.add(Float.parseFloat(nodeLislng.item(0).getTextContent()));
									}

								}
							}
						}
					}

					//ImageIO.write(image,"jpg",new File("m.jpg"));

				} catch (IOException | ParserConfigurationException | SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			String marque="";
			for(int i=1;i<lngs.size()-1;i++){
				marque="&markers=color:green|label:d|"+lats.get(i)+","+lngs.get(i);
			}
			if(lats.size()>1){
				String url ="http://maps.googleapis.com/maps/api/staticmap?center="+urlADR(adresses.get(0))+"&zoom=13&size=600x600&maptype=roadmap&markers=color:blue|label:S|"+lats.get(0)+","+lngs.get(0)+marque+"&markers=color:green|label:d|"+lats.get(lats.size()-1)+","+lngs.get(lngs.size()-1)+"&format=map.pnp&sensor=false";
				image  = imageGoogleMap(url);
			}
			return image;
		}
		public Double getTotalkm() {
			return totalkm;
		}
		public void setTotalkm(Double totalkm) {
			this.totalkm = totalkm;
		}

	}

	class imagePanel extends JPanel
	{	
		BufferedImage image;
		public imagePanel(){

		}
		public imagePanel(BufferedImage image){
			this.image=image;

		}

		public BufferedImage getImage() {
			return image;
		}

		public void setImage(BufferedImage image) {
			this.image = image;
		}

		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			if(image != null)
			{
				g.drawImage(image, 0, 0, this);
			}
		}
	}

}
