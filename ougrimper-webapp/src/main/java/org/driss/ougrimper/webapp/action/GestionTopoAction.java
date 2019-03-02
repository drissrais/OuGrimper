package org.driss.ougrimper.webapp.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.struts2.interceptor.SessionAware;
import org.driss.ougrimper.business.contract.ManagerFactory;
import org.driss.ougrimper.model.bean.topo.Reservation;
import org.driss.ougrimper.model.bean.topo.Topo;
import org.driss.ougrimper.model.bean.utilisateur.Utilisateur;

import com.opensymphony.xwork2.ActionSupport;

public class GestionTopoAction extends ActionSupport implements SessionAware {

	// ==================== Attributs ==========================
	// ----- Eléments Struts
	private Map<String, Object> session;

	@Inject
	private ManagerFactory managerFactory;

	// ----- Eléments en entrée
	private Integer id;
	private Date dateDebut;
	private Date dateFin;

	// ----- Eléments en sortie
	private List<Topo> listTopo;
	private Topo topo;
	private List<Reservation> listReservation;
	private Reservation reservation;

	// ==================== Getters/Setters ====================
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Topo> getListTopo() {
		return this.listTopo;
	}

	public void setListTopo(List<Topo> listTopo) {
		this.listTopo = listTopo;
	}

	public Topo getTopo() {
		return this.topo;
	}

	public void setTopo(Topo topo) {
		this.topo = topo;
	}

	public List<Reservation> getListReservation() {
		return listReservation;
	}

	public void setListReservation(List<Reservation> listReservation) {
		this.listReservation = listReservation;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	// ==================== Méthodes ===========================
	public String doList() {
		listTopo = managerFactory.getTopoManager().getListTopo();
		return ActionSupport.SUCCESS;
	}

	/**
	 * Action affichant les détails d'un {@link Topo}
	 * 
	 * @return success / error
	 */
	public String doDetail() {
		if (id == null) {
			this.addActionError("Vous devez sélectionner un topo !");
		} else {
			topo = managerFactory.getTopoManager().getTopo(id);
//	            try {
//	            }
//	            catch (NotFoundException pE) {
//	                this.addActionError(getText("error.project.notfound", Collections.singletonList(id)));
//	            }
		}
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}

	/**
	 * Action listant les réservations d'un {@link Topo}
	 * 
	 * @return success / error
	 */
	public String doListReservation() {
		topo = managerFactory.getTopoManager().getTopo(id);
		listReservation = managerFactory.getTopoManager().getListReservation(id);
		return ActionSupport.SUCCESS;
	}
	
	/**
	 * Action listant la liste de toutes les réservations
	 * 
	 * @return success / error
	 */
	public String doListAllReservation() {
		listReservation = managerFactory.getTopoManager().getListReservation();
		return ActionSupport.SUCCESS;
	}

	/**
	 * Action permettant de créer une nouvelle {@link Reservation} d'un {@link Topo}
	 * 
	 * @return success / error
	 */
	public String doAddNewReservation() {
		Utilisateur vUtilisateur = (Utilisateur) session.get("user");
		reservation = new Reservation(dateDebut, dateFin, vUtilisateur);
		topo = managerFactory.getTopoManager().getTopo(id);
		reservation.setTopo(topo);
		managerFactory.getTopoManager().addNewReservation(reservation);

		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}

	/**
	 * Action AJAX permettant de réserver un {@link Topo}
	 * 
	 * @return success / error
	 */
	public String doAjaxAddNewReservation() {
    	if (dateDebut == null || dateFin == null) {
			this.addActionError("");
		} else {
			Utilisateur vUtilisateur = (Utilisateur) session.get("user");
			reservation = new Reservation(dateDebut, dateFin, vUtilisateur);
			topo = managerFactory.getTopoManager().getTopo(id);
			reservation.setTopo(topo);
			managerFactory.getTopoManager().addNewReservation(reservation);
		}

		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}

}
