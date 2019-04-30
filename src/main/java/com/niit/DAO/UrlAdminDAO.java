package com.niit.DAO;

import java.util.List;

import com.niit.model.Url;
import com.niit.model.UrlAdmin;

public interface UrlAdminDAO {
	public List<UrlAdmin> ShowURL1();
	public boolean addURLAdmin(UrlAdmin url);
	public boolean deleteURLAdmin(UrlAdmin url);
	public boolean updateURLAdmin(UrlAdmin url);
	
	public UrlAdmin getSupplierById(int sup_id);

}
