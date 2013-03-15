package interTransport;

import modelTransport.Adresse;
import modelTransport.Horaire;
import erreur.TransportException;

public interface interhoraireDAO {
	public void supprimer(Horaire h)throws TransportException; // supprimer (transport, trajet, Itineraire, adresse...) 
	public void sauvegarde(Horaire h)throws TransportException;// sauvegarde (transport, trajet, Itineraire, adresse...) 
	public void miseAjour(Horaire h)throws TransportException;// mise à jour (transport, trajet, Itineraire, adresse...) 
	public Horaire chercher(String id)throws TransportException;//chercher  (transport, trajet, Itineraire, adresse...) 
}
