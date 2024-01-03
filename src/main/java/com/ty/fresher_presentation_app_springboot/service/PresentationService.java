	package com.ty.fresher_presentation_app_springboot.service;
	
	import java.util.List;
	import java.util.Optional;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.stereotype.Service;
	
	import com.ty.fresher_presentation_app_springboot.dao.FresherDao;
	import com.ty.fresher_presentation_app_springboot.dao.PresentationDao;
	import com.ty.fresher_presentation_app_springboot.dto.ResponseStucture;
	import com.ty.fresher_presentation_app_springboot.entity.Fresher;
	import com.ty.fresher_presentation_app_springboot.entity.Presentation;
import com.ty.fresher_presentation_app_springboot.entity.Review;
import com.ty.fresher_presentation_app_springboot.repository.FresherRepository;
import com.ty.fresher_presentation_app_springboot.repository.PresentationRepository;
import com.ty.fresher_presentation_app_springboot.util.Status;

import fresher_presentation_app_springboot.exceptions.PresentationIdNotFoundException;
import fresher_presentation_app_springboot.exceptions.StudentIdNotFoundException;
	
	@Service
	public class PresentationService {
	
		@Autowired
		private PresentationDao presentationDao;
		
		@Autowired
		private FresherDao fresherDao;
		
		@Autowired
		private FresherRepository fresherRepository;
		
		@Autowired
		private PresentationRepository presentationRepository;
		
		public ResponseEntity<ResponseStucture<Presentation>> savePresentation(Presentation presentation,int id)
		{
			Optional<Fresher> student = fresherRepository.findById(id);
					if(student.isPresent()) {
						
						Fresher stud=student.get();
						List<Presentation> presentations=  stud.getPresentation();
						presentation.setStatus(Status.ASSIGNED);
						presentation.setPresentator(stud);
						
						presentations.add(presentation);
						stud.setPresentation(presentations);
						
						Presentation recievedPresentation=presentationDao.savePresentation(presentation);
						fresherDao.updateFresher(stud);
						
						ResponseStucture<Presentation> responseStucture=new ResponseStucture<>();
						responseStucture.setStatusCode(200);
						responseStucture.setMessage("success");
						responseStucture.setData(recievedPresentation);
						
						return new ResponseEntity<ResponseStucture<Presentation>>(responseStucture,HttpStatus.CREATED);
					}else {
						
						throw new StudentIdNotFoundException("ID: "+id+" ,not present in DB");
						
//						ResponseStucture<Presentation> responseStucture=new ResponseStucture<>();
//						responseStucture.setStatusCode(404);
//						responseStucture.setMessage("Student Id Not Found");
//						responseStucture.setData(null);
//						return new ResponseEntity<ResponseStucture<Presentation>>(responseStucture,HttpStatus.NOT_FOUND);
					}
		}
		
		public ResponseEntity<ResponseStucture<Presentation>> updatePresentation(int id)
		{
			Optional<Presentation> presentation = presentationRepository.findById(id);
			Presentation prstn =presentation.get();
			if(presentation.isPresent()) {
				if(prstn.getStatus()==Status.ASSIGNED) {
					prstn.setStatus(Status.VOTINGPOLLON);
					Presentation presentation1=presentationDao.savePresentation(prstn);
					ResponseStucture<Presentation> responseStucture=new ResponseStucture<>();
					responseStucture.setStatusCode(200);
					responseStucture.setMessage("Voting Poll is ON");
					responseStucture.setData(presentation1);
					return new ResponseEntity<ResponseStucture<Presentation>>(responseStucture,HttpStatus.OK);
				}
				else if(prstn.getStatus()==Status.VOTINGPOLLON){
					prstn.setStatus(Status.COMPLETED);
					Presentation presentation1=presentationDao.savePresentation(prstn);
					ResponseStucture<Presentation> responseStucture=new ResponseStucture<>();
					responseStucture.setStatusCode(200);
					responseStucture.setMessage("Presentation Completed");
					responseStucture.setData(presentation1);
					return new ResponseEntity<ResponseStucture<Presentation>>(responseStucture,HttpStatus.OK);
				}
				else
				{
					return null;
				}
	
			}
			else {
				
				throw new PresentationIdNotFoundException("ID: "+id+" ,not present in DB");
				
//				ResponseStucture<Presentation> responseStucture=new ResponseStucture<>();
//				responseStucture.setStatusCode(404);
//				responseStucture.setMessage("ID Not Found");
//				responseStucture.setData(null);
//				return new ResponseEntity<ResponseStucture<Presentation>>(responseStucture,HttpStatus.NOT_FOUND);
			}
		}
		
		public ResponseEntity<ResponseStucture<Presentation>> findPresentationById(int id)
		{ 
			Optional<Presentation> presentation = presentationRepository.findById(id);
			Presentation presentation1 =presentation.get();
			if(presentation.isPresent()) {
				ResponseStucture<Presentation> responseStucture=new ResponseStucture<>();
				responseStucture.setStatusCode(200);
				responseStucture.setMessage("Presentation Found");
				responseStucture.setData(presentation1);
				return new ResponseEntity<ResponseStucture<Presentation>>(responseStucture,HttpStatus.OK);
			}else {
				
				throw new PresentationIdNotFoundException("ID: "+id+" ,not present in DB");
				
//				ResponseStucture<Presentation> responseStucture=new ResponseStucture<>();
//				responseStucture.setStatusCode(404);
//				responseStucture.setMessage("ID Not Found");
//				responseStucture.setData(null);
//				return new ResponseEntity<ResponseStucture<Presentation>>(responseStucture,HttpStatus.NOT_FOUND);
			}
		}
		
		public ResponseEntity<ResponseStucture<List<Presentation>>> findByUserId(int id)
		{
			List<Presentation> presentation = presentationDao.findByUserId(id);
			
			if(presentation.size()>0) {
				ResponseStucture<List<Presentation>> responseStucture=new ResponseStucture<>();
				responseStucture.setStatusCode(200);
				responseStucture.setMessage("Presentation Found");
				responseStucture.setData(presentation);
				return new ResponseEntity<ResponseStucture<List<Presentation>>>(responseStucture,HttpStatus.OK);
			}else {
				
				throw new StudentIdNotFoundException("ID: "+id+" ,not present in DB");
				
//				ResponseStucture<List<Presentation>> responseStucture=new ResponseStucture<>();
//				responseStucture.setStatusCode(404);
//				responseStucture.setMessage("ID Not Found");
//				responseStucture.setData(null);
//				return new ResponseEntity<ResponseStucture<List<Presentation>>>(responseStucture,HttpStatus.NOT_FOUND);
			}
		}
		
		public ResponseEntity<ResponseStucture<Presentation>> calculatePresentation(int id)
		{
			Optional<Presentation> presentation = presentationRepository.findById(id);
			Presentation prstn =presentation.get();
			
			if(prstn.getStatus()==Status.COMPLETED)
			{
			
			List<Review> reviews=prstn.getReviews();
			
			if(reviews.size()!=0)
			{  
				
				int tscore=0;
				for(int i=0;i<reviews.size();i++)
				{
					int score=0;
					Review rvw=reviews.get(i);
					score=(Integer)rvw.getConfidence()+(Integer)rvw.getCommunication()+(Integer)rvw.getInteraction()
					       +(Integer)rvw.getEyeContact()+(Integer)rvw.getContent()+(Integer)rvw.getLiveliness()+(Integer)rvw.getEnergy();
					tscore=tscore+score;
					
				}
				int avgscore=tscore/reviews.size();
				prstn.setTotalScore(avgscore);
				
				Presentation recievedPresentation=presentationDao.savePresentation(prstn);
			
				
				ResponseStucture<Presentation> responseStucture=new ResponseStucture<>();
				responseStucture.setStatusCode(200);
				responseStucture.setMessage("success");
				responseStucture.setData(recievedPresentation);
				
				return new ResponseEntity<ResponseStucture<Presentation>>(responseStucture,HttpStatus.OK);
				
				
			}
			else
			{
				ResponseStucture<Presentation> responseStucture=new ResponseStucture<>();
				responseStucture.setStatusCode(404);
				responseStucture.setMessage("No Review Given Yet");
				responseStucture.setData(null);
				return new ResponseEntity<ResponseStucture<Presentation>>(responseStucture,HttpStatus.NOT_FOUND);
			}
		}
		else
		{
			ResponseStucture<Presentation> responseStucture=new ResponseStucture<>();
			responseStucture.setStatusCode(404);
			responseStucture.setMessage("Presentation Status is not Completed Yet..!");
			responseStucture.setData(null);
			return new ResponseEntity<ResponseStucture<Presentation>>(responseStucture,HttpStatus.NOT_FOUND);
	
		}
	   }
		
	}
