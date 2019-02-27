package org.driss.ougrimper.webapp.action;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.struts2.interceptor.SessionAware;
import org.driss.ougrimper.business.contract.ManagerFactory;
import org.driss.ougrimper.model.bean.site.CommentaireSite;
import org.driss.ougrimper.model.bean.site.Secteur;
import org.driss.ougrimper.model.bean.site.Site;
import org.driss.ougrimper.model.bean.site.Voie;
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
	
	// ----- Eléments en sortie
	private List<Site> listSite;
	private Site site;
	private List<CommentaireSite> listCommentaire;
	private CommentaireSite commentaireSite;
	private List<Secteur> listSecteur;
	private Secteur secteur;
	private List<Voie> listVoie;
	
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
	public List<Voie> getListVoie() {
		return listVoie;
	}
	public void setListVoie(List<Voie> listVoie) {
		this.listVoie = listVoie;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	// ==================== Méthodes ===========================
	public String doList() {
		listSite = managerFactory.getSiteManager().getListSite();
		return ActionSupport.SUCCESS;
	}
	
	/**
     * Action affichant les détails d'un {@link Projet}
     * @return success / error
     */
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
    
    /**
     * Action permettant de créer un nouveau {@link Commentaire} sur un {@link Site} 
     * @return success / error
     */
    public String doAddNewComment() {
//    	if (textComment == null) {
//			this.addActionError(getText("error.textComment.missing.name"));
//		} else {
			Utilisateur vUtilisateur = (Utilisateur) session.get("user");
			commentaireSite = new CommentaireSite(textComment, new Timestamp(0), vUtilisateur);
			site = managerFactory.getSiteManager().getSite(id);
			managerFactory.getSiteManager().addNewComment(site, commentaireSite);
//		}

		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
    
    public String doListComment() {
    	site = managerFactory.getSiteManager().getSite(id);
    	listCommentaire = managerFactory.getSiteManager().getListCommentaire(id);
    	return ActionSupport.SUCCESS;
    }
    
    /**
     * Action "AJAX" renvoyant la liste des voies d'un secteur
     * @return success / error
     */
    public String doAjaxGetListVoie() {
        if (secteur == null) {
            addActionError("Le secteur doit être précisé !");
        } else {
            listVoie = managerFactory.getSiteManager().getListVoie(secteur);
        }

        return hasErrors() ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
    
    public String doAjaxAddNewMessage() {
		if (textComment == null) {
			this.addActionError("");
		} else {
			Utilisateur vUtilisateur = (Utilisateur) session.get("user");
			commentaireSite = new CommentaireSite(textComment, new Timestamp(0), vUtilisateur);
			site = managerFactory.getSiteManager().getSite(id);
			managerFactory.getSiteManager().addNewComment(site, commentaireSite);
		}

		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}
    
}
