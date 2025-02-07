package com.college.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="admitcard")
public class Admitcard {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long slno;
	private String stuname;
	private String mothername;
	private String fathername;
	private String gender;
	private String category;
	private String course;
	private String courseid;
	private String medium;
	private String collegename;
	private String collegecode;
	private String regno;
	private String enrollmentno;
	private String rollno;
	private String semyr;
	private String studentid;
	private String profileimage;
	private String signatureimage;
	private String session;
	private String studentType;
	private String studentTypeCode;
	private String status;

}
