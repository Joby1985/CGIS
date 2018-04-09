package com.mindtree.cgis.dao;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class CGISDbGenericHibernateDao<T, ID extends Serializable> extends GenericNonPartitionedDao<T, ID> {

	@Autowired
	public void setSessionFactory(@Qualifier("cgisDbSessionFactory") SessionFactory sessionFactory){
		System.out.println("sessionFactory==="+sessionFactory.getCurrentSession()+" :: "+this.getClass().getName());
		this.sessionFactory = sessionFactory;
		
	}

}
