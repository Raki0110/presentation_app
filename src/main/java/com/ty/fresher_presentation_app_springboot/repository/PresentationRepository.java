package com.ty.fresher_presentation_app_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.fresher_presentation_app_springboot.entity.Presentation;

public interface PresentationRepository extends JpaRepository<Presentation, Integer>{
	
	

}
