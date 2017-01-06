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

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	public CustomAuthenticationProvider() {
		System.out.println("dfg");
	}

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {

		System.out.println("in authentication");
		String username = auth.getName();
		String password = auth.getCredentials().toString();

		List<GrantedAuthority> authorities = new ArrayList<>();
		System.out.println("username = " + username + "; password = " + password);
		if (password.equals("123456") && username.equals("admin")) {
			System.out.println("intrat in if");
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			return new UsernamePasswordAuthenticationToken(auth.getName(), auth.getCredentials(), authorities);
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> auth) {
		return auth.equals(UsernamePasswordAuthenticationToken.class);
	}

}
