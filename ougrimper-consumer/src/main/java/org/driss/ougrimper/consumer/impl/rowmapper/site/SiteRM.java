package org.driss.ougrimper.consumer.impl.rowmapper.site;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Named;

import org.driss.ougrimper.consumer.contract.dao.PaysDao;
import org.driss.ougrimper.consumer.contract.dao.VilleDao;
import org.driss.ougrimper.model.bean.site.Pays;
import org.driss.ougrimper.model.bean.site.Site;
import org.driss.ougrimper.model.bean.site.Ville;
import org.springframework.jdbc.core.RowMapper;

@Named
public class SiteRM implements RowMapper<Site> {

	@Inject
	private PaysDao paysDao;
	
	@Inject
	private VilleDao villeDao;

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
		
		String paysNom = rs.getString("pays_nom");
		Pays vPays = paysDao.getPays(paysNom);
		vSite.setPays(vPays);
		
		Integer villeId = rs.getInt("ville_plus_proche");
		Ville vVille = villeDao.getVille(villeId);
		vSite.setVillePlusProche(vVille);
		
		return vSite;
	}
	
}
