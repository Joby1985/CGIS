package com.mindtree.cgis.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "USERS")
public class CGISUser  implements java.io.Serializable {

	private static final Logger logger = Logger
			.getLogger(CGISUser.class);
	
	private String name;
	private String userId;
	private String password;
	private String cgisRole;
	private String emplRole;	
	private Date loginTime;
	//private boolean isActive;
	private String isActive;
	

	
	@Id
	@Column(name = "MID")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Column(name = "NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "PASSWD")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "CGIS_ROLE")
	public String getCgisRole() {
		return cgisRole;
	}
	public void setCgisRole(String cgisRole) {
		this.cgisRole = cgisRole;
	}
	
	@Column(name = "EMPL_ROLE")
	public String getEmplRole() {
		return emplRole;
	}
	public void setEmplRole(String emplRole) {
		this.emplRole = emplRole;
	}
	
	@Column(name = "LOGIN_TIME")
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	
	/*@Column(name = "IS_ACTIVE")
	@Type(type="yes_no")
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}*/
	@Column(name = "IS_ACTIVE")
	//@Type(type="yes_no")
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "CGISUser [name=" + name + ", userId=" + userId + ", password="
				+ password + ", cgisRole=" + cgisRole + ", loginTime=" + loginTime
				+ ", isActive=" + isActive + "]";
	}	
}
