package com.day12.session1;

import java.sql.*;
// :( manual tx mgt , why hell i should do it ... it is cross cutting conern... why not spring handle it
public class TransferFund {

	public static void main(String[] args) {
		// load the driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
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
			
			// i have to do tx mgt manually :(
			
			connection.setAutoCommit(false);
			
			
			PreparedStatement pstmt= 
					connection.prepareStatement("update account2 set balance= balance - 10 where id=?");
			pstmt.setInt(1, 1);
			
			pstmt.executeUpdate();
		
			if(1==1)
				throw new NullPointerException();
			
			pstmt= connection.prepareStatement("update account2 set balance= balance + 10 where id=?");
			pstmt.setInt(1, 2);
			pstmt.executeUpdate();
			
			connection.commit();
			
			
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
