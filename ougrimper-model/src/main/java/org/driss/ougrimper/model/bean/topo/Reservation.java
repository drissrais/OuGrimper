package org.driss.ougrimper.model.bean.topo;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.driss.ougrimper.model.bean.utilisateur.Utilisateur;

public class Reservation {

	// ==================== Attributs ====================
	@NotNull(message = "dateDebut cannot be null")
	private Date dateDebut;
	
	@NotNull(message = "dateFin cannot be null")
	private Date dateFin;
	
	@Max(value=50, message="statut trop long")
	private String statut;
	
	private Utilisateur utilisateur;
	private Topo topo;
	
	// ==================== Getters/Setters ==============
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Topo getTopo() {
		return topo;
	}
	public void setTopo(Topo topo) {
		this.topo = topo;
	}

	// ==================== Méthodes =====================

}
