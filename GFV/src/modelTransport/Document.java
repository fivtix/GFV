package modelTransport;

import java.io.FileInputStream;
//
//  @ Project : pfe
//  @ File Name : Document.java
//  @ Date : 11/03/2013
//  @ Author : Faten,Tania,Van,Idan,Xavier
//
import java.io.FileNotFoundException;



public class Document {
	
	private int id_document;
	private String nom;
	private String emplacement;
	private FileInputStream donnee;
	
	
	public Document()
	{
		
	}
	
	public Document(int id_document, String nom, String emplacement, FileInputStream donnee) 
	{
		this.id_document = id_document;
		this.nom = nom;
		this.emplacement = emplacement;
		this.donnee = donnee;
	}
	
	public int getId_document() 
	{
		return id_document;
	}
	
	public void setId_document(int id_document) 
	{
		this.id_document = id_document;
	}
	
	public String getNom() 
	{
		return nom;
	}
	
	public void setNom(String nom) 
	{
		this.nom = nom;
	}
	
	public String getEmplacement() 
	{
		return emplacement;
	}
	
	public void setEmplacement(String emplacement) 
	{
		this.emplacement = emplacement;
	}
	
	public FileInputStream getDonnee() 
	{
		return donnee;
	}
	
	public void setDonnee(FileInputStream donnee) 
	{
		this.donnee = donnee;
	}
	
	public void setFile(String pathname) throws FileNotFoundException
	{
		donnee = new FileInputStream(pathname);
	}

}
