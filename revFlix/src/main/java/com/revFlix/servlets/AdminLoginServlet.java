package com.revFlix.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revFlix.pojos.Admin;
import com.revFlix.services.AdminService;
import com.revFlix.services.AdminServiceImpl;
import com.revFlix.utils.ConnectionFactory;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("home.html");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ConnectionFactory.getConnection(this);
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Admin newAdmin = new Admin (username, password);
		
		AdminService as = new AdminServiceImpl();
		boolean goodLogin = as.loginUser(newAdmin);
		
		if (goodLogin) {
			resp.setStatus(200);
			resp.sendRedirect("AdminInsert");
		} else {
			resp.setStatus(418);
			resp.sendRedirect("home.html");
		}
	}

}
