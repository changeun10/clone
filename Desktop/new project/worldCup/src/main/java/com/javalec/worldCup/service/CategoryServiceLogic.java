package com.javalec.worldCup.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalec.worldCup.dao.CategoryRepository;
import com.javalec.worldCup.dto.WorldCupDto;

@Service
public class CategoryServiceLogic implements CategoryService {

	@Autowired
	private CategoryRepository cRepo;

	@Override
	public List<WorldCupDto> list(int type) {
		if (type == 0) {
			return cRepo.findAllByOrderByHit();
		} else {
			return cRepo.findAllByOrderByRegDate();
		}

	}

	@Override
	public void hit(int id) {
		WorldCupDto dto = cRepo.findById(Long.valueOf(id));
		dto.setHit(dto.getHit() + 1);
		cRepo.flush();
	}

	@Override
	public ArrayList<WorldCupDto> myList(String maker) {
		return cRepo.findAllByMaker(maker);

	}

	@Override
	@Transactional
	public void delete(int id) {
		cRepo.deleteById(Long.valueOf(id));
	}

}
