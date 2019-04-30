package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.UrlAdminDAO;
import com.niit.model.UrlAdmin;

public class UrlAdminTestCase {

	static UrlAdminDAO urlAdminDAO;
	
	@BeforeClass
	public static void configure()
	{
		AnnotationConfigApplicationContext con = new AnnotationConfigApplicationContext();
		con.scan("com.niit");
		con.refresh();
		urlAdminDAO = (UrlAdminDAO)con.getBean("urlDAOAdmin");
	}
	
	@Ignore
	@Test
	public void inserttest()
	{
		UrlAdmin urlAdmin = new UrlAdmin();
		urlAdmin.setUrl("https://www.phishtank.com/");
		urlAdmin.setUrl_ID(1);
		assertTrue("Problem",urlAdminDAO.addURLAdmin(urlAdmin));
		
		
	}

}
