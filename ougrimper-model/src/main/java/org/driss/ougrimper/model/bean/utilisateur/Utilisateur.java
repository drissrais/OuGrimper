package org.driss.ougrimper.model.bean.utilisateur;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class Utilisateur {

	// ==================== Attributs ====================
	@NotNull(message = "id cannot be null")
	private Integer id;
	
	@NotNull(message = "nom cannot be null")
	@Max(value = 100, message = "nom trop long")
	private String nom;
	
	@NotNull(message = "prenom cannot be null")
	@Max(value = 100, message = "prenom trop long")
	private String prenom;
	
	@NotNull(message = "civilite cannot be null")
	@Max(value = 20, message = "trop long")
	private String civilite;
	
	@NotNull(message = "dateDeNaissance cannot be null")
	private Date dateDeNaissance;
	
	@NotNull(message = "email cannot be null")
	@Max(value = 200, message = "email trop long")
	private String email;
	
	@NotNull(message = "pseudo cannot be null")
	@Max(value = 100, message = "pseudo trop long")
	private String pseudo;
	
	@NotNull(message = "motDePasse cannot be null")
	@Max(value = 100, message = "trop long")
	private String motDePasse;
	
	@NotNull(message = "role cannot be null")
	@Max(value = 100, message = "trop long")
	private String role;
	
	
	// ==================== Getters/Setters ====================
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCivilite() {
		return civilite;
	}
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	// ==================== Méthodes ====================

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", civilite=" + civilite
				+ ", dateDeNaissance=" + dateDeNaissance + ", email=" + email + ", pseudo=" + pseudo + ", motDePasse="
				+ motDePasse + ", role=" + role + "]";
	}
	
}
