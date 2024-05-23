package com.college.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.app.model.AnnualResult;


public interface ResultRepository extends JpaRepository<AnnualResult, Long>{

	public AnnualResult findByStudentid(Long studentid);

}
