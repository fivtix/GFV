package interTransport;

import java.util.Collection;
import modelTransport.Nature_Marchandise;
import erreur.TransportException;

public interface interNatMarchDAO {
	
	public void supprimer(Nature_Marchandise e)throws TransportException; // supprimer (transport, trajet, Itineraire, adresse...) 
	public int sauvegarde(Nature_Marchandise e)throws TransportException;// sauvegarde (transport, trajet, Itineraire, adresse...) 
	public void miseAjour(Nature_Marchandise e)throws TransportException;// mise à jour (transport, trajet, Itineraire, adresse...) 
	public Nature_Marchandise chercher(int id)throws TransportException;//chercher  (transport, trajet, Itineraire, adresse...) 
	public Collection<Nature_Marchandise> toutNature_Marchandise()throws TransportException; // chercher  (transport, trajet, Itineraire, adresse...) 
}


