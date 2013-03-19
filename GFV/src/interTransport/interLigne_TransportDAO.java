package interTransport;

import java.util.Collection;

import modelTransport.Ligne_Transport;
import erreur.TransportException;


public interface interLigne_TransportDAO {

	public void supprimer(Ligne_Transport l)throws TransportException; 
	public void sauvegarde(Ligne_Transport l)throws TransportException; 
	//public void miseAjour(Ligne_Transport l)throws TransportException;
	public Ligne_Transport chercher(int id_transport,int id_gestion_transports,int id_arrete)throws TransportException;
	public Collection<Ligne_Transport> toutLigne_Transport()throws TransportException; 

}
