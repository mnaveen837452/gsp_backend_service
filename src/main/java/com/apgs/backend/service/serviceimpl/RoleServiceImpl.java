package com.apgs.backend.service.serviceimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apgs.backend.service.dao.RoleDao;
import com.apgs.backend.service.model.Role;
import com.apgs.backend.service.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	RoleDao roleDao;
	
	@Autowired
	public RoleServiceImpl(RoleDao roleDao){
		this.roleDao = roleDao;
	}
	
	@Override
	public Integer addRole(Role role) {
		com.apgs.backend.service.database.model.Role roleDb = new com.apgs.backend.service.database.model.Role();
		roleDb.setRoleName(role.getRoleName());
		roleDb.setRoleDescription(role.getRoleDescription());
		roleDb.setCreatedDate(LocalDate.now());
		com.apgs.backend.service.database.model.Role roleEntity = roleDao.saveAndFlush(roleDb);
		return roleEntity.getRoleId();
	}

	@Override
	public Role getRole(Integer roleId) {
		com.apgs.backend.service.database.model.Role roleEntity = roleDao.getById(roleId);
		Role role = new Role();
		role.setRoleId(roleEntity.getRoleId());
		role.setRoleName(roleEntity.getRoleName());
		role.setRoleDescription(roleEntity.getRoleDescription());
		return role;
	}

	@Override
	public Integer updateRole(Role role) {
		com.apgs.backend.service.database.model.Role roleDb = roleDao.getById(role.getRoleId());
		roleDb.setRoleName(role.getRoleName());
		roleDb.setRoleDescription(role.getRoleDescription());
		roleDb.setModifiedDate(LocalDate.now());
		com.apgs.backend.service.database.model.Role roleEntity = roleDao.saveAndFlush(roleDb);
		return roleEntity.getRoleId();
	}

	@Override
	public String deleteRole(Integer roleId) {
		com.apgs.backend.service.database.model.Role roleDb = roleDao.getById(roleId);
		roleDao.delete(roleDb);
		return "Deleted successfully";
	}

	@Override
	public List<Role> getAllRoles() {
		List<com.apgs.backend.service.database.model.Role> rolesListDb = roleDao.findAll();
		List<Role> rolesList = new ArrayList<>();
		rolesListDb.forEach(roleDb -> {
			Role role = new Role();
			role.setRoleId(roleDb.getRoleId());
			role.setRoleName(roleDb.getRoleName());
			role.setRoleDescription(roleDb.getRoleDescription());
			rolesList.add(role);
		});
		return rolesList;
	}

}
