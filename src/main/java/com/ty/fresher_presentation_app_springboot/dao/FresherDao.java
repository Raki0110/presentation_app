package com.ty.fresher_presentation_app_springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.fresher_presentation_app_springboot.entity.Fresher;
import com.ty.fresher_presentation_app_springboot.repository.FresherRepository;

@Repository
public class FresherDao {

	@Autowired
	private FresherRepository fresherRepository;
	
	public Fresher saveFresher(Fresher fresher)
	{
		return fresherRepository.save(fresher);
	}
	
}
