package org.driss.ougrimper.consumer.impl.rowmapper.utilisateur;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.driss.ougrimper.model.bean.utilisateur.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

public class UtilisateurRM implements RowMapper<Utilisateur> {

	@Override
	public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId(rs.getInt("id"));
		utilisateur.setNom(rs.getString("nom"));
		utilisateur.setPrenom(rs.getString("prenom"));
		utilisateur.setCivilite(rs.getString("civilite"));
		utilisateur.setDateDeNaissance(rs.getDate("date_de_naissance"));
		utilisateur.setEmail(rs.getString("email"));
		utilisateur.setRole(rs.getString("role"));
		utilisateur.setPseudo(rs.getString("pseudo"));
		utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
		return utilisateur;
	}

}
