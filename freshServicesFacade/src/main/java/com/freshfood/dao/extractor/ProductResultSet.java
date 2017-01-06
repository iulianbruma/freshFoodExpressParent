package com.freshfood.dao.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freshfood.Product;

public class ProductResultSet implements ResultSetExtractor<Map<String, Product>> {

	@Override
	public Map<String, Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, Product> products = new HashMap<>();
		
		while (rs.next()) {
			Product product = new Product();
			product.setName(rs.getString("product_name"));
			product.setPrice(rs.getDouble("price"));
			product.setSubcategoryId(rs.getInt("subcategory_id"));
			product.setCategoryId(rs.getInt("category_id"));
			
			products.put(product.getName(), product);
		}
		
		return products;
	}
}
