package com.valtech.hackathon.userservice.config;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTFilter extends OncePerRequestFilter{
	
	private JwtHelper jwtHelper;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		if(request.getHeader(HttpHeaders.AUTHORIZATION) == null && request.getRequestURI().equals("/myuser")) {
			filterChain.doFilter(request, response);
			return;
		}
		//if auth header is null then 403 is unauthorized
		String token = request.getHeader(HttpHeaders.AUTHORIZATION).replace("Bearer", "");
		Map<String,Object> claims = jwtHelper.parseToken(token);
		String username = (String) claims.get(Claims.SUBJECT);
		String roles = (String) claims.get("roles");
		List<String> rolesList = List.of(roles.split(","));
		List<GrantedAuthority> authorities = rolesList.stream().map(r -> new SimpleGrantedAuthority(r))
				.collect(Collectors.toList());
//		List.of((String)claims.get("roles")))
		UsernamePasswordAuthenticationToken authToken = 
				new UsernamePasswordAuthenticationToken(username,null, authorities);
		SecurityContextHolder.getContext().setAuthentication(authToken);
		try {
			filterChain.doFilter(request, response);
		}catch(AccessDeniedException ex) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
		
	}
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		
		return request.getRequestURI().equals("/login");
	}

}
