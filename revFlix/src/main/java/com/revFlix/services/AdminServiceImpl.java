package com.revFlix.services;

import com.revFlix.daos.UserDao;
import com.revFlix.daos.UserDaoImpl;
import com.revFlix.pojos.Admin;
import com.revFlix.pojos.Movie;
import com.revFlix.services.AdminService;

public class AdminServiceImpl implements AdminService {

	UserDao ud = new UserDaoImpl();
	
	@Override
	public boolean loginUser(Admin newAdmin) {
		return ud.loginUser(newAdmin);
	}

	@Override
	public void insertMovie(Movie re) {
		ud.insertMovie(re);
	}

}
