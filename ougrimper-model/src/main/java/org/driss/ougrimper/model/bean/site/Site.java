package org.driss.ougrimper.model.bean.site;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class Site {

	// ==================== Attributs ====================
	@NotNull(message = "id cannot be null")
	private Integer id;
	
	@NotNull(message = "nom cannot be null")
	@Max(value = 150, message = "nom trop long")
	private String nom;
	
	@Max(value = 1000, message = "trop long")
	private String description;
	
	@NotNull(message = "localite cannot be null")
	@Max(value = 1000, message = "trop long")
	private String localite;
	
	@NotNull(message = "region cannot be null")
	@Max(value = 100, message = "trop long")
	private String region;
	
	@Max(value = 255, message = "trop long")
	private String photo;
	
	@Max(value = 255, message = "trop long")
	private String plan;
	
	private Ville ville;
	private Pays pays;
	
	// ==================== Constructors =================
	public Site() {
		// TODO Auto-generated constructor stub
	}
	public Site(Integer id) {
		super();
		this.id = id;
	}
	
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
	public String getLocalite() {
		return localite;
	}
	public void setLocalite(String localite) {
		this.localite = localite;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville villePlusProche) {
		this.ville = villePlusProche;
	}
	public Pays getPays() {
		return pays;
	}
	public void setPays(Pays pays) {
		this.pays = pays;
	}
	
	// ==================== Méthodes =====================
	
}
