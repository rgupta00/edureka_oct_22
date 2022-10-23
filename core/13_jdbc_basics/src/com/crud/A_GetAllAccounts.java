package com.crud;

import java.sql.*;

public class A_GetAllAccounts {

	public static void main(String[] args) {
		// load the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver is loaded...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Connection
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/edu123?useSSL=false", "root", "root");
			// now i want to print all records
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from accounts");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + ":" + rs.getString(2) + ": " + rs.getDouble(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
