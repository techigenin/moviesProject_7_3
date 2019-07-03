package com.revFlix.daos;

import com.revFlix.pojos.*;

public interface UserDao {
	
	// insert movie
	void insertMovie(Movie m);
	
	// update movie
	void updateMovie(Movie m);
	
	// login 
	boolean loginUser(Admin a);
}
