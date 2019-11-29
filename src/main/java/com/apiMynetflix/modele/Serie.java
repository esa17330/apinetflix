package com.apiMynetflix.modele;

import java.util.Date;

public class Serie {
	private int id;
	private String nom;
	private String nomOriginal;
	private int anneeParution;
	private String synopsis;
	private int idstatut;
	private int idPaysOrigine;
	
	public Serie(String nom, String nomOriginal, int anneeParution, String synopsis, int idstatut,
			int idPaysOrigine) {
		super();
		this.nom = nom;
		this.nomOriginal = nomOriginal;
		this.anneeParution = anneeParution;
		this.synopsis = synopsis;
		this.idstatut = idstatut;
		this.idPaysOrigine = idPaysOrigine;
	}
	
	
	public int getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNomOriginal() {
		return nomOriginal;
	}
	public void setNomOriginal(String nomOriginal) {
		this.nomOriginal = nomOriginal;
	}
	public int getAnneeParution() {
		return anneeParution;
	}
	public void setAnneeParution(int anneeParution) {
		this.anneeParution = anneeParution;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public int getidStatut() {
		return idstatut;
	}
	public void setStatut(int statut) {
		this.idstatut = statut;
	}
	public int getIdPaysOrigine() {
		return idPaysOrigine;
	}
	public void setIdPaysOrigine(int idPaysOrigine) {
		this.idPaysOrigine = idPaysOrigine;
	}
	
	
	
	

}
