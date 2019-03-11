package org.driss.ougrimper.consumer.contract.dao;

import java.util.List;

import org.driss.ougrimper.model.bean.site.Site;

public interface SiteDao {
	
	Site getSite(Integer siteId);
	List<Site> getListSite();
	void updateSite(Site site);
	void addNewSite(Site site);
	void deleteSite(Integer siteId);
	List<Site> getListSitePays(Integer paysId);
	List<Site> getListSiteVille(Integer paysId, Integer villeId);
	
}
