package org.driss.ougrimper.consumer.contract.dao;

import java.util.List;

import org.driss.ougrimper.model.bean.topo.Topo;

public interface TopoDao {

	Topo getTopo(Integer topoId);
	List<Topo> getListTopo();
	Topo getTopoSite(Integer siteId);
	void deleteTopo(Integer siteId);
	void updateTopo(Topo topo);
	
}
