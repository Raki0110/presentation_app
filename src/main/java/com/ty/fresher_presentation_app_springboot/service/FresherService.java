package com.ty.fresher_presentation_app_springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.fresher_presentation_app_springboot.dao.FresherDao;
import com.ty.fresher_presentation_app_springboot.dto.ResponseStucture;
import com.ty.fresher_presentation_app_springboot.entity.Fresher;
import com.ty.fresher_presentation_app_springboot.repository.FresherRepository;
import com.ty.fresher_presentation_app_springboot.util.Role;
import com.ty.fresher_presentation_app_springboot.util.Status;

import fresher_presentation_app_springboot.exceptions.StudentIdNotFoundException;

@Service
public class FresherService {

	@Autowired
	private FresherDao fresherDao;
	
	@Autowired
	private FresherRepository fresherRepository;
	
	public ResponseEntity<ResponseStucture<Fresher>> saveFresher(Fresher fresher)
	{
        List<Fresher> fresh=fresherRepository.checkTrainer(Role.TRAINER);
		
		if(fresh.size()!=0)
		{
		  fresher.setRole(Role.STUDENT);
		  fresher.setStatus(Status.ACTIVE);
		  Fresher recievedFresher=fresherDao.saveFresher(fresher);
		
		ResponseStucture<Fresher> responseStucture=new ResponseStucture<>();
		responseStucture.setStatusCode(200);
		responseStucture.setMessage("success");
		responseStucture.setData(recievedFresher);
		
		return new ResponseEntity<ResponseStucture<Fresher>>(responseStucture,HttpStatus.CREATED);
		}
		else
		{
			ResponseStucture<Fresher> responseStucture=new ResponseStucture<>();
			responseStucture.setStatusCode(404);
			responseStucture.setMessage("PLEASE ADD TRAINER FIRST");
			responseStucture.setData(null);
			
			return new ResponseEntity<ResponseStucture<Fresher>>(responseStucture,HttpStatus.BAD_REQUEST);

		}
	}
	
	public ResponseEntity<ResponseStucture<Fresher>> saveTrainer()
	{

		Fresher recievedFresher=fresherDao.saveTrainer();
		
		ResponseStucture<Fresher> responseStucture=new ResponseStucture<>();
		responseStucture.setStatusCode(200);
		responseStucture.setMessage("success , Added trainer");
		responseStucture.setData(recievedFresher);
		
		return new ResponseEntity<ResponseStucture<Fresher>>(responseStucture,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStucture<Fresher>> updateFresher(Fresher fresher,int id)
	{
		Optional<Fresher> stud=fresherRepository.findById(id);
		
		if(stud.isPresent())
		{
			fresher.setRole(Role.STUDENT);
			fresher.setStatus(Status.ACTIVE);
			
			Fresher student=stud.get();
			student.setId(id);
			student.setName(fresher.getName());
			student.setEmail(fresher.getEmail());
			student.setPassword(fresher.getPassword());
			student.setPhone(fresher.getPhone());
			student.setRole(fresher.getRole());
			student.setStatus(fresher.getStatus());
			
			Fresher updatedFresher=fresherDao.updateFresher(student);
			ResponseStucture<Fresher> responseStucture=new ResponseStucture<>();
			responseStucture.setStatusCode(200);
			responseStucture.setMessage("success ,updated student");
			responseStucture.setData(updatedFresher);
			
			return new ResponseEntity<ResponseStucture<Fresher>>(responseStucture,HttpStatus.CREATED);
		}
		
		else
		{
			throw new StudentIdNotFoundException("ID: "+id+" ,not present in DB");
			
//			ResponseStucture<Fresher> responseStucture=new ResponseStucture<>();
//			responseStucture.setStatusCode(404);
//			responseStucture.setMessage("Student with given ID Not Found");
//			responseStucture.setData(null);
//			
//			return new ResponseEntity<ResponseStucture<Fresher>>(responseStucture,HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<ResponseStucture<List<Fresher>>> findByName(String name)
	{
		List<Fresher> freshers = fresherDao.findByName(name);
		if(freshers.size()!=0) {
			ResponseStucture<List<Fresher>> responseStucture=new ResponseStucture<>();
			responseStucture.setStatusCode(200);
			responseStucture.setMessage("student records found");
			responseStucture.setData(freshers);
			
			return new ResponseEntity<ResponseStucture<List<Fresher>>>(responseStucture,HttpStatus.OK);

			
		}
		else
		{
			ResponseStucture<List<Fresher>> responseStucture=new ResponseStucture<>();
			responseStucture.setStatusCode(404);
			responseStucture.setMessage("Student with given Name Not Found");
			responseStucture.setData(null);
			
			return new ResponseEntity<ResponseStucture<List<Fresher>>>(responseStucture,HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	
}
