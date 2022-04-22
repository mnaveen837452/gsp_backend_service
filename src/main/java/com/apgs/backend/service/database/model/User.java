package com.apgs.backend.service.database.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="User")
public class User {

	@Id
	@GeneratedValue(generator = "user_sequence")
	private Integer userId;
	
	@Column
	private String loginId;
	
	@Column
	private String password;
	
	@OneToOne
	private Role role;
	
	@OneToOne
	private User createdBy;
	
	@Column
	private LocalDate createdDate;
	
	@OneToOne
	private User updatedBy;
	
	@Column
	private LocalDate modifiedDate;
}
