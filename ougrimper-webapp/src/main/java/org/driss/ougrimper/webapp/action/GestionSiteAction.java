package org.driss.ougrimper.webapp.action;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.driss.ougrimper.business.contract.ManagerFactory;
import org.driss.ougrimper.model.bean.site.CommentaireSite;
import org.driss.ougrimper.model.bean.site.Pays;
import org.driss.ougrimper.model.bean.site.Secteur;
import org.driss.ougrimper.model.bean.site.Site;
import org.driss.ougrimper.model.bean.site.Ville;
import org.driss.ougrimper.model.bean.site.Voie;
import org.driss.ougrimper.model.bean.topo.Topo;
import org.driss.ougrimper.model.bean.utilisateur.Utilisateur;

import com.opensymphony.xwork2.ActionSupport;

public class GestionSiteAction extends ActionSupport implements SessionAware {

	// ==================== Attributs ==========================
	// ----- Eléments Struts
	private Map<String, Object> session;

	@Inject
	private ManagerFactory managerFactory;

	// ----- Eléments en entrée
	private Integer id;
	private String textComment;
	private Integer secteurId;
	private Integer voieId;
	private Integer paysId;

	// ----- Eléments en entrée UPLOAD
	private File fileUpload;
	private String fileUploadFileName;
	private String fileUploadContentType;
	private File file2Upload;
	private String file2UploadFileName;
	private String file2UploadContentType;

	// ----- Eléments en sortie
	private List<Site> listSite;
	private Site site;
	private Topo topo;
	private List<CommentaireSite> listCommentaire;
	private CommentaireSite commentaireSite;
	private List<Secteur> listSecteur;
	private Secteur secteur;
	private List<Voie> listVoie;
	private Voie voie;
	private List<Pays> listPays;
	private List<Ville> listVille;

	// ==================== Getters/Setters ====================
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTextComment() {
		return textComment;
	}

	public void setTextComment(String textComment) {
		this.textComment = textComment;
	}

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

	public CommentaireSite getCommentaireSite() {
		return commentaireSite;
	}

	public void setCommentaireSite(CommentaireSite commentaireSite) {
		this.commentaireSite = commentaireSite;
	}

	public List<CommentaireSite> getListCommentaire() {
		return listCommentaire;
	}

	public void setListCommentaire(List<CommentaireSite> listCommentaire) {
		this.listCommentaire = listCommentaire;
	}

	public List<Secteur> getListSecteur() {
		return listSecteur;
	}

	public void setListSecteur(List<Secteur> listSecteur) {
		this.listSecteur = listSecteur;
	}

