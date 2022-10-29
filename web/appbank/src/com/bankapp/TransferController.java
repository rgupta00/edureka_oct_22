package com.bankapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TransferController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer fromAccId=Integer.parseInt(request.getParameter("fromId"));
		Integer toAccId=Integer.parseInt(request.getParameter("toId"));
		
		Double amount=Double.parseDouble(request.getParameter("amount"));
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver is loaded...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Connection
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/edu123?useSSL=false", "root", "root");
			// now i want to print all records

			// i have to do tx mgt manually :(

			connection.setAutoCommit(false);

			PreparedStatement pstmt = connection
					.prepareStatement("update accounts set balance= balance - 10 where id=?");
			pstmt.setInt(1, 1);

			pstmt.executeUpdate();

			pstmt = connection.prepareStatement("update accounts set balance= balance + 10 where id=?");
			pstmt.setInt(1, 2);
			pstmt.executeUpdate();

			connection.commit();
			
			//AFTER POST DONT USE RD RequestDispatcher better to use Redirect
			//request.setAttribute("info", "transfer successfully");
			HttpSession httpSession=request.getSession();
			httpSession.setAttribute("info", "transfer successfully");
			response.sendRedirect("result.jsp");
			
//			RequestDispatcher rd=request.getRequestDispatcher("result.jsp");
//			request.setAttribute("info", "transfer successfully");
//			rd.forward(request, response);

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
