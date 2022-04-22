package com.apgs.backend.service.service;

import com.apgs.backend.service.model.Subject;

public interface SubjectService {

	public Integer addSubject(Subject subject);
	
	public Subject getSubject(Integer subjectId);
	
	public Integer updateSubject(Subject subject);
	
	public String deleteSubject(Integer subjectId);
}
