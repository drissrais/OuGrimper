package org.driss.ougrimper.business.contract.manager;

import java.util.List;

import org.driss.ougrimper.model.bean.site.CommentaireSite;
import org.driss.ougrimper.model.bean.site.Secteur;
import org.driss.ougrimper.model.bean.site.Site;
import org.driss.ougrimper.model.bean.site.Voie;

public interface SiteManager {
	
	Site getSite(Integer siteId);
	List<Site> getListSite();
	void addNewComment(Site site, CommentaireSite commentaireSite);
	List<CommentaireSite> getListCommentaire(Integer siteId);
	List<Secteur> getListSecteur(Integer siteId);
	List<Voie> getListVoie(Integer secteurId);

}
