package com.practice.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.springbootapp.model.Family;

public interface FamilyRepository extends JpaRepository<Family, Long>{

	Family findByUserId(Long userId);	
}
