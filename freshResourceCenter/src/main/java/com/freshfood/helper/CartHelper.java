package com.freshfood.helper;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import com.freshfood.Product;
import com.freshfood.ui.ProductView;
import com.freshfood.ui.util.CommonMethods;

public class CartHelper {
	
	@Autowired
	CacheManager cacheManager;
	
	public CartHelper() {
		
	}
	//@CacheEvict(value="cartProducts", key="cart")
	@SuppressWarnings("unchecked")
	public void addToCartCacheProducts(ProductView product) {
		Cache cache = cacheManager.getCache("cartProducts");
		Map<ProductView, Integer> products;
		try {
			products = (Map<ProductView, Integer>) cache.get("cart").get();
			if (products.containsKey(product)) {
				product.setQuantity(products.get(product) + 1);
				products.remove(product);
				products.put(product, product.getQuantity());
			} else {
				products.put(product, 1);
			}
		} catch(NullPointerException e) {
			products = new HashMap<>();
			products.put(product, 1);
		}
		
		cache.put("cart", products);
	}
	
	@SuppressWarnings("unchecked")
	public Map<ProductView, Integer> getCachedProducts() {
		Map<ProductView, Integer> map;
		try {
			map =(Map<ProductView, Integer>) cacheManager.getCache("cartProducts").get("cart").get();
		} catch (NullPointerException e) {
			return new HashMap<>();
		}
		 
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public int getCartQuantity() {
		Cache cache = cacheManager.getCache("cartProducts");
		Map<ProductView, Integer> products;
		int quantity = 0;
		
		try {
			products = (Map<ProductView, Integer>) cache.get("cart").get();
			for (int value : products.values()) {
				quantity += value;
			}
		} catch (NullPointerException e) {
			return quantity;
		}
		
		return quantity;
	}
	
	@SuppressWarnings("unchecked")
	public BigDecimal getCartTotalPrice() {
		Cache cache = cacheManager.getCache("cartProducts");
		Map<ProductView, Integer> products;
		
		float totalPrice = 0.00f;
		
		try {
			products = (Map<ProductView, Integer>) cache.get("cart").get();
			for (Map.Entry<ProductView, Integer> item : products.entrySet()) {
				totalPrice += item.getKey().getPrice() * item.getValue().floatValue();
			}
		} catch (NullPointerException e) {
			return CommonMethods.round(totalPrice, 2);
		}
		
		return CommonMethods.round(totalPrice, 2);
	}
	
	public void clearCartCache() {
		cacheManager.getCache("cartProducts").clear();
	}

}
