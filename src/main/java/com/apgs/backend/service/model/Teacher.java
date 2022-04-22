package com.apgs.backend.service.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Teacher {

	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String middleName;
	
	private String fatherName;
	
	private String motherName;
	
	private String qualification;
	
	//@JsonbDateFormat("dd/MM/yyyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate joiningDate;
	
	private Long mobileNumber;
	
	private String phoneNumber;
	
	private Long aadhar;
	
	//private List<Subject> subjects;	
}
