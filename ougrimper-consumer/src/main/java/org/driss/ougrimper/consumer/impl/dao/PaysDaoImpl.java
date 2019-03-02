package org.driss.ougrimper.consumer.impl.dao;

import java.util.List;

import org.driss.ougrimper.consumer.contract.dao.PaysDao;
import org.driss.ougrimper.consumer.impl.rowmapper.site.PaysRM;
import org.driss.ougrimper.model.bean.site.Pays;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class PaysDaoImpl extends AbstractDaoImpl implements PaysDao {

	@Override
	public Pays getPays(String paysNom) {
		Pays vPays = null;
		String vSQL = "SELECT * FROM pays WHERE nom = ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Pays> vRowMapper = new PaysRM();
		
		if (paysNom != null) {
			vPays = (Pays) vJdbcTemplate.queryForObject(vSQL, new Object[] { paysNom }, vRowMapper);
		}

		return vPays;
	}

	@Override
	public List<Pays> getListPays() {
		String vSQL = "SELECT * FROM public.pays";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Pays> vRowMapper = new PaysRM();
		
		List<Pays> listPays = vJdbcTemplate.query(vSQL, vRowMapper);
		return listPays;
	}

	@Override
	public void addNewPays(Pays vPays) {
		String vSQL = "INSERT INTO public.pays (nom) VALUES (:nom)";
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		
		vParams.addValue("nom", vPays.getNom());
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		vJdbcTemplate.update(vSQL, vParams);
	}

}
