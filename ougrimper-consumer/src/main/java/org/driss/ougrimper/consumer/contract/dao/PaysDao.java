package org.driss.ougrimper.consumer.contract.dao;

import java.util.List;

import org.driss.ougrimper.model.bean.site.Pays;

public interface PaysDao {
	
	Pays getPays(Integer paysId);
	List<Pays> getListPays();
	
}
