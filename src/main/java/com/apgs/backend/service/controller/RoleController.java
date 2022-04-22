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

import com.apgs.backend.service.model.Role;
import com.apgs.backend.service.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	RoleService roleService;
	
	@PostMapping("/addrole")
	public Integer addRole(@RequestBody Role role) {
		
		return roleService.addRole(role);
	}
	
	@GetMapping("/getrole")
	public Role getRole(@RequestParam("roleId") Integer roleId) {
		
		return roleService.getRole(roleId);
	}
	
	@PutMapping("/updaterole")
	public Integer updateRole(@RequestBody Role role) {
		
		return roleService.updateRole(role);
	}
	
	@DeleteMapping("/deleterole")
	public String deleteRole(@RequestParam("roleId") Integer roleId) {
		
		return roleService.deleteRole(roleId);
	}
	
	@GetMapping("/getallroles")
	public List<Role> getAllRoles(){
		
		return roleService.getAllRoles();
	}
}
