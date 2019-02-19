package org.driss.ougrimper.consumer.impl.dao;

import org.driss.ougrimper.consumer.contract.dao.PaysDao;
import org.driss.ougrimper.consumer.impl.rowmapper.site.PaysRM;
import org.driss.ougrimper.model.bean.site.Pays;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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

}
