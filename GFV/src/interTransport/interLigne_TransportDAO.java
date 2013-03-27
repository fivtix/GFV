package interTransport;

import java.util.ArrayList;
import java.util.Collection;

import modelTransport.Ligne_Transport;
import modelTransport.Role;
import erreur.TransportException;


public interface interLigne_TransportDAO {

	public void supprimer(int idGestiontransport)throws TransportException; 
	public void sauvegarde(int idGestiontransport,int idTransport)throws TransportException; 
	public ArrayList<Ligne_Transport> chercher(int idGestiontransport)throws TransportException; 
}
