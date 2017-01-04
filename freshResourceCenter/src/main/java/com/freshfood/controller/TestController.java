package com.freshfood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.freshfood.User;
import com.freshfood.dao.FreshFoodDao;

@Controller
public class TestController {
	
	@Autowired
	private FreshFoodDao freshFoodDao;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index(ModelMap model){
		return "index";
	}
	
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public String getUsers(ModelMap model) {
		List<User> users = freshFoodDao.getUsers();
		
		for (User user : users) {
			System.out.println(user.toString());
		}
		return "index";
	}
}
