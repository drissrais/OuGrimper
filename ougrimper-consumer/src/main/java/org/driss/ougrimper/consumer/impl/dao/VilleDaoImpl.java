package org.driss.ougrimper.consumer.impl.dao;

import org.driss.ougrimper.consumer.contract.dao.VilleDao;
import org.driss.ougrimper.consumer.impl.rowmapper.site.VilleRM;
import org.driss.ougrimper.model.bean.site.Ville;
import org.driss.ougrimper.model.exception.NotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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

}
