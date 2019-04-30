package com.niit.test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.UserInputDao;
import com.niit.model.UserInputPhishing;

public class InputPhishingUrl {

	static UserInputDao userInputDao;
	
	public static void configure()
	{
		AnnotationConfigApplicationContext con = new AnnotationConfigApplicationContext();
		con.scan("com.niit");
		con.refresh();
		userInputDao = (UserInputDao)con.getBean("uid");
	}
	@Ignore
	@Test
	public void inserttest()
	{
		UserInputPhishing uip = new UserInputPhishing();
		uip.setPhishingURL("hello URL");
		assertTrue("Problem",userInputDao.checkUserInputURL(uip));
		
	}
}
