package com.ty.fresher_presentation_app_springboot.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ty.fresher_presentation_app_springboot.util.Role;
import com.ty.fresher_presentation_app_springboot.util.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Fresher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private long phone;
	private String password;
	private Role role;
	private Status status;
	private double userTotalScore;
	
	@JsonIgnore
	@OneToMany
	private List<Presentation> presentation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Presentation> getPresentation() {
		return presentation;
	}

	public void setPresentation(List<Presentation> presentation) {
		this.presentation = presentation;
	}

	public double getUserTotalScore() {
		return userTotalScore;
	}

	public void setUserTotalScore(double userTotalScore) {
		this.userTotalScore = userTotalScore;
	}

	
	
	
	
	
	
	
	

}
