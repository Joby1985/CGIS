package com.mindtree.cgis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.cgis.daoimp.cgisdb.UserDAO;
import com.mindtree.cgis.entity.CGISUser;;

@Service

public class CGISCommonService {

	@Autowired
	public UserDAO userDAO;

	
	
	public UserDAO getUserDAO() {
		return userDAO;
	}



	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}


	@Transactional(value = "cgisDbTransactionManager")
	public CGISUser getUserByID(String empId) {
		CGISUser user = null;
		System.out.println("getUserByID.. in Service class...");
		user = userDAO.get(empId);

		return user;

	}
}
