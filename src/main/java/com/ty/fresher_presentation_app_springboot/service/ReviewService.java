package com.ty.fresher_presentation_app_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ty.fresher_presentation_app_springboot.dao.FresherDao;
import com.ty.fresher_presentation_app_springboot.dao.ReviewDao;
import com.ty.fresher_presentation_app_springboot.dto.ResponseStucture;
import com.ty.fresher_presentation_app_springboot.entity.Fresher;
import com.ty.fresher_presentation_app_springboot.entity.Review;

public class ReviewService {

	@Autowired
	private ReviewDao reviewDao;
	
	public ResponseEntity<ResponseStucture<Review>> saveReview(Review review)
	{
		Review recievedReview=reviewDao.saveReview(review);
		
		ResponseStucture<Review> responseStucture=new ResponseStucture<>();
		responseStucture.setStatusCode(200);
		responseStucture.setMessage("success");
		responseStucture.setData(recievedReview);
		
		return new ResponseEntity<ResponseStucture<Review>>(responseStucture,HttpStatus.CREATED);
	}
}
