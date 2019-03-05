package org.driss.ougrimper.consumer.impl.dao;

import java.util.List;

import org.driss.ougrimper.consumer.contract.dao.ProprietaireTopoDao;
import org.driss.ougrimper.consumer.impl.rowmapper.utilisateur.ProprietaireTopoRM;
import org.driss.ougrimper.model.bean.utilisateur.ProprietaireTopo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class ProprietaireTopoDaoImpl extends AbstractDaoImpl implements ProprietaireTopoDao {

	@Override
	public ProprietaireTopo getProprietaireTopo(Integer proprietaireId) {
		ProprietaireTopo vProprietaireTopo = null;
		String vSQL = "SELECT * FROM compte_utilisateur WHERE id = ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<ProprietaireTopo> vRowMapper = new ProprietaireTopoRM();

		if (proprietaireId != null) {
			vProprietaireTopo = (ProprietaireTopo) vJdbcTemplate.queryForObject(vSQL, new Object[] { proprietaireId },
					vRowMapper);
		}

		return vProprietaireTopo;
	}

	@Override
	public List<ProprietaireTopo> getListProprietaireTopo() {
		String vSQL = "SELECT * FROM public.compte_utilisateur WHERE role = 'topo_owner'";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		RowMapper<ProprietaireTopo> vRowMapper = new ProprietaireTopoRM();
		List<ProprietaireTopo> vListProprietaireTopo = vJdbcTemplate.query(vSQL, vRowMapper);
		
		return vListProprietaireTopo;
	}

}
