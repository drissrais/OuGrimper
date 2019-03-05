package org.driss.ougrimper.consumer.impl.rowmapper.site;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.driss.ougrimper.model.bean.site.Longueur;
import org.driss.ougrimper.model.bean.site.Voie;
import org.springframework.jdbc.core.RowMapper;

public class LongueurRM implements RowMapper<Longueur> {

	@Override
	public Longueur mapRow(ResultSet rs, int rowNum) throws SQLException {
		Longueur longueur = new Longueur();
		longueur.setId(rs.getInt("id"));
		longueur.setVerticalite(rs.getString("verticalite"));
		longueur.setNbPoint(rs.getInt("nb_point"));
		longueur.setCotation(rs.getString("cotation"));
		
		Integer voieId = rs.getInt("voie_id");
		Voie voie = new Voie();
		voie.setId(voieId);
		longueur.setVoie(voie);
		
		return longueur;
	}

}
