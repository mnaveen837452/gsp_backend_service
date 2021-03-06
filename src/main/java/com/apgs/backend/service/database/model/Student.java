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
@Table(name="Student")
public class Student {

	@Id
	@GeneratedValue(generator = "student_sequence")
	private Integer id;
	
	@Column
	private Integer rollNumber;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String middleName;
	
	@Column
	private Long aadhar;
	
	@Column
	private LocalDate dateOfBirth;
	
	@Column
	private LocalDate joiningDate;
	
	@Column
	private String joinedStandard;
	
	@Column
	private String address;
	
	@Column
	private String standard;
	
	//@OneToOne
	//private com.apgs.backend.service.database.model.Teacher classTeacher;
	@OneToOne
	private ParentsDetails parentsDetails;
}
