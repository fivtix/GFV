package ihmTransport.Trajet;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import erreur.TransportException;

import modelTransport.Item;
import modelTransport.Trajet;

import ihmTransport.ihmTransports;
import ihmTransport.Actions.trajet.lieuxActions;
import ihmTransport.List.List;
import ihmTransport.controlleur.Observable;
import ihmTransport.controlleur.Observer;

public class listTrajetJPanel extends JPanel implements Observer{
	private ihmTransports ihmtransport;
	private JPanel listtrajets,editeurTranjet;
	private List list;
	private JPopupMenu popupMenu;
	public listTrajetJPanel(ihmTransports ihmtransport) throws TransportException{
		this.ihmtransport = ihmtransport;
		setLayout(new BorderLayout());
		listtrajets = new JPanel();	
		editeurTranjet = new JPanel();
		popupMenu = new JPopupMenu("Trajet de transport");
		listTrajetJPanel();
		add(listtrajets,BorderLayout.WEST);
		add(editeurTranjet,BorderLayout.CENTER);
	}
	public void init() throws TransportException{
		removeAll();
		add(listtrajets,BorderLayout.WEST);
		revalidate();
	}
	public void updateListTrajet()throws TransportException{
		removeAll();
		add(listtrajets,BorderLayout.WEST);
		revalidate();
		list.getModel().removeAllElements();
		ArrayList<Trajet> trajets = (ArrayList<Trajet>) ihmtransport.getTrajetdao().toutTrajet();
		int size= trajets.size();
		for(int i=0;i<size;i++){
			list.ajouterLigne(new Item(trajets.get(i).getId(),trajets.get(i).getNom()));
		}
	}
	public void listTrajetJPanel() throws TransportException{
		list =new List();
		listtrajets.setBorder(BorderFactory.createEtchedBorder());
		list.setPreferredSize(180,500);
		ArrayList<Trajet> trajets = (ArrayList<Trajet>) ihmtransport.getTrajetdao().toutTrajet();
		int size= trajets.size();
		for(int i=0;i<size;i++){
			list.ajouterLigne(new Item(trajets.get(i).getId(),trajets.get(i).getNom()));
		}
		JMenuItem trajetMenuItem = new JMenuItem("Trajet...");
		trajetMenuItem.addActionListener(new actionTrajet("trajet..."));
		popupMenu.add(trajetMenuItem);
		popupMenu.addSeparator();
		JMenuItem supprimer = new JMenuItem("Supprimer");
		supprimer.addActionListener(new actionTrajet("supprimer"));
		popupMenu.add(supprimer);
		list.getJlist().setComponentPopupMenu(popupMenu);
		listtrajets.add(list);		
	}
	class actionTrajet implements ActionListener{
		private String nom;
		public actionTrajet(String nomAction){
			nom = nomAction;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int index = list.getJlist().getSelectedIndex();
			if(nom.equals("trajet...")){
				if(index>=0){
					removeAll();
					editeurTranjet.removeAll();
					add(editeurTranjet,BorderLayout.CENTER);
					Item item=(Item) list.getModel().elementAt(index);
					try {
						ihmtransport.getCreertrajet().setTrajet(ihmtransport.getTrajetdao().chercher(item.getId()));
					} catch (TransportException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					editeurTranjet.add(ihmtransport.getCreertrajet());
					editeurTranjet.validate();
					editeurTranjet.revalidate();
				}
			}else if(nom.equals("supprimer")){
				if(index>=0){
					Item item=(Item) list.getModel().elementAt(index);
					try {
						ihmtransport.getTrajetdao().supprimer(item.getId());
					} catch (TransportException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					list.getModel().remove(index);
				}
				
			}
		}
	}
	@Override
	public void Update(Observable subject) {
		// TODO Auto-generated method stub
		if (subject == ihmtransport){
			if(ihmtransport.getCreertrajet()==ihmtransport.getJpanelCentre()){
				try {
					ihmtransport.getListtrajetJPanel().init();
				} catch (TransportException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
