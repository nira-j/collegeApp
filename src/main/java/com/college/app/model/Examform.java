package com.college.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name="acedemic_exam_form")
public class Examform {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long form_no;
	private String firstname;
	private String lastname;
	private String fathername;
	private String mothername;
	private String dob;
	private String gender;
	private String category;
	private String mobileno;
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
	private String payment_amount;
	private String payment_status;
	private String payment_date;
	private String address;
	private String state;
	private String pin;
	private String district;
	private String course_type;
	private String email_id;
	private String session;
	private String student_type;
	
	
}

