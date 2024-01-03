package com.ty.fresher_presentation_app_springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int confidence;
	private int communication;
	private int interaction;
	private int eyeContact;
	private int content;
	private int liveliness;
	private int energy;
	
	@OneToOne
	private Fresher voter;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getConfidence() {
		return confidence;
	}

	public void setConfidence(int confidence) {
		this.confidence = confidence;
	}

	public int getCommunication() {
		return communication;
	}

	public void setCommunication(int communication) {
		this.communication = communication;
	}

	public int getInteraction() {
		return interaction;
	}

	public void setInteraction(int interaction) {
		this.interaction = interaction;
	}

	public int getEyeContact() {
		return eyeContact;
	}

	public void setEyeContact(int eyeContact) {
		this.eyeContact = eyeContact;
	}

	public int getContent() {
		return content;
	}

	public void setContent(int content) {
		this.content = content;
	}

	public int getLiveliness() {
		return liveliness;
	}

	public void setLiveliness(int liveliness) {
		this.liveliness = liveliness;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public Fresher getVoter() {
		return voter;
	}

	public void setVoter(Fresher voter) {
		this.voter = voter;
	}
	
	
	
	

}
