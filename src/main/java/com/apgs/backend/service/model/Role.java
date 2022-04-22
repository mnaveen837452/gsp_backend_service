package com.apgs.backend.service.model;

import java.time.LocalDate;

import com.apgs.backend.service.database.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Role {

	private Integer roleId;
	
	private String roleName;
	
	private String roleDescription;
	
	private User createdBy;
	
	private LocalDate createdDate;
	
	private User updatedBy;
	
	private LocalDate modifiedDate;
	
}
