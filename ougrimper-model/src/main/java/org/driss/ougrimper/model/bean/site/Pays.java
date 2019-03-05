package org.driss.ougrimper.model.bean.site;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class Pays {

	// ==================== Attributs ====================
	@NotNull(message = "id cannot be null")
	private Integer id;
	
	@NotNull(message = "nom cannot be null")
	@Max(value = 100, message = "trop long")
	private String nom;

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
	
	// ==================== Méthodes =====================
	
}
