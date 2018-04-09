package com.mindtree.cgis;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/emp")
public class EmployeeService {
	
	@Path("/empDetails")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	@GET
	public Employee resource(){
		Employee emp=new Employee();
		emp.setName("joby");
		emp.setId(123);
		emp.setCompany("ics");
		emp.setSal(4522);
		emp.setLocation("blr");
		System.out.println("This is Service side rest service...............");
		
		return emp;
		
	} 

}
