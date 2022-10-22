package com.day12.session1;

import java.sql.*;

public class HelloWorldJdbc {

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
			connection = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/edu123?useSSL=false", "root", "root");
			// now i want to print all records
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from emp1");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + ":" + rs.getString(2) + ": " + rs.getString(3) + ": "
						+ rs.getString(4) + ": " + rs.getDouble(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
