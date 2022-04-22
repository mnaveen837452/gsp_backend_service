package com.apgs.backend.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apgs.backend.service.model.User;
import com.apgs.backend.service.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/adduser")
	public Integer addUser(@RequestBody User user) {
		
		return userService.addUser(user);
	}
	
	@GetMapping("/getuser")
	public User getUser(@RequestParam("userId") Integer userId) {
		
		return userService.getUser(userId);
	}
	
	@PutMapping("/updateuser")
	public Integer updateUser(@RequestBody User user) {
		
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/deleteuser")
	public String deleteUser(@RequestParam("userId") Integer userId) {
		
		return userService.deleteUser(userId);
	}
	
	@GetMapping("/getallusers")
	public List<User> getAllUsers(){
		
		return userService.getAllUsers();
	}
}
