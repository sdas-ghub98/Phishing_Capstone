package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

	@Override
	public List<Url> ShowURL() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Url");
		List<Url> listurl = query.list();
		return listurl;
	}
}
