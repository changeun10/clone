package com.javalec.worldCup.service;

import java.util.List;

import com.javalec.worldCup.dto.WorldCupDto;
import com.javalec.worldCup.model.WorldCup;

public interface SearchService {

	public List<WorldCup> search(String keyword); 
}
