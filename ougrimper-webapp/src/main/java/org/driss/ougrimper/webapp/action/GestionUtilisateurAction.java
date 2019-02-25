package org.driss.ougrimper.webapp.action;

import javax.inject.Inject;

import org.driss.ougrimper.business.contract.ManagerFactory;
import org.driss.ougrimper.model.bean.utilisateur.Utilisateur;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action de gestion des {@link Utilisateur}
 */
public class GestionUtilisateurAction extends ActionSupport {

	// ==================== Attributs ====================
	@Inject
	private ManagerFactory managerFactory;

	// ----- Eléments en sortie

	// ----- Eléments en entrée et sortie
	private Utilisateur utilisateur;
	
	// ==================== Getters/Setters ====================
	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
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
				// Si ajout avec succès -> Result "success"
				vResult = ActionSupport.SUCCESS;
				this.addActionMessage(
						"Votre nouveau compte a été créé avec succès. Veuillez saisir vos nouveaux identifiants !");
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
}
