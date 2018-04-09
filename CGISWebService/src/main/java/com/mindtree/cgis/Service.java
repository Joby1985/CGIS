package com.mindtree.cgis;

import javax.ws.rs.QueryParam;



public interface Service {
    
	
	public String resource(@QueryParam(value = "loggedUserName") String loggedUserName);
		
	
}
