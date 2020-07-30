package com.dollarsbank.model;

import java.util.Date;

import com.dollarsbank.enums.AccountType;
import com.dollarsbank.interfaces.Account;

public class SavingsAccount implements Account{
	private int id, customerId;
	private float amount;
	private AccountType type = AccountType.SAVINGS;
	private Date timestamp;
	public AccountType getType() {
		return type;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
}
