package org.driss.ougrimper.model.bean.site;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class Cotation {

	// ==================== Attributs ====================
	@NotNull(message = "cotation cannot be null")
	@Max(value = 20, message = "trop long")
	private String cotation;

	// ==================== Getters/Setters ==============
	public String getCotation() {
		return cotation;
	}
	
	public void setCotation(String cotation) {
		this.cotation = cotation;
	}
	
	// ==================== Méthodes =====================
	
}
