package com.day13.session1;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.*;

import com.day12.session1.ConnectionFactory;
public class CallingStoreProcedure {
	
	public static void main(String[] args) throws SQLException {
		Connection connection=ConnectionFactory.getConnection();
		
		CallableStatement cstmt=connection.prepareCall("call addNum2(?,?,?)");
		
		cstmt.setInt(1, 3);
		cstmt.setInt(2, 44);
		cstmt.registerOutParameter(3, Types.INTEGER);
		cstmt.execute();
		System.out.println("Result:"+cstmt.getInt(3));
	}

}
