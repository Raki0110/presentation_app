package com.ty.fresher_presentation_app_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.fresher_presentation_app_springboot.dto.ResponseStucture;
import com.ty.fresher_presentation_app_springboot.entity.Presentation;
import com.ty.fresher_presentation_app_springboot.entity.Review;
import com.ty.fresher_presentation_app_springboot.service.PresentationService;
import com.ty.fresher_presentation_app_springboot.service.ReviewService;

@RestController
public class ReviewController {

	@Autowired(required = true)
	private ReviewService reviewService; 
	
	@PostMapping("/savereview/{rid}/{pid}")
	public ResponseEntity<ResponseStucture<Review>> savePresentation(@RequestBody Review review,@PathVariable int rid,@PathVariable int pid)
	{
		return reviewService.saveReview(rid, pid, review);
	}
	
}
