package org.driss.ougrimper.consumer.contract.dao;

import org.driss.ougrimper.model.bean.site.Pays;
import org.driss.ougrimper.model.exception.NotFoundException;

public interface PaysDao {
	
	Pays getPays(String paysNom);
	
}
