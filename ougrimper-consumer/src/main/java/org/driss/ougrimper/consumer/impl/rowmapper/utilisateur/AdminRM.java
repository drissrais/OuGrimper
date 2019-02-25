package org.driss.ougrimper.consumer.impl.rowmapper.utilisateur;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.driss.ougrimper.model.bean.utilisateur.Admin;
import org.springframework.jdbc.core.RowMapper;

public class AdminRM implements RowMapper<Admin> {

	@Override
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		Admin admin = new Admin();
		admin.setId(rs.getInt("id"));
		admin.setNom(rs.getString("nom"));
		admin.setPrenom(rs.getString("prenom"));
		admin.setCivilite(rs.getString("civilite"));
		admin.setDateDeNaissance(rs.getDate("date_de_naissance"));
		admin.setEmail(rs.getString("email"));
		admin.setRole(rs.getString("role"));
		admin.setPseudo(rs.getString("pseudo"));
		admin.setMotDePasse(rs.getString("mot_de_passe"));
		return admin;
	}

}
