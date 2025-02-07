package com.college.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.app.model.RegisteredStudent;
import com.college.app.service.RegisteredStudentService;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class RegistrationController {
	
	@Autowired
	private RegisteredStudentService registeredStudentService;
	
	
	@GetMapping("admin/registerstudent/list")
	public List <RegisteredStudent> getAllRegisteredStuList() {
		List <RegisteredStudent> l=registeredStudentService.getAllRegisteredStudent();
		return l;
	}

	@GetMapping("admin/registerstudent/list/{courseid}")
	public List <RegisteredStudent> getRegisteredStuListByCourseid(@PathVariable String courseid) {
		return null;
		
	}
	@GetMapping("admin/registerstudent/list/{coursetype}")
	public List <RegisteredStudent> getRegisteredStuListByCourseType(@PathVariable String coursetype) {
		return null;
		
	}
}
