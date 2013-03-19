package interTransport;

import java.util.Collection;

import modelTransport.User;
import erreur.TransportException;

public interface interUserDAO {
	
	public void supprimer(User p)throws TransportException; // supprimer (transport, trajet, Itineraire, adresse...) 
	public void sauvegarde(User p)throws TransportException;// sauvegarde (transport, trajet, Itineraire, adresse...) 
	public void miseAjour(User p)throws TransportException;// mise � jour (transport, trajet, Itineraire, adresse...) 
	public User chercher(int id)throws TransportException;//chercher  (transport, trajet, Itineraire, adresse...) 
	public Collection<User> toutUser()throws TransportException; // chercher  (transport, trajet, Itineraire, adresse...) 

}