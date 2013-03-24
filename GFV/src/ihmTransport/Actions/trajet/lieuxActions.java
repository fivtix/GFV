package ihmTransport.Actions.trajet;

import ihmTransport.ihmTransports;
import ihmTransport.Lieux.lieuxJpanel;
import ihmTransport.List.List;
import ihmTransport.Trajet.creerTrajet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

import erreur.TransportException;

import modelTransport.Item;
import modelTransport.Lieux;

public class lieuxActions implements ActionListener {
	private List listlieux;
	private String nom;
	private creerTrajet trajetJpanel;
	public lieuxActions(creerTrajet jpaneltrajet,List listlieux,String nomAction){
		this.listlieux=listlieux;
		this.nom=nomAction;
		this.trajetJpanel=jpaneltrajet;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(nom.equals("lieux"))
			trajetJpanel.creerLieux();
		else if(nom.equals("supprimer")){
			int index = listlieux.getJlist().getSelectedIndex();
			if(index>=0)
				listlieux.removeElement(index);
		}else if(nom.equals("lieux...")){
			int index = listlieux.getJlist().getSelectedIndex();
			if(index>=0){
				Item item=(Item) listlieux.getModel().elementAt(index);
				try {
					trajetJpanel.creerLieux(trajetJpanel.chercherLieux(item.getId()));
				} catch (TransportException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}


}
