package com.college.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.app.model.AnnualResult;
import com.college.app.repository.ResultRepository;

@Service
public class ResultService {

	@Autowired ResultRepository resultRepository;
	
	public AnnualResult getResult(Long studentid) {
		return resultRepository.findByStudentid(studentid);
	}
	public AnnualResult saveResult(AnnualResult annualresult ) {
		return resultRepository.save(annualresult);
	}
	

}
