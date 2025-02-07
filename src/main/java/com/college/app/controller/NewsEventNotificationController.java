package com.college.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.college.app.model.NewsEvent;
import com.college.app.model.Notification;
import com.college.app.service.NewsEventNotificationService;

@RestController
@CrossOrigin("*")
public class NewsEventNotificationController {
	
	@Autowired NewsEventNotificationService newsEventNotificationService;
	
	public List<NewsEvent> getAllNewsEvents(){
		return newsEventNotificationService.getAllNewsEvents();
	}
	
	public List<Notification> getAllNotification(){
		return newsEventNotificationService.getAllNotification();
	}
	
}
