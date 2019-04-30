package com.niit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UrlAdmin implements Serializable {
	
	@Id
	@GeneratedValue
	private int url_ID;
	private String url;
	public int getUrl_ID() {
		return url_ID;
	}
	public void setUrl_ID(int url_ID) {
		this.url_ID = url_ID;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
