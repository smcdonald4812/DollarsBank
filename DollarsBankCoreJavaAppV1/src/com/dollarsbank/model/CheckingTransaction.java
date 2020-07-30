package com.dollarsbank.model;

import java.util.Date;

import com.dollarsbank.enums.AccountType;
import com.dollarsbank.interfaces.Transaction;

public class CheckingTransaction implements Transaction {
	private int id, userId, accountId;
	private float amount, startAmount, endAmount;
	private AccountType type = AccountType.CHECKING;
	private Date timestamp;
	public void setType(AccountType type) {
		this.type = type;
	}
	public AccountType getType() {
		return type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public float getStartAmount() {
		return startAmount;
	}
	public void setStartAmount(float startAmount) {
		this.startAmount = startAmount;
	}
	public float getEndAmount() {
		return endAmount;
	}
	public void setEndAmount(float endAmount) {
		this.endAmount = endAmount;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
