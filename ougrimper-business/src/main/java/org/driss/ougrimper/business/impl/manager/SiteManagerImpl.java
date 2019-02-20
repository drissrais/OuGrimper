package org.driss.ougrimper.business.impl.manager;

import java.util.List;

import org.driss.ougrimper.business.contract.manager.SiteManager;
import org.driss.ougrimper.model.bean.site.Pays;
import org.driss.ougrimper.model.bean.site.Site;
import org.driss.ougrimper.model.bean.site.Ville;
import org.driss.ougrimper.model.exception.NotFoundException;

public class SiteManagerImpl extends AbstractManager implements SiteManager {

	@Override
	public Site getSite(Integer siteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Site> getListSite() {
		List<Site> listSite = getDaoFactory().getSiteDao().getListSite();
		for (Site site : listSite) {
			Pays vPays = getDaoFactory().getPaysDao().getPays(site.getPays().getNom());
			Ville vVille = getDaoFactory().getVilleDo().getVille(site.getVillePlusProche().getId());
			site.setPays(vPays);
			site.setVillePlusProche(vVille);
		}
		return listSite;
	}

	@Override
	public Pays getPays(String paysNom) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ville getVille(Integer villeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
