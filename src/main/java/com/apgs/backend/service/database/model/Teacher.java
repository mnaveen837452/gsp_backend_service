package com.apgs.backend.service.database.model;

import java.time.LocalDate;

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
@Table(name = "Teacher")
public class Teacher {

	@Id
	@GeneratedValue(generator = "teacher_sequence")
	private Integer id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String middleName;
	
	@Column
	private String fatherName;
	
	@Column
	private String motherName;
	
	@Column
	private String qualification;
	
	@Column
	private LocalDate joiningDate;
	
	@Column
	private Long mobileNumber;
	
	@Column
	private String phoneNumber;
	
	@Column
	private Long aadhar;
	
	/*
	 * @OneToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "ID", referencedColumnName = "ID") private List<Subject>
	 * subjects;
	 */
}
