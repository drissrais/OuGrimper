package org.driss.ougrimper.business.contract.manager;

import org.driss.ougrimper.model.bean.utilisateur.Utilisateur;

public interface UtilisateurManager {
	
	Utilisateur getUtilisateur(String email, String motDePasse);
	void insertUtilisateur(Utilisateur utilisateur);
	int lastIndexId();
	
}
