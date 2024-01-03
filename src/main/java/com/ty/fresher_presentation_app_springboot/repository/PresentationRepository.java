package com.ty.fresher_presentation_app_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.fresher_presentation_app_springboot.entity.Presentation;

public interface PresentationRepository extends JpaRepository<Presentation, Integer>{
	
	@Query("SELECT f FROM Presentation f WHERE f.presentator.id=?1")
	List<Presentation> findByUserId(int id);
	

}
