package org.driss.ougrimper.model.bean.topo;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.driss.ougrimper.model.bean.utilisateur.Utilisateur;

public class CommentaireTopo {

	// ==================== Attributs ====================
	@NotNull(message = "contenu cannot be null")
	@Max(value=1000, message="trop long")
	private String contenu;
	
	@NotNull(message = "date cannot be null")
	private Date date;
	
	private Utilisateur redacteur;
	private Topo topo;
	
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
	public Topo getTopo() {
		return topo;
	}
	public void setTopo(Topo topo) {
		this.topo = topo;
	}

	// ==================== Méthodes =====================

}
