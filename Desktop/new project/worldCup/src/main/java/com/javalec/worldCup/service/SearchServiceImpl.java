package com.javalec.worldCup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalec.worldCup.dao.WorldCupRepository;
import com.javalec.worldCup.dto.WorldCupDto;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private WorldCupRepository wRepo;

	@Override
	public List<WorldCupDto> search(String keyword) {

		return wRepo.findAllByTitleContaining(keyword);
	}

}
