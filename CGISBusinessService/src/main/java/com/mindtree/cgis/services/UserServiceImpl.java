package com.mindtree.cgis.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mindtree.cgis.entity.CGISUser;

@Service
public class UserServiceImpl implements UserService {

	public CGISUser getUserByID(String empId) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
