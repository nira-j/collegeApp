package com.college.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.app.model.RegisteredStudent;

@Repository
public interface RegisteredStudentRepository extends JpaRepository<RegisteredStudent, Long>{

	List<RegisteredStudent> getByCourseid(String courseid);
	
}
