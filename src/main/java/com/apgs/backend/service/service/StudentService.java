package com.apgs.backend.service.service;

import com.apgs.backend.service.model.Student;

public interface StudentService {

	public Student getStudent(Integer studentId);

	public Integer saveStudent(Student student);

	public Integer updateStudent(Student student);

	public String deleteStudent(int studentId);
}
