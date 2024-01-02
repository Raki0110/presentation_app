package com.ty.fresher_presentation_app_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ty.fresher_presentation_app_springboot.dao.FresherDao;
import com.ty.fresher_presentation_app_springboot.dao.PresentationDao;
import com.ty.fresher_presentation_app_springboot.dto.ResponseStucture;
import com.ty.fresher_presentation_app_springboot.entity.Fresher;
import com.ty.fresher_presentation_app_springboot.entity.Presentation;

public class PresentationService {

	@Autowired
	private PresentationDao presentationDao;
	
	public ResponseEntity<ResponseStucture<Presentation>> savePresentation(Presentation presentation)
	{
		Presentation recievedPresentation=presentationDao.savePresentation(presentation);
		
		ResponseStucture<Presentation> responseStucture=new ResponseStucture<>();
		responseStucture.setStatusCode(200);
		responseStucture.setMessage("success");
		responseStucture.setData(recievedPresentation);
		
		return new ResponseEntity<ResponseStucture<Presentation>>(responseStucture,HttpStatus.CREATED);
	}
}
