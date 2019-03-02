package org.driss.ougrimper.consumer.contract;

import org.driss.ougrimper.consumer.contract.dao.CommentaireSiteDao;
import org.driss.ougrimper.consumer.contract.dao.PaysDao;
import org.driss.ougrimper.consumer.contract.dao.ProprietaireTopoDao;
import org.driss.ougrimper.consumer.contract.dao.ReservationDao;
import org.driss.ougrimper.consumer.contract.dao.SecteurDao;
import org.driss.ougrimper.consumer.contract.dao.SiteDao;
import org.driss.ougrimper.consumer.contract.dao.TopoDao;
import org.driss.ougrimper.consumer.contract.dao.UtilisateurDao;
import org.driss.ougrimper.consumer.contract.dao.VilleDao;
import org.driss.ougrimper.consumer.contract.dao.VoieDao;

public interface DaoFactory {
	
	SiteDao getSiteDao();
	void setSiteDao(SiteDao siteDao);
	TopoDao getTopoDao();
	void setTopoDao(TopoDao topoDao);
	UtilisateurDao getUtilisateurDao();
	void setUtilisateurDao(UtilisateurDao utilisateurDao);
	PaysDao getPaysDao();
	void setPaysDao(PaysDao paysDao);
	VilleDao getVilleDao();
	void setVilleDao(VilleDao villeDao);
	ProprietaireTopoDao getProprietaireTopoDao();
	void setProprietaireTopoDao(ProprietaireTopoDao proprietaireTopoDao);
	SecteurDao getSecteurDao();
	void setSecteurDao(SecteurDao secteurDao);
	VoieDao getVoieDao();
	void setVoieDao(VoieDao voieDao);
	ReservationDao getReservationDao();
	void setReservationDao(ReservationDao reservationDao);
	CommentaireSiteDao getCommentaireSiteDao();
	void setCommentaireSiteDao(CommentaireSiteDao commentaireSiteDao);

}
