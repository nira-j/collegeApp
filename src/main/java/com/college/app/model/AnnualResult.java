package com.college.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="result")
public class AnnualResult {
	@Id
	private Long studentid;
	private Integer scanno;
	private String name;
	private String fname;
	private String mname;
	private String dob;
	private String gender;
	private String category;
	private String blood_group;
	private String student_photo;
	private String student_signature;
	private String mobile;
	private String status;
	private String userid;
	private String admit_id;
	private String student_id;
	private String course;
	private String courseid;
	private String mediam;
	private String enrollment_no;
	private String rollno;
	private String college_code;
	private String college_name;
	private String degree;
	private String degree_code;
	private String semyr;
	private String semyr_code;
	private String stud_type;
	private String subcode;
	private String subject;
	
	private String sub1p1;
	private String sub1p1code;

	private String sub2p1;
	private String sub2p1code;

	private String sub3p1;
	private String sub3p1code;

	private String sub4p1;
	private String sub4p1code;

	private String sub5p1;
	private String sub5p1code;

	private String sub6p1;
	private String sub6p1code;

	private String sub7p1;
	private String sub7p1code;

	private String sub8p1;
	private String sub8p1code;

	private String sub9p1;
	private String sub9p1code;
	
	private String sub1_th_tot;
	private String sub1_pr_tot;
	private String sub1_tot;
	private String sub2_th_tot;
	private String sub2_pr_tot;
	private String sub2_tot;
	private String sub3_th_tot;
	private String sub3_pr_tot;
	private String sub3_tot;
	private String sub4_th_tot;
	private String sub4_pr_tot;
	private String sub4_tot;
	private String sub5_th_tot;
	private String sub5_pr_tot;
	private String sub5_tot;
	private String sub6_th_tot;
	private String sub6_pr_tot;
	private String sub6_tot;
	private String sub7_th_tot;
	private String sub7_pr_tot;
	private String sub7_tot;
	private String sub8_th_tot;
	private String sub8_pr_tot;
	private String sub8_tot;
	private String sub9_th_tot;
	private String sub9_pr_tot;
	private String sub9_tot;
	
	private String sub1_cr;
	private String sub1_gr;
	private String sub1_dsc;
	private String sub2_cr;
	private String sub2_gr;
	private String sub2_dsc;
	private String sub3_cr;
	private String sub3_gr;
	private String sub3_dsc;
	private String sub4_cr;
	private String sub4_gr;
	private String sub4_dsc;
	private String sub5_cr;
	private String sub5_gr;
	private String sub5_dsc;
	private String sub6_cr;
	private String sub6_gr;
	private String sub6_dsc;
	private String sub7_cr;
	private String sub7_gr;
	private String sub7_dsc;
	private String sub8_cr;
	private String sub8_gr;
	private String sub8_dsc;
	private String sub9_cr;
	private String sub9_gr;
	private String sub9_dsc;

	private String result;
	private String publish_date;
	
	
}
