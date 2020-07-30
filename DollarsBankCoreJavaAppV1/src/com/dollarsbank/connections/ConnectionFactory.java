package com.dollarsbank.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static final String URL = "jdbc:mysql://localhost:3306/dollarsbank";
	public static final String USER = "root";
	public static final String PASS = "root";

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException ex) {
			System.out.println("Error connecting to the database");
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
