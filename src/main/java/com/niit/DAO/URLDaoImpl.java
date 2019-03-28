package com.niit.DAO;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Url;


@Repository("urlDAO")
@Transactional
public class URLDaoImpl implements URLDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addURLr(Url url) {
		try 
		{
			sessionFactory.getCurrentSession().save(url);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
