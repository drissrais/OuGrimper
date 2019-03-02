package org.driss.ougrimper.consumer.impl.dao;

import java.util.List;

import org.driss.ougrimper.consumer.contract.dao.VoieDao;
import org.driss.ougrimper.consumer.impl.rowmapper.site.VoieRM;
import org.driss.ougrimper.model.bean.site.Voie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class VoieDaoImpl extends AbstractDaoImpl implements VoieDao {

	@Override
	public List<Voie> getListVoie(Integer secteurId) {
		String vSQL = "SELECT * FROM public.voie WHERE secteur_id = ?";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		
		RowMapper<Voie> vRowMapper = new VoieRM();
		List<Voie> listVoie = vJdbcTemplate.query(vSQL, new Object[] { secteurId }, vRowMapper);
		
		return listVoie;
	}

	@Override
	public Voie getVoie(Integer voieId) {
		String vSQL = "SELECT * FROM public.voie WHERE id = ?";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		
		RowMapper<Voie> vRowMapper = new VoieRM();
		Voie voie = vJdbcTemplate.queryForObject(vSQL, new Object[] { voieId }, vRowMapper);
		
		return voie;
	}

}
