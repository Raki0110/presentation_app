package com.ty.fresher_presentation_app_springboot.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ty.fresher_presentation_app_springboot.util.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Presentation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String topic;
	private String subject;
	private Status status;
	private double totalScore;
	@CreationTimestamp
	private LocalDateTime creationDateAndTime;
	private double totalTime;
	
	@JsonIgnore
	@OneToMany
	private List<Review> reviews;
	
	@JsonIgnore
	@ManyToOne
	private Fresher presentator;
	
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public Fresher getPresentator() {
		return presentator;
	}
	public void setPresentator(Fresher presentator) {
		this.presentator = presentator;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public double getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}
	public LocalDateTime getCreationDateAndTime() {
		return creationDateAndTime;
	}
	public void setCreationDateAndTime(LocalDateTime creationDateAndTime) {
		this.creationDateAndTime = creationDateAndTime;
	}
	public double getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(double totalTime) {
		this.totalTime = totalTime;
	}
	
	
	

}
