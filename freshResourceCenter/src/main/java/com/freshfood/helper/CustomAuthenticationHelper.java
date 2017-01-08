package com.freshfood.helper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.freshfood.User;
import com.freshfood.dao.FreshFoodDao;

@Repository
public class CustomAuthenticationHelper {
	
	private FreshFoodDao freshFoodDao;

	public User checkForUserOnLogin(String username, String password) {
		User newUser = null;
		
		List<User> users = freshFoodDao.getUsers();
		
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return newUser;
	}
	
	public void setFreshFoodDao(FreshFoodDao freshFoodDao) {
		this.freshFoodDao = freshFoodDao;
	}
}
