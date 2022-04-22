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
@Table(name = "subject")
public class Subject {

	@Id
	@GeneratedValue(generator = "subject_sequence")
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String description;
}
