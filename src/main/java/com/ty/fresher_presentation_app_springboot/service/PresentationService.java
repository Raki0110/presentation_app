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
	import com.ty.fresher_presentation_app_springboot.repository.FresherRepository;
	import com.ty.fresher_presentation_app_springboot.util.Status;
	
	@Service
	public class PresentationService {
	
		@Autowired
		private PresentationDao presentationDao;
		
		@Autowired
		private FresherDao fresherDao;
		
		@Autowired
		private FresherRepository fresherRepository;
		
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
						ResponseStucture<Presentation> responseStucture=new ResponseStucture<>();
						responseStucture.setStatusCode(404);
						responseStucture.setMessage("Student Id Not Found");
						responseStucture.setData(null);
						return new ResponseEntity<ResponseStucture<Presentation>>(responseStucture,HttpStatus.NOT_FOUND);
					}
			
		}
	}
