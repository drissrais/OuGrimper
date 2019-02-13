package org.driss.ougrimper.model.bean.utilisateur;

import org.driss.ougrimper.model.bean.site.Cotation;

public class Grimpeur extends Utilisateur {

	// ==================== Attributs ====================
	private Cotation niveauActuel;
	
	// ==================== Getters/Setters ==============
	public Cotation getNiveauActuel() {
		return niveauActuel;
	}
	
	public void setNiveauActuel(Cotation niveauActuel) {
		this.niveauActuel = niveauActuel;
	}
	
	// ==================== Méthodes =====================
	
}
