package interTransport;

import modelTransport.Adresse;
import modelTransport.Arrete;
import erreur.TransportException;

public interface interarreteDAO {
	public void supprimer(Arrete a)throws TransportException; // supprimer (transport, trajet, Itineraire, adresse...) 
	public void sauvegarde(Arrete adr)throws TransportException;// sauvegarde (transport, trajet, Itineraire, adresse...) 
	public void miseAjour(Arrete adr)throws TransportException;// mise à jour (transport, trajet, Itineraire, adresse...) 
	public Arrete chercher(String id)throws TransportException;//chercher  (transport, trajet, Itineraire, adresse...) 
}
