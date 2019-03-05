package org.driss.ougrimper.consumer.contract.dao;

import java.util.List;

import org.driss.ougrimper.model.bean.utilisateur.ProprietaireTopo;

public interface ProprietaireTopoDao {
	
	ProprietaireTopo getProprietaireTopo(Integer utilisateurId);
	List<ProprietaireTopo> getListProprietaireTopo();

}
