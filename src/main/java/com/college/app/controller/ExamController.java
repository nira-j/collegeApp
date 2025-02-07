package com.college.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.app.model.Admitcard;
import com.college.app.model.AnnualResult;
import com.college.app.model.Courses;
import com.college.app.model.Examform;
import com.college.app.service.ExamformService;
import com.college.app.service.ResultService;


@RestController
@CrossOrigin("*")
@RequestMapping("api/v1")
public class ExamController {
	
	@Autowired ExamformService examService;
	@Autowired ResultService resultService;
	
	@GetMapping("/get/courses/{course_type}")
	public List<Courses> getAllCourses(@PathVariable String course_type){
		return examService.getAllCourses(course_type);
	}
	
	@GetMapping("/get/courses/{courseid}")
	public Courses getCoursesById(@PathVariable String courseid){
		return examService.getCoursesById(courseid);
	}
	
	@GetMapping("/getall/courses")
	public List<Courses> getAllCourses(){
		return examService.getAllCourses();
	}
	
	@DeleteMapping("/delete/course/{id}")
	public String deleteCourse(@PathVariable Long id) {
		return examService.deleteCourse(id);
	}
	
	@PostMapping("/save/examform")
	public Examform saveExamform(@RequestBody Examform examform) {
		return examService.saveExamform(examform);
	}
	
	@GetMapping("/get/result/{studentid}")
	public AnnualResult getResultByStudentId(@PathVariable long studentid){
		return examService.getResultByStudentId(studentid);
	}
	
	@GetMapping("/get/admitcard/{studentid}")
	public Admitcard getAdmitcard(@PathVariable String studentid) {
		return resultService.getAdmitcard(studentid);
	}
	
}
