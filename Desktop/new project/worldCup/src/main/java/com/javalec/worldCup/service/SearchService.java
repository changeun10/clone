package com.javalec.worldCup.service;

import java.util.List;

import com.javalec.worldCup.dto.WorldCupDto;

public interface SearchService {

	public List<WorldCupDto> search(String keyword); 
}
