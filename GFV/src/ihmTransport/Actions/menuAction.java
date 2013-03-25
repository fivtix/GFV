package ihmTransport.Actions;

import ihmTransport.ihmTransports;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import erreur.TransportException;

import modelTransport.Trajet;

public class menuAction implements ActionListener{
	private ihmTransports ihmtransport;
	private JButton[] jbuttons;
	private int index;
	private String nom;
	public menuAction(String nomAction,ihmTransports ihmtransport,JButton[] jbuttons,int index){
		this.ihmtransport= ihmtransport;
		this.jbuttons=jbuttons;
		this.index= index;
		this.nom=nomAction;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		for(int i=0;i<jbuttons.length;i++){
			if(jbuttons[i]!=null){
				jbuttons[i].setEnabled(true);
			}
		}
		jbuttons[index].setEnabled(false);
		if(nom.equals("creertrajet")){
			ihmtransport.getCreertrajet().init();
			ihmtransport.ajouterComponnentJPanelCentre(ihmtransport.getCreertrajet());
		}else if(nom.equals("listtrajet")){
			try {
				ihmtransport.getListtrajetJPanel().init();
			} catch (TransportException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ihmtransport.ajouterComponnentJPanelCentre(ihmtransport.getListtrajetJPanel());
		}else if(nom.equals("transport")){
			ihmtransport.ajouterComponnentJPanelCentre(ihmtransport.getTransportJPanel());
		}else if(nom.equals("listtransports")){
			ihmtransport.ajouterComponnentJPanelCentre(ihmtransport.getListtransports());
		}
	}

}
