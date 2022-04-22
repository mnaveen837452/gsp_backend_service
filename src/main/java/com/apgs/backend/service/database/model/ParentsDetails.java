package com.apgs.backend.service.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Student")
public class ParentsDetails {
	
	@Id
	@GeneratedValue(generator = "parent_details_sequence")
	private Integer id;
	
	@Column
	private String fatherFirstName;
	
	@Column
	private String fatherMiddleName;
	
	@Column
	private String fatherLastName;
	
	@Column
	private String motherFirstName;
	
	@Column
	private String motherMiddleName;
	
	@Column
	private String motherLastName;
	
	@Column
	private String address;
	
	@Column
	private Long mobileNumber;
	
	@Column
	private long phoneNumber;
	
	@Column
	private Long fatherAadhar;
	
	@Column
	private Long motherAadhar;
}
