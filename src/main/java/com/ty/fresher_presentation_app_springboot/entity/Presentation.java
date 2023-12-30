package com.ty.fresher_presentation_app_springboot.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

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
	private String toipc;
	private String subject;
	private String status;
	private double totalScore;
	@CreationTimestamp
	private LocalDateTime creationDateAndTime;
	private double totalTime;
	
	@OneToMany
	private List<Review> reviews;
	
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
	public String getToipc() {
		return toipc;
	}
	public void setToipc(String toipc) {
		this.toipc = toipc;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
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
