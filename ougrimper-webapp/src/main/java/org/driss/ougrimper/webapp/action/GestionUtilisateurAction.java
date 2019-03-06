package org.driss.ougrimper.webapp.action;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.struts2.interceptor.SessionAware;
import org.driss.ougrimper.business.contract.ManagerFactory;
import org.driss.ougrimper.model.bean.topo.Topo;
import org.driss.ougrimper.model.bean.utilisateur.Utilisateur;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action de gestion des {@link Utilisateur}
 */
public class GestionUtilisateurAction extends ActionSupport implements SessionAware {

	// ==================== Attributs ====================

	@Inject
	private ManagerFactory managerFactory;

	// ----- Eléments Struts
	private Map<String, Object> session;

	// ----- Eléments en entrée
	private Integer id;

	// ----- Eléments en sortie
	private List<Utilisateur> listUtilisateur;
	private List<Topo> listTopo;

	// ----- Eléments en entrée et en sortie
	private Utilisateur utilisateur;

	// ==================== Getters/Setters ====================
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public List<Utilisateur> getListUtilisateur() {
		return listUtilisateur;
	}
	public void setListUtilisateur(List<Utilisateur> listUtilisateur) {
		this.listUtilisateur = listUtilisateur;
	}
	public List<Topo> getListTopo() {
		return listTopo;
	}
	public void setListTopo(List<Topo> listTopo) {
		this.listTopo = listTopo;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	// ==================== Méthodes ====================
	/**
	 * Action permettant de créer un nouveau {@link Utilisateur}
	 * 
	 * @return input / success / error
	 */
	public String doCreate() {
		// Si (this.utilisateur == null) c'est que l'on entre dans la creation
		// d'utilisateur
		// Sinon, c'est que l'on vient de valider le formulaire de creation

		// Par défaut, le result est "input"
		String vResult = ActionSupport.INPUT;

		// ===== Validation de la creation d'utilisateur (utilisateur != null)
		if (this.utilisateur != null) {
			// Si pas d'erreur, ajout du projet...
			if (!this.hasErrors()) {
				managerFactory.getUtilisateurManager().insertUtilisateur(this.utilisateur);

				utilisateur = managerFactory.getUtilisateurManager().getUtilisateur(utilisateur.getEmail(),
						utilisateur.getMotDePasse());
				// Ajout de l'utilisateur en session
				this.session.put("user", utilisateur);

				// Si ajout avec succès -> Result "success"
				vResult = ActionSupport.SUCCESS;
				this.addActionMessage("Félicitations ! Votre nouveau compte a été créé avec succès.");
//                try {
//
//                } catch (FunctionalException pEx) {
//                    // Sur erreur fonctionnelle on reste sur la page de saisie
//                    // et on affiche un message d'erreur
//                    this.addActionError(pEx.getMessage());
//
//                } catch (TechnicalException pEx) {
//                    // Sur erreur technique on part sur le result "error"
//                    this.addActionError(pEx.getMessage());
//                    vResult = ActionSupport.ERROR;
//                }
//            }
			}
		}

		return vResult;
	}

	public String doList() {
		listUtilisateur = managerFactory.getUtilisateurManager().getListUtilisateur();
		return ActionSupport.SUCCESS;
	}

	// Action affichant les details à modifier d'un utilisateur donné
	public String doDetailUtilisateur() {
		if (id == null) {
			this.addActionError("Veuillez sélectionner un topo à modifier !");
		} else {
			utilisateur = managerFactory.getUtilisateurManager().getUtilisateur(id);
			listUtilisateur = managerFactory.getUtilisateurManager().getListUtilisateur();
		}
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}

	// Action "AJAX" permettant de supprimer un utilisateur
	public String doAjaxDeleteUtilisateur() {
		if (id == null) {
			addActionError("Veuillez préciser un utilisateur à supprimer !");
		} else {
			// Récupérer l'utilisateur à partir de son identifiant
			utilisateur = managerFactory.getUtilisateurManager().getUtilisateur(id);
			
			// Si l'utilisateur est un propriétaire de topo 
			if (utilisateur.getRole().equals("topo_owner")) {
				// On récupére la liste de ses topos
				listTopo = managerFactory.getTopoManager().getListTopoUtilisateur(id);
				// On parcourt cette liste
				for (Topo topo : listTopo) {
					// On supprime les réservations de chaque topo de la liste 
					managerFactory.getTopoManager().deleteReservationsTopo(topo.getId());
					// On supprime chaque topo que posséde ce propriétaire 
					managerFactory.getTopoManager().deleteTopoById(topo.getId());
				}
				// Et on supprime le propriétaire lui-même
				managerFactory.getUtilisateurManager().deleteUtilisateur(id);
			// Sinon, c-à-d soit un admin soit un user normal
			} else {
				// Supprimer les réservations de topo faites par cet utilisateur, s'il y en a
				managerFactory.getTopoManager().deleteReservationsUtilisateur(id);
				
				// Supprimer l'utilisateur lui-même
				managerFactory.getUtilisateurManager().deleteUtilisateur(id);
			}

		}
		return hasErrors() ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}

}
