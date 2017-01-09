package com.freshfood.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
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
		
		Map<String, List<Product>> products = freshFoodDao.getProducts();
		List<Product> productsList = products.get("Pizza");
		for (Product product : productsList) {
			System.out.println(product);
		}
		
		return "index";
	}
	
	@RequestMapping(value = "/admin**", method = {RequestMethod.GET, RequestMethod.POST})
	public String adminPage() {

	  return "admin";

	}
	
	@RequestMapping(value="/welcom**", method = RequestMethod.GET)
	public String welcome(ModelMap model){
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(@RequestParam(value = "error", required = false) String error,
			 ModelMap model) {
		
		if (error != null) {
			return "403";
		}
		model.addAttribute("user", new User());
		
		return "login";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registrateUser(ModelMap model, User user) {
		
		try {
			freshFoodDao.addUser(user);
		} catch (DuplicateKeyException e) {
			throw e;
		} catch (DataAccessException e) {
			throw e;
		}
		return "login";
	}
	
	@RequestMapping(value = "/pizza", method = RequestMethod.GET)
	public String getPizza(ModelMap model) {
		
		Map<String, List<Product>> products = freshFoodDao.getProducts();
		
		model.addAttribute("title", "Pizza");
		model.addAttribute("products", products.get("Pizza"));
		return "products";
	}
	
	@RequestMapping(value = "/paste", method = RequestMethod.GET)
	public String getPaste(ModelMap model) {
		
		Map<String, List<Product>> products = freshFoodDao.getProducts();
		
		model.addAttribute("title", "Paste");
		model.addAttribute("products", products.get("Paste"));
		return "products";
	}
	
	@RequestMapping(value = "/garnituri", method = RequestMethod.GET)
	public String getGarnituri(ModelMap model) {
		
		Map<String, List<Product>> products = freshFoodDao.getProducts();
		
		model.addAttribute("title", "Garnituri");
		model.addAttribute("products", products.get("Garnituri"));
		return "products";
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String loginError() {


	  //check if user is login

	  return "403";
	}
	
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String accesssDenied() {


	  //check if user is login

	  return "denied";
	}
}
