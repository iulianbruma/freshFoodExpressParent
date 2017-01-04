package com.freshfood.dao.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freshfood.User;

public class UserResultSetExtractor implements ResultSetExtractor<Map<String, User>> {

	public Map<String, User> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		Map<String, User> users = new HashMap<String, User>();;
		
		return null;
	}
	

}
