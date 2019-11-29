package com.apiMynetflix.modele;

public class Pays {
	private int id;
	private String nom;
	private String code ;
	
	public Pays(int id,String nom, String code) {
		super();
		this.id=id;
		this.nom = nom;
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	

	public String getCode() {
		return code;
	}

	public int getId() {
		return id;
	}
	
	

}
