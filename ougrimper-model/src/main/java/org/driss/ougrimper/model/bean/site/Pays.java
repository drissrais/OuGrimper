package org.driss.ougrimper.model.bean.site;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class Pays {

	// ==================== Attributs ====================
	@NotNull(message = "nom cannot be null")
	@Max(value = 100, message = "trop long")
	private String nom;

	// ==================== Getters/Setters ==============
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	// ==================== Méthodes =====================
	
}
