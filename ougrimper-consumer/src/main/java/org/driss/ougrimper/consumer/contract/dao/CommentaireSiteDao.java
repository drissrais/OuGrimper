package org.driss.ougrimper.consumer.contract.dao;

import java.util.List;

import org.driss.ougrimper.model.bean.site.CommentaireSite;

public interface CommentaireSiteDao {
	
	void addNewComment(CommentaireSite commentaireSite);
	List<CommentaireSite> getListCommentaire(Integer siteId);
	List<CommentaireSite> getListCommentaire();
	void deleteCommentairesSite(Integer siteId);

}
