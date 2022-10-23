package com.crud;
import java.sql.*;

import com.util.ConnectionFactory;
public class C_InsertNewAccount {
	public static void main(String[] args) {
		
		
		//Statement vs PreparedSatatement vs CallableStamtement
		//SQL injection 
		//select * from  emp where i=11 or 1=1;
		
		Connection connection=ConnectionFactory.getConnection();
		try {
			PreparedStatement pstmt=connection.
					prepareStatement("insert into accounts(name, balance) values(?,?)");
			
			pstmt.setString(1, "seema");
			pstmt.setDouble(2, 5000);
			
			int noOfRowsEffeted = pstmt.executeUpdate();
			
			System.out.println(noOfRowsEffeted);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
