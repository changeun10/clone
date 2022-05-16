package com.javalec.worldCup.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javalec.worldCup.dto.WorldCupDto;

public interface CategoryRepository extends JpaRepository<WorldCupDto, Integer>{

	ArrayList<WorldCupDto> findAllByMaker(String maker);

	void deleteById(Long id);

	WorldCupDto findById(Long id);


}
