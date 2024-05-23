package com.college.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.app.model.AnnualResult;
import com.college.app.model.Courses;
import com.college.app.model.Examform;
import com.college.app.repository.CoursesRepository;
import com.college.app.repository.ExamformRepository;
import com.college.app.repository.ResultRepository;


@Service
public class ExamformService {
	
	@Autowired ExamformRepository examformRepository;
	@Autowired CoursesRepository coursesRepository;
	@Autowired ResultRepository resultRepository;
	
	public List<Courses> getCourses(String collegecode) {
		return coursesRepository.findAllByCollegecode(collegecode);
	}
	
	public Examform saveExamform(Examform examform) {
		return examformRepository.save(examform);
	}

	public List<Courses> getAllCourses() {
		return coursesRepository.findAll();
	}
	
	public AnnualResult getResultByStudentId(Long studentid) {
		return resultRepository.findByStudentid(studentid);
	}
}
