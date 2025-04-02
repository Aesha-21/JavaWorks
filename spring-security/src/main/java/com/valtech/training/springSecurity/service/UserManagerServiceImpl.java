package com.valtech.training.springSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.valtech.training.springSecurity.entities.User;
import com.valtech.training.springSecurity.repos.UserRepo;
import com.valtech.training.springSecurity.vos.ChangePasswordVO;

import jakarta.annotation.PostConstruct;

@Service
public class UserManagerServiceImpl implements UserDetailsService, UserManagerService{

	@Autowired
	private UserRepo userRepo;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void init() {
		if(userRepo.count() == 0) {
			registerUSer(new User(0, "Aesha", "qwerty", "USER"));
			registerUSer(new User(0, "admin", "admin", "ADMIN"));
		}
	}
	
	@Override
	public void registerUSer(User user) {
	
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepo.save(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepo.findByUsername(username);
	}

	@Override
	public void changePassword(String username, ChangePasswordVO chpwdVO) {
		User user = (User) loadUserByUsername(username);
		System.out.println("................>>>>>>>>>>>>"+user);
		if(passwordEncoder.matches(chpwdVO.currentPassword(), user.getPassword())) {
			if(chpwdVO.newPassword().equals(chpwdVO.confirmPassword())) {
				user.setPassword(passwordEncoder.encode(chpwdVO.newPassword()));
				userRepo.save(user);
			}
		}
	}

}
