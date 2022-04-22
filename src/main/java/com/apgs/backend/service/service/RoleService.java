package com.apgs.backend.service.service;

import java.util.List;

import com.apgs.backend.service.model.Role;

public interface RoleService {

	public Integer addRole(Role role);
	
	public Role getRole(Integer roleId);
	
	public Integer updateRole(Role role);
	
	public String deleteRole(Integer roleId);
	
	public List<Role> getAllRoles();
	
}
