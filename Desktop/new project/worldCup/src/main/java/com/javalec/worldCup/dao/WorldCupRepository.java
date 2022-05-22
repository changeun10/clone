package com.javalec.worldCup.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javalec.worldCup.dto.WorldCupDto;

public interface WorldCupRepository extends JpaRepository<WorldCupDto, Integer>{

	WorldCupDto findById(Long id);
	
	@Query(value = "select w from WorldCupDto w where w.title like %:keyword%")
	public List<WorldCupDto> findAllByTitleContaining(@Param("keyword") String keyword);

	WorldCupDto findAllById(Long valueOf);
	
}
