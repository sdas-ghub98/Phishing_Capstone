package com.niit.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.UserInputPhishing;

@Repository("uid")
@Transactional
public class UserInputDaoImpl implements UserInputDao 
{
	@Autowired
	SessionFactory sf;
	UserInputPhishing uipd = null;
	public boolean checkUserInputURL(UserInputPhishing uip)
	{
		boolean flag = false;
		try
		{
			Session s = sf.openSession();
			Criteria ct = s.createCriteria(UserInputPhishing.class);
			ct.add(Restrictions.eqOrIsNull("PhishingURL", uip.getPhishingURL()));
			uipd = (UserInputPhishing) ct.uniqueResult();
			if(uipd != null)
				return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
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
