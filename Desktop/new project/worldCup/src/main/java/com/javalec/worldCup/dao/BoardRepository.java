package com.javalec.worldCup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javalec.worldCup.dto.BoardDto;

public interface BoardRepository extends JpaRepository<BoardDto, Integer>{
	
}
