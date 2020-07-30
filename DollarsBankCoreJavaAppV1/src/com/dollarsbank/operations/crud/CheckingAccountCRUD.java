package com.dollarsbank.operations.crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.dollarsbank.connections.ConnectionFactory;
import com.dollarsbank.enums.AccountType;
import com.dollarsbank.interfaces.Account;
import com.dollarsbank.model.CheckingAccount;
import com.dollarsbank.operations.AccountOps;

public class CheckingAccountCRUD implements AccountOps<Account>{
	@Override
	public Account get(int custId) {
		Account a = new CheckingAccount();
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("SELECT * FROM accounts WHERE customerId=? AND visible=1 AND type='CHECKING'");
			ps.setInt(1, custId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				a.setId(rs.getInt("id"));
				a.setCustomerId(rs.getInt("customerId"));
				a.setAmount(rs.getFloat("amount"));
				a.setTimestamp(rs.getTimestamp("dateCreated"));
			}
			return a;
		} catch(SQLException e) {
			System.out.println("issue with get operation in AccountCRUD");
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public Vector<Account> getAll() {
		Vector<Account> av = new Vector<>();
		try {
			ResultSet rs = ConnectionFactory.getConnection().createStatement().executeQuery("SELECT * FROM accounts WHERE visible=1");
			while(rs.next()) {
				Account a = new CheckingAccount();
				a.setId(rs.getInt("id"));
				a.setCustomerId(rs.getInt("customerId"));
				a.setAmount(rs.getFloat("amount"));
				a.setTimestamp(rs.getTimestamp("dateCreated"));
				av.add(a);
			}
			return av;
		} catch(SQLException e) {
			System.out.println("issue with getAll operation in AccountCRUD");
			e.printStackTrace();
		}
		return av;
	}
	
	@Override
	public Vector<Account> getAll(int custId) {
		Vector<Account> av = new Vector<>();
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("SELECT * FROM account WHERE visible=1 AND type='CHECKING' AND customerId=?");
			ps.setInt(1, custId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Account a = new CheckingAccount();
				a.setId(rs.getInt("id"));
				a.setCustomerId(rs.getInt("customerId"));
				a.setAmount(rs.getFloat("amount"));
				a.setTimestamp(rs.getTimestamp("dateCreated"));
				av.add(a);
			}
			return av;
		} catch(SQLException e) {
			System.out.println("issue with getAll operation in AccountCRUD");
			e.printStackTrace();
		}
		return av;
	}
	
	@Override
	public void create(Account t) {
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("INSERT INTO accounts (customerId, amount, type) VALUES (?,?,?)");
			ps.setInt(1, t.getCustomerId());
			ps.setFloat(2, t.getAmount());
			ps.setObject(3, AccountType.CHECKING.toString());
			ps.execute();
		} catch(SQLException e) {
			System.out.println("issue with create operation in AccountCRUD");
			e.printStackTrace();
		}	
	}

	@Override
	public void update(Account t) {
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("UPDATE accounts SET customerId=?, amount=?, type=? WHERE id=?");
			ps.setInt(1, t.getCustomerId());
			ps.setFloat(2, t.getAmount());
			ps.setObject(3, AccountType.CHECKING.toString());
			ps.setInt(4, t.getId());
			ps.execute();
		} catch(SQLException e) {
			System.out.println("issue with update operation in AccountCRUD");
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("UPDATE accounts SET visible=0 WHERE id=?");
			ps.setInt(1, id);
			ps.execute();
		} catch(SQLException e) {
			System.out.println("issue with delete operation in AccountCRUD");
			e.printStackTrace();
		}
	}
}
