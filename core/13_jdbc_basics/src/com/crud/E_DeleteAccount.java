package com.crud;
import java.sql.*;

import com.util.ConnectionFactory;
public class E_DeleteAccount {
	public static void main(String[] args) {
		
		
		//Statement vs PreparedSatatement vs CallableStamtement
		//SQL injection 
		//select * from  emp where i=11 or 1=1;
		
		Connection connection=ConnectionFactory.getConnection();
		try {
			PreparedStatement pstmt=connection.
					prepareStatement("delete from accounts where id =?");
			
			pstmt.setInt(1, 3);
			
			int noOfRowsEffeted = pstmt.executeUpdate();
			
			System.out.println(noOfRowsEffeted);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
