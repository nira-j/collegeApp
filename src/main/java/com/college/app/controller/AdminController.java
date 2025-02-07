package com.college.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.app.model.Admitcard;
import com.college.app.model.Courses;
import com.college.app.model.Examform;
import com.college.app.model.StudentEnrollment;
import com.college.app.service.AdminService;
import com.college.app.service.ResultService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/admin")
public class AdminController {
	
	@Autowired AdminService adminService;
	@Autowired ResultService resultService;
	
	//initial dashboard as admin login(landingpage)
	@GetMapping("/dashboard")
	public Map<String, String> getDashboard(){
		return adminService.getCountStatus();
	}
	
	@GetMapping("/examform/list")
	public List <Examform> getFilledExamformList() {
		return null;
		
	}
	
	@PostMapping("/course/add")
	public Courses addCourse(@RequestBody Courses courses) {
		adminService.addCourse(courses);
		return courses;
	}
	
	
	@PostMapping("/admitcard/all")
	public List<Admitcard> getAllAdmitcard() {
		return resultService.getAllAdmitcard();
	}
	
	@GetMapping("/admitcard/{rollno}")
	public Admitcard getAdmitcard(@PathVariable String rollno) {
		return resultService.getAdmitcard(rollno);
	}
	
	@GetMapping("/admitcard/studtype/{studtype}")
	public List<Admitcard> getAdmitcardByStudtype(@PathVariable String studtype) {
		return resultService.getAdmitcardByStudtype(studtype);
	}
	
	@GetMapping("/admitcard/course/{courseid}")
	public List<Admitcard> getAdmitcardByCourse(@PathVariable String courseid) {
		return resultService.getAdmitcardByCourse(courseid);
	}
	
	@GetMapping("/course/enable/{courseid}")
	public String enableCourse(@PathVariable String courseid) {
		return adminService.enableCourse(courseid);
	}
	
	@GetMapping("/course/disabled/{courseid}")
	public String disableCourse(@PathVariable String courseid) {
		return adminService.disableCourse(courseid);
	}
	

}
