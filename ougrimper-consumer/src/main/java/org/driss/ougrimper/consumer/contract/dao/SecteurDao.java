package org.driss.ougrimper.consumer.contract.dao;

import java.util.List;

import org.driss.ougrimper.model.bean.site.Secteur;

public interface SecteurDao {
	
	List<Secteur> getListSecteur(Integer siteId);
	Secteur getSecteur(Integer secteurId);

}
