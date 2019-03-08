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
		String vSQL = "SELECT * FROM public.site WHERE id = :id";
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", siteId);

		RowMapper<Site> vRowMapper = new SiteRM();
		site = (Site) vJdbcTemplate.queryForObject(vSQL, vParams, vRowMapper);

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
		String vSQL = "";
		if (site.getPlan() == null)
			vSQL = "UPDATE public.site "
					+ "SET nom = :nom, description = :description, region = :region, localite = :localite , ville_plus_proche = :ville_plus_proche, pays = :pays WHERE id = :id";
		else
			vSQL = "UPDATE public.site "
					+ "SET nom = :nom, description = :description, region = :region, localite = :localite, plan = :plan, ville_plus_proche = :ville_plus_proche, pays = :pays WHERE id = :id";
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		MapSqlParameterSource vParams = new MapSqlParameterSource();

		vParams.addValue("nom", site.getNom());
		vParams.addValue("description", site.getDescription());
		vParams.addValue("region", site.getRegion());
		vParams.addValue("localite", site.getLocalite());
		
		if (site.getPlan() != null)
			vParams.addValue("plan", site.getPlan());
		
		vParams.addValue("ville_plus_proche", site.getVille().getId());
		vParams.addValue("pays", site.getPays().getId());
		vParams.addValue("id", site.getId());

		vJdbcTemplate.update(vSQL, vParams);
	}

	@Override
	public void addNewSite(Site site) {
		String vSQL = "";
		if (site.getPhoto() == null && site.getPlan() == null) {
			vSQL = "INSERT INTO public.site (nom, description, localite, region, pays, ville_plus_proche) VALUES (:nom, :description, :localite, :region, :pays, :ville_plus_proche)";
		} else if (site.getPhoto() != null && site.getPlan() == null) {
			vSQL = "INSERT INTO public.site (nom, description, localite, region, photo, pays, ville_plus_proche) VALUES (:nom, :description, :localite, :region, :photo, :pays, :ville_plus_proche)";
		} else if (site.getPhoto() == null && site.getPlan() != null) {
			vSQL = "INSERT INTO public.site (nom, description, localite, region, plan, pays, ville_plus_proche) VALUES (:nom, :description, :localite, :region, :plan, :pays, :ville_plus_proche)";
		} else {
			vSQL = "INSERT INTO public.site (nom, description, localite, region, photo, plan, pays, ville_plus_proche) VALUES (:nom, :description, :localite, :region, :photo, :plan, :pays, :ville_plus_proche)";
		}
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		MapSqlParameterSource vParams = new MapSqlParameterSource();

		vParams.addValue("nom", site.getNom());
		vParams.addValue("description", site.getDescription());
		vParams.addValue("localite", site.getLocalite());
		vParams.addValue("region", site.getRegion());
		
		if (site.getPhoto() != null && site.getPlan() != null) {
			vParams.addValue("photo", site.getPhoto());
			vParams.addValue("plan", site.getPlan());
		} 
		if (site.getPhoto() != null && site.getPlan() == null) {
			vParams.addValue("photo", site.getPhoto());
		} 
		if (site.getPhoto() == null && site.getPlan() != null) {
			vParams.addValue("plan", site.getPlan());
		}
		
		vParams.addValue("pays", site.getPays().getId());
		vParams.addValue("ville_plus_proche", site.getVille().getId());

		vJdbcTemplate.update(vSQL, vParams);
	}

	@Override
	public void deleteSite(Integer siteId) {
		String vSQL = "DELETE FROM public.site WHERE id = :id";
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", siteId);
		
		vJdbcTemplate.update(vSQL, vParams);
	}

	@Override
	public List<Site> getListSitePays(Integer paysId) {
		String vSQL = "SELECT * FROM public.site WHERE pays = :pays";
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("pays", paysId);

		RowMapper<Site> vRowMapper = new SiteRM();
		List<Site> vListSite = vJdbcTemplate.query(vSQL, vParams, vRowMapper);

		return vListSite;
	}

	@Override
	public List<Site> getListSiteVille(Integer villeId) {
		String vSQL = "SELECT * FROM public.site WHERE ville_plus_proche = :ville_plus_proche";
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("ville_plus_proche", villeId);

		RowMapper<Site> vRowMapper = new SiteRM();
		List<Site> vListSite = vJdbcTemplate.query(vSQL, vParams, vRowMapper);

		return vListSite;
	}

}
