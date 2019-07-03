package com.revFlix.servlets;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revFlix.pojos.Movie;
import com.revFlix.services.AdminService;
import com.revFlix.services.AdminServiceImpl;
import com.revFlix.utils.ConnectionFactory;

public class AdminInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.sendRedirect("insertMovie.html");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		ConnectionFactory.getConnection(this);
		
		String title = req.getParameter("title");
		String yearString = req.getParameter("year");
		String genre = req.getParameter("genre");
		String actorsString = req.getParameter("actors");
		String runTimeString = req.getParameter("runtime");
		
		ArrayList<String> actorList = new ArrayList<String>(Arrays.asList(actorsString.split(",")));

		LocalDate year;
		LocalTime runTime;
		
		try {
		 year = LocalDate.parse(yearString);
		} catch (DateTimeParseException e) {
			year = LocalDate.of(2000, 0, 1);
		}
		try {
			runTime  = LocalTime.of((int)Integer.parseInt(runTimeString)/60,Integer.parseInt(runTimeString) % 60);
		} catch (DateTimeParseException e) {
			runTime = LocalTime.of(0, 0);
		} catch (NumberFormatException e) {
			runTime = LocalTime.of(0, 0);
		}
		 
		Movie m = new Movie(title, year, runTime, genre, actorList);
		
		AdminService as = new AdminServiceImpl();
		as.insertMovie(m);
		
		System.out.println(title + " inserted!");
	}

}
