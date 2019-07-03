package com.revFlix.daos;

import com.revFlix.pojos.*;

public interface UserDao {
	
	// insert movie
	//void insertMovie(Movie m);
	
	// update movie
	public void insertMovie(Movie re);
	
	// login 
	boolean loginUser(Admin a);
}
