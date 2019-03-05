package org.driss.ougrimper.consumer.contract.dao;

import java.util.List;

import org.driss.ougrimper.model.bean.topo.Reservation;

public interface ReservationDao {
	
	List<Reservation> getListReservation(Integer topoId);
	void addNewReservation(Reservation reservation);
	List<Reservation> getListReservation();
	void deleteReservationsTopo(Integer topoId);

}
