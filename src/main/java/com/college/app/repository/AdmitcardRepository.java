package com.college.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.app.model.Admitcard;

public interface AdmitcardRepository extends JpaRepository<Admitcard, Long> {

	public Admitcard findByStudentid(String studentid);
	public Optional<Admitcard> findByRollno(String rollno);
	public List<Admitcard> findByStudentType(String studtype);
	public List<Admitcard> findByCourseid(String courseid);
}
