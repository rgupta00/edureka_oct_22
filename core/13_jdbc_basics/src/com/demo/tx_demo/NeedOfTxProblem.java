package com.demo.tx_demo;

import java.sql.*;

import com.day12.session1.ConnectionFactory;

//declartive tx mgt: spring tx mgt

public class NeedOfTxProblem {

	public static void main(String[] args) {

		Connection connection = ConnectionFactory.getConnection();

		try {
			PreparedStatement pstmt = connection.
					prepareStatement("update accounts set balance=balance-10 where id=?");
			pstmt.setInt(1, 1);
			pstmt.executeUpdate();

			pstmt = connection.prepareStatement("update acounts set balance=balance+10 where id=?");
			pstmt.setInt(1, 2);
			pstmt.executeUpdate();

			System.out.println("transfer is done");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
