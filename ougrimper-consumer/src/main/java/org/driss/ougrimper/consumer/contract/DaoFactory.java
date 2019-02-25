package org.driss.ougrimper.consumer.contract;

import org.driss.ougrimper.consumer.contract.dao.PaysDao;
import org.driss.ougrimper.consumer.contract.dao.ProprietaireTopoDao;
import org.driss.ougrimper.consumer.contract.dao.SecteurDao;
import org.driss.ougrimper.consumer.contract.dao.SiteDao;
import org.driss.ougrimper.consumer.contract.dao.TopoDao;
import org.driss.ougrimper.consumer.contract.dao.UtilisateurDao;
import org.driss.ougrimper.consumer.contract.dao.VilleDao;

public interface DaoFactory {
	
	SiteDao getSiteDao();
	void setSiteDao(SiteDao siteDao);
	TopoDao getTopoDao();
	void setTopoDao(TopoDao topoDao);
	UtilisateurDao getUtilisateurDao();
	void setUtilisateurDao(UtilisateurDao utilisateurDao);
	PaysDao getPaysDao();
	void setPaysDao(PaysDao paysDao);
	VilleDao getVilleDo();
	void setVilleDao(VilleDao villeDao);
	ProprietaireTopoDao getProprietaireTopoDao();
	void setProprietaireTopoDao(ProprietaireTopoDao proprietaireTopoDao);
	SecteurDao getSecteurDao();
	void setSecteurDao(SecteurDao secteurDao);

}
