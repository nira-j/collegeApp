package com.college.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.app.model.AnnualResult;
import com.college.app.model.Courses;
import com.college.app.model.Examform;
import com.college.app.service.ExamformService;


@RestController
@CrossOrigin("*")
@RequestMapping("api/v1")
public class ExamController {
	
	@Autowired ExamformService examService;
	
	@GetMapping("/get/courses")
	public List<Courses> getAllCourses(){
		return examService.getAllCourses();
	}
	
	@PostMapping("/save/examform")
	public Examform saveExamform(@RequestBody Examform examform) {
		return examService.saveExamform(examform);
	}
	
	@GetMapping("/get/result/{studentid}")
	public AnnualResult getResultByStudentId(@PathVariable long studentid){
		return examService.getResultByStudentId(studentid);
	}
	
}
