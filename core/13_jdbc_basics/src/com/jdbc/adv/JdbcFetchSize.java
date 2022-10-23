package com.jdbc.adv;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.ConnectionFactory;

public class JdbcFetchSize {

	public static void main(String[] args) {
		
		Connection connection=ConnectionFactory.getConnection();
		
		long start= System.currentTimeMillis();
		
	
		try {
			
			PreparedStatement pstmt=connection.prepareStatement("select * from mytemp3");
			System.out.println(pstmt.getFetchSize());
			pstmt.setFetchSize(20000);
			System.out.println(pstmt.getFetchSize());
			
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			
		} catch (SQLException e) {

		}
		
		
		long end= System.currentTimeMillis();
		
		System.out.println("time taken: "+ (end-start));
		
		
	}
}
