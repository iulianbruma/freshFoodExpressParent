package com.freshfood.dao.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freshfood.User;

public class UserResultSet implements ResultSetExtractor<Map<String, User>>{

	@Override
	public Map<String, User> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, User> users = new HashMap<>();
		
		while (rs.next()) {
			User user = new User();
			user.setUsername(rs.getString("username"));
			user.setFirstName(rs.getString("firstname"));
			user.setLastName(rs.getString("lastname"));
			user.setEmail(rs.getString("email"));
			user.setBirthday(rs.getDate("birthday"));
			user.setPassword(rs.getString("password"));
			user.setLogDate(rs.getDate("log_date"));
			user.setRole(rs.getString("role"));
			
			users.put(user.getUsername(), user);
		}
		
		return users;
	}
	

}
