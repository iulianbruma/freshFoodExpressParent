package com.freshfood.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.freshfood.User;
import com.freshfood.helper.CustomAuthenticationHelper;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private CustomAuthenticationHelper customAuthenticationHelper;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {

		System.out.println("in authentication");
		String username = auth.getName();
		String password = auth.getCredentials().toString();

		List<GrantedAuthority> authorities = new ArrayList<>();
		User user = customAuthenticationHelper.checkForUserOnLogin(username, password);
		
		if (user != null) {
			authorities.add(new SimpleGrantedAuthority(user.getRole()));
			return new UsernamePasswordAuthenticationToken(auth.getName(), auth.getCredentials(), authorities);
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> auth) {
		return auth.equals(UsernamePasswordAuthenticationToken.class);
	}

	public void setCustomAuthenticationHelper(CustomAuthenticationHelper customAuthenticationHelper) {
		this.customAuthenticationHelper = customAuthenticationHelper;
	}
	
}