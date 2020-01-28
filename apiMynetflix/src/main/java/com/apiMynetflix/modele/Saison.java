package com.apiMynetflix.modele;

public class Saison {
	private int id;
	private int numero;
	private String resume;
	private int anneeDiffusion;
	private int idstatut;
	private int idserie;

	public Saison(int numero, String resume, int anneeDiffusion, int idstatut, int idserie) {
		super();
		this.numero = numero;
		this.resume = resume;
		this.anneeDiffusion = anneeDiffusion;
		this.idstatut = idstatut;
		this.idserie = idserie;
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

	public int getAnneeDiffusion() {
		return anneeDiffusion;
	}

	public void setAnneeDiffusion(int anneeDiffusion) {
		this.anneeDiffusion = anneeDiffusion;
	}

	public int getIdStatut() {
		return idstatut;
	}

	public void setIdStatut(int idstatut) {
		this.idstatut = idstatut;
	}

	public int getIdSerie() {
		return idserie;
	}

	public void setIdSerie(int idserie) {
		this.idserie = idserie;
	}

	public int getId() {
		return id;
	}

}
