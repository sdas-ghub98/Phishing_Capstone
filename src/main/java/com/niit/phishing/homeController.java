package com.niit.phishing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

//import java.net.MalformedURLException;
//import java.net.URL;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.niit.DAO.URLDao;
import com.niit.DAO.UserInputDao;
import com.niit.model.Url;
import com.niit.model.UserInputPhishing;
//import JavaPythonIntegration.p1.Caller;


@Controller
public class homeController {
	
	@Autowired
	URLDao urlDAO;
	@Autowired
	UserInputDao uid;
	
	@RequestMapping("/")
	public String HomePage(Model m)
	{
		return "index";
	}
	
	@RequestMapping("/url2")
	public String ForwardPage(@RequestParam("url") String url, Model m) throws MalformedURLException 
	{
			/*URL aURL = new URL(url);
			String protocol = aURL.getProtocol();
			String authority = aURL.getAuthority();
			String host = aURL.getHost();
			int port = aURL.getPort();
			String path = aURL.getPath();
			String query = aURL.getQuery();
			String filename = aURL.getFile();
			String ref = aURL.getRef();
			
			System.out.println("protocol = "+protocol);
	        System.out.println("authority = " + aURL.getAuthority());
	        System.out.println("host = " + aURL.getHost());
	        System.out.println("port = " + aURL.getPort());
	        System.out.println("path = " + aURL.getPath());
	        System.out.println("query = " + aURL.getQuery());
	        System.out.println("filename = " + aURL.getFile());
	        System.out.println("ref = " + aURL.getRef());
		
		
		Url url1 = new Url();
	    url1.setAuthority(authority);
		url1.setFile(filename);
		url1.setHost(host);
		url1.setPath(path);
		url1.setPort(port);
		url1.setProtocol(protocol);
		url1.setQuery(query);
		url1.setRef(ref);
		urlDAO.addURLr(url1);*/
		
		//-------------------------------------- JAVA DATABASE CROSSCHECKING CODE --------------------------------------//
		boolean resHQLDB = false;
		UserInputPhishing uip = new UserInputPhishing();
		uip.setPhishingURL(url);
		try
		{
			resHQLDB = uid.checkUserInputURL(uip);
			if(resHQLDB == true)
			{
				System.out.println("Java says : It is a phishing website!!");
				m.addAttribute("Java",true);
			}
			else
			{
				System.out.println("Java says : It is not a phishing website!!");
				m.addAttribute("Java",false);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Java crashed somewhere in between... X(");	
		}
		//-------------------------------------- PYTHON CALLING CODE --------------------------------------//
		/*//String filePath = (String) request.getSession().getServletContext().getRealPath("/");
		//System.setProperty("user.dir","/");
		//Path pt=Paths.get("/python");
		//System.out.println(pt.toString());
				
		//System.out.println(filePath);
			
				try 
				{
					//System.out.println("Level 1");
					String s2 = "python index.py "+ url;
					//String[] s3 = new String[] {"cmd.exe","/c",s2};
					//System.out.println(s2);
					Process p = Runtime.getRuntime().exec(s2);
					//Process p = Runtime.getRuntime().load("D:\\Eclipse Projects\\index.py");
					//System.out.println("Level 2");
					BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
					System.out.println(in.read());
					int ret = in.read();
					//ret = in.read();
					System.out.println("Value : " + ret);
					if(ret == 91)	
					{
						System.out.println("Python says it is not a phishing website");
						m.addAttribute("Python", false);
					}
					else if(ret == 85)
					{
						System.out.println("Python says it is a phishing website");
						m.addAttribute("Python", true);
					}
					//System.out.println("Level 5");
				}
				catch(Exception e)
				{
					System.out.println("Python crashed somewhere in between... X(");
					e.printStackTrace();
				}
*/		
		//-------------------------------------- FILE WRITER CODE --------------------------------------// 
				/*try
				{
					FileWriter f0 = new FileWriter("file1.txt");
					BufferedWriter bw = new BufferedWriter(f0);
					bw.write(url);
					bw.close();
					System.out.println("File created!!");
					f0.close();
				}
				catch(Exception e)
				{
					System.out.println("Could not create and write into file...");
				}*/
		m.addAttribute("UserInput", url);
		return "results";
	}
	
	/*@RequestMapping("/results")
	public String showUrl(Model m) {
		
		List<Url> listurl = urlDAO.ShowURL();
		m.addAttribute("url", listurl);
	
		return "results";
	}*/
}