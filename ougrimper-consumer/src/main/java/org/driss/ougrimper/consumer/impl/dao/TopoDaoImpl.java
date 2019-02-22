package org.driss.ougrimper.consumer.impl.dao;

import java.util.List;

import org.driss.ougrimper.consumer.contract.dao.TopoDao;
import org.driss.ougrimper.consumer.impl.rowmapper.topo.TopoRM;
import org.driss.ougrimper.model.bean.topo.Topo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao {

	@Override
	public Topo getTopo(Integer topoId) {
		Topo topo = null;
		String vSQL = "SELECT * FROM public.topo WHERE id = ?";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		
		RowMapper<Topo> vRowMapper = new TopoRM();
		topo = (Topo) vJdbcTemplate.queryForObject(vSQL, new Object[] { topoId }, vRowMapper);
		return topo;
	}

	@Override
	public List<Topo> getListTopo() {
		String vSQL = "SELECT * FROM public.topo";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		RowMapper<Topo> vRowMapper = new TopoRM();
		List<Topo> vListTopo = vJdbcTemplate.query(vSQL, vRowMapper);

		return vListTopo;
	}

}
