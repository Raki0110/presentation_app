package com.ty.fresher_presentation_app_springboot.service;

import java.util.Optional;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.fresher_presentation_app_springboot.dao.FresherDao;
import com.ty.fresher_presentation_app_springboot.dao.PresentationDao;
import com.ty.fresher_presentation_app_springboot.dao.ReviewDao;
import com.ty.fresher_presentation_app_springboot.dto.ResponseStucture;
import com.ty.fresher_presentation_app_springboot.entity.Fresher;
import com.ty.fresher_presentation_app_springboot.entity.Presentation;
import com.ty.fresher_presentation_app_springboot.entity.Review;
import  fresher_presentation_app_springboot.exceptions.*;

import com.ty.fresher_presentation_app_springboot.repository.FresherRepository;
import com.ty.fresher_presentation_app_springboot.repository.PresentationRepository;
import com.ty.fresher_presentation_app_springboot.repository.ReviewRepository;

import fresher_presentation_app_springboot.exceptions.StudentIdNotFoundException;

@Service
public class ReviewService {

	@Autowired
	private ReviewDao reviewDao;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private PresentationRepository presentationRepository;
	
	@Autowired
	private FresherRepository fresherRepository;
	
	@Autowired
	private PresentationDao presentationDao;
	
	public ResponseEntity<ResponseStucture<Review>> saveReview( int r_id, int p_id ,Review review)
	{
	    Optional<Presentation> presentation=presentationRepository.findById(p_id);
	    Presentation prstn=presentation.get();
	    
	    if(prstn!=null)
	    {
	    	Fresher student=prstn.getPresentator();
	    	int presentorId=student.getId();
	    	
	    	if(presentorId!=r_id)
	    	{
	    		Optional<Fresher> reviewer=fresherRepository.findById(r_id);
	    		Fresher reviewer1=reviewer.get();
	    		
	    		review.setVoter(reviewer1);
	    		
	    		Review recievedReview=reviewDao.saveReview(review);
	    		
	    		List<Review> reviews=prstn.getReviews();
	    		reviews.add(review);
	    		
	    		presentationDao.savePresentation(prstn);
	    		
	    		ResponseStucture<Review> responseStucture=new ResponseStucture<>();
	    		responseStucture.setStatusCode(200);
	    		responseStucture.setMessage("success, review saved");
	    		responseStucture.setData(recievedReview);
	    		
	    		return new ResponseEntity<ResponseStucture<Review>>(responseStucture,HttpStatus.CREATED);
	    	}
	    	else
	    	{
	    		throw new UnAuthorizedReviewException("student cannot review himself");
	    	}
	    }
	    else
	    {
	    	ResponseStucture<Review> responseStucture=new ResponseStucture<>();
    		responseStucture.setStatusCode(404);
    		responseStucture.setMessage("Presentation Id not Found");
    		responseStucture.setData(null);
    		
    		return new ResponseEntity<ResponseStucture<Review>>(responseStucture,HttpStatus.NOT_FOUND);
	    }
	}
}
