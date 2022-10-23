package com.crud;
import java.sql.*;

import com.util.ConnectionFactory;
public class D_UpdateAccount {
	public static void main(String[] args) {
		
		
		//Statement vs PreparedSatatement vs CallableStamtement
		//SQL injection 
		//select * from  emp where i=11 or 1=1;
		
		Connection connection=ConnectionFactory.getConnection();
		try {
			PreparedStatement pstmt=connection.
					prepareStatement("update accounts set balance=? where id=?");
			
			pstmt.setDouble(1, 5400);
			pstmt.setInt(2, 3);
			
			int noOfRowsEffeted = pstmt.executeUpdate();
			
			System.out.println(noOfRowsEffeted);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
