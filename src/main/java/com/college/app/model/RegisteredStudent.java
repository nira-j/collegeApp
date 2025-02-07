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
@Table(name="registered_student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredStudent {
	
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
	private String course;
	private String courseid;
	//course type UG/PG
	private String coursetype;
	private String paymentAmount;
	private String paymentStatus;
	private String paymentDate;
	//address
	private String cstate;
	private String cdistrict;
	private String cpin;
	private String cstreet;
	
	private String status;
	private String rollno;
	private String enrollno;

}
