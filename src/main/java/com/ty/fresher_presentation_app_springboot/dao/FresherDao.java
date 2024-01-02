package com.ty.fresher_presentation_app_springboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.fresher_presentation_app_springboot.entity.Fresher;
import com.ty.fresher_presentation_app_springboot.repository.FresherRepository;
import com.ty.fresher_presentation_app_springboot.util.Role;

@Repository
public class FresherDao {

	@Autowired
	private FresherRepository fresherRepository;
	
	public Fresher saveTrainer()
	{
		List<Fresher> fresh=fresherRepository.checkTrainer(Role.TRAINER);
		
		if(fresh.isEmpty())
		{
		Fresher fresher=new Fresher();
		fresher.setRole(Role.TRAINER);
		fresher.setName("ram");
		fresher.setEmail("ram@gmail.com");
		fresher.setPassword("Ram@123");
		fresher.setPhone(7894562123l);
		System.out.println("trainer Created Successfuy................");
		return fresherRepository.save(fresher);
		}
		else
		{
			System.out.println("Trainer already exist");
			return null;
		}
		
	}
	
	public Fresher saveFresher(Fresher fresher)
	{
		return fresherRepository.save(fresher);
	}
	
	public Fresher updateFresher(Fresher fresher)
	{
		return fresherRepository.save(fresher);
	}
	
	public List<Fresher> findByName(String name) {
		
		return fresherRepository.findByName(name);
	}
	
}
