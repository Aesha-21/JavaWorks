package com.valtech.hackathon.userservice.vos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.valtech.hackathon.userservice.entities.User;
import com.valtech.hackathon.userservice.entities.Vehicle;
import com.valtech.hackathon.userservice.repos.VehicleRepo;

public record UserVO(int id,String name, String password, String phone, String email, String address, List<Integer> vehicleIds) {

	public static UserVO from (User user){
		List<Integer> vehicleIds   = user.getVehicles().stream().map(vehicleId -> vehicleId.getId()).collect(Collectors.toList());
		return new UserVO(user.getId(), user.getName(), user.getPassword(),user.getPhone(), user.getEmail(),user.getAddress(), vehicleIds);
	} 
	public static List<UserVO> from (List<User> users){
		return users.stream().map(user -> UserVO.from(user)).collect(Collectors.toList());
	}
	public User to() {
		return new User(name,password,phone,email,address);
	}
}
