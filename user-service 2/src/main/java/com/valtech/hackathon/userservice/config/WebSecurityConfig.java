package com.valtech.hackathon.userservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class WebSecurityConfig {
	


	@Autowired
	@Lazy
	private JWTFilter jwtFilter;

	@Autowired
	@Lazy 
	private LoginFilter loginFilter;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
		security.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(
						request -> request.requestMatchers("/myuser").anonymous().anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults());
		security.addFilterBefore(loginFilter, BasicAuthenticationFilter.class);
		security.addFilterBefore(jwtFilter, BasicAuthenticationFilter.class);
		return security.build();
	}
	
	@Bean
	public UserDetailsManager userDetailsManager() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.builder().username("aesha").password("test").roles("USER").build());
//		manager.createUser(User.builder().username("aesha").password(passwordEncoder().encode("test")).roles("USER").build());

		return manager;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder();
	}
	
//	private JWTFilter jwtFilter;
//	
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	
//		http.csrf(AbstractHttpConfigurer::disable)
//		.authorizeHttpRequests(a -> a.requestMatchers(HttpMethod.GET,"/api/v1/**").permitAll()
////				.requestMatchers(HttpMethod.POST,"/api/v1/")
//				.requestMatchers("/api/v1/**").authenticated()
//				.anyRequest().permitAll()
//				)
//		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//		.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//		
//		return http.build();
//	}
//	
//	
//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
//		return configuration.getAuthenticationManager();
//	}

}	
	
