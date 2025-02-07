package com.college.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.app.exception.ResourceNotFoundException;
import com.college.app.model.Admitcard;
import com.college.app.model.AnnualResult;
import com.college.app.repository.AdmitcardRepository;
import com.college.app.repository.ResultRepository;

@Service
public class ResultService {

	@Autowired ResultRepository resultRepository;
	@Autowired AdmitcardRepository admitcardRepository;
	
	public AnnualResult getResult(Long studentid) {
		return resultRepository.findByStudentid(studentid);
	}
	public AnnualResult saveResult(AnnualResult annualresult ) {
		return resultRepository.save(annualresult);
	}
	public List<Admitcard> getAllAdmitcard(){
		return admitcardRepository.findAll();
	}
	public Admitcard getAdmitcard(String rollno) {
		Optional<Admitcard> admitcard=admitcardRepository.findByRollno(rollno);
		if(admitcard.isEmpty()) {
			throw new ResourceNotFoundException(String.format("No record found with rollno: %s", rollno));
		}
		return admitcard.get();
	}
	
	public List<Admitcard> getAdmitcardByStudtype(String studtype) {
		List<Admitcard> admitcards = admitcardRepository.findByStudentType(studtype);
		if(admitcards.isEmpty()) {
			throw new ResourceNotFoundException(String.format("Record not found with Student type: %s", studtype));
		}
			return admitcards;
	}
	
	public List<Admitcard> getAdmitcardByCourse(String courseid) {
		List<Admitcard> admitcards=admitcardRepository.findByCourseid(courseid);
		if(admitcards.size()==0) {
			throw new ResourceNotFoundException(String.format("Not found with courseid: %s", courseid));
		}
		return admitcards;
	}
	

}
