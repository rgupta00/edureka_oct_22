package com.crud;

import java.sql.*;

import com.util.ConnectionFactory;

public class B_GetAllAccountsWithConnectionFactory {

	public static void main(String[] args) {
		
		
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			connection = ConnectionFactory.getConnection();

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
