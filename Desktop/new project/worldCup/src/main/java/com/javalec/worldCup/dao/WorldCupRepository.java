package com.javalec.worldCup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javalec.worldCup.dto.WorldCupDto;

public interface WorldCupRepository extends JpaRepository<WorldCupDto, Integer>{

	WorldCupDto findById(Long id);

	
	
}
