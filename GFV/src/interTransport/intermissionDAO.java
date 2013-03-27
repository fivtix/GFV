package interTransport;

import java.util.Collection;

import modelTransport.Adresse;
import modelTransport.Mission;
import modelTransport.Transport;
import modelTransport.User;
import erreur.TransportException;

public interface intermissionDAO {

	public void supprimer(int idMission)throws TransportException; // supprimer (transport, trajet, Itineraire, adresse...) 
	public int sauvegarde(Mission mission)throws TransportException;// sauvegarde (transport, trajet, Itineraire, adresse...) 
	public void miseAjour(Mission mission)throws TransportException;// mise à jour (transport, trajet, Itineraire, adresse...) 
	public Adresse chercher(int idMission)throws TransportException;//chercher  (transport, trajet, Itineraire, adresse...) 
	public Collection<Adresse> toutAdresse()throws TransportException; // chercher  (transport, trajet, Itineraire, adresse...) 
}
