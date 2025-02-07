package com.college.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student_enrollment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEnrollment {

	//basic details
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long form_no;
	public String firstname;
	public String lastname;
	public String fathername;
	public String mothername;
	public String guardianame;
	public String isdomicile;
	public String dob;
	private String gender;
	private String category;
	private String mobileno;
	private String emailid;
	private String ishandicaped;
	//course applied for
	private String appliedfor;
	//course type UG/PG
	private String coursetype;
	private String courseid;
	private String paymentAmount;
	private String paymentStatus;
	private String paymentDate;
	// permanent address
	private String pstate;
	private String pdistrict;
	private String ppin;
	private String pstreet;
	
	// current address
	private String cstate;
	private String cdistrict;
	private String cpin;
	private String cstreet;
	
	// 10th Accedemic details
	private String mBoard;
	private String mSchool;
	private String mPassyear;
	private String mTotal;
	private String mObtained;
	private String mPercentage;
	private String mMarksheet;
	
	
	// 12th Accedemic details
	private String iBoard;
	private String iSchool;
	private String iPassyear;
	private String iTotal;
	private String iObtained;
	private String iPercentage;
	private String iMarksheet;
	
	// ug Accedemic details
	private String ugUniversity;
	private String ugCollege;
	private String ugPassyear;
	private String ug1Session;
	private String ug1Total;
	private String ug1Obtained;
	private String ug1Percentage;
	private String ug1Marksheet;
	
	private String ug2Session;
	private String ug2Total;
	private String ug2Obtained;
	private String ug2Percentage;
	private String ug2Marksheet;
	
	private String ug3Session;
	private String ug3Total;
	private String ug3Obtained;
	private String ug3Percentage;
	private String ug3Marksheet;
	
}
