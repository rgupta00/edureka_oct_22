package com.day12.session1;
import java.sql.*;
public class DeleteEmp {
	public static void main(String[] args) {
		
		
		//Statement vs PreparedSatatement vs CallableStamtement
		//SQL injection 
		//select * from  emp where i=11 or 1=1;
		
		Connection connection=ConnectionFactory.getConnection();
		try {
			PreparedStatement pstmt=connection.
					prepareStatement("delete from emp1 where id =?");
			
		
			pstmt.setInt(1, 5);
			
			int noOfRowsEffeted = pstmt.executeUpdate();
			
			System.out.println(noOfRowsEffeted);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
