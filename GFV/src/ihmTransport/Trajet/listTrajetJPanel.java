package ihmTransport.Trajet;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import erreur.TransportException;

import modelTransport.Item;
import modelTransport.Trajet;

import ihmTransport.ihmTransports;
import ihmTransport.Actions.trajet.lieuxActions;
import ihmTransport.List.List;
import ihmTransport.controlleur.Observable;
import ihmTransport.controlleur.Observer;
import ihmTransport.tables.tableModelTrajet;


public class listTrajetJPanel extends JPanel implements Observer{
	private ihmTransports ihmtransport;
	private tableModelTrajet tablemodelTrajet;
	private JPopupMenu popupMenu;
	private JTable tableTrajets;
	public listTrajetJPanel(ihmTransports ihmtransport) throws TransportException{
		this.ihmtransport = ihmtransport;
		setLayout(new BorderLayout());
		popupMenu = new JPopupMenu("Trajet de transport");
		tablemodelTrajet = new  tableModelTrajet();
		tableTrajets = new JTable(tablemodelTrajet);
		tableTrajets.setPreferredScrollableViewportSize(new Dimension(800,500));
		tableTrajets.setFillsViewportHeight(true);
		tableTrajets.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableTrajets.getColumnModel().getColumn(0).setPreferredWidth(80);
		tableTrajets.getColumnModel().getColumn(1).setPreferredWidth(297);
		tableTrajets.getColumnModel().getColumn(2).setPreferredWidth(300);
		tableTrajets.getColumnModel().getColumn(3).setPreferredWidth(120);
		add(listTrajetJPanel() ,BorderLayout.CENTER);
	}

	public void initData() throws TransportException{
		tablemodelTrajet.removeAllTrajets();
		ArrayList<Trajet> trajets = (ArrayList<Trajet>) ihmtransport.getTrajetdao().toutTrajet();
		int size= trajets.size();
		for(int i=0;i<size;i++){
			tablemodelTrajet.addTrajet(trajets.get(i));
		}
	}

	public JPanel listTrajetJPanel() throws TransportException{
		JPanel listtrajets = new JPanel(); 
		listtrajets.setBorder(BorderFactory.createEtchedBorder());
		JMenuItem trajetMenuItem = new JMenuItem("Trajet...");
		trajetMenuItem.addActionListener(new actionTrajet("trajet..."));
		//trajetMenuItem.addActionListener(new actionTrajet("trajet..."));
		popupMenu.add(trajetMenuItem);
		popupMenu.addSeparator();
		JMenuItem supprimer = new JMenuItem("Supprimer");
		supprimer.addActionListener(new actionTrajet("supprimer"));
		popupMenu.add(supprimer);
		tableTrajets.setComponentPopupMenu(popupMenu);
		JScrollPane scrollPane = new JScrollPane(tableTrajets);
		scrollPane.setPreferredSize(new Dimension(800,500));
		listtrajets.add(scrollPane);	
		return listtrajets;
	}
	public void AjouterTrajet(Trajet trajet){
		tablemodelTrajet.addTrajet(trajet);
	}
	class actionTrajet implements ActionListener{
		private String nom;
		public actionTrajet(String nomAction){
			nom = nomAction;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println(tableTrajets.getSelectedRow());
			if(tableTrajets.getSelectedRow()>=0)
				if(nom.equals("trajet...")){
					System.out.println("pùlùm");
					ihmtransport.getCreertrajet().setTrajet(tablemodelTrajet.getTrajet(tableTrajets.getSelectedRow()));
					ihmtransport.ajouterComponnentJPanelCentre(ihmtransport.getCreertrajet());
				}else if(nom.equals("supprimer")){
					if (tableTrajets.getSelectedRow()>=0){
						tablemodelTrajet.removeTrajet(tableTrajets.getSelectedRow());
							
					}
				}
		}
	 }
		@Override
		public void Update(Observable subject,String action) {
			// TODO Auto-generated method stub

		}
	}
