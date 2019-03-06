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
		Pays vPays = getDaoFactory().getPaysDao().getPays(site.getPays().getId());
		site.setPays(vPays);
		Ville vVille = getDaoFactory().getVilleDao().getVille(site.getVille().getId());
		site.setVille(vVille);
		return site;
	}

	@Override
	public List<Site> getListSite() {
		List<Site> listSite = getDaoFactory().getSiteDao().getListSite();
		for (Site site : listSite) {
			Pays vPays = getDaoFactory().getPaysDao().getPays(site.getPays().getId());
			Ville vVille = getDaoFactory().getVilleDao().getVille(site.getVille().getId());
			site.setPays(vPays);
			site.setVille(vVille);
		}
		return listSite;
	}

	@Override
	public void addNewComment(CommentaireSite commentaireSite) {
		getDaoFactory().getCommentaireSiteDao().addNewComment(commentaireSite);
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

	@Override
	public Voie getVoie(Integer voieId) {
		Voie voie = getDaoFactory().getVoieDao().getVoie(voieId);
		return voie;
	}

	@Override
	public List<CommentaireSite> getListCommentaire() {
		List<CommentaireSite> listCommentaire = getDaoFactory().getCommentaireSiteDao().getListCommentaire();
		for (CommentaireSite commentaireSite : listCommentaire) {
			Site vSite = getDaoFactory().getSiteDao().getSite(commentaireSite.getSite().getId());
			Utilisateur redacteur = getDaoFactory().getUtilisateurDao().getUtilisateur(commentaireSite.getRedacteur().getId());
			commentaireSite.setRedacteur(redacteur);
			commentaireSite.setSite(vSite);
		}
		return listCommentaire;
	}

	@Override
	public List<Pays> getListPays() {
		List<Pays> listPays = getDaoFactory().getPaysDao().getListPays();
		return listPays;
	}

	@Override
	public List<Ville> getListVille(Integer paysId) {
		List<Ville> listVille = getDaoFactory().getVilleDao().getListVille(paysId);
		for (Ville ville : listVille) {
			Pays vPays = getDaoFactory().getPaysDao().getPays(ville.getPays().getId());
			ville.setPays(vPays);
		}
		return listVille;
	}

	@Override
	public void updateSite(Site site) {
		getDaoFactory().getSiteDao().updateSite(site);
	}

	@Override
	public void addNewSite(Site site) {
		getDaoFactory().getSiteDao().addNewSite(site);
	}

	@Override
	public void deleteSite(Integer siteId) {
		getDaoFactory().getSiteDao().deleteSite(siteId);
	}

	@Override
	public void deleteCommentairesSite(Integer siteId) {
		getDaoFactory().getCommentaireSiteDao().deleteCommentairesSite(siteId);
	}

	@Override
	public void deleteLongueursVoie(Integer voieId) {
		getDaoFactory().getLongueurDao().deleteLongueursVoie(voieId);
	}

	@Override
	public void deleteVoiesSecteur(Integer secteurId) {
		getDaoFactory().getVoieDao().deleteVoiesSecteur(secteurId);
	}

	@Override
	public void deleteSecteursSite(Integer siteId) {
		getDaoFactory().getSecteurDao().deleteSecteursSite(siteId);
	}

	@Override
	public void deleteCommentairesSiteById(Integer commentaireId) {
		getDaoFactory().getCommentaireSiteDao().deleteCommentairesSiteById(commentaireId);
	}

	@Override
	public List<Ville> getListVille() {
		List<Ville> listVille = getDaoFactory().getVilleDao().getListVille();
		for (Ville ville : listVille) {
			Pays vPays = getDaoFactory().getPaysDao().getPays(ville.getPays().getId());
			ville.setPays(vPays);
		}
		return listVille;
	}

	@Override
	public Pays getPays(Integer paysId) {
		Pays vPays = getDaoFactory().getPaysDao().getPays(paysId);
		return vPays;
	}

	@Override
	public List<Site> getListSitePays(Integer paysId) {
		List<Site> listSitePays = getDaoFactory().getSiteDao().getListSitePays(paysId);
		for (Site site : listSitePays) {
			Pays vPays = getDaoFactory().getPaysDao().getPays(site.getPays().getId());
			site.setPays(vPays);
		}
		return listSitePays;
	}

	@Override
	public Ville getVille(Integer villeId) {
		Ville vVille = getDaoFactory().getVilleDao().getVille(villeId);
		return vVille;
	}

	@Override
	public List<Site> getListSiteVille(Integer villeId) {
		List<Site> listSiteVille = getDaoFactory().getSiteDao().getListSiteVille(villeId);
		for (Site site : listSiteVille) {
			Pays vPays = getDaoFactory().getPaysDao().getPays(site.getPays().getId());
			site.setPays(vPays);
			Ville vVille = getDaoFactory().getVilleDao().getVille(site.getVille().getId());
			site.setVille(vVille);
		}
		return listSiteVille;
	}

}
