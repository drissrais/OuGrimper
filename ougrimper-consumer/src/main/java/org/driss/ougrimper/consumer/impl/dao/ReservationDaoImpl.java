package org.driss.ougrimper.consumer.impl.dao;

import java.util.List;

import org.driss.ougrimper.consumer.contract.dao.ReservationDao;
import org.driss.ougrimper.consumer.impl.rowmapper.topo.ReservationRM;
import org.driss.ougrimper.model.bean.topo.Reservation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class ReservationDaoImpl extends AbstractDaoImpl implements ReservationDao {

	@Override
	public List<Reservation> getListReservation(Integer topoId) {
		String vSQL = "SELECT * FROM public.reservation WHERE topo_id = ?";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		
		RowMapper<Reservation> vRowMapper = new ReservationRM();
		List<Reservation> listReservation = vJdbcTemplate.query(vSQL, new Object[] { topoId }, vRowMapper);
		
		return listReservation;
	}

	@Override
	public void addNewReservation(Reservation reservation) {
		String vSQL = "INSERT INTO public.reservation (utilisateur_id, topo_id, date_debut, date_fin, statut) VALUES (:utilisateur_id, :topo_id, :date_debut, :date_fin, :statut);";
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		
		vParams.addValue("utilisateur_id", reservation.getUtilisateur().getId());
		vParams.addValue("topo_id", reservation.getTopo().getId());
		vParams.addValue("date_debut", reservation.getDateDebut());
		vParams.addValue("date_fin", reservation.getDateFin());
		vParams.addValue("statut", reservation.getStatut());
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		vJdbcTemplate.update(vSQL, vParams);
	}

	@Override
	public List<Reservation> getListReservation() {
		String vSQL = "SELECT * FROM public.reservation";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		
		RowMapper<Reservation> vRowMapper = new ReservationRM();
		List<Reservation> listReservation = vJdbcTemplate.query(vSQL, vRowMapper);
		
		return listReservation;
	}

	@Override
	public void deleteReservationsTopo(Integer topoId) {
		String vSQL = "DELETE FROM public.reservation WHERE topo_id = :topo_id";
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("topo_id", topoId);
		
		vJdbcTemplate.update(vSQL, vParams);
	}

	@Override
	public void deleteReservationsUtilisateur(Integer userId) {
		String vSQL = "DELETE FROM public.reservation WHERE utilisateur_id = :utilisateur_id";
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("utilisateur_id", userId);
		
		vJdbcTemplate.update(vSQL, vParams);
	}

}
