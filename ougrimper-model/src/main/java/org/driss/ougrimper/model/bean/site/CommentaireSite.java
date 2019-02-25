package org.driss.ougrimper.model.bean.site;

import java.sql.Timestamp;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.driss.ougrimper.model.bean.utilisateur.Utilisateur;

public class CommentaireSite {

	// ==================== Attributs ====================
	@NotNull(message = "contenu cannot be null")
	@Max(value = 1000, message = "trop long")
	private String contenu;

	@NotNull(message = "date cannot be null")
	private Timestamp date;

	private Utilisateur redacteur;
	private Site site;
	
	// ==================== Constructors =================
	public CommentaireSite() {
		// TODO Auto-generated constructor stub
	}
	public CommentaireSite(String contenu, Timestamp date, Utilisateur redacteur) {
		super();
		this.contenu = contenu;
		this.date = date;
		this.redacteur = redacteur;
	}


	// ==================== Getters/Setters ==============
	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
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
