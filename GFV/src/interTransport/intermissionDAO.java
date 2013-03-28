package interTransport;

import java.util.ArrayList;
import java.util.Collection;

import modelTransport.Adresse;
import modelTransport.Mission;
import modelTransport.Transport;
import modelTransport.User;
import erreur.TransportException;

public interface intermissionDAO {

	public void supprimer(int idGestionTransport)throws TransportException; // supprimer (transport, trajet, Itineraire, adresse...) 
	public void sauvegarde(int idGestionTransport,Mission mission)throws TransportException;// sauvegarde (transport, trajet, Itineraire, adresse...) 
	public Mission chercher(int idGestionTransport)throws TransportException;//chercher  (transport, trajet, Itineraire, adresse...) 
}
