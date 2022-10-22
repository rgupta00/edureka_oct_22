package com.day13.session1;

import java.sql.*;

import com.day12.session1.ConnectionFactory;

public class InsertEmpAndGettingAutogen {
	public static void main(String[] args) {

		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"insert into emp1(ename, city, desi, salary) values(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, "amit kr");
			pstmt.setString(2, "delhi");
			pstmt.setString(3, "sales");
			pstmt.setDouble(4, 67000.00);

			int noOfRowsEffeted = pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				System.out.println(rs.getInt(2));

			}

			System.out.println(noOfRowsEffeted);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
