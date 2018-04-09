package com.mindtree.cgis;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String phno;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}

}
