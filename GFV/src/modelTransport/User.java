package modelTransport;

import interTransport.interInfos_Personnelles;

import java.sql.Date;
import java.util.ArrayList;

public class User {
    private String id_users;
    private String motdepass;
	private Infos_Personnelles  infop;
	private ArrayList<Role> roles;
	public User()
	{
		roles = new ArrayList<Role>();
	}
	public User(String utilisateur,String password,Infos_Personnelles  infop) {
		this.id_users = utilisateur;
		this.motdepass=password;
		this.infop=infop;
		roles = new ArrayList<Role>();
	}
	public String getId_users() {
		return id_users;
	}
	public void setId_users(String id_users) {
		this.id_users = id_users;
	}
	public String getMotdepass() {
		return motdepass;
	}
	public void setMotdepass(String motdepass) {
		this.motdepass = motdepass;
	}
	public Infos_Personnelles  getInfop() {
		return infop;
	}
	public void setInfop(Infos_Personnelles  infop) {
		this.infop = infop;
	}
	public void AjouterRole(Role r){
		roles.add(r);
	}
	public ArrayList<Role> getRoles() {
		return roles;
	}
	public void setRoles(ArrayList<Role> roles) {
		this.roles = roles;
	}
	
	
	


	
}
