package ihmTransport;

import ihmTransport.Trajet.creerTrajet;
import ihmTransport.Trajet.listTrajetJPanel;
import ihmTransport.controlleur.Observable;
import ihmTransport.controlleur.Observer;
import ihmTransport.document.Documents;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modelTransport.User;
import transportDAO.JdbcTools;
import transportDAO.adresseDAO;
import transportDAO.entrepriseDAO;
import transportDAO.itineraireDAO;
import transportDAO.lieuxDAO;
import transportDAO.objetDAO;
import transportDAO.parcoursDAO;
import transportDAO.trajetDAO;
import transportDAO.transportDAO;
import erreur.TransportException;

public class ihmTransports extends JPanel implements Observable{
	private Vector<Observer> observersList;
	private JPanel jpanelCentre;
	private int width=800,hight=500;
	private User use ;
	private ToolbarMenu  toolbarmenu;
	private  creerTrajet creertrajet;
	private adresseDAO adrdao;
	private lieuxDAO lieuxdao;
	private JdbcTools jdbctool;
	private parcoursDAO parcourdao;
	private trajetDAO trajetdao;
	private String url = "jdbc:mysql://127.0.0.1/n20404039";
	private String utilisateur = "n20404039";
	private String motdepass = "CQcc.W";
	private String pilote = "com.mysql.jdbc.Driver";
	private listTrajetJPanel listtrajetJPanel;
	private creerTransportJPanel transportJPanel;
	private entrepriseDAO entDAO;
	private objetDAO dao;
	private transportDAO transportsDAO;
	private String actions;
	private listTransportJPanel listtransports;
	private Documents documents;
	private JpanePlanning jpanelplanning;
	public ihmTransports(){
		observersList = new Vector<Observer>();
		jpanelCentre = new JPanel(); 
		use = new User();// creer une utilisateur
		jdbctool = new  JdbcTools(pilote,url,utilisateur,motdepass);
		try {
		    jdbctool.init();
		    toolbarmenu = new ToolbarMenu(this); // creer classe toolbarmenu
			adrdao  = new adresseDAO(jdbctool);
			lieuxdao=new lieuxDAO(jdbctool,adrdao);
			parcourdao=new parcoursDAO(jdbctool,lieuxdao);
			trajetdao=new trajetDAO(jdbctool,parcourdao);
			dao = new objetDAO(jdbctool);
			entDAO = new entrepriseDAO(jdbctool,adrdao);
			transportsDAO = new transportDAO(jdbctool,entDAO,lieuxdao);
			listtransports = new listTransportJPanel(this);
			documents = new Documents(jdbctool );
			transportJPanel = new creerTransportJPanel (this);
			toolbarmenu = new ToolbarMenu(this); // creer classe toolbarmenu
			creertrajet = new creerTrajet(this); // creer classe trajet
			listtrajetJPanel = new listTrajetJPanel(this);
			jpanelplanning = new JpanePlanning() ;
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		init();
	}
	public void init(){
		setLayout(new BorderLayout());
		toolbarmenu.setBorder(BorderFactory.createRaisedBevelBorder ());
		toolbarmenu.setPreferredSize(new Dimension(180,500));
		add(jpanelCentre,BorderLayout.CENTER);
		add(toolbarmenu,BorderLayout.WEST);
		add(new JPanel(),BorderLayout.SOUTH);
	}
	public User getUtilisateur() {
		return use;
	}
	public void setUtilisateur(User utilisateur) {
		this.use = utilisateur;
		
	}
	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (int i = 0; i < observersList.size(); i++) {
			Observer observer = (Observer) observersList.elementAt(i);
			observer.Update(this,actions);
		}
	}
    public JPanel getJpanelCentre() {
		return jpanelCentre;
	}
    public void misaAjourData(String nomAction){
    	actions=nomAction;
    	notifyObservers();
    }
	public void setJpanelCentre(JPanel jpanelCentre) {
		this.jpanelCentre = jpanelCentre;
	}
	public void ajouterComponnentJPanelCentre(Component comp){
    	jpanelCentre.setLayout(new FlowLayout(FlowLayout.LEFT));
    	jpanelCentre.removeAll();
    	jpanelCentre.add(comp);
    	jpanelCentre.validate();
    	jpanelCentre.revalidate();
    	jpanelCentre.updateUI();
    }
	@Override
	public void register(Observer obs) {
		// TODO Auto-generated method stub
		observersList.add( obs); 
	}
	
	public listTrajetJPanel getListtrajetJPanel() {
		return listtrajetJPanel;
	}
	public void setListtrajetJPanel(listTrajetJPanel listtrajetJPanel) {
		this.listtrajetJPanel = listtrajetJPanel;
	}
	public lieuxDAO getLieuxdao() {
		return lieuxdao;
	}
	public void setLieuxdao(lieuxDAO lieuxdao) {
		this.lieuxdao = lieuxdao;
	}
	public trajetDAO getTrajetdao() {
		return trajetdao;
	}
	public void setTrajetdao(trajetDAO trajetdao) {
		this.trajetdao = trajetdao;
	}
	public creerTrajet getCreertrajet() {
		return creertrajet;
	}
	public void setCreertrajet(creerTrajet creertrajet) {
		this.creertrajet = creertrajet;
	}
	@Override
	public void unRegister(Observer obs) {
		// TODO Auto-generated method stub
		observersList.remove(obs);
	}
	public creerTransportJPanel getTransportJPanel() {
		return transportJPanel;
	}
	public void setTransportJPanel(creerTransportJPanel transportJPanel) {
		this.transportJPanel = transportJPanel;
	}
	public JdbcTools getJdbctool() {
		return jdbctool;
	}
	public void setJdbctool(JdbcTools jdbctool) {
		this.jdbctool = jdbctool;
	}
	public entrepriseDAO getEntDAO() {
		return entDAO;
	}
	public objetDAO getDao() {
		return dao;
	}
	public transportDAO getTransportsDAO() {
		return transportsDAO;
	}
	public listTransportJPanel getListtransports() {
		return listtransports;
	}
	public Documents getDocuments() {
		return documents;
	}
	public JpanePlanning getJpanelplanning() {
		return jpanelplanning;
	}
	
		

}
