package org.driss.ougrimper.consumer.impl.dao;

import java.util.List;

import org.driss.ougrimper.consumer.contract.dao.VilleDao;
import org.driss.ougrimper.consumer.impl.rowmapper.site.VilleRM;
import org.driss.ougrimper.model.bean.site.Ville;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class VilleDaoImpl extends AbstractDaoImpl implements VilleDao {

	@Override
	public Ville getVille(Integer villeId) {
		Ville vVille = null;
		String vSQL = "SELECT * FROM ville WHERE id = ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Ville> vRowMapper = new VilleRM();
		
		if (villeId != null) {
			vVille = (Ville) vJdbcTemplate.queryForObject(vSQL, new Object[] { villeId }, vRowMapper);
		}

		return vVille;
	}

	@Override
	public List<Ville> getListVille(String paysNom) {
		String vSQL = "SELECT * FROM public.ville WHERE pays = ?";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		
		RowMapper<Ville> vRowMapper = new VilleRM();
		List<Ville> listVille = vJdbcTemplate.query(vSQL, new Object[] { paysNom }, vRowMapper);
		
		return listVille;
	}

	@Override
	public void addNewVille(Ville vVille) {
		String vSQL = "INSERT INTO public.ville (nom, pays) VALUES (:nom, :pays)";
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		
		vParams.addValue("nom", vVille.getNom());
		vParams.addValue("pays", vVille.getPays().getNom());
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		vJdbcTemplate.update(vSQL, vParams);
	}

}
