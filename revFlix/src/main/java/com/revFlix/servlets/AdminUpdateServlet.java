package com.revFlix.servlets;

import javax.servlet.http.HttpServlet;

public class AdminUpdateServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException ,java.io.IOException 
	{
		resp.sendRedirect("updateform.html");
	}
	
	protected void doPost(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException ,java.io.IOException 
	{
		
	}
}
