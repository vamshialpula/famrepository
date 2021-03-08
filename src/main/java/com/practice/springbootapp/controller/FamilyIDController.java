package com.practice.springbootapp.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.practice.springbootapp.exception.MemberNotFoundException;
import com.practice.springbootapp.model.Family;
import com.practice.springbootapp.service.FamilyDaoService;

@RestController
@RequestMapping("/family")
public class FamilyIDController  {

	@Autowired
	FamilyDaoService familyDaoService;
	
	@Autowired
	private MessageSource messageSource;

	@PostMapping("/save")
	public ResponseEntity<?> saveMember(@Valid @RequestBody Family familyData) {
		Family fMemberSaved = familyDaoService.saveFamilyDetails(familyData);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(fMemberSaved.getUserId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/retrieveAll")
	public List<Family> retrieveAllUsers() {
		List<Family> familyMembers = familyDaoService.getAllUsers();
		if(familyMembers == null) 
			throw new MemberNotFoundException("Retrieve All failed:");		
		return familyMembers;
	}
	
	@GetMapping("/retrieve/{userId}")
	public EntityModel<Family> retrieveMember(@PathVariable Long userId) {
		Family familyMember = familyDaoService.getFamilyMember(userId);
		
		if(familyMember == null)
			throw new MemberNotFoundException("Retrieve Id failed:"+userId);
		
		Link userResourceLink = WebMvcLinkBuilder.linkTo(FamilyIDController.class).slash(userId).withSelfRel();
		Link addressesResourceLink = WebMvcLinkBuilder.linkTo(FamilyIDController.class).slash("/").withRel("retrieveAll");
		
		familyMember.add(userResourceLink);
		familyMember.add(addressesResourceLink);		
		
		return EntityModel.of(familyMember);
	}	
	
	@DeleteMapping("/delete/{userId}")
	public void deleteMember(@PathVariable Long userId) {
		familyDaoService.deleteFamilyMember(userId);		
	}
	
	/* Internationalization RestAPI method*/
	@GetMapping("/message-internationalized")
	public String greetingInternationalized() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
}
