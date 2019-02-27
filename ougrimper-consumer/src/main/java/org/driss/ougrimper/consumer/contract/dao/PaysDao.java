package org.driss.ougrimper.consumer.contract.dao;

import org.driss.ougrimper.model.bean.site.Pays;

public interface PaysDao {
	
	Pays getPays(String paysNom);
	
}
