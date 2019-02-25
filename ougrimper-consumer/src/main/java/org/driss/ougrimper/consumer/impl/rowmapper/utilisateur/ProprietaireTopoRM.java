package org.driss.ougrimper.consumer.impl.rowmapper.utilisateur;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.driss.ougrimper.model.bean.utilisateur.ProprietaireTopo;
import org.springframework.jdbc.core.RowMapper;

public class ProprietaireTopoRM implements RowMapper<ProprietaireTopo> {

	@Override
	public ProprietaireTopo mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProprietaireTopo proprietaireTopo = new ProprietaireTopo();
		proprietaireTopo.setId(rs.getInt("id"));
		proprietaireTopo.setNom(rs.getString("nom"));
		proprietaireTopo.setPrenom(rs.getString("prenom"));
		proprietaireTopo.setCivilite(rs.getString("civilite"));
		proprietaireTopo.setDateDeNaissance(rs.getDate("date_de_naissance"));
		proprietaireTopo.setEmail(rs.getString("email"));
		proprietaireTopo.setRole(rs.getString("role"));
		proprietaireTopo.setPseudo(rs.getString("pseudo"));
		proprietaireTopo.setMotDePasse(rs.getString("mot_de_passe"));
		return proprietaireTopo;
	}

}
