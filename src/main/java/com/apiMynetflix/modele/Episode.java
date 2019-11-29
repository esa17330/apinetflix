package com.apiMynetflix.modele;

import java.util.Date;

public class Episode {
	private int id;
	private int numero;
	private String titre;
	private String titreOriginal;
	private int duree;
	private String resume;
	private Date dateRealisation;
	private Date datePremiereDiffusion;
	private int idpublic;
	private Statut statut;
	private Saison saison;
	
	public Episode(int numero, String titre, String titreOriginal, int duree, String resume,
			Date dateRealisation, Date datePremiereDiffusion, int idpublic, Statut statut, Saison saison) {
		super();
		this.numero = numero;
		this.titre = titre;
		this.titreOriginal = titreOriginal;
		this.duree = duree;
		this.resume = resume;
		this.dateRealisation = dateRealisation;
		this.datePremiereDiffusion = datePremiereDiffusion;
		this.idpublic = idpublic;
		this.statut = statut;
		this.saison = saison;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getTitreOriginal() {
		return titreOriginal;
	}

	public void setTitreOriginal(String titreOriginal) {
		this.titreOriginal = titreOriginal;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public Date getDateRealisation() {
		return dateRealisation;
	}

	public void setDateRealisation(Date dateRealisation) {
		this.dateRealisation = dateRealisation;
	}

	public Date getDatePremiereDiffusion() {
		return datePremiereDiffusion;
	}

	public void setDatePremiereDiffusion(Date datePremiereDiffusion) {
		this.datePremiereDiffusion = datePremiereDiffusion;
	}

	public int getIdpublic() {
		return idpublic;
	}

	public void setIdpublic(int idpublic) {
		this.idpublic = idpublic;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public Saison getSaison() {
		return saison;
	}

	public void setSaison(Saison saison) {
		this.saison = saison;
	}

	public int getId() {
		return id;
	}
	
	
}
