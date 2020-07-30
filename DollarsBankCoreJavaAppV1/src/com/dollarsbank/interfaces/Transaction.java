package com.dollarsbank.interfaces;

import java.util.Date;

import com.dollarsbank.enums.AccountType;


public interface Transaction {
	public AccountType getType();
	public void setType(AccountType type);
	public int getId();
	public void setId(int id);
	public int getUserId();
	public void setUserId(int userId);
	public int getAccountId();
	public void setAccountId(int accountId);
	public float getAmount();
	public void setAmount(float amount);
	public float getStartAmount();
	public void setStartAmount(float startAmount);
	public float getEndAmount();
	public void setEndAmount(float endAmount);
	public Date getTimestamp();
	public void setTimestamp(Date timestamp);
}
