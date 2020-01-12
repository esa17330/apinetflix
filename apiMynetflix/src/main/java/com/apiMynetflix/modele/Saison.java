package com.apiMynetflix.modele;

import java.util.Date;

public class Saison {
	private int id;
	private int numero;
	private String resume;
	private Date anneeDiffusion;
	private Statut statut;
	private Serie serie;
	
	public Saison( int numero, String resume, Date anneeDiffusion, Statut statut, Serie serie) {
		super();
		this.numero = numero;
		this.resume = resume;
		this.anneeDiffusion = anneeDiffusion;
		this.statut = statut;
		this.serie = serie;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public Date getAnneeDiffusion() {
		return anneeDiffusion;
	}

	public void setAnneeDiffusion(Date anneeDiffusion) {
		this.anneeDiffusion = anneeDiffusion;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public int getId() {
		return id;
	}
	
	

}
