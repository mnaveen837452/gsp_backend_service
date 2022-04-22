package com.apgs.backend.service.serviceimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apgs.backend.service.dao.RoleDao;
import com.apgs.backend.service.dao.UserDao;
import com.apgs.backend.service.model.Role;
import com.apgs.backend.service.model.User;
import com.apgs.backend.service.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	UserDao userDao;
	
	RoleDao roleDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao, RoleDao roleDao){
		this.userDao = userDao;
		this.roleDao = roleDao;
	}
	
	@Override
	public Integer addUser(User user) {
		com.apgs.backend.service.database.model.User userDb = new com.apgs.backend.service.database.model.User();
		userDb.setLoginId(user.getLoginId());
		userDb.setPassword(user.getPassword());
		userDb.setRole(roleDao.getById(user.getRole().getRoleId()));
		userDb.setCreatedDate(LocalDate.now());
		com.apgs.backend.service.database.model.User userEntity = userDao.saveAndFlush(userDb);
		return userEntity.getUserId();
	}

	@Override
	public User getUser(Integer userId) {
		com.apgs.backend.service.database.model.User userDb = userDao.getById(userId);
		User user = new User();
		
		user.setUserId(userDb.getUserId());
		user.setPassword(userDb.getPassword());
		user.setLoginId(userDb.getLoginId());
		Role role = new Role();
		
		role.setRoleId(userDb.getRole().getRoleId());
		role.setRoleName(userDb.getRole().getRoleName());
		role.setRoleDescription(userDb.getRole().getRoleDescription());
		user.setRole(role);
		return user;
	}

	@Override
	public Integer updateUser(User user) {
		com.apgs.backend.service.database.model.User userDb = userDao.getById(user.getUserId());
		userDb.setLoginId(user.getLoginId());
		userDb.setPassword(user.getPassword());
		userDb.setRole(roleDao.getById(user.getRole().getRoleId()));
		userDb.setModifiedDate(LocalDate.now());
		com.apgs.backend.service.database.model.User userEntity = userDao.saveAndFlush(userDb);
		return userEntity.getUserId();
	}

	@Override
	public String deleteUser(Integer userId) {
		com.apgs.backend.service.database.model.User userDb = userDao.getById(userId);
		userDao.delete(userDb);
		return "Deleted Successfully";
	}

	@Override
	public List<User> getAllUsers() {
		List<User> usersList = new ArrayList<>();
		List<com.apgs.backend.service.database.model.User> usersListDb = userDao.findAll();
		
		usersListDb.forEach(userDb -> {
			User user = new User();
			user.setUserId(userDb.getUserId());
			user.setPassword(userDb.getPassword());
			Role role = new Role();
			role.setRoleId(userDb.getRole().getRoleId());
			role.setRoleName(userDb.getRole().getRoleName());
			role.setRoleDescription(userDb.getRole().getRoleDescription());
			user.setRole(role);
			usersList.add(user);
		});
		return usersList;
	}

}
