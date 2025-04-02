package com.valtech.training.springSecurity.vos;

import com.valtech.training.springSecurity.entities.User;

public record UserVO(Long id,String username,String password) {

	public User to() {
//		return new User(id, username, password, "USER");
		return new User(id == null ? 0 : id, username, password, "USER");
	}
}
