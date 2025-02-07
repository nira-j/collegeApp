package com.college.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.app.model.Courses;
import com.college.app.model.Examform;
import com.college.app.model.StudentEnrollment;
import com.college.app.repository.CoursesRepository;
import com.college.app.repository.ExamformRepository;
import com.college.app.repository.StudentEnrollmentRepository;

@Service
public class AdminService {
	@Autowired StudentEnrollmentRepository studentEnrollmentRepository;
	@Autowired ExamformRepository examformRepository;
	@Autowired CoursesRepository coursesRepository;
	
	public List<StudentEnrollment> getRegisteredStuList(){
		return studentEnrollmentRepository.findAll();
	}
	
	public List<Examform> getFilledExamformList(){
		return examformRepository.findAll();
	}
	
	public List<Courses> getCoursesList(){
		return coursesRepository.findAll();
	}

	public Courses addCourse(Courses courses) {
		coursesRepository.save(courses);
		return courses;
	}
	
	public Map<String, String> getDashboard() {
		return null;
		
	}

	public Map<String, String> getCountStatus() {
		Map<String, String> map=new HashMap<>();
		map.put("examform", examformRepository.count()+"");
		map.put("registration", studentEnrollmentRepository.count()+"");
		map.put("coursescount", coursesRepository.count()+"");
		return map;
	}

	public String enableCourse(String courseid) {
		Courses course=coursesRepository.findByCourseid(courseid);
		if (course == null) {
	        return "Course not found";
	    }
		course.setStatus("Y");
		coursesRepository.save(course);
		return "Enabled";
	}
	
	public String disableCourse(String courseid) {
		Courses course=coursesRepository.findByCourseid(courseid);
		if (course == null) {
	        return "Course not found";
	    }
		course.setStatus("N");
		coursesRepository.save(course);
		return "Disabled";
	}
		
}