package org.driss.ougrimper.consumer.impl.dao;

import java.util.List;

import org.driss.ougrimper.consumer.contract.dao.TopoDao;
import org.driss.ougrimper.consumer.impl.rowmapper.topo.TopoRM;
import org.driss.ougrimper.model.bean.topo.Topo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao {

	@Override
	public Topo getTopo(Integer topoId) {
		Topo topo = null;
		String vSQL = "SELECT * FROM public.topo WHERE id = ?";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		
		RowMapper<Topo> vRowMapper = new TopoRM();
		topo = (Topo) vJdbcTemplate.queryForObject(vSQL, new Object[] { topoId }, vRowMapper);
		return topo;
	}

	@Override
	public List<Topo> getListTopo() {
		String vSQL = "SELECT * FROM public.topo";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		RowMapper<Topo> vRowMapper = new TopoRM();
		List<Topo> vListTopo = vJdbcTemplate.query(vSQL, vRowMapper);

		return vListTopo;
	}

	@Override
	public Topo getTopoSite(Integer siteId) {
		Topo topo = null;
		String vSQL = "SELECT * FROM public.topo WHERE site_id = ?";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		
		RowMapper<Topo> vRowMapper = new TopoRM();
		topo = (Topo) vJdbcTemplate.queryForObject(vSQL, new Object[] { siteId }, vRowMapper);
		return topo;
	}

	@Override
	public void deleteTopo(Integer siteId) {
		String vSQL = "DELETE FROM public.topo WHERE site_id = :site_id";
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("site_id", siteId);
		
		vJdbcTemplate.update(vSQL, vParams);
	}

	@Override
	public void updateTopo(Topo topo) {
		String vSQL = "";
		if (topo.getPlan() == null)
			vSQL = "UPDATE public.topo "
					+ "SET nom = :nom, description = :description, disponible = :disponible, proprietaire_id = :proprietaire_id, site_id = :site_id WHERE id = :id";
		else
			vSQL = "UPDATE public.topo "
					+ "SET nom = :nom, description = :description, disponible = :disponible, plan = :plan, proprietaire_id = :proprietaire_id, site_id = :site_id WHERE id = :id";
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		MapSqlParameterSource vParams = new MapSqlParameterSource();

		vParams.addValue("nom", topo.getNom());
		vParams.addValue("description", topo.getDescription());
		vParams.addValue("disponible", topo.getDisponible());
		
		if (topo.getPlan() != null)
			vParams.addValue("plan", topo.getPlan());
		
		vParams.addValue("proprietaire_id", topo.getProprietaire().getId());
		vParams.addValue("site_id", topo.getSite().getId());
		vParams.addValue("id", topo.getId());
		

		vJdbcTemplate.update(vSQL, vParams);
	}

}
