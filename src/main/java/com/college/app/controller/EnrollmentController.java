package com.college.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.college.app.model.StudentEnrollment;
import com.college.app.service.StudentEnrollmentService;

@RequestMapping("api/v1")
public class EnrollmentController {
	
	@Autowired StudentEnrollmentService studentEnrollmentService;
	
	@PostMapping("user/register")
	public StudentEnrollment getResitered(@RequestBody StudentEnrollment studentEnrollment) {
		studentEnrollmentService.getRegister(studentEnrollment);
		return studentEnrollment;
	}
	
	@GetMapping("admin/generate/enrollment/{courseid}/{semyr}")
	public String generateEnrollment(@PathVariable String courseid, @PathVariable String semyr) {
		return studentEnrollmentService.generateEnrollment(courseid, semyr);
	}
	
	@GetMapping("admin/generate/rollno/{courseid}/{semyr}")
	public String generateRollno(@PathVariable String courseid, @PathVariable String semyr) {
		return studentEnrollmentService.generateRollno(courseid, semyr);
	}
}
