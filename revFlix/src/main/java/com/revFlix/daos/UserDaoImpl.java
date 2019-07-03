package com.revFlix.daos;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.*;

import com.revFlix.daos.UserDao;
import com.revFlix.pojos.Admin;
import com.revFlix.pojos.Movie;
import com.revFlix.utils.ConnectionFactory;

public class UserDaoImpl implements UserDao {

	Connection conn = ConnectionFactory.getConnection();
	
	@Override
	public void insertMovie(Movie m) {
		try {PreparedStatement pstmt = conn.prepareStatement("select insert_movie(?, ?, ?, ?, ?)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateMovie(Movie m) {

	}

	@Override
	public boolean loginUser(Admin a) {
		try  {
			CallableStatement cstmt = conn.prepareCall("select * from admins where username = ?;");
			cstmt.setString(1, a.getUsername());
			
			ResultSet rs = cstmt.executeQuery();
			
			if (rs.next()) {
				Admin newA = new Admin(rs.getString("username"), rs.getString("pass_word"));
				
				return a.equals(newA);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public class FillUpdate {
		Connection conn =ConnectionFactory.getConnection();
		
		public void FillForm(Movie re) {
			String title=re.getTitle();
			LocalDate year=re.getYear();
			String ge=re.getGenre();
			LocalTime rt=re.getRunTime();
			
			String sql="INSERT INTO Movie" + 
					"(title,runtime,genere,year)" + 
					"VALUES(?,?,?,?);";
		
			
			PreparedStatement stmt;
			
			try {		
				
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, title);
				stmt.setObject(2, rt);
				stmt.setString(3, ge);
				stmt.setObject(4, year);
				stmt.executeUpdate();		
			}
			catch (SQLException e) {
		
				e.printStackTrace();
			}	
			
			genrefill(ge,title,year);
		}

		public void genrefill(String genre,String title,LocalDate year) {
			Movie mv = new Movie();
			String sql="select movieid from Movie where genre=" + genre +"year =" +year +"title =" + title;
			int id = 0;
			
			Statement stmt ;
			
			try {
				stmt=conn.createStatement();
				ResultSet rs =stmt.executeQuery(sql);
				
				while(rs.next()) {
					id=rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
					mv.setId(id);
					
					int i=mv.getId();
					
				CreateGenre( i, genre);
			
		}
		
		
		public void CreateGenre(int i , String genre) {
			
			
			
			String sql="INSERT INTO movie_genre" + 
					"(movieid,genre)" + 
					"VALUES(?,?);";
		
			
			PreparedStatement stmt;
			
			try {		
				
				stmt = conn.prepareStatement(sql);
				
				stmt.setInt(1, i);
				stmt.setString(2, genre);
				stmt.executeUpdate();		
			}
			catch (SQLException e) {
		
				e.printStackTrace();
			}	
			

		}

}
