package org.driss.ougrimper.consumer.impl.dao;

import java.util.List;

import org.driss.ougrimper.consumer.contract.dao.SiteDao;
import org.driss.ougrimper.consumer.impl.rowmapper.site.SiteRM;
import org.driss.ougrimper.model.bean.site.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao {

	@Override
	public Site getSite(Integer siteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Site> getListSite() {
		String vSQL = "SELECT * FROM public.site";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		RowMapper<Site> vRowMapper = new SiteRM();
		List<Site> vListSite = vJdbcTemplate.query(vSQL, vRowMapper);

		return vListSite;
	}

}
