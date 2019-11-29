package com.apiMynetflix.modele;

public class Personne {
	private int id;
	private String nom;
	private String prenom;
	private int idCivilite;
	
	public Personne(String nom, String prenom, int idCivilite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.idCivilite = idCivilite;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getIdCivilite() {
		return idCivilite;
	}
	public void setIdCivilite(int idCivilite) {
		this.idCivilite = idCivilite;
	}
	public int getId() {
		return id;
	}
	
	
}
