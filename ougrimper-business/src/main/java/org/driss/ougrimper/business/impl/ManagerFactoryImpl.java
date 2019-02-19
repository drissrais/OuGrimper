package org.driss.ougrimper.business.impl;

import org.driss.ougrimper.business.contract.ManagerFactory;
import org.driss.ougrimper.business.contract.manager.SiteManager;
import org.driss.ougrimper.business.contract.manager.TopoManager;
import org.driss.ougrimper.business.contract.manager.UtilisateurManager;

public class ManagerFactoryImpl implements ManagerFactory {
	
	private SiteManager siteManager;
	private TopoManager topoManager;
	private UtilisateurManager utilisateurManager;

	@Override
	public SiteManager getSiteManager() {
		return this.siteManager;
	}

	@Override
	public void setSiteManager(SiteManager siteManager) {
		this.siteManager = siteManager;
	}

	@Override
	public TopoManager getTopoManager() {
		return this.topoManager;
	}

	@Override
	public void setTopoManager(TopoManager topoManager) {
		this.topoManager = topoManager;
	}

	@Override
	public UtilisateurManager getUtilisateurManager() {
		return this.utilisateurManager;
	}

	@Override
	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

}
