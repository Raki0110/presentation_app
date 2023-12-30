package com.ty.fresher_presentation_app_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.fresher_presentation_app_springboot.dao.FresherDao;
import com.ty.fresher_presentation_app_springboot.dto.ResponseStucture;
import com.ty.fresher_presentation_app_springboot.entity.Fresher;

@Service
public class FresherService {

	@Autowired
	private FresherDao fresherDao;
	
	public ResponseEntity<ResponseStucture<Fresher>> saveFresher(Fresher fresher)
	{
		Fresher recievedFresher=fresherDao.saveFresher(fresher);
		
		ResponseStucture<Fresher> responseStucture=new ResponseStucture<>();
		responseStucture.setStatusCode(200);
		responseStucture.setMessage("success");
		responseStucture.setData(recievedFresher);
		
		return new ResponseEntity<ResponseStucture<Fresher>>(responseStucture,HttpStatus.CREATED);
	}
}
