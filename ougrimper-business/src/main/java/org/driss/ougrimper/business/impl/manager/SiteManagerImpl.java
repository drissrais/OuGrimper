package org.driss.ougrimper.business.impl.manager;

import java.util.List;

import org.driss.ougrimper.business.contract.manager.SiteManager;
import org.driss.ougrimper.model.bean.site.Pays;
import org.driss.ougrimper.model.bean.site.Site;
import org.driss.ougrimper.model.bean.site.Ville;

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
	public Pays getPays(String paysNom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ville getVille(Integer villeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
