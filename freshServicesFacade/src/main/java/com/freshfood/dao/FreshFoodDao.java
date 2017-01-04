package com.freshfood.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.freshfood.User;
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

}
