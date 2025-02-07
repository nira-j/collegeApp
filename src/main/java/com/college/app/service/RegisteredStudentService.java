package com.college.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.app.model.RegisteredStudent;
import com.college.app.repository.RegisteredStudentRepository;

@Service
public class RegisteredStudentService {
	
	@Autowired
	private RegisteredStudentRepository registeredStudentRepository;
	
	public List<RegisteredStudent> getAllRegisteredStudent(){
		return registeredStudentRepository.findAll();
		
	}
	
	public List<RegisteredStudent> getRegisteredStudentByCourseId(String courseid){
		return registeredStudentRepository.getByCourseid(courseid);
		
	}


}
