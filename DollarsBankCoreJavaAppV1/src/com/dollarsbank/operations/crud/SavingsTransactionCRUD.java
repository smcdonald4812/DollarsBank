package com.dollarsbank.operations.crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.dollarsbank.connections.ConnectionFactory;
import com.dollarsbank.interfaces.Transaction;
import com.dollarsbank.model.SavingsTransaction;
import com.dollarsbank.operations.TransactionOps;

public class SavingsTransactionCRUD implements TransactionOps<Transaction>{
	@Override
	public Transaction get(int id) {
		Transaction a = new SavingsTransaction();
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("SELECT * FROM transaction WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				a.setId(rs.getInt("id"));
				a.setUserId(rs.getInt("customerTransactionId"));
				a.setAccountId(rs.getInt("accountTransactionId"));
				a.setAmount(rs.getFloat("amount"));
				a.setStartAmount(rs.getFloat("startAmount"));
				a.setEndAmount(rs.getFloat("endAmount"));
				a.setTimestamp(rs.getTimestamp("dateCreated"));
			}
			return a;
		} catch(SQLException e) {
			System.out.println("issue with get operation in TransactionCRUD");
			e.printStackTrace();
		}
		return a;
	}
	
	@Override
	public Vector<Transaction> getAll() {
		Vector<Transaction> tv = new Vector<>();
		try {
			ResultSet rs = ConnectionFactory.getConnection().createStatement().executeQuery("SELECT * FROM transaction WHERE type='SAVINGS' ORDER BY id DESC LIMIT 25");
			while(rs.next()) {
				Transaction a = new SavingsTransaction();
				a.setId(rs.getInt("id"));
				a.setUserId(rs.getInt("customerTransactionId"));
				a.setAccountId(rs.getInt("accountTransactionId"));
				a.setAmount(rs.getFloat("amount"));
				a.setStartAmount(rs.getFloat("startAmount"));
				a.setEndAmount(rs.getFloat("endAmount"));
				a.setTimestamp(rs.getTimestamp("dateCreated"));
				tv.add(a);
			}
			return tv;
		} catch(SQLException e) {
			System.out.println("issue with get operation in TransactionCRUD");
			e.printStackTrace();
		}
		return tv;
	}
	
	@Override
	public Vector<Transaction> getAll(int custId) {
		Vector<Transaction> tv = new Vector<>();
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("SELECT * FROM transaction WHERE type='SAVINGS' AND customerTransactionId=? ORDER BY id DESC LIMIT 25");
			ps.setInt(1, custId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Transaction a = new SavingsTransaction();
				a.setId(rs.getInt("id"));
				a.setUserId(rs.getInt("customerTransactionId"));
				a.setAccountId(rs.getInt("accountTransactionId"));
				a.setAmount(rs.getFloat("amount"));
				a.setStartAmount(rs.getFloat("startAmount"));
				a.setEndAmount(rs.getFloat("endAmount"));
				a.setTimestamp(rs.getTimestamp("dateCreated"));
				tv.add(a);
			}
			return tv;
		} catch(SQLException e) {
			System.out.println("issue with getAll operation in TransactionCRUD");
			e.printStackTrace();
		}
		return tv;
	}
	
	@Override
	public void create(Transaction t) {
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("INSERT INTO transaction (customerTransactionId, accountTransactionId, amount, startAmount, endAmount, type) VALUES (?,?,?,?,?,?)");
			ps.setInt(1, t.getUserId());
			ps.setInt(2, t.getAccountId());
			ps.setFloat(3, t.getAmount());
			ps.setFloat(4, t.getStartAmount());
			ps.setFloat(5, t.getEndAmount());
			ps.setObject(6, t.getType().toString());
			ps.execute();
		} catch(SQLException e) {
			System.out.println("issue with create operation in TransactionCRUD");
			e.printStackTrace();
		}
	}

	@Override
	public void update(Transaction t) {
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("UPDATE transaction SET customerTransactionId=?, accountTransactionId=?, amount=?, startAmount=?, endAmount=?, type=? WHERE id=?");
			ps.setInt(1, t.getUserId());
			ps.setInt(2, t.getAccountId());
			ps.setFloat(3, t.getAmount());
			ps.setFloat(4, t.getStartAmount());
			ps.setFloat(5, t.getEndAmount());
			ps.setObject(6, t.getType().toString());
			ps.setInt(7, t.getId());
			ps.execute();
		} catch(SQLException e) {
			System.out.println("issue with update operation in TransactionCRUD");
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("DELETE FROM transaction WHERE id=?");
			ps.setInt(1, id);
			ps.execute();
		} catch(SQLException e) {
			System.out.println("issue with delete operation in TransactionCRUD");
			e.printStackTrace();
		}
	}
}
