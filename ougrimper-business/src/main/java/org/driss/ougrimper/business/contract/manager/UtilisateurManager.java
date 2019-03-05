package org.driss.ougrimper.business.contract.manager;

import java.util.List;

import org.driss.ougrimper.model.bean.utilisateur.ProprietaireTopo;
import org.driss.ougrimper.model.bean.utilisateur.Utilisateur;

public interface UtilisateurManager {
	
	Utilisateur getUtilisateur(String email, String motDePasse);
	void insertUtilisateur(Utilisateur utilisateur);
	List<Utilisateur> getListUtilisateur();
	List<ProprietaireTopo> getListProprietaireTopo();
	
}
