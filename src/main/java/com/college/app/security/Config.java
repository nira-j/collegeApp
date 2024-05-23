package com.college.app.security;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import com.college.app.security.service.CustomUserService;

import jakarta.servlet.MultipartConfigElement;

@Configuration
public class Config {
	
	

	 @Bean
	    public StandardServletMultipartResolver standardServletMultipartResolver() {
	        return new StandardServletMultipartResolver();
	    }
	
	@Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserService();
    }
	
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
 
     @Bean
	 public AuthenticationProvider authenticationProvider(){
	     DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
	     authenticationProvider.setUserDetailsService(userDetailsService());
	     authenticationProvider.setPasswordEncoder(passwordEncoder());
	     return authenticationProvider;
	 }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }

}
