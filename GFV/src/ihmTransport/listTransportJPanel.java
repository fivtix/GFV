package ihmTransport;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import ihmTransport.tables.modeltableTransports;

import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import modelTransport.Transport;

import erreur.TransportException;

public class listTransportJPanel extends JPanel {
	private JTable tableTransports;
	private modeltableTransports tablemodetransports;
	private ihmTransports ihmtransport;
	private JPopupMenu popupMenu;
	public listTransportJPanel(ihmTransports ihmtransport) throws TransportException  {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
		setPreferredSize(new Dimension(800,500));
		this.ihmtransport = ihmtransport;
		popupMenu = new JPopupMenu();
		tablemodetransports = new modeltableTransports();
		tableTransports = new JTable(tablemodetransports);
		tableTransports.setPreferredScrollableViewportSize(new Dimension(800, 500));
		tableTransports.setFillsViewportHeight(true);
		tableTransports.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableTransports.getColumnModel().getColumn(0).setPreferredWidth(70);
		tableTransports.getColumnModel().getColumn(1).setPreferredWidth(150);
		tableTransports.getColumnModel().getColumn(2).setPreferredWidth(170);
		tableTransports.getColumnModel().getColumn(3).setPreferredWidth(170);
		tableTransports.getColumnModel().getColumn(4).setPreferredWidth(110);
		tableTransports.getColumnModel().getColumn(5).setPreferredWidth(110);
		tableTransports.setPreferredScrollableViewportSize(new Dimension(800,500));
		JMenuItem transportMenuItem = new JMenuItem("Transport...");
		transportMenuItem.addActionListener(new actionListTransport("modifier"));
		popupMenu.add(transportMenuItem);
		popupMenu.addSeparator();
		JMenuItem supprimer = new JMenuItem("Supprimer");
		supprimer.addActionListener( new actionListTransport("supprimer"));
		popupMenu.add(supprimer);
		tableTransports.setComponentPopupMenu(popupMenu);
		//tableTransports.add(popup);
		JScrollPane scrollPane = new JScrollPane(tableTransports);
		scrollPane.setPreferredSize(new Dimension(750,450));
		//Add the scroll pane to this panel.
		add(scrollPane ,BorderLayout.NORTH);
	}
	public void initData() throws TransportException{
		// ajouter les trans port en table
		ArrayList<Transport> transports= ihmtransport.getTransportsDAO().toutTransport();
		 int size = transports.size();
		 for(int i = 0;i<size;i++)
			 tablemodetransports.addTransport(transports.get(i)); 
	}
	public void AjouterTransport(Transport transport){
		 tablemodetransports.addTransport(transport); 
	}
	class actionListTransport implements ActionListener{
		private String nom;
		public actionListTransport(String nom){
			this.nom= nom;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(nom.equals("modifier")){
				if(tableTransports.getSelectedRow()>=0){
					ihmtransport.getTransportJPanel().setTransport(tablemodetransports.getTransport(tableTransports.getSelectedRow()));
					ihmtransport.ajouterComponnentJPanelCentre(ihmtransport.getTransportJPanel());
				}
			}else if(nom.equals("supprimer")){
				if(tableTransports.getSelectedRow()>=0){
					Transport t = tablemodetransports.getTransport(tableTransports.getSelectedRow());
					try {
						ihmtransport.getTransportsDAO().supprimer(t.getId());
					} catch (TransportException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					tablemodetransports.removeTransport(tableTransports.getSelectedRow());
				}
			}
			
			
		}
	}

}
