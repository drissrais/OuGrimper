package org.driss.ougrimper.consumer.impl;

import org.driss.ougrimper.consumer.contract.DaoFactory;
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

public class DaoFactoryImpl implements DaoFactory {
	
	private SiteDao siteDao;
	private TopoDao topoDao;
	private UtilisateurDao utilisateurDao;
	private PaysDao paysDao;
	private VilleDao villeDao;
	private ProprietaireTopoDao proprietaireTopoDao;
	private SecteurDao secteurDao;
	private VoieDao voieDao;
	private ReservationDao reservationDao;
	private CommentaireSiteDao commentaireSiteDao;

	@Override
	public SiteDao getSiteDao() {
		return this.siteDao;
	}

	@Override
	public void setSiteDao(SiteDao siteDao) {
		this.siteDao = siteDao;
	}

	@Override
	public TopoDao getTopoDao() {
		return this.topoDao;
	}

	@Override
	public void setTopoDao(TopoDao topoDao) {
		this.topoDao = topoDao;
	}

	@Override
	public UtilisateurDao getUtilisateurDao() {
		return this.utilisateurDao;
	}

	@Override
	public void setUtilisateurDao(UtilisateurDao utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}

	@Override
	public PaysDao getPaysDao() {
		return this.paysDao;
	}

	@Override
	public void setPaysDao(PaysDao paysDao) {
		this.paysDao = paysDao;
	}

	@Override
	public VilleDao getVilleDo() {
		return this.villeDao;
	}

	@Override
	public void setVilleDao(VilleDao villeDao) {
		this.villeDao = villeDao;
	}

	@Override
	public ProprietaireTopoDao getProprietaireTopoDao() {
		return this.proprietaireTopoDao;
	}

	@Override
	public void setProprietaireTopoDao(ProprietaireTopoDao proprietaireTopoDao) {
		this.proprietaireTopoDao = proprietaireTopoDao;
	}

	@Override
	public SecteurDao getSecteurDao() {
		return this.secteurDao;
	}

	@Override
	public void setSecteurDao(SecteurDao secteurDao) {
		this.secteurDao = secteurDao;
	}

	@Override
	public VoieDao getVoieDao() {
		return this.voieDao;
	}

	@Override
	public void setVoieDao(VoieDao voieDao) {
		this.voieDao = voieDao;
	}

	@Override
	public ReservationDao getReservationDao() {
		return this.reservationDao;
	}

	@Override
	public void setReservationDao(ReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}

	@Override
	public CommentaireSiteDao getCommentaireSiteDao() {
		return this.commentaireSiteDao;
	}

	@Override
	public void setCommentaireSiteDao(CommentaireSiteDao commentaireSiteDao) {
		this.commentaireSiteDao = commentaireSiteDao;
	}

}
