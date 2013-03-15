package interTransport;
 
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import erreur.TransportException;

import modelTransport.Transport;


public interface interTransportDAO {
  
  
  /**Enregistrer d'un transport 
   * @throws TransportException */
  public void saveTransport(Transport t) throws SQLException, TransportException;
  
  /**Lister  tous les transports*/
  
  public ArrayList<Transport> TransportListing () throws SQLException, TransportException;
  
  /**Chercher un  transport*/
  
  public Transport  findTransport (int id) throws SQLException, TransportException;
  /**Mise à jour d'un transport*/
  public void updateTransport (Transport t) throws SQLException, TransportException ;
  
  /**supprimer  tous les transports*/
  public void DeleteAllTransports() throws SQLException, TransportException;
  
  /**supprimer  un transport*/
  
  public void DeleteOneTransport (Transport t) throws SQLException, TransportException ;
  

}
