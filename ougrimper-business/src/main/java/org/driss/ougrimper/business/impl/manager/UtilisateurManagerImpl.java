package org.driss.ougrimper.business.impl.manager;

import java.util.List;

import org.driss.ougrimper.business.contract.manager.UtilisateurManager;
import org.driss.ougrimper.model.bean.utilisateur.ProprietaireTopo;
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
	public List<Utilisateur> getListUtilisateur() {
		List<Utilisateur> listUtilisateur = getDaoFactory().getUtilisateurDao().getListUtilisateur();
		return listUtilisateur;
	}

	@Override
	public List<ProprietaireTopo> getListProprietaireTopo() {
		List<ProprietaireTopo> listProprietaireTopo = getDaoFactory().getProprietaireTopoDao().getListProprietaireTopo();
		return listProprietaireTopo;
	}

	@Override
	public Utilisateur getUtilisateur(Integer utilisateurId) {
		Utilisateur utilisateur = null;
		utilisateur = getDaoFactory().getUtilisateurDao().getUtilisateur(utilisateurId);
		return utilisateur;
	}

	@Override
	public void deleteUtilisateur(Integer userId) {
		getDaoFactory().getUtilisateurDao().deleteUtilisateur(userId);
	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) {
		getDaoFactory().getUtilisateurDao().updateUtilisateur(utilisateur);
	}

}
