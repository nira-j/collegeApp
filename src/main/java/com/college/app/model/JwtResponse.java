package com.college.app.model;

import java.util.List;

import com.college.app.dto.SigninDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class JwtResponse {
	
	private String jwttoken;
	private String username;
	private String role;

}
