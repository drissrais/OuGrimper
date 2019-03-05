package org.driss.ougrimper.consumer.impl.dao;

import java.util.List;

import org.driss.ougrimper.consumer.contract.dao.PaysDao;
import org.driss.ougrimper.consumer.impl.rowmapper.site.PaysRM;
import org.driss.ougrimper.model.bean.site.Pays;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class PaysDaoImpl extends AbstractDaoImpl implements PaysDao {

	@Override
	public Pays getPays(Integer paysId) {
		Pays vPays = null;
		String vSQL = "SELECT * FROM pays WHERE id = ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Pays> vRowMapper = new PaysRM();
		
		if (paysId != null) {
			vPays = (Pays) vJdbcTemplate.queryForObject(vSQL, new Object[] { paysId }, vRowMapper);
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

}
