package com.dollarsbank.interfaces;

import java.util.Date;

import com.dollarsbank.enums.AccountType;

public interface Account {
	public int getId();
	public void setId(int id);
	public int getCustomerId();
	public void setCustomerId(int customerId);
	public float getAmount();
	public void setAmount(float amount);
	public Date getTimestamp();
	public void setTimestamp(Date timestamp);
	public AccountType getType();
}
