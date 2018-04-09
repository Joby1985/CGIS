package com.mindtree.cgis.dao;

import java.io.Serializable;

import org.hibernate.SessionFactory;


public abstract class GenericNonPartitionedDao<T, ID extends Serializable> extends GenericHibernateDao<T, ID>{
	
	protected SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
	
	public abstract void setSessionFactory(SessionFactory sessionFactory);

}
