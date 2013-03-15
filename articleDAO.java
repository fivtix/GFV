package transportDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import modelTransport.Article;
import modelTransport.Transport;
import erreur.TransportException;
import interTransport.interArticleDAO;

public class articleDAO implements interArticleDAO {
  
	
	
	
	private static JdbcTools jdbctool;
	static ArrayList<Article> listArticle = new ArrayList<Article>();
	public articleDAO(){

	}
	/**Constructeurs et methodes */
			public JdbcTools getJdbctool() {
				return jdbctool;
			}
			public void setJdbctool(JdbcTools jdbctool) {
				this.jdbctool = jdbctool;
			}
			public articleDAO(JdbcTools jdbctool)throws TransportException{
				this.jdbctool=jdbctool;
			}
			public articleDAO(String pilote, String url, String utilisateur, String motdepass) throws TransportException{
				jdbctool = new  JdbcTools(pilote,url,utilisateur,motdepass);
				try {
					jdbctool.init();
				} catch (TransportException e) {
					// TODO Auto-generated catch block
					throw new TransportException(e.getMessage());
				}
			}
		
  /**Enregistre un article dans la base de données*/
		@Override
		public void saveArticle(Article a) throws SQLException, TransportException {
			// TODO Auto-generated method stub
			
			 try {
		        	 	    	
					jdbctool.executeUpdate("INSERT INTO articles (id_articles) VALUES('"+ a.getId_article()+"')");
			         } catch (SQLException e) {
				   // TODO Auto-generated catch block
				    throw new TransportException(e.getErrorCode(),e.getMessage());
			    } 
	     }
		
	 /**Renvoie la liste des tous les articles de la base*/

				@Override
				public ArrayList<Article> ArticleListing() throws SQLException,TransportException {
					
					Connection conn = null;
					Statement stat  = null;	
					ResultSet rst =null;
					conn = jdbctool.newConnection();
			        stat = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			        String query ="SELECT * FROM articles ";
			        ResultSet elementListe = stat.executeQuery(query);
			        while (elementListe.next()) {
			        	
			        	Article ArtFound =  new Article (elementListe.getInt(1));
			        				
			        	listArticle.add(ArtFound);
			        };
					return listArticle;
					
					
				}
  
	/**Renvoie un article selon son id */
				@Override
				public Article findArticle(int id) throws SQLException, TransportException {
					// TODO Auto-generated method stub
					Article a  = null;
					com.mysql.jdbc.Connection conn = null;
					PreparedStatement st  = null;	
					ResultSet result =null;
					String query="select * from articles where id_articles="+id;
					try {
						conn = jdbctool.newConnection();
						st = (PreparedStatement) conn.prepareStatement(query);
						
						result = st.executeQuery();
						
						while(result.next()){
							a = new Article();
							a.setId_article(result.getInt(1));
						} 
						
						return a;
					
					  }catch (SQLException e){
						    throw new TransportException(e.getErrorCode(),e.getMessage()); 
						  }
					      finally {
							if(result!=null)
								try {
									result.close();
									jdbctool.quietClose(conn);
								    } catch (SQLException e) {
									// TODO Auto-generated catch block
									throw new TransportException(e.getErrorCode(),e.getMessage());
								   }
						        }
				           }
					
					
	/**Met a jour les champs d' un article */
				@Override
				public void updateArticle(Article a, int a2) throws SQLException,TransportException {
					// TODO Auto-generated method stub
					try {
						jdbctool.executeUpdate("update articles set id_articles=?",
								a2);
					    } 
					catch (SQLException e) {
						// TODO Auto-generated catch block
						throw new TransportException(e.getErrorCode(),e.getMessage());
					    }
				    }
					
	

    /**Supprime tous les articles de la base*/
					@Override
					public void DeleteAllArticles() throws SQLException, TransportException {
						// TODO Auto-generated method stub
						
							// TODO Auto-generated method stub
							String query = "DELETE FROM Articles "; 
							jdbctool.executeUpdate(query);	
						}
						
					
     /**Supprime un articles de la base*/
					@Override
					public void DeleteOneArticle(Article a) throws SQLException,TransportException {
						// TODO Auto-generated method stub
						
							// TODO Auto-generated method stub
							String query = "DELETE FROM articles WHERE id_articles=?";
							
							try {
								jdbctool.executeUpdate(query,a.getId_article());
							} catch (SQLException ex) {
								// TODO Auto-generated catch block
								throw new TransportException(ex.getErrorCode(),ex.getMessage());
							}
							
						}
						

     }
