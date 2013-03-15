package modelTransport;

public class Article {
  int id_article;
  
  
   /**CONSTRUCTEURS*/
          public Article() {}
  		public Article(int id_article) {
  			super();
  			this.id_article = id_article;
  		}

  /**GETTERS ET SETTERS*/
  
  		public int getId_article() {
  			return id_article;
  		}
  	
  		public void setId_article(int id_article) {
  			this.id_article = id_article;
  		}
  
}
