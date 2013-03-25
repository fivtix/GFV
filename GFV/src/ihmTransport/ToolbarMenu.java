package ihmTransport;

import ihmTransport.Actions.menuAction;
import ihmTransport.controlleur.Observable;
import ihmTransport.controlleur.Observer;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import erreur.TransportException;

public class ToolbarMenu extends JPanel implements Observer{
	private ihmTransports ihmtransport;
	private JButton[] jbuttons;
	public ToolbarMenu( ihmTransports ihmtransport ){
		this.ihmtransport=ihmtransport;
		ihmtransport.register(this);
		jbuttons = new JButton[10];
		init();
	}
	public void init(){
		setPreferredSize(new Dimension(180,500));
		setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
		add(menuTrajet());
		add(menuTransport());
		add(menuDocument());
		
	}
	public JPanel menuTrajet(){
	    JPanel jpanelTrajet = new JPanel();
		jpanelTrajet.setLayout(new GridLayout(2,1,4,4));
		jpanelTrajet.setPreferredSize(new Dimension(160,50));
		jbuttons[0] = new JButton("Créer Trajet");
		jbuttons[1] = new JButton("List deTrajets");
		jbuttons[0].addActionListener(new menuAction("creertrajet",ihmtransport,jbuttons,0));
		jbuttons[1].addActionListener(new menuAction("listtrajet",ihmtransport,jbuttons,1));
		jpanelTrajet.add(jbuttons[0]);
		jpanelTrajet.add(jbuttons[1]);
		return jpanelTrajet;
	}
	public JPanel menuTransport(){
		JPanel jpanelTransport = new JPanel();
		jpanelTransport.setLayout(new GridLayout(2,1,4,4));
		jpanelTransport.setPreferredSize(new Dimension(160,50));
		jbuttons[2] = new JButton("Créer Transport");
		jbuttons[3] = new JButton("List Transports");
		jbuttons[2].addActionListener(new menuAction("transport",ihmtransport,jbuttons,2));
		jbuttons[3].addActionListener(new menuAction("listtransports",ihmtransport,jbuttons,3));
		jpanelTransport.add(jbuttons[2]);
		jpanelTransport.add(jbuttons[3]);
		return jpanelTransport;
	}
	public JPanel menuDocument(){
		JPanel jpanelDocument = new JPanel();
		jpanelDocument.setLayout(new GridLayout(1,1,4,4));
		jpanelDocument.setPreferredSize(new Dimension(160,50));
		jbuttons[4] = new JButton("Documents");
		jbuttons[4].addActionListener(new menuAction("documents",ihmtransport,jbuttons,4));
		jpanelDocument.add(jbuttons[4]);
		jpanelDocument.setPreferredSize(new Dimension(160,25));
		return jpanelDocument;
	}
	public void menuConnection(){


	}
	@Override
	public void Update(Observable subject,String action) {
		// TODO Auto-generated method stub
		if (subject == ihmtransport){
			if(action.equals("lieuxtrajet"))
				 ihmtransport.getTransportJPanel().initDataLieux();
			else if(action.equals("lieuxtransport"))
				try {
					ihmtransport.getCreertrajet().initDataLieux();
				} catch (TransportException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}



}
