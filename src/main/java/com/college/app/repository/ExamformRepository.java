package com.college.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.app.model.Courses;
import com.college.app.model.Examform;

	public interface ExamformRepository extends JpaRepository<Examform, Long>{
		
		public List<Courses> findAllByCollegecode(String collegecode);

	}

