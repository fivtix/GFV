package interTransport;

import java.util.Collection;

import modelTransport.Gestion_Transport;

import erreur.TransportException;

public interface interGestionTransport {
	public void supprimer(Gestion_Transport gt)throws TransportException; // supprimer (transport, trajet, Itineraire, adresse...) 
	public void sauvegarde(Gestion_Transport gt)throws TransportException;// sauvegarde (transport, trajet, Itineraire, adresse...) 
	public void miseAjour(Gestion_Transport gt)throws TransportException;// mise à jour (transport, trajet, Itineraire, adresse...) 
	public Gestion_Transport chercher(int id)throws TransportException;//chercher  (transport, trajet, Itineraire, adresse...) 
	public Collection<Gestion_Transport> toutGestionTransport()throws TransportException; // chercher  (transport, trajet, Itineraire, adresse...) 

}
