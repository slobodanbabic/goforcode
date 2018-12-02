package com.goforcode.Web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goforcode.Web.model.User;
import com.goforcode.Web.repository.UserRepository;

@Service
public class UserService {

	UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}

}
