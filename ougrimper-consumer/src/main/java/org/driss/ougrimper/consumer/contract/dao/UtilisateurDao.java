package org.driss.ougrimper.consumer.contract.dao;

import org.driss.ougrimper.model.bean.utilisateur.Utilisateur;

public interface UtilisateurDao {
	
	Utilisateur getUtilisateur(String email, String motDePasse);
	void insertUtilisateur(Utilisateur utilisateur);
	int lastIndexId();
	Utilisateur getUtilisateur(Integer id);

}
