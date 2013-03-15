package interTransport;

import java.sql.SQLException;
import java.util.ArrayList;

import erreur.TransportException;
import modelTransport.Article;


public interface interArticleDAO {  
  
			/**Enregistrer un Article    * @throws TransportException */
			public void saveArticle(Article a) throws SQLException, TransportException;   
			
			/**Lister  tous les Articles*/  
			public ArrayList<Article> ArticleListing () throws SQLException, TransportException; 
			
			/**Chercher un  Article*/    
			public Article  findArticle (int id) throws SQLException, TransportException;  
			
			/**Mise à jour d'un Article*/ 
			public void updateArticle (Article a, int a2) throws SQLException, TransportException ; 
			/**supprimer  tous les Article*/
			public void DeleteAllArticles() throws SQLException, TransportException;   
			
			/**supprimer  un Article*/   
			public void DeleteOneArticle (Article a) throws SQLException, TransportException ; 


}
