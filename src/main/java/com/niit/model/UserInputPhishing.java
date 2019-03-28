package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserInputPhishing 
{
	@Id
	@GeneratedValue
	private int Sno;
	private String PhishingURL;
	public int getSno() {
		return Sno;
	}
	public void setSno(int sno) {
		Sno = sno;
	}
	public String getPhishingURL() {
		return PhishingURL;
	}
	public void setPhishingURL(String phishingURL) {
		PhishingURL = phishingURL;
	}
}
