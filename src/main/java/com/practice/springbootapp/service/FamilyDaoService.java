package com.practice.springbootapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.springbootapp.model.Family;
import com.practice.springbootapp.repository.FamilyRepository;

@Service
public class FamilyDaoService {
	
	@Autowired
	FamilyRepository familyRepository;
	
	public Family saveFamilyDetails(Family familyDetails) {				
		return familyRepository.save(familyDetails);		
	}

	public Family getFamilyMember(Long userId) {		
		return familyRepository.findByUserId(userId);	
	}

	public List<Family> getAllUsers() {
		return familyRepository.findAll();
	}

	public void deleteFamilyMember(Long userId) {
		familyRepository.deleteById(userId);		
	}
	
}
