package interTransport;

import java.sql.SQLException;
import java.util.ArrayList;

import modelTransport.Incident;

import erreur.TransportException;

public interface interGestIncidDAO {
  
	/**Enregistrer un Incident    * @throws TransportException */
	public void saveIncident(Incident i) throws SQLException,TransportException;   
	
	/**Lister  tous les Incident*/  
	public ArrayList<Incident> IncidentListing () throws SQLException, TransportException; 
	
	/**Chercher un  Incident*/    
	public Incident  findIncident (int id) throws SQLException, TransportException;  
	
	/**Mise à jour d'un Incident*/ 
	public void updateIncident (Incident a) throws SQLException, TransportException ; 
	
	/**supprimer  tous les Incidents*/
	
	public void DeleteAllIncidents() throws SQLException, TransportException;   
	
	/**supprimer  un Incident*/   
	public void DeleteOneIncident (Incident a) throws SQLException, TransportException ; 

}
