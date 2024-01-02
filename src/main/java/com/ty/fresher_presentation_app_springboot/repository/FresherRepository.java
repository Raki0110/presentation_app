package com.ty.fresher_presentation_app_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.fresher_presentation_app_springboot.entity.Fresher;
import com.ty.fresher_presentation_app_springboot.util.Role;

public interface FresherRepository extends JpaRepository<Fresher, Integer>{

	@Query("SELECT f FROM Fresher f WHERE f.role=?1")
	List<Fresher> checkTrainer(Role role);
	
	@Query("SELECT n FROM Fresher n WHERE n.name=?1")
	List<Fresher> findByName(String name);
}
