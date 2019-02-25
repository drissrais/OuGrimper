package org.driss.ougrimper.webapp.action;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.driss.ougrimper.business.contract.ManagerFactory;
import org.driss.ougrimper.model.bean.utilisateur.Utilisateur;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware, ServletRequestAware {

	// ----- Eléments Struts
	private Map<String, Object> session;
	private HttpServletRequest servletRequest;

	// ==================== Attributs ====================
	@Inject
	private ManagerFactory managerFactory;

	// ----- Paramètres en entrée
	private String email;
	private String password;

	// ----- Paramètres en sortie
	private Utilisateur user;

	// ==================== Getters/Setters ====================
	public String getEmail() {
		return email;
	}

	public void setEmail(String pEmail) {
		email = pEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pPassword) {
		password = pPassword;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.servletRequest = request;
	}

	// ==================== Méthodes ====================
	/**
	 * Action permettant la connexion d'un utilisateur
	 * 
	 * @return input / success
	 */
	public String doLogin() {
		String vResult = ActionSupport.INPUT;
		if (!StringUtils.isAllEmpty(email, password)) {
//			try {
			user = managerFactory.getUtilisateurManager().getUtilisateur(email, password);

			// Ajout de l'utilisateur en session
			this.session.put("user", user);

			vResult = ActionSupport.SUCCESS;
//			} catch (NotFoundException pEx) {
//				this.addActionError("Identifiant ou mot de passe invalide !");
//			}
		}
		return vResult;
	}

	/**
	 * Action de déconnexion d'un utilisateur
	 * 
	 * @return success
	 */
	public String doLogout() {
		// Suppression de l'utilisateur en session
		this.session.remove("user");

		// Invalidation de la session
		this.servletRequest.getSession().invalidate();

		return ActionSupport.SUCCESS;
	}

}
