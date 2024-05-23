package com.college.app.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignupDto {
	
	private String firstname;
	private String lastname;
	private String emailid;
	private String password;
	private String mobileno;
	private String role;
	
}
