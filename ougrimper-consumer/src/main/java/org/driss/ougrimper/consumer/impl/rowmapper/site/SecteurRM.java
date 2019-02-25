package org.driss.ougrimper.consumer.impl.rowmapper.site;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.driss.ougrimper.model.bean.site.Secteur;
import org.driss.ougrimper.model.bean.site.Site;
import org.springframework.jdbc.core.RowMapper;

public class SecteurRM implements RowMapper<Secteur> {

	@Override
	public Secteur mapRow(ResultSet rs, int rowNum) throws SQLException {
		Secteur secteur = new Secteur();
		secteur.setId(rs.getInt("id"));
		secteur.setNom(rs.getString("nom"));
		
		Integer siteId = rs.getInt("site_id");
		Site vSite = new Site();
		vSite.setId(siteId);
		secteur.setSite(vSite);
		
		return secteur;
	}

}
