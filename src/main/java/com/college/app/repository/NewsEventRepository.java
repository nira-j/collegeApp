package com.college.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.app.model.NewsEvent;

@Repository
public interface NewsEventRepository extends JpaRepository<NewsEvent, Long> {
	
}
