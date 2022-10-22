package com.day12.session1;

import java.sql.*;

public class HelloWorldJdbc2 {

	public static void main(String[] args) {
		
		
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			connection = ConnectionFactory.getConnection();

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
