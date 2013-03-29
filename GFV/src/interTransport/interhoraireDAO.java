package interTransport;

import java.util.ArrayList;

import modelTransport.Adresse;
import modelTransport.Horaire;
import erreur.TransportException;

public interface interhoraireDAO {
	public void supprimer(int idGestionTransport)throws TransportException; // supprimer (transport, trajet, Itineraire, adresse...) 
	public void sauvegarde(int idGestionTransport,Horaire h)throws TransportException;// sauvegarde (transport, trajet, Itineraire, adresse...) 
	public ArrayList<Horaire> chercher(int idGistionTransport)throws TransportException;//chercher  (transport, trajet, Itineraire, adresse...) 
	
}
