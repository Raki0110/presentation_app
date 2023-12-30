package com.ty.fresher_presentation_app_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.fresher_presentation_app_springboot.dto.ResponseStucture;
import com.ty.fresher_presentation_app_springboot.entity.Fresher;
import com.ty.fresher_presentation_app_springboot.service.FresherService;
import com.ty.fresher_presentation_app_springboot.util.Role;

@RestController
public class FresherController {

	@Autowired
	private FresherService fresherService;
	
	@PostMapping("/savefresher")
	public ResponseEntity<ResponseStucture<Fresher>> saveFresher(@RequestBody Fresher fresher)
	{
		fresher.setRole(Role.TRAINER);
		return fresherService.saveFresher(fresher);
	}
}
