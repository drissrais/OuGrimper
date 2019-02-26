package org.driss.ougrimper.consumer.impl.dao;

import java.util.List;

import org.driss.ougrimper.consumer.contract.dao.VoieDao;
import org.driss.ougrimper.consumer.impl.rowmapper.site.VoieRM;
import org.driss.ougrimper.model.bean.site.Secteur;
import org.driss.ougrimper.model.bean.site.Voie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class VoieDaoImpl extends AbstractDaoImpl implements VoieDao {

	@Override
	public List<Voie> getListVoie(Secteur secteur) {
		String vSQL = "SELECT * FROM public.voie WHERE secteur_id = ?";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		
		RowMapper<Voie> vRowMapper = new VoieRM();
		List<Voie> listVoie = vJdbcTemplate.query(vSQL, new Object[] { secteur.getId() }, vRowMapper);
		
		return listVoie;
	}

}
