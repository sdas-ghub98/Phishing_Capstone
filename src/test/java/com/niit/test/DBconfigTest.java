package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.URLDao;
import com.niit.DAO.UrlAdminDAO;
import com.niit.DAO.UserDAO;
import com.niit.DAO.UserInputDao;

/*import com.niit.DAO.CategoryDAO;
import com.niit.DAO.ProductDAO;
import com.niit.DAO.SupplierDAO;*/
//import com.niit.DAO.UserDAO;

import com.niit.model.Url;
import com.niit.model.UrlAdmin;
import com.niit.model.User;
import com.niit.model.UserInputPhishing;
/*import com.niit.model.Category;
import com.niit.model.Products;
import com.niit.model.Supplier;*/
//import com.niit.model.User;

public class DBconfigTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		/*CategoryDAO categoryDAO =(CategoryDAO) context.getBean("categoryDAO");
		
		Category category = new Category();
		category.setCategoryName("Mobile:");
		category.setCategoryDesc("Samsung");
		categoryDAO.addCategory(category);
		System.out.println("Object created nice");
		category.setCategoryName("Mobi12:");
		category.setCategoryDesc("Samsung12");
		categoryDAO.addCategory(category);
		
		UserDAO userDAO =(UserDAO) context.getBean("userDAO");
		
		User user = new User();
		user.setName("Vaibhav");
		user.setEmail("123@gmail");
		user.setPassword("12345");
		user.setPhone_no(123456);
		
		userDAO.addUser(user);
		System.out.println("Object created nice wow");
		
		
SupplierDAO supplierDAO =(SupplierDAO) context.getBean("supplierDAO");
		
		Supplier supplier = new Supplier();
		supplier.setDealer_Name("Manu:");
		supplier.setDealer_desc("Ok:");
		supplier.setDealer_address("Mayur Vihar");
		supplierDAO.addSupplier(supplier);
		System.out.println("Object created nice wow wow");
		*/
		/*ProductDAO productDAO =(ProductDAO) context.getBean("productDAO");
		Products product = new Products();
		product.setProduct_name("Samsung");
		product.setDescription("Mobile");
		product.setProduct_category("Electronics");
		product.setPrice(10000);
		product.setCategoryId(1);
		product.setStock(4);
		product.setSupplierId(1);
		productDAO.addProduct(product);
		System.out.println("nice");*/

		/*URLDao urlDAO = (URLDao) context.getBean("urlDAO");
		
		Url url = new Url();
		url.setAuthority("xyz");
		url.setFile("abc");
		url.setHost("me");
		url.setId(1);
		url.setPath("root");
		url.setPort(2);
		url.setRef("ref");
		url.setProtocol("https");
		url.setQuery("null");
		urlDAO.addURLr(url);
	
		UserInputDao uid = (UserInputDao) context.getBean("uid");
		UserInputPhishing uip = new UserInputPhishing();
		uip.setPhishingURL("hello URL");
		uid.createAndCheckTable(uip);*/
		
		/*boolean res = uid.createAndCheckTable(uip);
		if(res)
			System.out.println("Hello URL pushed!!!");
		else
			System.out.println("Hello URL not pushed!!");*/
		
		/*UserDAO userDAO = (UserDAO) context.getBean("userDAO");
		User user = new User();
		user.setEmail("s.vaibhav1998@gmail.com");
		user.setEnabled(true);
		user.setName("Vaibhav");
		user.setPassword("1234");
		user.setRole("admin");
		user.setUser_id(1);
		userDAO.addUser(user);
		System.out.println("Added User");*/
		
	/*	UrlAdminDAO urlAdminDAO = (UrlAdminDAO) context.getBean("urlDAOAdmin");
		
		UrlAdmin urlAdmin = new UrlAdmin();
		urlAdmin.setUrl("https://www.phishtank.com/");
		urlAdmin.setUrl_ID(1);
		urlAdminDAO.addURLAdmin(urlAdmin);
		*///System.out.println("Added Url");
		
	}

}
