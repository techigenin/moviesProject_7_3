package com.revFlix.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revFlix.pojos.Movie;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("user.html");
        return;
		
//		List<Movie> rblist;
//        Movie mv=new Movie();
//        String name = request.getPathInfo();
//        HttpSession sess = request.getSession(false);
//        if (sess == null && sess.getAttribute("user") == null)
//            {
//            
//            request.getRequestDispatcher("home").forward(request,response);
//                return;
//                
//            }
//    
//        else {
//            
////             rblist= mv.form();
//            ObjectMapper objectMapper = new ObjectMapper();
////            String st=objectMapper.writeValueAsString(rblist);
//            response.getWriter().write(st);
        
          
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
