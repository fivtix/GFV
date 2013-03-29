package interTransport;

import java.util.ArrayList;
import java.util.Collection;

import modelTransport.Adresse;
import modelTransport.GestionTransport;
import erreur.TransportException;

public interface interGestionTransportDAO{

	public void supprimer(int idGestioTransport)throws TransportException; // supprimer (transport, trajet, Itineraire, adresse...) 
	public int sauvegarde(GestionTransport gestioTransport)throws TransportException;// sauvegarde (transport, trajet, Itineraire, adresse...) 
	public void miseAjour(GestionTransport gestioTransport)throws TransportException;// mise à jour (transport, trajet, Itineraire, adresse...) 
	public GestionTransport chercher(int id)throws TransportException;//chercher  (transport, trajet, Itineraire, adresse...) 
	public ArrayList<GestionTransport> toutGestionTransport()throws TransportException; // chercher  (transport, trajet, Itineraire, adresse...) 



}
