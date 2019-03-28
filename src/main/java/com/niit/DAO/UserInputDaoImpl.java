package com.niit.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.UserInputPhishing;

@Repository("uid")
@Transactional
public class UserInputDaoImpl implements UserInputDao 
{
	@Autowired
	SessionFactory sf;
	public boolean checkUserInputURL(UserInputPhishing uip)
	{
		try
		{
			Session session = sf.openSession();
			Query q = session.createQuery("Select PhishingURL from UserInputPhishing where PhishingURL="+uip.getPhishingURL());
			if(q != null )
				return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public boolean createAndCheckTable(UserInputPhishing uip)
	{
		try
		{
			sf.getCurrentSession().save(uip);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
