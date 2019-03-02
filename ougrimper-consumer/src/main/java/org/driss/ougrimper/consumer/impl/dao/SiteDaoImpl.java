package org.driss.ougrimper.consumer.impl.dao;

import java.util.List;

import org.driss.ougrimper.consumer.contract.dao.SiteDao;
import org.driss.ougrimper.consumer.impl.rowmapper.site.SiteRM;
import org.driss.ougrimper.model.bean.site.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao {

	@Override
	public Site getSite(Integer siteId) {
		Site site = null;
		String vSQL = "SELECT * FROM public.site WHERE id = ?";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		RowMapper<Site> vRowMapper = new SiteRM();
		site = (Site) vJdbcTemplate.queryForObject(vSQL, new Object[] { siteId }, vRowMapper);

		return site;
	}

	@Override
	public List<Site> getListSite() {
		String vSQL = "SELECT * FROM public.site";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		RowMapper<Site> vRowMapper = new SiteRM();
		List<Site> vListSite = vJdbcTemplate.query(vSQL, vRowMapper);

		return vListSite;
	}

	@Override
	public void updateSite(Site site) {
		String vSQL = "UPDATE public.site " + 
				"SET nom = :nom, description = :description, region = :region, localite = :localite, photo = :photo, plan = :plan, ville_plus_proche = :ville_plus_proche, pays_nom = :pays_nom WHERE id = :id";
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		
		vParams.addValue("nom", site.getNom());
		vParams.addValue("description", site.getDescription());
		vParams.addValue("region", site.getRegion());
		vParams.addValue("localite", site.getLocalite());
		vParams.addValue("photo", site.getPhoto());
		vParams.addValue("plan", site.getPlan());
		vParams.addValue("ville_plus_proche", site.getVille().getId());
		vParams.addValue("pays_nom", site.getPays().getNom());
		vParams.addValue("id", site.getId());

		vJdbcTemplate.update(vSQL, vParams);
	}

}
