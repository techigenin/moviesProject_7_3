package com.revFlix.daos;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

}
