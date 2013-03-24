package interTransport;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import modelTransport.Entreprise;
import modelTransport.Marchandise;
import erreur.TransportException;


	
	public interface interMarchandiseDAO {  
		
		/**Enregistrer un Marchandise    * @throws TransportException */
		public String sauvegarde(Marchandise m) throws  TransportException;   
		
		/**Lister  tous les Marchandises*/  
		public ArrayList<Marchandise> toutMarchandise () throws TransportException; 
		
		/**Chercher un  Marchandise*/    
		public Marchandise  chercher (int id) throws  TransportException;  
		
		/**Mise à jour d'un Marchandise*/ 
		public void miseAjour (Marchandise m) throws  TransportException ; 
		/**supprimer  tous les Marchandise*/
		public void DeleteAllMarchandises() throws TransportException;   
		
		/**supprimer  un Marchandise*/   
		public void supprimer (Marchandise a) throws  TransportException ; 

}

	
	
	