package org.driss.ougrimper.webapp.action;

import java.util.List;

import javax.inject.Inject;

import org.driss.ougrimper.business.contract.ManagerFactory;
import org.driss.ougrimper.model.bean.topo.Topo;

import com.opensymphony.xwork2.ActionSupport;

public class GestionTopoAction extends ActionSupport {

	// ==================== Attributs ==========================
		@Inject
		private ManagerFactory managerFactory;
		
		// ----- Eléments en entrée
		private Integer id;
		
		// ----- Eléments en sortie
		private List<Topo> listTopo;
		private Topo topo;
		
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
		
		// ==================== Méthodes ===========================
		public String doList() {
			listTopo = managerFactory.getTopoManager().getListTopo();
			return ActionSupport.SUCCESS;
		}
		
		/**
	     * Action affichant les détails d'un {@link Topo}
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
	
}