	public Secteur getSecteur() {
		return secteur;
	}

	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}

	public Integer getSecteurId() {
		return secteurId;
	}

	public void setSecteurId(Integer secteurId) {
		this.secteurId = secteurId;
	}

	public List<Voie> getListVoie() {
		return listVoie;
	}

	public void setListVoie(List<Voie> listVoie) {
		this.listVoie = listVoie;
	}

	public Integer getVoieId() {
		return voieId;
	}

	public void setVoieId(Integer voieId) {
		this.voieId = voieId;
	}

	public Voie getVoie() {
		return voie;
	}

	public void setVoie(Voie voie) {
		this.voie = voie;
	}

	// ============== Getters/Setters BackOffice ===============
	public Integer getPaysId() {
		return paysId;
	}

	public void setPaysId(Integer paysId) {
		this.paysId = paysId;
	}

	public List<Pays> getListPays() {
		return listPays;
	}

	public void setListPays(List<Pays> listPays) {
		this.listPays = listPays;
	}

	public List<Ville> getListVille() {
		return listVille;
	}

	public void setListVille(List<Ville> listVille) {
		this.listVille = listVille;
	}

	public Topo getTopo() {
		return topo;
	}

	public void setTopo(Topo topo) {
		this.topo = topo;
	}

	// ============== Getters/Setters UPLOAD ===============
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

	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getFile2UploadFileName() {
		return file2UploadFileName;
	}

	public void setFile2UploadFileName(String file2UploadFileName) {
		this.file2UploadFileName = file2UploadFileName;
	}

	public String getFile2UploadContentType() {
		return file2UploadContentType;
	}

	public void setFile2UploadContentType(String file2UploadContentType) {
		this.file2UploadContentType = file2UploadContentType;
	}

	public File getFile2Upload() {
		return file2Upload;
	}

	public void setFile2Upload(File file2Upload) {
		this.file2Upload = file2Upload;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	// ==================== Méthodes ===========================

	// Action renvoyant la liste des sites d'escalade
	public String doList() {
		listSite = managerFactory.getSiteManager().getListSite();
		return ActionSupport.SUCCESS;
	}

	// Action affichant les détails d'un site d'escalade
	public String doDetail() {
		if (id == null) {
			this.addActionError("Vous devez sélectionner un site !");
		} else {
			site = managerFactory.getSiteManager().getSite(id);
			listSecteur = managerFactory.getSiteManager().getListSecteur(id);
//            try {
//            }
//            catch (NotFoundException pE) {
//                this.addActionError(getText("error.project.notfound", Collections.singletonList(id)));
//            }
		}
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}

	// Action permettant de créer un nouveau commentaire sur un site
	public String doAddNewComment() {
//    	if (textComment == null) {
//			this.addActionError(getText("error.textComment.missing.name"));
//		} else {
		Utilisateur vUtilisateur = (Utilisateur) session.get("user");
		site = managerFactory.getSiteManager().getSite(id);

		commentaireSite = new CommentaireSite();
		commentaireSite.setRedacteur(vUtilisateur);
		commentaireSite.setSite(site);
		commentaireSite.setDate(new Timestamp(0));
		commentaireSite.setContenu(textComment);

		managerFactory.getSiteManager().addNewComment(commentaireSite);
//		}

		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}

	// Action renvoyant la liste des commentaires d'un site d'escalade donné
	public String doListComment() {
		site = managerFactory.getSiteManager().getSite(id);
		listCommentaire = managerFactory.getSiteManager().getListCommentaire(id);
		return ActionSupport.SUCCESS;
	}

	// Action renvoyant la liste des commentaires de tous les sites d'escalade
	public String doListAllComment() {
		listCommentaire = managerFactory.getSiteManager().getListCommentaire();
		return ActionSupport.SUCCESS;
	}

	// Action affichant les details à modifier d'un site donné
	public String doDetailSite() {
		if (id == null) {
			this.addActionError("Vous devez sélectionner un site à modifier !");
		} else {
			site = managerFactory.getSiteManager().getSite(id);
			listSite = managerFactory.getSiteManager().getListSite();
			listPays = managerFactory.getSiteManager().getListPays();
		}
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}

	// Action permettant à l'administrateur de modifier un site d'escalade
	public String doEditSite() {
		// ===== Validation du nouveau site (site != null)
		if (this.site != null) {
			// Récupération du nom
//			if (this.site.getNom() == null) {
//				this.addFieldError("site.nom", "ne doit pas être vide");
//			}

			// Si pas d'erreur, mise à jour du site...
			if (!this.hasErrors()) {
//						try {
				String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("jsp\\images\\");

				if (fileUploadFileName == null)
					this.site.setPlan(null);
				else {
					File fileToCreate = new File(filePath, fileUploadFileName);
					try {
						FileUtils.copyFile(fileUpload, fileToCreate);
					} catch (IOException e) {
						e.printStackTrace();
					}
					this.site.setPlan("jsp/images/" + fileUploadFileName);
				}

				managerFactory.getSiteManager().updateSite(this.site);
				this.addActionMessage("Vos modifications ont été enregistrées avec succès !");
//						} catch (FunctionalException pEx) {
//							// Sur erreur fonctionnelle on reste sur la page de saisie
//							// et on affiche un message d'erreur
//							this.addActionError(pEx.getMessage());
//						} catch (TechnicalException pEx) {
//							// Sur erreur technique on part sur le result "error"
//							this.addActionError(pEx.getMessage());
//							vResult = ActionSupport.ERROR;
//						}
			}
		}
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}

	// Action permettant à l'administrateur d'ajouter un nouveau site d'escalade
	public String doCreateSite() {
		// Si (this.site == null) c'est que l'on entre dans l'ajout de site
		// Sinon, c'est que l'on vient de valider le formulaire d'ajout

		// Par défaut, le result est "input"
		String vResult = ActionSupport.INPUT;
		listPays = managerFactory.getSiteManager().getListPays();

		// ===== Validation du nouveau site (site != null)
		if (this.site != null) {
			// Récupération du nom
			if (this.site.getNom() == null) {
				this.addFieldError("site.nom", "ne doit pas être vide");
			}

			// Si pas d'erreur, mise à jour du site...
			if (!this.hasErrors()) {
//							try {
				if (fileUploadFileName == null) {
					this.site.setPhoto(null);
				} else {
					String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("jsp\\images\\");
					File fileToCreate = new File(filePath, fileUploadFileName);
					try {
						FileUtils.copyFile(fileUpload, fileToCreate);
					} catch (IOException e) {
						e.printStackTrace();
					}
					this.site.setPhoto("jsp/images/" + fileUploadFileName);
				}

				if (file2UploadFileName == null) {
					this.site.setPlan(null);
				} else {
					String file2Path = ServletActionContext.getServletContext().getRealPath("/")
							.concat("jsp\\images\\");
					File file2ToCreate = new File(file2Path, file2UploadFileName);
					try {
						FileUtils.copyFile(file2Upload, file2ToCreate);
					} catch (IOException e) {
						e.printStackTrace();
					}
					this.site.setPlan("jsp/images/" + file2UploadFileName);
				}

				managerFactory.getSiteManager().addNewSite(this.site);
				// Si ajout avec succès -> Result "success"
				vResult = ActionSupport.SUCCESS;
				this.addActionMessage("Un nouveau site d'escalade a été ajouté avec succès !");
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

		return vResult;
	}

	/*----------- Les actions "AJAX" -----------------------*/

	// Action "AJAX" renvoyant la liste des voies d'un secteur
	public String doAjaxGetListVoie() {
		if (secteurId == null) {
			addActionError("Le secteur doit être précisé !");
		} else {
			listVoie = managerFactory.getSiteManager().getListVoie(secteurId);
		}

		return hasErrors() ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}

	// Action "AJAX" renvoyant une voie à partir de son identifiant
	public String doAjaxGetVoie() {
		if (voieId == null) {
			addActionError("La voie doit être précisée !");
		} else {
			voie = managerFactory.getSiteManager().getVoie(voieId);
		}

		return hasErrors() ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}

	// Action "AJAX" permettant de créer un nouveau commentaire sur un site
	public String doAjaxAddNewComment() {
		if (textComment == null) {
			this.addActionError("");
		} else {
			Utilisateur vUtilisateur = (Utilisateur) session.get("user");
			site = managerFactory.getSiteManager().getSite(id);

			commentaireSite = new CommentaireSite();
			commentaireSite.setRedacteur(vUtilisateur);
			commentaireSite.setSite(site);
			commentaireSite.setDate(new Timestamp(System.currentTimeMillis()));
			commentaireSite.setContenu(textComment);
			managerFactory.getSiteManager().addNewComment(commentaireSite);
			// listCommentaire = managerFactory.getSiteManager().getListCommentaire(id);
		}

		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}

	// Action "AJAX" renvoyant la liste des villes d'un pays
	public String doAjaxGetListVille() {
		if (paysId == null) {
			addActionError("Le pays doit être précisé !");
		} else {
			listVille = managerFactory.getSiteManager().getListVille(paysId);
		}
		return hasErrors() ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}

	// Action "AJAX" permettant de supprimer un site d'escalade
	public String doAjaxDeleteSite() {
		if (id == null) {
			addActionError("Veuillez préciser un site à supprimer !");
		} else {
			// Supprimer les commentaires du site à supprimer
			managerFactory.getSiteManager().deleteCommentairesSite(id);

			listSecteur = managerFactory.getSiteManager().getListSecteur(id);
			for (Secteur secteur : listSecteur) {
				listVoie = managerFactory.getSiteManager().getListVoie(secteur.getId());
				for (Voie voie : listVoie) {
					// Supprimer les longueurs de chaque voie de chaque secteur du site à supprimer
					managerFactory.getSiteManager().deleteLongueursVoie(voie.getId());
				}
				// Supprimer les voies de chaque secteur du site à supprimer
				managerFactory.getSiteManager().deleteVoiesSecteur(secteur.getId());
			}
			// Supprimer les secteurs du site à supprimer
			managerFactory.getSiteManager().deleteSecteursSite(id);

			// Supprimer les réservations du topo du site à supprimer
			topo = managerFactory.getTopoManager().getTopoSite(id);

			if (topo != null) {
				managerFactory.getTopoManager().deleteReservationsTopo(topo.getId());

				// Supprimer le ou les topos du site à supprimer
				managerFactory.getTopoManager().deleteTopoSite(id);
			}
			// Supprimer le site donné
			managerFactory.getSiteManager().deleteSite(id);
		}
		return hasErrors() ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}

}
