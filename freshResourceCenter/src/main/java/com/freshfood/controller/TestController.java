package com.freshfood.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.freshfood.Product;
import com.freshfood.User;
import com.freshfood.dao.FreshFoodDao;
import com.freshfood.helper.CartHelper;
import com.freshfood.ui.CartView;
import com.freshfood.ui.ProductView;
import com.freshfood.ui.converter.ProductToProductView;

@Controller
public class TestController {
	
	@Autowired
	private FreshFoodDao freshFoodDao;
	
	@Autowired
	private CartHelper cartHelper;
	
	@Autowired
	private ProductToProductView productToProductView;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index(ModelMap model){
		
		model.addAttribute("quantity", cartHelper.getCartQuantity());
		model.addAttribute("totalPrice", cartHelper.getCartTotalPrice());
		model.addAttribute("cartProducts", getCartProducts());
		return "index";
	}
	
	@RequestMapping(value = "/admin**", method = {RequestMethod.GET, RequestMethod.POST})
	public String adminPage() {

	  return "admin";

	}
	
	@RequestMapping(value="/welcom**", method = RequestMethod.GET)
	public String welcome(ModelMap model){
		model.addAttribute("quantity", cartHelper.getCartQuantity());
		model.addAttribute("totalPrice", cartHelper.getCartTotalPrice());
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(@RequestParam(value = "error", required = false) String error,
			 ModelMap model) {
		
		if (error != null) {
			return "403";
		}
		model.addAttribute("quantity", cartHelper.getCartQuantity());
		model.addAttribute("totalPrice", cartHelper.getCartTotalPrice());
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
		model.addAttribute("quantity", cartHelper.getCartQuantity());
		model.addAttribute("totalPrice", cartHelper.getCartTotalPrice());
		return "login";
	}
	
	@RequestMapping(value = "/pizza", method = RequestMethod.GET)
	public String getPizza(ModelMap model) {
		
		Map<String, List<Product>> products = freshFoodDao.getProducts();
		
		model.addAttribute("quantity", cartHelper.getCartQuantity());
		model.addAttribute("totalPrice", cartHelper.getCartTotalPrice());
		model.addAttribute("title", "Pizza");
		model.addAttribute("products", products.get("Pizza"));
		model.addAttribute("cartProducts", getCartProducts());
		return "products";
	}
	
	@RequestMapping(value = "/paste", method = RequestMethod.GET)
	public String getPaste(ModelMap model) {
		
		Map<String, List<Product>> products = freshFoodDao.getProducts();
		
		model.addAttribute("quantity", cartHelper.getCartQuantity());
		model.addAttribute("totalPrice", cartHelper.getCartTotalPrice());
		model.addAttribute("title", "Paste");
		model.addAttribute("products", products.get("Paste"));
		model.addAttribute("cartProducts", getCartProducts());
		return "products";
	}
	
	@RequestMapping(value = "/garnituri", method = RequestMethod.GET)
	public String getGarnituri(ModelMap model) {
		
		Map<String, List<Product>> products = freshFoodDao.getProducts();
		
		model.addAttribute("quantity", cartHelper.getCartQuantity());
		model.addAttribute("totalPrice", cartHelper.getCartTotalPrice());
		model.addAttribute("title", "Garnituri");
		model.addAttribute("products", products.get("Garnituri"));
		model.addAttribute("cartProducts", getCartProducts());
		return "products";
	}
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String getCart(ModelMap model) {
		model.addAttribute("quantity", cartHelper.getCartQuantity());
		model.addAttribute("totalPrice", cartHelper.getCartTotalPrice());
		model.addAttribute("cartProducts", getCartProducts());
		return "cart";
	}
	
	@RequestMapping(value = "/submitOrder", method = RequestMethod.GET)
	public String orderSubmit() {
		cartHelper.clearCartCache();
		
	  return "orderSubmit";
	}
	
	@RequestMapping(value = "/addToCart", method = RequestMethod.POST)
	@ResponseBody
	public CartView addProductToCart(@RequestBody Product product) {
		
		ProductView productView = productToProductView.convert(product);
		cartHelper.addToCartCacheProducts(productView);
		Map<ProductView, Integer> map = cartHelper.getCachedProducts();
		
		System.out.println("<******************Cache nou***************>");
		for (Map.Entry<ProductView, Integer> product1: map.entrySet()) {
			System.out.println(product1.getKey().toString());
			System.out.println(product1.getValue());
		}
		
		CartView cartView = new CartView(cartHelper.getCartQuantity(), cartHelper.getCartTotalPrice());
		return cartView;
	}
	
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String loginError() {

	  return "403";
	}
	
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String accesssDenied() {

	  return "denied";
	}
	
	private List<ProductView> getCartProducts() {
		Set<ProductView> set = cartHelper.getCachedProducts().keySet();
		List<ProductView> list = new ArrayList<>();
		list.addAll(set);
		
		return list;
	}
}
