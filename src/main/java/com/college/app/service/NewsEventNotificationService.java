package com.college.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.app.model.NewsEvent;
import com.college.app.model.Notification;
import com.college.app.repository.NewsEventRepository;
import com.college.app.repository.NotificationRepository;

@Service
public class NewsEventNotificationService {
	
	@Autowired NewsEventRepository newsEventRepository;
	@Autowired NotificationRepository notificationRepository;

	public List<NewsEvent> getAllNewsEvents(){
		return newsEventRepository.findAll();
	}
	
	public List<Notification> getAllNotification(){
		return notificationRepository.findAll();
	}
}
