package org.driss.ougrimper.business.contract;

import org.driss.ougrimper.business.contract.manager.SiteManager;
import org.driss.ougrimper.business.contract.manager.TopoManager;
import org.driss.ougrimper.business.contract.manager.UtilisateurManager;

public interface ManagerFactory {
	
	SiteManager getSiteManager();
	void setSiteManager(SiteManager siteManager);
	TopoManager getTopoManager();
	void setTopoManager(TopoManager topoManager);
	UtilisateurManager getUtilisateurManager();
	void setUtilisateurManager(UtilisateurManager utilisateurManager);

}
