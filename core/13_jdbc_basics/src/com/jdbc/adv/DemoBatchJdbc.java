package com.jdbc.adv;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.ConnectionFactory;

public class DemoBatchJdbc {

	public static void main(String[] args) {
		
		Connection connection=ConnectionFactory.getConnection();
	
		long start= System.currentTimeMillis();
		
	
		try {
			//connection.setAutoCommit(false);
			PreparedStatement pstmt=connection.prepareStatement("insert into mytemp3(name) values(?)");
			for (long i = 1; i <= 10000; i++) {
				pstmt.setString(1, "foo:" + i);
				pstmt.executeUpdate();
//				   pstmt.addBatch();//it is adding to batch
//					if (i % 200 == 0) {
//						pstmt.executeBatch();//it hit the db but unconmmited
//					}
				}
			//connection.commit();
		} catch (SQLException e) {
//			
//			e.printStackTrace();
//			try {
//				connection.rollback();
//			} catch (SQLException e1) {
//
//				e1.printStackTrace();
//			}
		}
		
		
		long end= System.currentTimeMillis();
		
		System.out.println("time taken: "+ (end-start));
		
		
	}
}
