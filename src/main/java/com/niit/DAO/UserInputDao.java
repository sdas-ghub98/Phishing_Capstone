package com.niit.DAO;

import com.niit.model.UserInputPhishing;

public interface UserInputDao 
{
	public boolean checkUserInputURL(UserInputPhishing uip);
}