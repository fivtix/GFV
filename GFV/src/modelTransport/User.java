package modelTransport;


public class User {
	private int id_User;
	private String pass;
	private Infos_Personnelles infop;

	//default
	public User()
	{
		
	}
	//constructor
	public User(int id_user,String pass, Infos_Personnelles infop) {
		super();
		this.id_User=id_user;
		this.pass=pass;
		this.setInfop(infop);
	}
	//getters & setters
	public int getId_User() {
		return id_User;
	}
	public void setId_User(int id_User) {
		this.id_User = id_User;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Infos_Personnelles getInfop() {
		return infop;
	}
	public void setInfop(Infos_Personnelles infop) {
		this.infop = infop;
	}
	

	
}