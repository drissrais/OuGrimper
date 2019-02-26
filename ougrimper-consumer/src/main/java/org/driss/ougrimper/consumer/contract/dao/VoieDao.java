package org.driss.ougrimper.consumer.contract.dao;

import java.util.List;

import org.driss.ougrimper.model.bean.site.Secteur;
import org.driss.ougrimper.model.bean.site.Voie;

public interface VoieDao {
	
	List<Voie> getListVoie(Secteur secteur);

}
