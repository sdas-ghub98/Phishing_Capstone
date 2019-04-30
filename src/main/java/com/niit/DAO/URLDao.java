package com.niit.DAO;

import java.util.List;

import com.niit.model.Url;

public interface URLDao {
	public boolean addURLr(Url url);
	public List<Url> ShowURL();

}
