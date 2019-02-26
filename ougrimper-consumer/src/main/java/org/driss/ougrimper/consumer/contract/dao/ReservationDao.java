package org.driss.ougrimper.consumer.contract.dao;

import java.util.List;

import org.driss.ougrimper.model.bean.topo.Reservation;
import org.driss.ougrimper.model.bean.topo.Topo;

public interface ReservationDao {
	
	List<Reservation> getListReservation(Integer topoId);
	void addNewReservation(Topo topo, Reservation reservation);

}
