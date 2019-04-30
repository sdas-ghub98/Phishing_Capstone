package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.User;


@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addUser(User user) {
		
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean deleteUser(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}

	}

	@Override
	public User getUserByid(int user_id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			User user = (User)session.get(User.class,user_id);
			session.close();
			return user;
			
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public List<User> userCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByEmail(String username) {
		try {
			Session session = sessionFactory.getCurrentSession();
			User user = session.createQuery("from User where email=:email",User.class).setParameter("email", username).getSingleResult();
	
			return user;
			
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
