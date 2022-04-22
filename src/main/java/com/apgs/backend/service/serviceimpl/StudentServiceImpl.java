package com.apgs.backend.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apgs.backend.service.dao.StudentDao;
import com.apgs.backend.service.model.Name;
import com.apgs.backend.service.model.Student;
import com.apgs.backend.service.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	StudentDao studentDao;
	
	@Autowired
	public StudentServiceImpl(StudentDao studentDao){
		this.studentDao = studentDao;
	}
	
	@Override
	public Student getStudent(Integer studentId) {
		
		com.apgs.backend.service.database.model.Student sutdentById = studentDao.getById(studentId);
		Student student = new Student();
		Name name = new Name();		
		name.setFirst(sutdentById.getFirstName());
		name.setLast(sutdentById.getLastName());
		name.setMiddle(sutdentById.getMiddleName());
		student.setStudentName(name);
		student.setStandard(sutdentById.getStandard());
		student.setRollNumber(sutdentById.getRollNumber());
		return student;
	}

	@Override
	public Integer saveStudent(Student student) {
		com.apgs.backend.service.database.model.Student studentDb = new com.apgs.backend.service.database.model.Student();
		studentDb.setFirstName(student.getStudentName().getFirst());
		studentDb.setLastName(student.getStudentName().getLast());
		studentDb.setMiddleName(student.getStudentName().getMiddle());
		
		/*
		 * studentDb.setFatherFirstName(student.getFatherName().getFirst());
		 * studentDb.setFatherLastName(student.getFatherName().getLast());
		 * studentDb.setFatherMiddleName(student.getStudentName().getMiddle());
		 * 
		 * studentDb.setMotherFirstName(student.getMotherName().getFirst());
		 * studentDb.setMotherLastName(student.getMotherName().getLast());
		 * studentDb.setMotherMiddleName(student.getStudentName().getMiddle());
		 */
		
		studentDb.setRollNumber(student.getRollNumber());
		studentDb.setStandard(student.getStandard());
		com.apgs.backend.service.database.model.Student savedStudent = studentDao.save(studentDb);
		return savedStudent.getId();
	}

	@Override
	public Integer updateStudent(Student student) {
		
		com.apgs.backend.service.database.model.Student studentDb = studentDao.getById(student.getId());
		
		if(!student.getStudentName().getFirst().equalsIgnoreCase("")) {
			studentDb.setFirstName(student.getStudentName().getFirst());
		}
		if(!student.getStudentName().getFirst().equalsIgnoreCase("")) {
			studentDb.setLastName(student.getStudentName().getLast());
		}
		
		if(!student.getStudentName().getFirst().equalsIgnoreCase("")) {
			studentDb.setMiddleName(student.getStudentName().getMiddle());
		}
		
		
		/*
		 * if(!student.getFatherName().getFirst().equalsIgnoreCase("")) {
		 * studentDb.setFatherFirstName(student.getFatherName().getFirst()); }
		 * if(!student.getFatherName().getFirst().equalsIgnoreCase("")) {
		 * studentDb.setFatherLastName(student.getFatherName().getLast()); }
		 * 
		 * if(!student.getFatherName().getFirst().equalsIgnoreCase("")) {
		 * studentDb.setFatherMiddleName(student.getStudentName().getMiddle()); }
		 * 
		 * if(!student.getFatherName().getFirst().equalsIgnoreCase("")) {
		 * studentDb.setMotherFirstName(student.getMotherName().getFirst()); }
		 * if(!student.getFatherName().getFirst().equalsIgnoreCase("")) {
		 * studentDb.setMotherLastName(student.getMotherName().getLast()); }
		 * 
		 * if(!student.getFatherName().getFirst().equalsIgnoreCase("")) {
		 * studentDb.setMotherMiddleName(student.getStudentName().getMiddle()); }
		 */
		
		if(student.getRollNumber() != null) {
			studentDb.setRollNumber(student.getRollNumber());
		}
		if(student.getStandard() != null) {
			studentDb.setStandard(student.getStandard());
		}
		
		com.apgs.backend.service.database.model.Student savedStudent = studentDao.saveAndFlush(studentDb);
		
		return savedStudent.getId();
	}

	@Override
	public String deleteStudent(int studentId) {
		com.apgs.backend.service.database.model.Student studentDb = studentDao.getById(studentId);
		studentDao.delete(studentDb);
		return "Deleted Successfully";
	}

}
