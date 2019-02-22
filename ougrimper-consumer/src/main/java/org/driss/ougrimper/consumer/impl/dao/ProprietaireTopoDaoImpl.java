package org.driss.ougrimper.consumer.impl.dao;

import org.driss.ougrimper.consumer.contract.dao.ProprietaireTopoDao;
import org.driss.ougrimper.model.bean.utilisateur.ProprietaireTopo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProprietaireTopoDaoImpl extends AbstractDaoImpl implements ProprietaireTopoDao {

	@Override
	public ProprietaireTopo getProprietaireTopo(Integer utilisateurId) {
		ProprietaireTopo vProprietaireTopo = null;
		String vSQL = "SELECT * FROM proprietaire_topo WHERE utilisateur_id = ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		if (utilisateurId != null) {
			vProprietaireTopo = (ProprietaireTopo) vJdbcTemplate.queryForObject(vSQL, new Object[] { utilisateurId },
					new BeanPropertyRowMapper<>(ProprietaireTopo.class));
		}

		return vProprietaireTopo;
	}

}
