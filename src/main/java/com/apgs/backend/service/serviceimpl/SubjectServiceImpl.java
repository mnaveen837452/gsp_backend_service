package com.apgs.backend.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apgs.backend.service.dao.SubjectDao;
import com.apgs.backend.service.model.Subject;
import com.apgs.backend.service.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	SubjectDao subjectDao;
	
	@Autowired
	public SubjectServiceImpl(SubjectDao subjectDao){
		this.subjectDao = subjectDao;
	}
	
	@Override
	public Integer addSubject(Subject subject) {
		com.apgs.backend.service.database.model.Subject subjectDb = new com.apgs.backend.service.database.model.Subject();
		subjectDb.setName(subject.getName());
		subjectDb.setDescription(subject.getDescription());
		com.apgs.backend.service.database.model.Subject subjectEntity = subjectDao.save(subjectDb);
		return subjectEntity.getId();
	}

	@Override
	public Subject getSubject(Integer subjectId) {
		com.apgs.backend.service.database.model.Subject subjectDb = subjectDao.getById(subjectId);
		Subject subject = new Subject();
		subject.setId(subjectDb.getId());
		subject.setName(subjectDb.getName());
		subject.setDescription(subjectDb.getDescription());
		return subject;
	}

	@Override
	public Integer updateSubject(Subject subject) {
		com.apgs.backend.service.database.model.Subject subjectDb = subjectDao.getById(subject.getId());
		subjectDb.setName(subject.getName());
		subjectDb.setDescription(subject.getDescription());
		com.apgs.backend.service.database.model.Subject subjectEntity = subjectDao.saveAndFlush(subjectDb);
		return subjectEntity.getId();
	}

	@Override
	public String deleteSubject(Integer subjectId) {
		com.apgs.backend.service.database.model.Subject subjectDb = subjectDao.getById(subjectId);
		subjectDao.delete(subjectDb);
		return "Deleted Succefully";
	}

}
