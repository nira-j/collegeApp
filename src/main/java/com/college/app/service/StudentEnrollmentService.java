package com.college.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.app.model.Courses;
import com.college.app.model.RegisteredStudent;
import com.college.app.model.StudentEnrollment;
import com.college.app.repository.CoursesRepository;
import com.college.app.repository.RegisteredStudentRepository;
import com.college.app.repository.StudentEnrollmentRepository;

@Service
public class StudentEnrollmentService {
	
	private @Autowired StudentEnrollmentRepository studentEnrollmentRepository;
	private @Autowired ExamformService examformService;
	private @Autowired RegisteredStudentService registeredStudentService;
	private @Autowired CoursesRepository coursesRepository;
	private @Autowired RegisteredStudentRepository registeredStudentRepository;

	public StudentEnrollment getRegister(StudentEnrollment studentEnrollment) {
		studentEnrollmentRepository.save(studentEnrollment);
		return studentEnrollment;
	}
	
	public String generateEnrollment(String courseid, String semyr) {
		Courses course = examformService.getCoursesById(courseid);
		List<RegisteredStudent> stuList=registeredStudentService.getRegisteredStudentByCourseId(courseid);
		String coursetype = course.getCoursetype();
		String degree = course.getDegree();
		String course_id = course.getCourseid().substring(2, 5);
		for (int i=0; i<=stuList.size(); i++) {
			stuList.get(i).setEnrollno("2025"+degree+coursetype+course_id+i+"i");
		}
		registeredStudentRepository.saveAll(stuList);
		return "Enrollment no. generated";
	}
	
	public String generateRollno(String courseid, String semyr) {
		Courses course = examformService.getCoursesById(courseid);
		List<RegisteredStudent> stuList=registeredStudentService.getRegisteredStudentByCourseId(courseid);
		
		return semyr;
	}

}
