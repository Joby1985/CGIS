package com.mindtree.cgis.daoimp.cgisdb;

import org.springframework.stereotype.Repository;

import com.mindtree.cgis.dao.CGISDbGenericHibernateDao;
import com.mindtree.cgis.entity.CGISUser;

@Repository
public class UserDAO extends
		CGISDbGenericHibernateDao<CGISUser, String> {
	
	
}
