package org.driss.ougrimper.consumer.impl.dao;

import java.util.List;

import org.driss.ougrimper.consumer.contract.dao.SiteDao;
import org.driss.ougrimper.consumer.impl.rowmapper.site.CommentaireSiteRM;
import org.driss.ougrimper.consumer.impl.rowmapper.site.SiteRM;
import org.driss.ougrimper.model.bean.site.CommentaireSite;
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
	public void addNewComment(Site site, CommentaireSite commentaireSite) {
		String vSQL = "INSERT INTO public.commentaire_site (utilisateur_id, site_id, contenu, date) VALUES (:utilisateur_id, :site_id, :contenu, :date);";
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		
		vParams.addValue("utilisateur_id", commentaireSite.getRedacteur().getId());
		vParams.addValue("site_id", site.getId());
		vParams.addValue("contenu", commentaireSite.getContenu());
		vParams.addValue("date", commentaireSite.getDate());
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		vJdbcTemplate.update(vSQL, vParams);
	}

	@Override
	public List<CommentaireSite> getListCommentaire(Integer siteId) {
		String vSQL = "SELECT * FROM public.commentaire_site WHERE site_id = ?";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		
		RowMapper<CommentaireSite> vRowMapper = new CommentaireSiteRM();
		List<CommentaireSite> listCommentaire = vJdbcTemplate.query(vSQL, new Object[] { siteId }, vRowMapper);
		
		return listCommentaire;
	}

}
