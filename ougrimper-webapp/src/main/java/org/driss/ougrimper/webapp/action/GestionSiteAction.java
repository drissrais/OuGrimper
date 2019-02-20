package org.driss.ougrimper.webapp.action;

import java.util.List;

import javax.inject.Inject;

import org.driss.ougrimper.business.contract.ManagerFactory;
import org.driss.ougrimper.model.bean.site.Site;

import com.opensymphony.xwork2.ActionSupport;

public class GestionSiteAction extends ActionSupport {
	
	// ==================== Attributs ==========================
	@Inject
	private ManagerFactory managerFactory;
	
	// ----- Eléments en sortie
	private List<Site> listSite;
	private Site site;
	
	// ==================== Getters/Setters ====================
	public List<Site> getListSite() {
		return listSite;
	}
	public void setListSite(List<Site> listSite) {
		this.listSite = listSite;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	
	// ==================== Méthodes ===========================
	public String doList() {
		listSite = managerFactory.getSiteManager().getListSite();
		return ActionSupport.SUCCESS;
	}

}
