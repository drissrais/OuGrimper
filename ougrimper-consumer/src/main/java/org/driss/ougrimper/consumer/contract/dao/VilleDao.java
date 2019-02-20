package org.driss.ougrimper.consumer.contract.dao;

import org.driss.ougrimper.model.bean.site.Ville;
import org.driss.ougrimper.model.exception.NotFoundException;

public interface VilleDao {

	Ville getVille(Integer villeId);
	
}
