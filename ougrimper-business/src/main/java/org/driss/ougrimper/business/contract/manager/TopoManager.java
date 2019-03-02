package org.driss.ougrimper.business.contract.manager;

import java.util.List;

import org.driss.ougrimper.model.bean.topo.Reservation;
import org.driss.ougrimper.model.bean.topo.Topo;

public interface TopoManager {
	
	Topo getTopo(Integer topoId);
	List<Topo> getListTopo();
	List<Reservation> getListReservation(Integer id);
	void addNewReservation(Reservation reservation);
	List<Reservation> getListReservation();

}
