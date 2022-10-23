package com.jdbc.adv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.util.ConnectionFactory;

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
