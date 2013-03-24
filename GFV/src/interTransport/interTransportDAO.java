package interTransport;

import java.util.ArrayList;

import modelTransport.Transport;
import erreur.TransportException;

public interface interTransportDAO {

	
	/**Enregistrer un Transport    * @throws TransportException */
	public int sauvegarde(Transport t) throws  TransportException;   
	
	/**Lister  tous les Vehicule*/  
	public ArrayList<Transport> toutTransport () throws TransportException; 
	
	/**Chercher un  Vehicule*/    
	public Transport  chercher (int id) throws  TransportException;  
	
	/**Mise à jour d'un Marchandise*/ 
	public void miseAjour (Transport t) throws  TransportException ; 
	
	
	/**supprimer  un Vehicule*/   
	public void supprimer (int id) throws  TransportException ; 
	
}
