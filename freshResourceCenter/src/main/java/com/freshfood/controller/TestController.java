package com.freshfood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.freshfood.Product;
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
	
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public String adminPage() {

	  return "admin";

	}
	
	@RequestMapping(value="/welcom**", method = RequestMethod.GET)
	public String welcome(ModelMap model){
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getUsers(@RequestParam(value = "error", required = false) String error,
			 ModelMap model) {
		if (error != null) {
			return "403";
		}
		List<User> users = freshFoodDao.getUsers();
		
		for (User user : users) {
			System.out.println(user.toString());
		}
		
		List<Product> products = freshFoodDao.getProducts();
		
		for (Product prod : products) {
			System.out.println(prod.toString());
		}
		return "login";
	}
	
	
	@RequestMapping(value = "/403", method = RequestMethod.POST)
	public String accesssDenied() {


	  //check if user is login

	  return "403";

	}
}
