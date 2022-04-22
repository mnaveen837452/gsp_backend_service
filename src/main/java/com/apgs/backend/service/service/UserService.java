package com.apgs.backend.service.service;

import java.util.List;

import com.apgs.backend.service.model.User;

public interface UserService {

	public Integer addUser(User user);
	
	public User getUser(Integer usrId);
	
	public Integer updateUser(User user);
	
	public String deleteUser(Integer userId);
	
	public List<User> getAllUsers();
}
