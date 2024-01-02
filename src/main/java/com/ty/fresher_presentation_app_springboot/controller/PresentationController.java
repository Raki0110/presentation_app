package com.ty.fresher_presentation_app_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.fresher_presentation_app_springboot.dto.ResponseStucture;
import com.ty.fresher_presentation_app_springboot.entity.Presentation;
import com.ty.fresher_presentation_app_springboot.service.PresentationService;

@RestController
public class PresentationController {
	
	@Autowired(required = true)
	private PresentationService presentationService; 
	
	@PostMapping("/savepresentation/{id}")
	public ResponseEntity<ResponseStucture<Presentation>> savePresentation(@RequestBody Presentation presentation,@PathVariable int id)
	{
		return presentationService.savePresentation(presentation, id);
	}
	
	@PutMapping("/updatepresentation/{id}")
	
	public ResponseEntity<ResponseStucture<Presentation>> savePresentation(@PathVariable int id)
	{
		return presentationService.updatePresentation(id);
	}

}
