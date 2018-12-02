package com.goforcode.Web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goforcode.Web.model.User;
import com.goforcode.Web.service.UserService;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

	@Autowired
	UserService userService;// ...

	@GetMapping
	public ResponseEntity<List<User>> showUsers() {
		List<User> users = userService.getAllUsers();
		for (User u : users) {
			System.out.println(u);
		}
//		if (!users.isEmpty())
		return new ResponseEntity<>(users, HttpStatus.OK);
//		else
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		if (!userService.getAllUsers().contains(user)) {
			User savedUser = userService.saveUser(user);
			System.out.println(savedUser);
			
			if (savedUser != null) {
				return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
