package com.college.app.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="notification")
public class Notification {
	@Id
    private Long id;
    private String message;
    private String type;
    private Date timestamp;

    // Constructor
    
    public Notification() {}
    
    public Notification(Long id, String message, String type, Date timestamp) {
        this.id = id;
        this.message = message;
        this.type = type;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    // toString Method
    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", type='" + type + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}

