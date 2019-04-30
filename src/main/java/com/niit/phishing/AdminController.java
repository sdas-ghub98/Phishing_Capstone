package com.niit.phishing;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.DAO.UrlAdminDAO;
import com.niit.DAO.UserDAO;
import com.niit.model.UrlAdmin;
import com.niit.model.User;

@Controller
public class AdminController {
	@Autowired
	UserDAO userDAO;
	
	
	@Autowired
	UrlAdminDAO urlDAOAdmin;
	
	boolean f = false;
	
	@RequestMapping(value="/login")
	public String showLoginPage()
	{
		//System.out.println("Hi");
		return "adminlogin";
	}
	
	@RequestMapping("login_success")
	public String loginSuccess(Model m,HttpSession session)
	{
		String page="";
		boolean loggedin = false;
		SecurityContext securitycontext = SecurityContextHolder.getContext();
		Authentication auth = securitycontext.getAuthentication();
		String username = auth.getName();
		
		User user=userDAO.getUserByEmail(username);
		session.setAttribute("user", user);
		
		Collection<GrantedAuthority> roles = (Collection<GrantedAuthority>) auth.getAuthorities();
		for(GrantedAuthority role:roles)
		{
			System.out.println(roles.toString());
			session.setAttribute("role",role.getAuthority());
			if(role.getAuthority().equals("admin"))
			{
				loggedin=true;
				page="AdminHome1";
				session.setAttribute("loggedin",loggedin);
				session.setAttribute("username", username);
			}
		}
		return page;
	}
	
	
	@RequestMapping("/adminmanage")
	public String showadmin(Model m)
	{
		 List<UrlAdmin> listurl = urlDAOAdmin.ShowURL1();
		 m.addAttribute("listUrlAdmin", listurl);
		System.out.println("Four");
		return "AdminHome";
	}
	
	@RequestMapping("/insertUrl")
	public String insertUrl(@RequestParam("url")String Url,Model m) {
		
		f=false;
		UrlAdmin urlAdmin = new UrlAdmin();
		urlAdmin.setUrl(Url);
		urlDAOAdmin.addURLAdmin(urlAdmin);
		 List<UrlAdmin> listurl = urlDAOAdmin.ShowURL1();
		 m.addAttribute("listUrlAdmin", listurl);
		 m.addAttribute("flag", f);
		
		
		return "redirect:/adminmanage";
		
		
		
	}
	@RequestMapping("/j_spring_security_check")
	public String retLogin() {
		return "adminlogin";
	}
	
	@RequestMapping("/deleteUrl/{url_ID}")
	public String deleteUrl(@PathVariable("url_ID")int id,Model m)

	{
		f=false;
		UrlAdmin urlAdmin = urlDAOAdmin.getSupplierById(id);
		urlDAOAdmin.deleteURLAdmin(urlAdmin);
		List<UrlAdmin> listurl = urlDAOAdmin.ShowURL1();
		 m.addAttribute("listUrlAdmin", listurl);
		 m.addAttribute("flag", f);

		
		
		
		return "redirect:/adminmanage";
	}
	
	
		

}
