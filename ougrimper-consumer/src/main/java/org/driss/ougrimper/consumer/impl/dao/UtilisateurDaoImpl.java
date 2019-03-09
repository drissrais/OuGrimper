package org.driss.ougrimper.consumer.impl.dao;

import java.text.SimpleDateFormat;
import java.util.List;

import org.driss.ougrimper.consumer.contract.dao.UtilisateurDao;
import org.driss.ougrimper.consumer.impl.rowmapper.utilisateur.UtilisateurRM;
import org.driss.ougrimper.model.bean.utilisateur.Utilisateur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class UtilisateurDaoImpl extends AbstractDaoImpl implements UtilisateurDao {

	@Override
	public Utilisateur getUtilisateur(String email, String motDePasse) {
		Utilisateur utilisateur = null;
		String vSQL = "SELECT * FROM public.compte_utilisateur WHERE email = ? AND mot_de_passe = ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Utilisateur> vRowMapper = new UtilisateurRM();
		try {
			utilisateur = (Utilisateur) vJdbcTemplate.queryForObject(vSQL, new Object[] { email, motDePasse },
					vRowMapper);
		} catch (Exception ex) {
			return null;
		}
		return utilisateur;
	}

	@Override
	public void insertUtilisateur(Utilisateur utilisateur) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = formatter.format(utilisateur.getDateDeNaissance());

		String vSQL = "INSERT INTO public.compte_utilisateur (nom, prenom, civilite, date_de_naissance, email, role, pseudo, mot_de_passe) VALUES ('"
				+ utilisateur.getNom() + "', '" + utilisateur.getPrenom() + "', '" + utilisateur.getCivilite() + "', '"
				+ strDate + "', '" + utilisateur.getEmail() + "', '" + utilisateur.getRole() + "', '"
				+ utilisateur.getPseudo() + "', '" + utilisateur.getMotDePasse() + "')";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		vJdbcTemplate.update(vSQL);
//		try {
//		} catch (DuplicateKeyException e) {
//			
//		}
	}

	@Override
	public Utilisateur getUtilisateur(Integer id) {
		Utilisateur vUtilisateur = null;
		String vSQL = "SELECT * FROM public.compte_utilisateur WHERE id = ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Utilisateur> vRowMapper = new UtilisateurRM();

		if (id != null) {
			vUtilisateur = (Utilisateur) vJdbcTemplate.queryForObject(vSQL, new Object[] { id }, vRowMapper);
		}

		return vUtilisateur;
	}

	@Override
	public List<Utilisateur> getListUtilisateur() {
		String vSQL = "SELECT * FROM public.compte_utilisateur";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Utilisateur> vRowMapper = new UtilisateurRM();

		List<Utilisateur> listUtilisateur = vJdbcTemplate.query(vSQL, vRowMapper);

		return listUtilisateur;
	}

	@Override
	public void deleteUtilisateur(Integer userId) {
		String vSQL = "DELETE FROM public.compte_utilisateur WHERE id = :id";
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", userId);

		vJdbcTemplate.update(vSQL, vParams);
	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) {
		String vSQL = "UPDATE public.compte_utilisateur "
				+ "SET nom = :nom, prenom = :prenom, civilite = :civilite, date_de_naissance = :date_de_naissance, email = :email, role = :role, pseudo = :pseudo, mot_de_passe = :mot_de_passe WHERE id = :id";

		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		MapSqlParameterSource vParams = new MapSqlParameterSource();

		vParams.addValue("nom", utilisateur.getNom());
		vParams.addValue("prenom", utilisateur.getPrenom());
		vParams.addValue("civilite", utilisateur.getCivilite());
		vParams.addValue("date_de_naissance", utilisateur.getDateDeNaissance());
		vParams.addValue("email", utilisateur.getEmail());
		vParams.addValue("role", utilisateur.getRole());
		vParams.addValue("pseudo", utilisateur.getPseudo());
		vParams.addValue("mot_de_passe", utilisateur.getMotDePasse());
		vParams.addValue("id", utilisateur.getId());

		vJdbcTemplate.update(vSQL, vParams);
	}

}
