package com.javalec.worldCup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javalec.worldCup.dto.BoardDto;
import com.javalec.worldCup.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{
	
}
