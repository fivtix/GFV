package interTransport;

import java.sql.SQLException;
import java.util.ArrayList;

import erreur.TransportException;
import modelTransport.Marchandise;


public interface interMarchandiseDAO {  
  
			/**Enregistrer un Marchandise    * @throws TransportException */
			public void saveMarchandise(Marchandise a) throws SQLException, TransportException;   
			
			/**Lister  tous les Marchandises*/  
			public ArrayList<Marchandise> MarchandiseListing () throws SQLException, TransportException; 
			
			/**Chercher un  Marchandise*/    
			public Marchandise  findMarchandise (int id) throws SQLException, TransportException;  
			
			/**Mise à jour d'un Marchandise*/ 
			public void updateMarchandise (Marchandise a, int a2) throws SQLException, TransportException ; 
			/**supprimer  tous les Marchandise*/
			public void DeleteAllMarchandises() throws SQLException, TransportException;   
			
			/**supprimer  un Marchandise*/   
			public void DeleteOneMarchandise (Marchandise a) throws SQLException, TransportException ; 


}
