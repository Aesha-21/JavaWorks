package com.valtech.hackathon.userservice.services;

import java.util.List;

import com.valtech.hackathon.userservice.entities.User;
import com.valtech.hackathon.userservice.vos.UserVO;

public interface UserService {
	
	
    void registerUser(User user);
	UserVO createUser(UserVO uvo);

	UserVO getUser(int id);

	List<UserVO> getAllUsers();

	void deleteUser(UserVO uvo);

	List<UserVO> getAllUsersWithMultipleVehicles();

}