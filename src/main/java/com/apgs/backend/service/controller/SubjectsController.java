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

import com.apgs.backend.service.model.Subject;
import com.apgs.backend.service.service.SubjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectsController {

	@Autowired
	SubjectService subjectService;
	
	@PostMapping("/addsubject")
	public Integer addSubject(@RequestBody Subject subject) {
		
		return subjectService.addSubject(subject);
	}
	
	@GetMapping("/getsubject")
	public Subject getSubject(@RequestParam("subjectId") Integer subjectId) {
		System.out.println("test");
		return subjectService.getSubject(subjectId);
	}
	

	@PutMapping("/updatesubject")
	public Integer updateSubject(@RequestBody Subject subject) {
		return subjectService.updateSubject(subject);
	}

	@DeleteMapping("/deletesubject")
	public String deleteSubject(@RequestParam("subjectId") Integer subjectId) {
		return subjectService.deleteSubject(subjectId);
	}
}
