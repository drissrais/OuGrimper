package org.driss.ougrimper.consumer.impl.dao;

import java.util.List;

import org.driss.ougrimper.consumer.contract.dao.SecteurDao;
import org.driss.ougrimper.consumer.impl.rowmapper.site.SecteurRM;
import org.driss.ougrimper.model.bean.site.Secteur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class SecteurDaoImpl extends AbstractDaoImpl implements SecteurDao {

	@Override
	public List<Secteur> getListSecteur(Integer siteId) {
		String vSQL = "SELECT * FROM public.secteur WHERE site_id = ?";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		
		RowMapper<Secteur> vRowMapper = new SecteurRM();
		List<Secteur> listSecteur = vJdbcTemplate.query(vSQL, new Object[] { siteId }, vRowMapper);
		
		return listSecteur;
	}

	@Override
	public Secteur getSecteur(Integer secteurId) {
		String vSQL = "SELECT * FROM public.secteur WHERE id = ?";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		
		RowMapper<Secteur> vRowMapper = new SecteurRM();
		Secteur vSecteur = vJdbcTemplate.queryForObject(vSQL, new Object[] { secteurId }, vRowMapper);
		
		return vSecteur;
	}

	@Override
	public void deleteSecteursSite(Integer siteId) {
		String vSQL = "DELETE FROM public.secteur WHERE site_id = :site_id";
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("site_id", siteId);
		
		vJdbcTemplate.update(vSQL, vParams);
	}

}
