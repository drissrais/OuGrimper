package org.driss.ougrimper.business.impl.manager;

import java.util.List;

import org.driss.ougrimper.business.contract.manager.TopoManager;
import org.driss.ougrimper.model.bean.site.Site;
import org.driss.ougrimper.model.bean.topo.Topo;
import org.driss.ougrimper.model.bean.utilisateur.ProprietaireTopo;

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

}
