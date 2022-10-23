package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	private static Connection connection = null;

	public static Connection getConnection() {

		Properties properties = new Properties();
		
		InputStream ins=null;
		try {
			 ins=new FileInputStream("db.properties");
			
			 properties.load(ins);
			 
		} catch ( IOException e1) {
			e1.printStackTrace();
		}
	
		String url=properties.getProperty("jdbc.url");
		String driverName=properties.getProperty("jdbc.driver");
		String userName=properties.getProperty("jdbc.username");
		String password=properties.getProperty("jdbc.password");
		
		
		try {
			Class.forName(driverName);
			System.out.println("driver is loaded...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection
					(url, userName	, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}
}
