package com.mindtree.cgis;

import javax.annotation.PostConstruct;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.cgis.daoimp.cgisdb.UserDAO;
import com.mindtree.cgis.entity.CGISUser;

@ContextConfiguration("classpath:/com/mindtree/cgis/DataAccess-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDAOTest {
	@Autowired
	public UserDAO userDao;
	
	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		Assert.assertNotNull("employeeOnboardViewDAO  not wired.",
				userDao);
	}

	@Test
	public void testSimpleProperties() throws Exception {
		Assert.assertNotNull(userDao);
	}

	@Test	
	@Transactional(value = "cgisDbTransactionManager")
	public void testGetUserData() {
		CGISUser user=null;
		user = userDao.get("M1025830");
		System.out.println("CGISUser::"+user);

	}
	


}
