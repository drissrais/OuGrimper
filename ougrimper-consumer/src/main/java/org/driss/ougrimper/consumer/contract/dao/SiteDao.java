package org.driss.ougrimper.consumer.contract.dao;

import java.util.List;

import org.driss.ougrimper.model.bean.site.CommentaireSite;
import org.driss.ougrimper.model.bean.site.Site;

public interface SiteDao {
	
	Site getSite(Integer siteId);
	List<Site> getListSite();
	void addNewComment(Site site, CommentaireSite commentaireSite);
	List<CommentaireSite> getListCommentaire(Integer siteId);
	
}
