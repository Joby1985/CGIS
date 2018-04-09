package com.mindtree.cgis;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mindtree.cgis.entity.User;
import com.mindtree.cgis.services.CGISCommonService;

@org.springframework.stereotype.Service
@Path("/rest")
public class ServiceImpl implements Service {
	
	@Autowired
	public CGISCommonService cGISCommonService;
	
	@Path("/ayyappa")
	@Consumes("application/json")
	@Produces("application/json")
	@GET
	public String resource(@QueryParam(value = "loggedUserName") String loggedUserName) {
		System.out.println("successfully calling");
		System.out.println("loggedUserName::::::::"+loggedUserName);
		User us=new User();
		us.setName("Ayyapaa");
		//us.setPhno("121212");		
		
		
		Gson gson = new Gson();
		String json=null;
		json = gson.toJson(us);
		return json;
	}
	
	@Path("/userId")
	@Consumes("application/json")
	@Produces("application/json")
	@GET
	public String getUserDataById(@QueryParam(value = "loggedUserName") String loggedUserName) {
		System.out.println("successfully calling");
		System.out.println("loggedUserName::::::::"+loggedUserName);
		User user = null;
		user = cGISCommonService.getUserByID(loggedUserName);

		
		Gson gson = new Gson();
		String json=null;
		json = gson.toJson(user);
		return json;
	}
	
	//@Consumes({ "application/json;charset=utf-8", "application/xml;charset=utf-8" })
	@Consumes("application/xml")	
	@POST
	@Path(value = "/creport")	
	public Boolean sendCuaReportByEmail(@QueryParam(value = "loggedUserName") String loggedUserName) 
	{
		
		System.out.println("loggedUserName::::::::"+loggedUserName);
		return true;
	}


	
}
