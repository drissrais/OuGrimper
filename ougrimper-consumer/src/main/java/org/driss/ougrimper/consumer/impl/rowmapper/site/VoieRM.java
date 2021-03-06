package org.driss.ougrimper.consumer.impl.rowmapper.site;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.driss.ougrimper.model.bean.site.Secteur;
import org.driss.ougrimper.model.bean.site.Voie;
import org.springframework.jdbc.core.RowMapper;

public class VoieRM implements RowMapper<Voie> {

	@Override
	public Voie mapRow(ResultSet rs, int rowNum) throws SQLException {
		Voie voie = new Voie();
		voie.setId(rs.getInt("id"));
		voie.setNom(rs.getString("nom"));
		voie.setNbLongueur(rs.getInt("nb_longueur"));
		voie.setCotation(rs.getString("cotation"));
		
		Integer secteurId = rs.getInt("secteur_id");
		Secteur vSecteur = new Secteur();
		vSecteur.setId(secteurId);
		voie.setSecteur(vSecteur);
		
		return voie;
	}

}
