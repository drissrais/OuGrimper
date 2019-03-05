package org.driss.ougrimper.consumer.impl.dao;

import org.driss.ougrimper.consumer.contract.dao.LongueurDao;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class LongueurDaoImpl extends AbstractDaoImpl implements LongueurDao {

	@Override
	public void deleteLongueursVoie(Integer voieId) {
		String vSQL = "DELETE FROM public.longueur WHERE voie_id = :voie_id";
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("voie_id", voieId);
		
		vJdbcTemplate.update(vSQL, vParams);
	}

}
