package org.driss.ougrimper.model.bean.topo;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.driss.ougrimper.model.bean.site.Site;
import org.driss.ougrimper.model.bean.utilisateur.ProprietaireTopo;

public class Topo {

	// ==================== Attributs ====================
	@NotNull(message = "id cannot be null")
	private Integer id;
	
	@NotNull(message = "nom cannot be null")
	@Max(value=200, message="nom trop long")
	private String nom;
	
	@Max(value=1000, message="trop long")
	private String description;
	
	@NotNull(message = "disponible cannot be null")
	private Boolean disponible;
	
	@Max(value=255, message="trop long")
	private String plan;
	
	private ProprietaireTopo proprietaire;
	private Site site;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getDisponible() {
		return disponible;
	}
	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public ProprietaireTopo getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(ProprietaireTopo proprietaire) {
		this.proprietaire = proprietaire;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}

	// ==================== Méthodes =====================

}
