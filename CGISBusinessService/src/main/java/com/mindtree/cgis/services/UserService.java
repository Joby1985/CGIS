package com.mindtree.cgis.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mindtree.cgis.entity.CGISUser;

public interface UserService {
	public CGISUser getUserByID(String empId);
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException;
}
