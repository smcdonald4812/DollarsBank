package com.dollarsbank.operations.crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.dollarsbank.connections.ConnectionFactory;
import com.dollarsbank.interfaces.Customer;
import com.dollarsbank.model.BasicCustomer;
import com.dollarsbank.operations.CustomerOps;

public class BasicCustomerCRUD implements CustomerOps<Customer>{

	@Override
	public Customer get(int id) {
		Customer c = null;
		try {
			c = new BasicCustomer();
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("SELECT * FROM customer WHERE id=? AND visible=1");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				c.setId(rs.getInt("id"));
				c.setFirstName(rs.getString("firstname"));
				c.setLastName(rs.getString("lastname"));
				c.setUserName(rs.getString("username"));
				c.setPassword(rs.getString("password"));
				c.setCountry(rs.getString("country"));
				c.setMobile(rs.getString("mobile"));
				c.setTimestamp(rs.getTimestamp("dateCreated"));
			}
			return c;
		} catch(SQLException e) {
			System.out.println("issue with get operation in CustomerCRUD");
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Vector<Customer> getAll() {
		Vector<Customer> cv = new Vector<>();
		try {
			ResultSet rs = ConnectionFactory.getConnection().createStatement().executeQuery("SELECT * FROM customer WHERE visible=1");
			while(rs.next()) {
				Customer c = new BasicCustomer();
				c.setId(rs.getInt("id"));
				c.setFirstName(rs.getString("firstname"));
				c.setLastName(rs.getString("lastname"));
				c.setUserName(rs.getString("username"));
				c.setPassword(rs.getString("password"));
				c.setCountry(rs.getString("country"));
				c.setMobile(rs.getString("mobile"));
				c.setTimestamp(rs.getTimestamp("dateCreated"));
				cv.add(c);
			}
			return cv;
		} catch(SQLException e) {
			System.out.println("issue with getAll operation in CustomerCRUD");
			e.printStackTrace();
		}
		return cv;
	}

	@Override
	public void create(Customer t) {
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("INSERT INTO customer (firstname, lastname, username, password, country, mobile) VALUES (?,?,?,?,?,?)");
			ps.setString(1, t.getFirstName());
			ps.setString(2, t.getLastName());
			ps.setString(3, t.getUserName());
			ps.setString(4, t.getPassword());
			ps.setString(5, t.getCountry());
			ps.setString(6, t.getMobile());
			ps.execute();
		} catch(SQLException e) {
			System.out.println("issue with create operation in CustomerCRUD");
			e.printStackTrace();
		}
	}

	@Override
	public void update(Customer t) {
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("UPDATE customer SET firstname=?, lastname=?, username=?, password=?, country=?, mobile=? WHERE id=?");
			ps.setString(1, t.getFirstName());
			ps.setString(2, t.getLastName());
			ps.setString(3, t.getUserName());
			ps.setString(4, t.getPassword());
			ps.setString(5, t.getCountry());
			ps.setString(6, t.getMobile());
			ps.setInt(7, t.getId());
			ps.execute();
		} catch(SQLException e) {
			System.out.println("issue with update operation in CustomerCRUD");
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("UPDATE customer SET visible=0 WHERE id=?");
			ps.setInt(1, id);
			ps.execute();
		} catch(SQLException e) {
			System.out.println("issue with delete operation in CustomerCRUD");
			e.printStackTrace();
		}
	}

	@Override
	public Customer get(String username) {
		Customer c = null;
		try {
			c = new BasicCustomer();
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("SELECT * FROM customer WHERE username=? AND visible=true");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				c.setId(rs.getInt("id"));
				c.setFirstName(rs.getString("firstname"));
				c.setLastName(rs.getString("lastname"));
				c.setUserName(rs.getString("username"));
				c.setPassword(rs.getString("password"));
				c.setCountry(rs.getString("country"));
				c.setMobile(rs.getString("mobile"));
				c.setTimestamp(rs.getTimestamp("dateCreated"));
			}
			return c;
		} catch(SQLException e) {
			System.out.println("issue with get operation in CustomerCRUD");
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Customer get(char[] mobile) {
		Customer c = new BasicCustomer();
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("SELECT * FROM customer WHERE mobile=? AND visible=true");
			ps.setString(1, mobile.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				c.setId(rs.getInt("id"));
				c.setFirstName(rs.getString("firstname"));
				c.setLastName(rs.getString("lastname"));
				c.setUserName(rs.getString("username"));
				c.setPassword(rs.getString("password"));
				c.setCountry(rs.getString("country"));
				c.setMobile(rs.getString("mobile"));
				c.setTimestamp(rs.getTimestamp("dateCreated"));
			}
			return c;
		} catch(SQLException e) {
			System.out.println("issue with get operation in CustomerCRUD");
			e.printStackTrace();
		}
		return c;
	}
}
