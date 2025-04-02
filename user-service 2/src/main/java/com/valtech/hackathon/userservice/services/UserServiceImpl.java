package com.valtech.hackathon.userservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.hackathon.userservice.entities.User;
import com.valtech.hackathon.userservice.repos.UserRepo;
import com.valtech.hackathon.userservice.repos.VehicleRepo;
import com.valtech.hackathon.userservice.vos.UserVO;



@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private VehicleRepo vehicleRepo;
	
	@Override
	public void registerUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepo.save(user);
	}
	
	@Override
	public UserDetails load
	}
	
	@Override
	public UserVO createUser(UserVO uvo) {
		User user = uvo.to();
//		user.setVehicles(vehicleRepo.findAllById(uvo.vehicleIds()));
		return UserVO.from(userRepo.save(user));
	}

	
	@Override
	public UserVO getUser(int id) {
		return UserVO.from(userRepo.getReferenceById(id));
	}
	
	@Override
	public List<UserVO> getAllUsers(){
		return UserVO.from(userRepo.findAll());
	}
	
	@Override
	public void deleteUser(UserVO uvo) {
		User user = uvo.to();
		user.setVehicles(vehicleRepo.findAllById(uvo.vehicleIds()));
		userRepo.delete(user);
	}


	@Override
	public List<UserVO> getAllUsersWithMultipleVehicles() {
		return UserVO.from(userRepo.findByVehiclesIsNotEmpty());
	}


	
}
