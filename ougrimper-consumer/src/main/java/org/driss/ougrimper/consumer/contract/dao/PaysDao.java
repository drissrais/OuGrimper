package org.driss.ougrimper.consumer.contract.dao;

import java.util.List;

import org.driss.ougrimper.model.bean.site.Pays;

public interface PaysDao {
	
	Pays getPays(String paysNom);
	List<Pays> getListPays();
	void addNewPays(Pays vPays);
	
}
