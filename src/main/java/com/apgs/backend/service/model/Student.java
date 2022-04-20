package com.apgs.backend.service.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

	Integer Id;
	
	Integer rollNumber;
	
	Name studentName;
	
	Name fatherName;
	
	Name motherName;
	
	String standard;	
	
}
