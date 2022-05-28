package com.javalec.worldCup.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javalec.worldCup.dto.WorldCupDto;
import com.javalec.worldCup.model.WorldCup;

public interface WorldCupRepository extends JpaRepository<WorldCup, Integer>{

	WorldCup findById(Long id);
	
	@Query(value = "select w from WorldCup w where w.title like %:keyword%")
	public List<WorldCup> findAllByTitleContaining(@Param("keyword") String keyword);

	WorldCup findAllById(Long valueOf);
	
}
