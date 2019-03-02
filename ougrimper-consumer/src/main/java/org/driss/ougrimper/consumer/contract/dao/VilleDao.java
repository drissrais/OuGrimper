package org.driss.ougrimper.consumer.contract.dao;

import java.util.List;

import org.driss.ougrimper.model.bean.site.Ville;

public interface VilleDao {

	Ville getVille(Integer villeId);
	List<Ville> getListVille(String paysNom);
	void addNewVille(Ville vVille);
	
}
