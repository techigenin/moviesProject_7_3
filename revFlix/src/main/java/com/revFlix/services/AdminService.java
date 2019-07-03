package com.revFlix.services;

import com.revFlix.pojos.Admin;
import com.revFlix.pojos.Movie;

public interface AdminService {

	boolean loginUser(Admin newAdmin);
	
	void insertMovie(Movie re);

}
