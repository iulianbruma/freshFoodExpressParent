package com.freshfood.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.freshfood.Product;
import com.freshfood.User;
import com.freshfood.dao.extractor.ProductResultSet;
import com.freshfood.dao.extractor.UserResultSet;

public class FreshFoodDao {
	
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	private Properties prop;
	
	public FreshFoodDao (NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
	}
	
	public void setProp(Properties prop) {
		this.prop = prop;
	}
	
	public List<User> getUsers() {
		String sql = prop.getProperty("getUsers");
		List<User> usersList;
		
		Map<String, User> usersMap = new HashMap<>();
		
		UserResultSet resultSet = new UserResultSet();
		
		try {
			usersMap = namedJdbcTemplate.query(sql, resultSet);
			
			if (usersMap.isEmpty()) {
				return Collections.emptyList();
			} else {
				usersList = new ArrayList<User>(usersMap.values());
				return usersList;
			}
			
		} catch(DataAccessException e) {
			throw e;
		}
	}
	
	public Map<String, List<Product>> getProducts() {
		String sql = prop.getProperty("getProducts");
		
		Map<String, List<Product>> productsMap = new HashMap<>();
		
		ProductResultSet resultSet = new ProductResultSet();
		
		try {
			productsMap = namedJdbcTemplate.query(sql, resultSet);
			
			if (productsMap.isEmpty()) {
				return Collections.emptyMap();
			} else {
				return productsMap;
			}
			
		} catch(DataAccessException e) {
			throw e;
		}
	}
	
	public void addUser(User user) {
		String sql = prop.getProperty("addUser");
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		namedParameters.addValue("username", user.getUsername());
		namedParameters.addValue("firstname", user.getFirstName());
		namedParameters.addValue("lastname", user.getLastName());
		namedParameters.addValue("email", user.getEmail());
		namedParameters.addValue("birthday", user.getBirthday());
		namedParameters.addValue("password", user.getPassword());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		namedParameters.addValue("log_date", dtf.format(localDate));
		namedParameters.addValue("role", "ROLE_USER");
		
		try {
			namedJdbcTemplate.update(sql, namedParameters);
		} catch (DuplicateKeyException e) {
			throw e;
		} catch (DataAccessException e) {
			throw e;
		}
	}

}
