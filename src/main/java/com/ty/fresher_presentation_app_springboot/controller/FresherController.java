package com.ty.fresher_presentation_app_springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.fresher_presentation_app_springboot.dto.ResponseStucture;
import com.ty.fresher_presentation_app_springboot.entity.Fresher;
import com.ty.fresher_presentation_app_springboot.service.FresherService;

@RestController
public class FresherController {

	@Autowired
	private FresherService fresherService;
	
	@PostMapping("/savetrainer")
	public ResponseEntity<ResponseStucture<Fresher>> saveTrainer()
	{
		return fresherService.saveTrainer();
	}
	
	@PostMapping("/saveuser")
	public ResponseEntity<ResponseStucture<Fresher>> saveFresher(@RequestBody Fresher fresher)
	{
		
		return fresherService.saveFresher(fresher);
	}
	
	@PostMapping("/updatestudent/{id}")
	public ResponseEntity<ResponseStucture<Fresher>> saveFresher(@RequestBody Fresher fresher, @PathVariable int id)
	{
		
		return fresherService.updateFresher(fresher, id);
	}
	
	@GetMapping("/findByName/{name}")
	
	public ResponseEntity<ResponseStucture<List<Fresher>>> findByName(@PathVariable String name)
	{
		
		return fresherService.findByName(name);
	}
	
	
	
	
	
	
}
