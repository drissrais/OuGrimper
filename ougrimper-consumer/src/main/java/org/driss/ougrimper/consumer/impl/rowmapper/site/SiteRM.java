package org.driss.ougrimper.consumer.impl.rowmapper.site;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.driss.ougrimper.model.bean.site.Pays;
import org.driss.ougrimper.model.bean.site.Site;
import org.driss.ougrimper.model.bean.site.Ville;
import org.springframework.jdbc.core.RowMapper;

public class SiteRM implements RowMapper<Site> {
	
	@Override
	public Site mapRow(ResultSet rs, int rowNum) throws SQLException {
		Site vSite = new Site();
		vSite.setId(rs.getInt("id"));
		vSite.setNom(rs.getString("nom"));
		vSite.setDescription(rs.getString("description"));
		vSite.setLocalite(rs.getString("localite"));
		vSite.setRegion(rs.getString("region"));
		vSite.setPhoto(rs.getString("photo"));
		vSite.setPlan(rs.getString("plan"));
		
		Integer paysId = rs.getInt("pays");
		Pays vPays = new Pays();
		vPays.setId(paysId);
		vSite.setPays(vPays);
		
		Integer villeId = rs.getInt("ville_plus_proche");
		Ville vVille = new Ville();
		vVille.setId(villeId);
		vSite.setVille(vVille);
		
		return vSite;
	}
	
}
