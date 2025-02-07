package com.college.app.security;

import org.springframework.stereotype.Component;

@Component
public class StorageProperties {

	/**
	 * Folder location for storing files
	 */
	private String location = "E:\\collegefrontapp\\public\\uploadedimg";

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}