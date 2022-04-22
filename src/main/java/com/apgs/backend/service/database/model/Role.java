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
@Table(name="Role")
public class Role {

	@Id
	@GeneratedValue(generator = "role_sequence")
	private Integer roleId;
	
	@Column
	private String roleName;
	
	@Column
	private String roleDescription;
	
	@OneToOne
	private User createdBy;
	
	@Column
	private LocalDate createdDate;
	
	@OneToOne
	private User updatedBy;
	
	@Column
	private LocalDate modifiedDate;
	
}
