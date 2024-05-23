package com.college.app.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.college.app.model.Role;
import com.college.app.model.User;
import com.college.app.repository.UserRepository;
import com.college.app.dto.SigninDto;
import com.college.app.dto.SignupDto;



@Service
public class UserService {
	
	@Autowired UserRepository userRepository;
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	
	public SigninDto getUserDetails(String username) {
		
		SigninDto signindto=new SigninDto();
		User user=userRepository.findByUsername(username);
		
		signindto.setId(user.getId());
		signindto.setFirstname(user.getFirstname());
		signindto.setLastname(user.getLastname());
		signindto.setMobileno(user.getMobileno());
		signindto.setProfileimage(user.getProfileimage());
		signindto.setProfilesignature(user.getProfilesignature());
		signindto.setUsername(user.getUsername());
		signindto.setRegno(user.getRegno());
		signindto.setCourse(user.getCourse());
		signindto.setEmailid(user.getEmailid());
		signindto.setExamrollno(user.getExamrollno());
		for(Role role: user.getRoles()) {
			signindto.setRole(role.getRolename());
		}
		
		return signindto;
				
	}
	public SignupDto saveUser(SignupDto signupdto) throws IllegalStateException, IOException {
		
		User user=new User();
		user.setEmailid(signupdto.getEmailid());
		user.setFirstname(signupdto.getFirstname());
		user.setLastname(signupdto.getLastname());
		user.setMobileno(signupdto.getMobileno());
		user.setPassword(passwordEncoder.encode(signupdto.getPassword()));
		user.setUsername(signupdto.getFirstname()+"_"+signupdto.getLastname());
		user.setStatus("Y");
		
		
		Role role=new Role();
		role.setRolename(signupdto.getRole());
		
		Set<Role> roleset = new HashSet<>();
		roleset.add(role);
		user.setRoles(roleset);
		
		userRepository.save(user);
		return signupdto;
		
	}
	
	public SigninDto updateMobileEmail(String username, String mobileno, String emailid) {
		User user=userRepository.findByUsername(username);
		
		user.setMobileno(mobileno);
		user.setEmailid(emailid);
		userRepository.save(user);
		
		return getUserDetails(username);
		
	}
	
	public String updatePassword(String username, String password) {
		User user = userRepository.findByUsername(username);
		user.setPassword(passwordEncoder.encode(password));
		userRepository.save(user);
		
		return "Password updated successfully";
	}
	
	


}
