package interTransport;
import java.util.ArrayList;
import java.util.Collection;

import modelTransport.Itineraire;
import erreur.TransportException;

public interface interItineraireDAO {
	public void supprimer(Itineraire i,int idArrete)throws TransportException; // supprimer (transport, trajet, Itineraire, adresse...) 
	public void sauvegarde(Itineraire i,int idarrete)throws TransportException;// sauvegarde (transport, trajet, Itineraire, adresse...) 
	public ArrayList<Itineraire> chercher(int idArrete)throws TransportException;//chercher  (transport, trajet, Itineraire, adresse...) 

}
