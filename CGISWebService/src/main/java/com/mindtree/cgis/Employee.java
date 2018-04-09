package com.mindtree.cgis;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {

	private String name;
	private String company;
	private int id;
	private int sal;
	private String location;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", company=" + company + ", id=" + id
				+ ", sal=" + sal + ", location=" + location + "]";
	}
	
	
}