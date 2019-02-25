package org.driss.ougrimper.business.impl.manager;

import org.driss.ougrimper.business.contract.manager.UtilisateurManager;
import org.driss.ougrimper.model.bean.utilisateur.Utilisateur;

public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {

	@Override
	public Utilisateur getUtilisateur(String email, String motDePasse) {
		Utilisateur utilisateur = null;
		utilisateur = getDaoFactory().getUtilisateurDao().getUtilisateur(email, motDePasse);
		return utilisateur;
	}

	@Override
	public void insertUtilisateur(Utilisateur utilisateur) {
		getDaoFactory().getUtilisateurDao().insertUtilisateur(utilisateur);
	}

	@Override
	public int lastIndexId() {
		return getDaoFactory().getUtilisateurDao().lastIndexId();
	}

}
