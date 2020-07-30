package com.dollarsbank.interfaces;

import java.util.Date;

public interface Customer {
	public Date getTimestamp();
	public void setTimestamp(Date timestamp);
	public int getId();
	public void setId(int id);
	public String getFirstName();
	public void setFirstName(String firstName);
	public String getLastName();
	public void setLastName(String lastName);
	public String getUserName();
	public void setUserName(String userName);
	public String getPassword();
	public void setPassword(String password);
	public String getCountry();
	public void setCountry(String country);
	public String getMobile();
	public void setMobile(String mobile);
}
