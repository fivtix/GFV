package modelTransport;

public class Marchandise {
  int id_Marchandise;
	
	
   /**CONSTRUCTEURS*/
	        public Marchandise() {}
			public Marchandise(int id_Marchandise) {
				super();
				this.id_Marchandise = id_Marchandise;
			}

	/**GETTERS ET SETTERS*/
	
			public int getId_Marchandise() {
				return id_Marchandise;
			}
		
			public void setId_Marchandise(int id_Marchandise) {
				this.id_Marchandise = id_Marchandise;
			}
	
}
