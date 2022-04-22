package com.apgs.backend.service.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

	private Integer userId;
	
	private String loginId;
	
	private String password;
	
	private Role role;
	
	private User createdBy;
	
	private LocalDate createdDate;
	
	private User updatedBy;
	
	private LocalDate modifiedDate;
}
