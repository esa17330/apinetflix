package com.apiMynetflix.modele;

public class Statut {
	private int id;
	private String libelle;
	private int idAffectation;
	
	public Statut(int id,String libelle, int idAffectation) {
		super();
		this.id=id;
		this.libelle = libelle;
		this.idAffectation = idAffectation;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getIdAffectation() {
		return idAffectation;
	}

	public void setIdAffectation(int idAffectation) {
		this.idAffectation = idAffectation;
	}

	public int getId() {
		return id;
	}
	
	

}
