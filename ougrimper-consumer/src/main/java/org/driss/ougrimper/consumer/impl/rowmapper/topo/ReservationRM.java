package org.driss.ougrimper.consumer.impl.rowmapper.topo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.driss.ougrimper.model.bean.topo.Reservation;
import org.driss.ougrimper.model.bean.topo.Topo;
import org.driss.ougrimper.model.bean.utilisateur.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

public class ReservationRM implements RowMapper<Reservation> {

	@Override
	public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
		Reservation vReservation = new Reservation();
		vReservation.setId(rs.getInt("id"));
		vReservation.setDateDebut(rs.getDate("date_debut"));
		vReservation.setDateFin(rs.getDate("date_fin"));
		
		Integer utilisateurId = rs.getInt("utilisateur_id");
		Utilisateur vUtilisateur = new Utilisateur();
		vUtilisateur.setId(utilisateurId);
		vReservation.setUtilisateur(vUtilisateur);
		
		Integer topoId = rs.getInt("topo_id");
		Topo vTopo = new Topo();
		vTopo.setId(topoId);
		vReservation.setTopo(vTopo);
		
		return vReservation;
	}

}
