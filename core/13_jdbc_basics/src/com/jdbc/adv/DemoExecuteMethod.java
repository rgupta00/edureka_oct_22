package com.jdbc.adv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.ConnectionFactory;

public class DemoExecuteMethod {

	public static void main(String[] args) {
		// Difference bw execute() vs executeQuery() vs executeUpdate()

		Connection connection = ConnectionFactory.getConnection();
		System.out.println("PE a query");
		String query;
		Scanner scanner = new Scanner(System.in);
		query = scanner.nextLine();

		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(query);
			boolean response = pstmt.execute();
			if (response) {
				//that mean that query is of executeQuyer type

					ResultSet rs=pstmt.getResultSet();
					while(rs.next()) {
						System.out.println(rs.getInt(1));
					}
			} else {
				//that mean that query is of executeUpdate type
				int noOfRowsEffected= pstmt.getUpdateCount();
				System.out.println("no of rows effected : "+ noOfRowsEffected);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
