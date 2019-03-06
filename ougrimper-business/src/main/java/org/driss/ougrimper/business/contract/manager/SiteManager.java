package org.driss.ougrimper.business.contract.manager;

import java.util.List;

import org.driss.ougrimper.model.bean.site.CommentaireSite;
import org.driss.ougrimper.model.bean.site.Pays;
import org.driss.ougrimper.model.bean.site.Secteur;
import org.driss.ougrimper.model.bean.site.Site;
import org.driss.ougrimper.model.bean.site.Ville;
import org.driss.ougrimper.model.bean.site.Voie;

public interface SiteManager {
	
	Site getSite(Integer siteId);
	List<Site> getListSite();
	void addNewComment(CommentaireSite commentaireSite);
	List<CommentaireSite> getListCommentaire(Integer siteId);
	List<Secteur> getListSecteur(Integer siteId);
	List<Voie> getListVoie(Integer secteurId);
	Voie getVoie(Integer voieId);
	List<CommentaireSite> getListCommentaire();
	List<Pays> getListPays();
	List<Ville> getListVille(Integer paysId);
	void updateSite(Site site);
	void addNewSite(Site site);
	void deleteSite(Integer siteId);
	void deleteCommentairesSite(Integer siteId);
	void deleteLongueursVoie(Integer voieId);
	void deleteVoiesSecteur(Integer secteurId);
	void deleteSecteursSite(Integer siteId);
	void deleteCommentairesSiteById(Integer commentaireId);

}
