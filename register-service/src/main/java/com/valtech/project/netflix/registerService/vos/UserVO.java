package com.valtech.project.netflix.registerService.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.project.netflix.registerService.entities.User;

public record UserVO(long id,String name,int age,String mobile,String email,boolean kid) {

	public static UserVO from(User usr) {
	
		return new UserVO(usr.getId(), usr.getName(), usr.getAge(), usr.getMobile(), usr.getEmail(), usr.getKid());
	}
	
	public User to(User user) {
		return new User(name, age, mobile, email, kid);
	}
	
	public List<UserVO> from(List<User> user){
		return user.stream().map(u -> UserVO.from(u)).collect(Collectors.toList());
	}
}
