package org.driss.ougrimper.webapp.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.driss.ougrimper.business.contract.ManagerFactory;
import org.driss.ougrimper.model.bean.site.Site;
import org.driss.ougrimper.model.bean.topo.Reservation;
import org.driss.ougrimper.model.bean.topo.Topo;
import org.driss.ougrimper.model.bean.utilisateur.ProprietaireTopo;
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
	
	// ----- Eléments en entrée UPLOAD
	private File fileUpload;
	private String fileUploadFileName;
	private String fileUploadContentType;

	// ----- Eléments en sortie
	private List<Topo> listTopo;
	private Topo topo;
	private List<Reservation> listReservation;
	private Reservation reservation;
	private List<Site> listSite;
	private List<ProprietaireTopo> listProprietaireTopo;

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
	public List<Site> getListSite() {
		return listSite;
	}
	public void setListSite(List<Site> listSite) {
		this.listSite = listSite;
	}
	public List<ProprietaireTopo> getListProprietaireTopo() {
		return listProprietaireTopo;
	}
	public void setListProprietaireTopo(List<ProprietaireTopo> listProprietaireTopo) {
		this.listProprietaireTopo = listProprietaireTopo;
	}
	
	// =============== Getters/Setters UPLOAD ==================
	public File getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}
	public String getFileUploadFileName() {
		return fileUploadFileName;
	}
	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}
	public String getFileUploadContentType() {
		return fileUploadContentType;
	}
	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
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

	// Action affichant les details à modifier d'un topo donné
	public String doDetailTopo() {
		if (id == null) {
			this.addActionError("Veuillez sélectionner un topo à modifier !");
		} else {
			topo = managerFactory.getTopoManager().getTopo(id);
			listSite = managerFactory.getSiteManager().getListSite();
			listProprietaireTopo = managerFactory.getUtilisateurManager().getListProprietaireTopo();
		}
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}

	// Action permettant à l'administrateur de modifier un topo d'escalade
	public String doEditTopo() {
		// ===== Validation du nouveau topo (topo != null)
		if (this.topo != null) {
			// Récupération du nom
//				if (this.topo.getNom() == null) {
//					this.addFieldError("topo.nom", "ne doit pas être vide");
//				}

			// Si pas d'erreur, mise à jour du site...
			if (!this.hasErrors()) {
//							try {
				String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("jsp\\images\\");

				if (fileUploadFileName == null)
					this.topo.setPlan(null);
				else {
					File fileToCreate = new File(filePath, fileUploadFileName);
					try {
						FileUtils.copyFile(fileUpload, fileToCreate);
					} catch (IOException e) {
						e.printStackTrace();
					}
					this.topo.setPlan("jsp/images/" + fileUploadFileName);
				}

				managerFactory.getTopoManager().updateTopo(this.topo);
				this.addActionMessage("Vos modifications ont été enregistrées avec succès !");
//							} catch (FunctionalException pEx) {
//								// Sur erreur fonctionnelle on reste sur la page de saisie
//								// et on affiche un message d'erreur
//								this.addActionError(pEx.getMessage());
//							} catch (TechnicalException pEx) {
//								// Sur erreur technique on part sur le result "error"
//								this.addActionError(pEx.getMessage());
//								vResult = ActionSupport.ERROR;
//							}
			}
		}
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
