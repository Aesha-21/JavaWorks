package com.valtech.hackathon.userservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.hackathon.userservice.services.UserService;
import com.valtech.hackathon.userservice.services.VehicleService;
import com.valtech.hackathon.userservice.vos.UserVO;
import com.valtech.hackathon.userservice.vos.VehicleVO;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@PostMapping("/")
	public UserVO addUSer(@RequestBody UserVO userVO) {
		return userService.createUser(userVO);
	}
	@PostMapping("/{id}/addVehicle")
	public VehicleVO addVehicle(@PathVariable("id") int userID, @RequestBody VehicleVO vvo) {
		return vehicleService.addVehicleByUserId(vvo, userID);
	}
	@GetMapping("/{id}")
	public UserVO getUser(@PathVariable("id") int id) {
		return userService.getUser(id);
	}
	@GetMapping("/")
	public List<UserVO> getAllUsers() {
		return userService.getAllUsers();
	}
	@GetMapping("/vehicleOwners")
	public List<UserVO> getAllUsersWithMultipleVehicles(){
		return userService.getAllUsersWithMultipleVehicles();
	}
	
	@GetMapping("/login")
	public String getUserAuth() {
		System.out.println("Login the user");
		return "Login";
	}
	
//	@GetMapping("/myuser")
//	public List<UserVO> getUserAuth() {
//		System.out.println("get the user");
//		return userService.getAllUsers();
//	}
//	
	
	
	
	
		
}
