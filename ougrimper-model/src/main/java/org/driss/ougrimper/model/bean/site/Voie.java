package org.driss.ougrimper.model.bean.site;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class Voie {

	// ==================== Attributs ====================
	@NotNull(message = "id cannot be null")
	private Integer id;
	
	@NotNull(message = "nom cannot be null")
	@Max(value = 100, message = "nom trop long")
	private String nom;
	
	@NotNull(message = "nbLongueur cannot be null")
	private Integer nbLongueur;
	private Cotation cotation;
	private Secteur secteur;
	
	// ==================== Getters/Setters ==============
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Integer getNbLongueur() {
		return nbLongueur;
	}
	public void setNbLongueur(Integer nbLongueur) {
		this.nbLongueur = nbLongueur;
	}
	public Cotation getCotation() {
		return cotation;
	}
	public void setCotation(Cotation cotation) {
		this.cotation = cotation;
	}
	public Secteur getSecteur() {
		return secteur;
	}
	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}

	// ==================== Méthodes =====================

}
