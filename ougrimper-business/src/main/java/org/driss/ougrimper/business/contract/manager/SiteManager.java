package org.driss.ougrimper.business.contract.manager;

import java.util.List;

import org.driss.ougrimper.model.bean.site.Pays;
import org.driss.ougrimper.model.bean.site.Site;
import org.driss.ougrimper.model.bean.site.Ville;
import org.driss.ougrimper.model.exception.NotFoundException;

public interface SiteManager {
	
	Site getSite(Integer siteId);
	List<Site> getListSite();
	Pays getPays(String paysNom);
	Ville getVille(Integer villeId);

}
