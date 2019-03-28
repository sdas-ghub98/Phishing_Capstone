package com.niit.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.niit.model.UserInputPhishing;

public class UserInputDaoImpl implements UserInputDao 
{
	public boolean checkUserInputURL(UserInputPhishing uip)
	{
		try
		{
			Class.forName("org.h2.Driver");
			String url = "jdbc:h2:tcp://localhost/~/test";
			String user = "sa";
			String pass = "";
			Connection con = DriverManager.getConnection(url,user,pass);
			String sql = "Select PhishingURL from UserInputPhishing where PhishingURL = "+ uip.getPhishingURL();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ps.close();
			if(rs.getString(2) != null)
				return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
