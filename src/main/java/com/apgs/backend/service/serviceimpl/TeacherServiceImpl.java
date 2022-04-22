package com.apgs.backend.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apgs.backend.service.dao.SubjectDao;
import com.apgs.backend.service.dao.TeacherDao;
import com.apgs.backend.service.database.model.Subject;
import com.apgs.backend.service.model.Teacher;
import com.apgs.backend.service.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{

	TeacherDao teacherDao;
	
	SubjectDao subjectDao;
	
	@Autowired
	public TeacherServiceImpl(TeacherDao teacherDao, SubjectDao subjectDao){
		this.teacherDao = teacherDao;
		this.subjectDao = subjectDao;
	}
	
	
	
	@Override
	public Integer addTeacher(Teacher teacher) {
		com.apgs.backend.service.database.model.Teacher teacherDb = new com.apgs.backend.service.database.model.Teacher();
		teacherDb.setFirstName(teacher.getFirstName());
		teacherDb.setLastName(teacher.getLastName());
		teacherDb.setMiddleName(teacher.getMiddleName());
		
		teacherDb.setFatherName(teacher.getFatherName());
		teacherDb.setMotherName(teacher.getMotherName());
		
		teacherDb.setQualification(teacher.getQualification());
		teacherDb.setAadhar(teacher.getAadhar());
		
		teacherDb.setJoiningDate(teacher.getJoiningDate());
		teacherDb.setMobileNumber(teacher.getMobileNumber());
		teacherDb.setPhoneNumber(teacher.getPhoneNumber());
		/*
		 * List<Subject> listSubjects = new ArrayList<>();
		 * teacher.getSubjects().forEach(subject -> {
		 * listSubjects.add(subjectDao.getById(subject.getId())); });
		 * teacherDb.setSubjects(listSubjects);
		 */
		com.apgs.backend.service.database.model.Teacher teacherEntity = teacherDao.saveAndFlush(teacherDb);
		
		return teacherEntity.getId();
	}

	@Override
	public Teacher getTeacher(Integer teacherId) {
		com.apgs.backend.service.database.model.Teacher teacherEntity = teacherDao.getById(teacherId);
		Teacher teacher = new Teacher();
		
		teacher.setId(teacherEntity.getId());
		teacher.setFirstName(teacherEntity.getFirstName());
		teacher.setLastName(teacherEntity.getLastName());
		teacher.setMiddleName(teacherEntity.getMiddleName());
		
		teacher.setFatherName(teacherEntity.getFatherName());
		teacher.setMotherName(teacherEntity.getMotherName());
		
		teacher.setQualification(teacherEntity.getQualification());
		teacher.setAadhar(teacherEntity.getAadhar());
		
		teacher.setJoiningDate(teacherEntity.getJoiningDate());
		teacher.setMobileNumber(teacherEntity.getMobileNumber());
		teacher.setPhoneNumber(teacherEntity.getPhoneNumber());
		
		List<com.apgs.backend.service.model.Subject> listSubjects = new ArrayList<>();
		
		/*
		 * teacherEntity.getSubjects().forEach(subjectDb -> {
		 * com.apgs.backend.service.model.Subject subject = new
		 * com.apgs.backend.service.model.Subject(); subjectDb.setId(subjectDb.getId());
		 * subjectDb.setName(subjectDb.getName());
		 * subjectDb.setDescription(subjectDb.getDescription());
		 * listSubjects.add(subject); });
		 * 
		 * teacher.setSubjects(listSubjects);
		 */
		
		return teacher;
	}

	@Override
	public Integer updateTeacher(Teacher teacher) {
		
		com.apgs.backend.service.database.model.Teacher teacherDb = teacherDao.getById(teacher.getId());
		teacherDb.setFirstName(teacher.getFirstName());
		teacherDb.setLastName(teacher.getLastName());
		teacherDb.setMiddleName(teacher.getMiddleName());
		
		teacherDb.setFatherName(teacher.getFatherName());
		teacherDb.setMotherName(teacher.getMotherName());
		
		teacherDb.setQualification(teacher.getQualification());
		teacherDb.setAadhar(teacher.getAadhar());
		
		teacherDb.setJoiningDate(teacher.getJoiningDate());
		teacherDb.setMobileNumber(teacher.getMobileNumber());
		teacherDb.setPhoneNumber(teacher.getPhoneNumber());
		/*
		 * List<Subject> listSubjects = new ArrayList<>();
		 * teacher.getSubjects().forEach(subject -> {
		 * listSubjects.add(subjectDao.getById(subject.getId())); });
		 * teacherDb.setSubjects(listSubjects);
		 */
		com.apgs.backend.service.database.model.Teacher teacherEntity = teacherDao.saveAndFlush(teacherDb);
		return teacherEntity.getId();
	}

	@Override
	public String deleteTeacher(Integer teacherId) {
		com.apgs.backend.service.database.model.Teacher teacherDb = teacherDao.getById(teacherId);
		teacherDao.delete(teacherDb);
		return "Deleted Successfully";
	}

}
