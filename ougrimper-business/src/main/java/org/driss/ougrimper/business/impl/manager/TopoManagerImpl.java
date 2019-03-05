package org.driss.ougrimper.business.impl.manager;

import java.util.List;

import org.driss.ougrimper.business.contract.manager.TopoManager;
import org.driss.ougrimper.model.bean.site.Site;
import org.driss.ougrimper.model.bean.topo.Reservation;
import org.driss.ougrimper.model.bean.topo.Topo;
import org.driss.ougrimper.model.bean.utilisateur.ProprietaireTopo;
import org.driss.ougrimper.model.bean.utilisateur.Utilisateur;

public class TopoManagerImpl extends AbstractManager implements TopoManager {

	@Override
	public Topo getTopo(Integer topoId) {
		Topo topo = null;
		topo = getDaoFactory().getTopoDao().getTopo(topoId);
		
		ProprietaireTopo vProprietaireTopo = getDaoFactory().getProprietaireTopoDao().getProprietaireTopo(topo.getProprietaire().getId());
		topo.setProprietaire(vProprietaireTopo);
		
		Site vSite = getDaoFactory().getSiteDao().getSite(topo.getSite().getId());
		topo.setSite(vSite);
		
		return topo;
	}

	@Override
	public List<Topo> getListTopo() {
		List<Topo> listTopo = getDaoFactory().getTopoDao().getListTopo();
		for (Topo topo : listTopo) {
			ProprietaireTopo vProprietaireTopo = getDaoFactory().getProprietaireTopoDao().getProprietaireTopo(topo.getProprietaire().getId());
			topo.setProprietaire(vProprietaireTopo);
			
			Site site = getDaoFactory().getSiteDao().getSite(topo.getSite().getId());
			topo.setSite(site);
		}
		return listTopo;
	}

	@Override
	public List<Reservation> getListReservation(Integer topoId) {
		List<Reservation> listReservation = getDaoFactory().getReservationDao().getListReservation(topoId);
		for (Reservation reservation : listReservation) {
			Utilisateur vUtilisateur = getDaoFactory().getUtilisateurDao().getUtilisateur(reservation.getUtilisateur().getId());
			Topo vTopo = getDaoFactory().getTopoDao().getTopo(reservation.getTopo().getId());
			reservation.setUtilisateur(vUtilisateur);
			reservation.setTopo(vTopo);
		}
		return listReservation;
	}

	@Override
	public void addNewReservation(Reservation reservation) {
		getDaoFactory().getReservationDao().addNewReservation(reservation);
	}

	@Override
	public List<Reservation> getListReservation() {
		List<Reservation> listReservation = getDaoFactory().getReservationDao().getListReservation();
		for (Reservation reservation : listReservation) {
			Utilisateur membre = getDaoFactory().getUtilisateurDao().getUtilisateur(reservation.getUtilisateur().getId());
			Topo vTopo = getDaoFactory().getTopoDao().getTopo(reservation.getTopo().getId());
			reservation.setUtilisateur(membre);
			reservation.setTopo(vTopo);
		}
		return listReservation;
	}

	@Override
	public Topo getTopoSite(Integer siteId) {
		Topo vTopo = getDaoFactory().getTopoDao().getTopoSite(siteId);
		return vTopo;
	}

	@Override
	public void deleteReservationsTopo(Integer topoId) {
		getDaoFactory().getReservationDao().deleteReservationsTopo(topoId);
	}

	@Override
	public void deleteTopo(Integer siteId) {
		getDaoFactory().getTopoDao().deleteTopo(siteId);
	}

	@Override
	public void updateTopo(Topo topo) {
		getDaoFactory().getTopoDao().updateTopo(topo);
	}

	@Override
	public void addNewTopo(Topo topo) {
		getDaoFactory().getTopoDao().addNewTopo(topo);
	}

}
