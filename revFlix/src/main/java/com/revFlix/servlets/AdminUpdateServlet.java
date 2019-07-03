package com.revFlix.servlets;

import javax.servlet.http.*;

public class AdminUpdateServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws javax.servlet.ServletException ,java.io.IOException 
	{
		resp.sendRedirect("updateform.html");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws javax.servlet.ServletException ,java.io.IOException 
	{
		
	}
}
