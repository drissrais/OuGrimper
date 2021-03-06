package org.driss.ougrimper.consumer.impl.rowmapper.site;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.driss.ougrimper.model.bean.site.Pays;
import org.driss.ougrimper.model.bean.site.Ville;
import org.springframework.jdbc.core.RowMapper;

public class VilleRM implements RowMapper<Ville> {

	@Override
	public Ville mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ville vVille = new Ville();
		vVille.setId(rs.getInt("id"));
		vVille.setNom(rs.getString("nom"));
		
		Integer paysId = rs.getInt("pays");
		Pays vPays = new Pays();
		vPays.setId(paysId);
		vVille.setPays(vPays);
		
		return vVille;
	}

}
