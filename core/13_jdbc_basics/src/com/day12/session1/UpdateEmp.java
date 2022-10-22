package com.day12.session1;
import java.sql.*;
public class UpdateEmp {
	public static void main(String[] args) {
		
		
		//Statement vs PreparedSatatement vs CallableStamtement
		//SQL injection 
		//select * from  emp where i=11 or 1=1;
		
		Connection connection=ConnectionFactory.getConnection();
		try {
			PreparedStatement pstmt=connection.
					prepareStatement("update emp1 set salary=? where id =?");
			
		
			pstmt.setDouble(1, 90000.00);
			pstmt.setInt(2, 5);
			
			int noOfRowsEffeted = pstmt.executeUpdate();
			
			System.out.println(noOfRowsEffeted);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
