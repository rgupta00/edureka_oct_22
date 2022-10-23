package com.jdbc.adv;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import com.util.ConnectionFactory;

public class GettingResultSetMetaData {
	
	public static void main(String[] args) throws SQLException {
		
		//Database metadata: it give information about database
		Connection connection=ConnectionFactory.getConnection();
		DatabaseMetaData dbmd=connection.getMetaData();  
		
		System.out.println("Driver Name: "+dbmd.getDriverName());  
		System.out.println("Driver Version: "+dbmd.getDriverVersion());  
		System.out.println("UserName: "+dbmd.getUserName());  
		System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
		System.out.println
		("Database Product Version: "+dbmd.getDatabaseProductVersion());
		
		
		
		//resultSetMetaData
//		Connection connection=ConnectionFactory.getConnection();
//		
//		PreparedStatement psmt=connection.prepareStatement("select * from emp1");
//		
//		ResultSet rs=psmt.executeQuery();
//		
//		//how to get metadata from rs
//		ResultSetMetaData rsMeta=rs.getMetaData();
//		
//		System.out.println(rsMeta.getColumnCount());
//		
//		for(int i=1;i<=rsMeta.getColumnCount();i++){
//			System.out.println(rsMeta.getColumnClassName(i)+": "+rsMeta.getColumnName(i));
//		}
//
//		
//		
	}

}
