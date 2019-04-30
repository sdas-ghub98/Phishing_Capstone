package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Url;
import com.niit.model.UrlAdmin;

@Repository("urlDAOAdmin")
@Transactional
public class UrlAdminDAOImpl implements UrlAdminDAO {

	
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public List<UrlAdmin> ShowURL1() {
	Session session = sessionFactory.getCurrentSession();
	System.out.println("First");
	Query query = session.createQuery("from UrlAdmin");
	System.out.println("Second");
	List<UrlAdmin> listurl = query.list();
	System.out.println("Third");
	return listurl;
		
	}
	@Override
	public boolean addURLAdmin(UrlAdmin url) {
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
	public boolean deleteURLAdmin(UrlAdmin url) {
		try 
		{
			sessionFactory.getCurrentSession().delete(url);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	@Override
	public boolean updateURLAdmin(UrlAdmin url) {
		try 
		{
			sessionFactory.getCurrentSession().update(url);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	@Override
	public UrlAdmin getSupplierById(int url_ID) {
		Session session =sessionFactory.getCurrentSession();
		UrlAdmin url = (UrlAdmin)session.get(UrlAdmin.class,url_ID);
		return url;
		
	}
	
	

}
