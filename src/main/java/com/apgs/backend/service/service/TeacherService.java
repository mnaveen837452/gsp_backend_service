package com.apgs.backend.service.service;

import com.apgs.backend.service.model.Teacher;

public interface TeacherService {

	public Integer addTeacher(Teacher teacher);
	
	public Teacher getTeacher(Integer teacherId);
	
	public Integer updateTeacher(Teacher teacher);
	
	public String deleteTeacher(Integer teacherId);
}
