package com.mindtree.cgis.services;

import javax.annotation.PostConstruct;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.cgis.entity.CGISUser;

@ContextConfiguration("classpath:/com/mindtree/cgis/CGISBusinessServiceConfigurationTests-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CGISCommonServiceTest {
	@Autowired
	public CGISCommonService  commonService;
	
	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		Assert.assertNotNull("employeeOnboardViewDAO  not wired.",
				commonService);
	}

	@Test
	public void testSimpleProperties() throws Exception {
		Assert.assertNotNull(commonService);
	}

	@Test	
	public void testGetUserData() {
		CGISUser user=null;
		String empId="M1025830";
		user = commonService.getUserByID(empId);
		System.out.println("User::"+user);

	}
	


}
