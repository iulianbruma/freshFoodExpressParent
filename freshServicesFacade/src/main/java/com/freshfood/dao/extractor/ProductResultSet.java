package com.freshfood.dao.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freshfood.Product;

public class ProductResultSet implements ResultSetExtractor<Map<String, List<Product>>> {

	@Override
	public Map<String, List<Product>> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, List<Product>> products = new HashMap<>();
		
		while (rs.next()) {
			
			Product product = new Product();
			product.setName(rs.getString("product_name"));
			product.setPrice(rs.getDouble("price"));
			product.setCategoryId(rs.getInt("category_id"));
			product.setCategoryName(rs.getString("category_name"));
			product.setSubcategoryId(rs.getInt("subcategory_id"));
			product.setSubcategoryName(rs.getString("subcategory_name"));
			
			if (products.containsKey(rs.getString("category_name"))) {
				products.get(rs.getString("category_name")).add(product);
			} else {
				List<Product> productsList = new ArrayList<>();
				productsList.add(product);
				products.put(product.getCategoryName(), productsList);
			}
		}
		
		return products;
	}
}
