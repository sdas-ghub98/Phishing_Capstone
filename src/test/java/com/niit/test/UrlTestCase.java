package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.URLDao;
import com.niit.model.Url;

public class UrlTestCase {
	
	static URLDao urlDao;
	
	
	@BeforeClass
	public static void configure()
	{
		AnnotationConfigApplicationContext con = new AnnotationConfigApplicationContext();
		con.scan("com.niit");
		con.refresh();
		
		urlDao=(URLDao)con.getBean("urlDAO");
	}
	
	@Ignore
	@Test
	public void inserttest()
	{
		Url url = new Url();
		url.setAuthority("xyz");
		url.setFile("abc");
		url.setHost("me");
		url.setId(1);
		url.setPath("root");
		url.setPort(2);
		url.setRef("ref");
		url.setProtocol("https");
		url.setQuery("null");
		assertTrue("Problem",urlDao.addURLr(url));
	}
	
}
