package com.ty.fresher_presentation_app_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.fresher_presentation_app_springboot.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{

}
