package org.driss.ougrimper.consumer.contract.dao;

import java.util.List;

import org.driss.ougrimper.model.bean.utilisateur.Utilisateur;

public interface UtilisateurDao {
	
	Utilisateur getUtilisateur(String email, String motDePasse);
	void insertUtilisateur(Utilisateur utilisateur);
	Utilisateur getUtilisateur(Integer id);
	List<Utilisateur> getListUtilisateur();
	void deleteUtilisateur(Integer userId);
	void updateUtilisateur(Utilisateur utilisateur);

}
