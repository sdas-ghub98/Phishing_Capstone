package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.UserDAO;
import com.niit.model.User;

public class UserTestCase {

	static UserDAO userDAO;
	
	@BeforeClass
	public static void configure()
	{
		AnnotationConfigApplicationContext con = new AnnotationConfigApplicationContext();
		con.scan("com.niit");
		con.refresh();
		userDAO = (UserDAO) con.getBean("userDAO");
	}
	
	@Ignore
	@Test
	public void inserttest()
	{
		User user = new User();
		user.setEmail("s.vaibhav1998@gmail.com");
		user.setEnabled(true);
		user.setName("Vaibhav");
		user.setPassword("1234");
		user.setRole("admin");
		user.setUser_id(1);
		assertTrue("Problem",userDAO.addUser(user));
		
		
	}
	
	
	
}
