package com.college.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.app.model.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Long>{
	
	public List<Courses> findAllByCollegecode(String collegecode);
}
