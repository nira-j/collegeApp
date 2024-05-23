package com.college.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.college.app.dto.SigninDto;
import com.college.app.dto.SignupDto;
import com.college.app.model.Courses;
import com.college.app.service.ExamformService;
import com.college.app.service.JwtService;
import com.college.app.service.StorageService;
import com.college.app.service.UserService;



@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired StorageService storageService;
	
	@Autowired
	private UserService userService;
	@Autowired ExamformService examService;
	
	@Autowired JwtService jwtService;
	
	@PostMapping("/user/signup")
	public ResponseEntity<String> saveUser(@RequestBody SignupDto signupdto) throws IllegalStateException, IOException {
	    userService.saveUser(signupdto);
	    return ResponseEntity.ok("User created successfully !");
	}
	
	@GetMapping("/get/userdetails")
	public SigninDto getUserDetails() {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 String username=jwtService.getUsernameFromToken((String)authentication.getDetails());
		 
	   return userService.getUserDetails(username);
	}
	
	@PostMapping("/update/mobilemail")
	public SigninDto updateMobileEmail(@RequestParam("mobileno") String mobileno, @RequestParam("emailid") String emailid) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		
		return userService.updateMobileEmail(username, mobileno, emailid);
	}
	
	@PostMapping("/update/password")
	public String updatePassword(@RequestParam("password") String password) {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		
		return userService.updatePassword(username, password);
	}
	
	
	@PostMapping("/upload/profileimage")
	public String handleProfileUpload(@RequestParam("profileimage") MultipartFile file) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username=jwtService.getUsernameFromToken((String)authentication.getDetails());
		storageService.store(file, username, "profile.jpg");
		return "Uploaded Successfully";
	}
	
	@PostMapping("/upload/signatureimage")
	public String handleSignatureUpload(@RequestParam("signatureimage") MultipartFile file) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username=jwtService.getUsernameFromToken((String)authentication.getDetails());
		storageService.store(file, username, "signature.jpg");
		return "Uploaded Successfully";
	}
	
}
