package org.driss.ougrimper.model.bean.site;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.driss.ougrimper.model.bean.utilisateur.Utilisateur;

public class CommentaireSite {

	// ==================== Attributs ====================
	@NotNull(message = "contenu cannot be null")
	@Max(value = 1000, message = "trop long")
	private String contenu;

	@NotNull(message = "date cannot be null")
	private Date date;

	private Utilisateur redacteur;
	private Site site;

	// ==================== Getters/Setters ==============
	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Utilisateur getRedacteur() {
		return redacteur;
	}

	public void setRedacteur(Utilisateur redacteur) {
		this.redacteur = redacteur;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	// ==================== Méthodes =====================

}
