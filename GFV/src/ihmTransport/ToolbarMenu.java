package ihmTransport;

import ihmTransport.Actions.menuAction;
import ihmTransport.controlleur.Observable;
import ihmTransport.controlleur.Observer;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

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
		setBorder(BorderFactory.createEmptyBorder(8, 8,8 , 8));
		add(menuTrajet());
		add( menuTransport());
		
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
	public void menuConnection(){


	}
	@Override
	public void Update(Observable subject) {
		// TODO Auto-generated method stub
		if (subject == ihmtransport){
			
		}
	}



}
