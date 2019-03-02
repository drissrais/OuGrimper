package org.driss.ougrimper.consumer.impl.rowmapper.site;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.driss.ougrimper.model.bean.site.CommentaireSite;
import org.driss.ougrimper.model.bean.site.Site;
import org.driss.ougrimper.model.bean.utilisateur.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

public class CommentaireSiteRM implements RowMapper<CommentaireSite> {

	@Override
	public CommentaireSite mapRow(ResultSet rs, int rowNum) throws SQLException {
		CommentaireSite vCommentaireSite = new CommentaireSite();
		vCommentaireSite.setId(rs.getInt("id"));
		
		Integer utilisateurId = rs.getInt("utilisateur_id");
		Utilisateur vUtilisateur = new Utilisateur();
		vUtilisateur.setId(utilisateurId);
		vCommentaireSite.setRedacteur(vUtilisateur);
		
		Integer siteId = rs.getInt("site_id");
		Site vSite = new Site(siteId);
		vCommentaireSite.setSite(vSite);
		
		vCommentaireSite.setContenu(rs.getString("contenu"));
		vCommentaireSite.setDate(rs.getTimestamp("date"));
		
		return vCommentaireSite;
	}

}
