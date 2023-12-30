package com.ty.fresher_presentation_app_springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.fresher_presentation_app_springboot.entity.Presentation;
import com.ty.fresher_presentation_app_springboot.entity.Review;
import com.ty.fresher_presentation_app_springboot.repository.ReviewRepository;

@Repository
public class ReviewDao {

	@Autowired
	private ReviewRepository reviewRepository;
	
	public Review saveReview(Review review)
	{
		return reviewRepository.save(review);
	}
}
