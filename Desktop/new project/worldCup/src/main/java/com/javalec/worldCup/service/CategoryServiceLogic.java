package com.javalec.worldCup.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.javalec.worldCup.dao.BoardRepository;
import com.javalec.worldCup.dao.CategoryRepository;
import com.javalec.worldCup.dao.ContentRepository;
import com.javalec.worldCup.dao.IWorldCupDao;
import com.javalec.worldCup.dao.WorldCupRepository;
import com.javalec.worldCup.dto.WorldCupDto;

@Service
public class CategoryServiceLogic implements CategoryService {
 
	@Autowired
	private CategoryRepository repo;
	
	@Override
	public List<WorldCupDto> list(int type) {
		return repo.findAll();
		/*
		 * if (type == 0) { return repo.findAllOrderByHit(); } else { return
		 * repo.findAllOrderByDate(); }
		 */
	}

	@Override
	public void hit(int id) {
		WorldCupDto dto = repo.findById(Long.valueOf(id));
		dto.setHit(dto.getHit()+1);
		repo.flush();
	}

	@Override
	public ArrayList<WorldCupDto> myList(String maker) {
		return repo.findAllByMaker(maker);
		
	}

	@Override
	@Transactional
	public void delete(int id) {
		repo.deleteById(Long.valueOf(id));
	}


}
