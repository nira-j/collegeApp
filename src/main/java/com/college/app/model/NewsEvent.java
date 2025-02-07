package com.college.app.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="newsevent")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewsEvent {
	@Id
    private Long id;
    private String title;
    private String description;
    private Date fromdate;
    private Date todate;
    private String author;
   
}

