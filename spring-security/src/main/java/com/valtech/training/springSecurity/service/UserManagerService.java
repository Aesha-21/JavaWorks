package com.valtech.training.springSecurity.service;

import com.valtech.training.springSecurity.entities.User;
import com.valtech.training.springSecurity.vos.ChangePasswordVO;

public interface UserManagerService {

	void registerUSer(User user);

	void changePassword(String username, ChangePasswordVO chpwdVO);

}