package interTransport;

import java.sql.SQLException;
import java.util.ArrayList;

import modelTransport.Incident;
import modelTransport.Mission;

import erreur.TransportException;

public interface interGestIncidDAO {
  
	public void supprimer(int idGestionTransport)throws TransportException; // supprimer (transport, trajet, Itineraire, adresse...) 
	public void sauvegarde(int idGestionTransport,Incident incident)throws TransportException;// sauvegarde (transport, trajet, Itineraire, adresse...) 
	public ArrayList<Incident> chercher(int idGestionTransport)throws TransportException;//chercher  (transport, trajet, Itineraire, adresse...) 
}
