package com.apgs.backend.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apgs.backend.service.model.Student;
import com.apgs.backend.service.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping("/getmessage")
	public Student getMessage() {
		
		return new Student();
	}
	
	@RequestMapping("/getstudent")
	@ResponseBody
	public Student getStudent(@RequestParam("studentId") int studentId) {
		
		System.out.println("student ID  : " + studentId);
		return studentService.getStudent(studentId);
	}
	
	@PostMapping("/savestudent")
	public Integer saveStudent(@RequestBody Student student) {
		
		return studentService.saveStudent(student);
	}
	
	@PutMapping("/updatestudent")
	public Integer updateStudent(@RequestBody Student student) {
		
		return studentService.updateStudent(student);
	}
	
	@DeleteMapping("/deletestudent")
	public String deleteStudent(@RequestParam("studentId") int studentId) {
		
		return studentService.deleteStudent(studentId);
		
	}
	
}
