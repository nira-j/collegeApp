package com.college.app.dto;

import java.util.Set;

import com.college.app.model.Role;

import lombok.Data;

@Data
public class SigninDto {
	
	private Long id;
	private String username;
	private String firstname;
	private String lastname;
	private String mobileno;
	private String regno;
	private String emailid;
	private String examrollno;
	private String course;
	private String profileimage;
	private String profilesignature;
	private String token;
	private String role;
}
