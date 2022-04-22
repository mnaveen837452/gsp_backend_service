package com.apgs.backend.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apgs.backend.service.model.Teacher;
import com.apgs.backend.service.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	TeacherService teacherService;
	
	@PostMapping("/addteacher")
	public Integer addTeacher(@RequestBody Teacher teacher) {

		System.out.println("test");
		return teacherService.addTeacher(teacher);
	}

	@GetMapping("/getteacher")
	public Teacher getTeacher(@RequestParam("teacheId") Integer teacherId) {

		return teacherService.getTeacher(teacherId);
	}

	@PutMapping("/updateteacher")
	public Integer updateTeacher(@RequestBody Teacher teacher) {

		return teacherService.updateTeacher(teacher);
	}

	@DeleteMapping("/deleteteacher")
	public String deleteTeacher(@RequestParam("teacheId") Integer teacherId) {
		teacherService.deleteTeacher(teacherId);
		return "Teacher Deleted";
	}
}
