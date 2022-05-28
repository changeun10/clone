package com.javalec.worldCup.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javalec.worldCup.dto.WorldCupDto;
import com.javalec.worldCup.model.WorldCup;

public interface CategoryRepository extends JpaRepository<WorldCup, Integer>{

	ArrayList<WorldCup> findAllByMaker(String maker);

	void deleteById(Long id);

	WorldCup findById(Long id);

	List<WorldCup> findAllByOrderByHit();

	List<WorldCup> findAllByOrderByRegDate();


}
