package com.freshfood.security;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.freshfood.User;

public class UserAuthorityGranter {
	
	public Authentication getAuthenticationToken(User user, Authentication authentication) {
		Collection<GrantedAuthority> authorities = createAuthorities(user);
		
		UsernamePasswordAuthenticationToken newAuthentication = new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(), authorities);
		return newAuthentication; 
	}

	private Collection<GrantedAuthority> createAuthorities(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}
