package org.driss.ougrimper.business.impl.manager;

import org.driss.ougrimper.consumer.contract.DaoFactory;

public abstract class AbstractManager {

	private DaoFactory daoFactory;
	
	protected DaoFactory getDaoFactory() {
		return daoFactory;
	}

	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
}
