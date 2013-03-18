package interTransport;
import java.util.Collection;
import modelTransport.User;
import erreur.TransportException;
public interface interUserDAO {
  
	public void supprimer(String idUser)throws TransportException; // supprimer (transport, trajet, Itineraire, adresse...) 
	public String sauvegarde(User p)throws TransportException;// sauvegarde (transport, trajet, Itineraire, adresse...) 
	public void miseAjourRole(User p)throws TransportException;// mise � jour (transport, trajet, Itineraire, adresse...) 
	public User chercher(String idUser)throws TransportException;//chercher  (transport, trajet, Itineraire, adresse...) 
	public Collection<User> toutUser()throws TransportException; // chercher  (transport, trajet, Itineraire, adresse...) 

}
