package com.modal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Customer{
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="name")
	String name; 
	
	@Column(name="email")
	String email;
	
	@Column(name="mobile")
	String mobile;
		
	@Column(name="alt_mobile")
	String alt_mobile;
	
	@Column(name="co_ord")
	String co_ord;

	@Column(name="district")
	String district;

	@Column(name="state")
	String state;
	
	@Column(name="date")
	Date date;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAlt_mobile() {
		return alt_mobile;
	}
	public void setAlt_mobile(String alt_mobile) {
		this.alt_mobile = alt_mobile;
	}
	public String getCo_ord() {
		return co_ord;
	}
	public void setCo_ord(String co_ord) {
		this.co_ord = co_ord;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}