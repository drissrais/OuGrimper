package org.driss.ougrimper.consumer.impl.rowmapper.topo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.driss.ougrimper.model.bean.site.Site;
import org.driss.ougrimper.model.bean.topo.Topo;
import org.driss.ougrimper.model.bean.utilisateur.ProprietaireTopo;
import org.springframework.jdbc.core.RowMapper;

public class TopoRM implements RowMapper<Topo> {

	@Override
	public Topo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Topo vTopo = new Topo();
		vTopo.setId(rs.getInt("id"));
		vTopo.setNom(rs.getString("nom"));
		vTopo.setDescription(rs.getString("description"));
		vTopo.setDisponible(rs.getBoolean("disponible"));
		vTopo.setPlan(rs.getString("plan"));
		
		Integer proprietaireId = rs.getInt("proprietaire_id");
		ProprietaireTopo proprietaire = new ProprietaireTopo();
		proprietaire.setId(proprietaireId);
		vTopo.setProprietaire(proprietaire);
		
		Integer siteId = rs.getInt("site_id");
		Site site = new Site(siteId);
		vTopo.setSite(site);
		
		return vTopo;
	}

}
