package org.driss.ougrimper.model.bean.topo;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.driss.ougrimper.model.bean.utilisateur.Utilisateur;

public class Reservation {

	// ==================== Attributs ====================
	@NotNull(message = "id cannot be null")
	private Integer id;
	
	@NotNull(message = "dateDebut cannot be null")
	private Date dateDebut;
	
	@NotNull(message = "dateFin cannot be null")
	private Date dateFin;
	
	@Max(value=50, message="statut trop long")
	private String statut;
	
	private Utilisateur utilisateur;
	private Topo topo;
	
	// ==================== Constructors ==================
	public Reservation() {
		// TODO Auto-generated constructor stub
	}
	
	public Reservation(Date dateDebut, Date dateFin, Utilisateur utilisateur) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.utilisateur = utilisateur;
	}
	
	
	// ==================== Getters/Setters ===============
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
