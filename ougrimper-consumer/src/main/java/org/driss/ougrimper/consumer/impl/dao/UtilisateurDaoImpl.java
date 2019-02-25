package org.driss.ougrimper.consumer.impl.dao;

import org.driss.ougrimper.consumer.contract.dao.UtilisateurDao;
import org.driss.ougrimper.consumer.impl.rowmapper.utilisateur.UtilisateurRM;
import org.driss.ougrimper.model.bean.utilisateur.Utilisateur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UtilisateurDaoImpl extends AbstractDaoImpl implements UtilisateurDao {

	@Override
	public Utilisateur getUtilisateur(String email, String motDePasse) {
		Utilisateur utilisateur = null;
		String vSQL = "SELECT * FROM public.compte_utilisateur WHERE email = ? AND mot_de_passe = ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<Utilisateur> vRowMapper = new UtilisateurRM();

		utilisateur = (Utilisateur) vJdbcTemplate.queryForObject(vSQL, new Object[] { email, motDePasse }, vRowMapper);
		return utilisateur;
	}

	@Override
	public void insertUtilisateur(Utilisateur utilisateur) {
		String vSQL = "INSERT INTO public.compte_utilisateur (nom, prenom, civilite, date_de_naissance, email, role, pseudo, mot_de_passe) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
//		if (pVersion.getNumero() == null)
//			throw new Exception("Vous devez indiquer un numéro de version !");

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		vJdbcTemplate.update(vSQL, utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getCivilite(),
				utilisateur.getDateDeNaissance(), utilisateur.getEmail(), utilisateur.getRole(), utilisateur.getPseudo(),
				utilisateur.getMotDePasse());
//		try {
//			
//		} catch (DuplicateKeyException e) {
//			throw new Exception("Une même version du projet existe dèjà !");
//		}

	}

	@Override
	public int lastIndexId() {
		int vMaxId;
		String vSQL = "SELECT MAX(id) FROM public.compte_utilisateur";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		vMaxId = vJdbcTemplate.queryForObject(vSQL, Integer.class);
		return vMaxId;
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

}
