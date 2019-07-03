package com.revFlix.services;

import com.revFlix.daos.UserDao;
import com.revFlix.daos.UserDaoImpl;
import com.revFlix.pojos.Admin;
import com.revFlix.services.AdminService;

public class AdminServiceImpl implements AdminService {

	UserDao ud = new UserDaoImpl();
	
	@Override
	public boolean loginUser(Admin newAdmin) {
		return ud.loginUser(newAdmin);
	}

}
