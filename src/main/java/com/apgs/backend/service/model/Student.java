package com.apgs.backend.service.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

	private Integer Id;
	
	private Integer rollNumber;
	
	private Name studentName;
	
	private Long aadhar;
	
	private LocalDate dateOfBirth;
	
	private LocalDate joiningDate;
	
	private String joinedStandard;
	
	private String address;
	
	private String standard;
	
	//private Teacher classTeacher;
	
}
