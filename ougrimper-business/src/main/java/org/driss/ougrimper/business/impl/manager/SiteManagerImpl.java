package org.driss.ougrimper.business.impl.manager;

import java.util.List;

import org.driss.ougrimper.business.contract.manager.SiteManager;
import org.driss.ougrimper.model.bean.site.CommentaireSite;
import org.driss.ougrimper.model.bean.site.Pays;
import org.driss.ougrimper.model.bean.site.Secteur;
import org.driss.ougrimper.model.bean.site.Site;
import org.driss.ougrimper.model.bean.site.Ville;
import org.driss.ougrimper.model.bean.site.Voie;
import org.driss.ougrimper.model.bean.utilisateur.Utilisateur;

public class SiteManagerImpl extends AbstractManager implements SiteManager {

	@Override
	public Site getSite(Integer siteId) {
		Site site = null;
		site = getDaoFactory().getSiteDao().getSite(siteId);
		Pays vPays = getDaoFactory().getPaysDao().getPays(site.getPays().getNom());
		site.setPays(vPays);
		Ville vVille = getDaoFactory().getVilleDo().getVille(site.getVille().getId());
		site.setVille(vVille);
		return site;
	}

	@Override
	public List<Site> getListSite() {
		List<Site> listSite = getDaoFactory().getSiteDao().getListSite();
		for (Site site : listSite) {
			Pays vPays = getDaoFactory().getPaysDao().getPays(site.getPays().getNom());
			Ville vVille = getDaoFactory().getVilleDo().getVille(site.getVille().getId());
			site.setPays(vPays);
			site.setVille(vVille);
		}
		return listSite;
	}

	@Override
	public void addNewComment(Site site, CommentaireSite commentaireSite) {
		getDaoFactory().getCommentaireSiteDao().addNewComment(site, commentaireSite);
	}

	@Override
	public List<CommentaireSite> getListCommentaire(Integer siteId) {
		List<CommentaireSite> listCommentaire = getDaoFactory().getCommentaireSiteDao().getListCommentaire(siteId);
		for (CommentaireSite commentaireSite : listCommentaire) {
			Utilisateur vUtilisateur = getDaoFactory().getUtilisateurDao().getUtilisateur(commentaireSite.getRedacteur().getId());
			Site vSite = getDaoFactory().getSiteDao().getSite(commentaireSite.getSite().getId());
			commentaireSite.setRedacteur(vUtilisateur);
			commentaireSite.setSite(vSite);
		}
		return listCommentaire;
	}

	@Override
	public List<Secteur> getListSecteur(Integer siteId) {
		List<Secteur> listSecteur = getDaoFactory().getSecteurDao().getListSecteur(siteId);
		for (Secteur secteur : listSecteur) {
			Site vSite = getDaoFactory().getSiteDao().getSite(secteur.getSite().getId());
			secteur.setSite(vSite);
		}
		return listSecteur;
	}

	@Override
	public List<Voie> getListVoie(Integer secteurId) {
		List<Voie> listVoie = getDaoFactory().getVoieDao().getListVoie(secteurId);
		for (Voie voie : listVoie) {
			Secteur vSecteur = getDaoFactory().getSecteurDao().getSecteur(secteurId);
			voie.setSecteur(vSecteur);
		}
		return listVoie;
	}

}
