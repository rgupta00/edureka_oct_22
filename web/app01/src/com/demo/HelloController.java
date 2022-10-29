package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("init method of servlet");
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		LocalDateTime dateTime=LocalDateTime.now();
		out.print("hello to all champs: "+ dateTime.toString());
		System.out.println("it is doget method");
	}
	

	
	@Override
	public void destroy() {
		System.out.println("destroy method of servlet");
	}



}
