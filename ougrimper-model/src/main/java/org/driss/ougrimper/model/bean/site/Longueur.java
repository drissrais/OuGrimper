package org.driss.ougrimper.model.bean.site;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class Longueur {

	// ==================== Attributs ====================
	@NotNull(message = "id cannot be null")
	private Integer id;
	
	@NotNull(message = "nbPoint cannot be null")
	private Integer nbPoint;
	
	@NotNull(message = "verticalite cannot be null")
	@Max(value = 100, message = "trop long")
	private String verticalite;
	
	private String cotation;
	private Voie voie;
	
	// ==================== Getters/Setters ==============
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNbPoint() {
		return nbPoint;
	}
	public void setNbPoint(Integer nbPoint) {
		this.nbPoint = nbPoint;
	}
	public String getVerticalite() {
		return verticalite;
	}
	public void setVerticalite(String verticalite) {
		this.verticalite = verticalite;
	}
	public String getCotation() {
		return cotation;
	}
	public void setCotation(String cotation) {
		this.cotation = cotation;
	}
	public Voie getVoie() {
		return voie;
	}
	public void setVoie(Voie voie) {
		this.voie = voie;
	}

	// ==================== Méthodes =====================

}
