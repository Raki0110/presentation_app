package com.ty.fresher_presentation_app_springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.fresher_presentation_app_springboot.entity.Presentation;
import com.ty.fresher_presentation_app_springboot.repository.PresentationRepository;

@Repository
public class PresentationDao {

	@Autowired
	private PresentationRepository presentationRepository;
	
	public Presentation savePresentation(Presentation presentation)
	{
		return presentationRepository.save(presentation);
	}
}
