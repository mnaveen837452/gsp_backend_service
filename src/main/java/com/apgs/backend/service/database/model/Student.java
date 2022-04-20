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
public class Student {

	@Id
    @GeneratedValue
	Integer id;
	
	@Column
	Integer rollNumber;
	
	@Column
	String firstName;
	
	@Column
	String lastName;
	
	@Column
	String middleName;
	
	@Column
	String fatherFirstName;
	
	@Column
	String fatherLastName;
	
	@Column
	String fatherMiddleName;
	
	@Column
	String motherFirstName;
	
	@Column
	String motherLastName;
	
	@Column
	String motherMiddleName;
	
	@Column
	String standard;
}
