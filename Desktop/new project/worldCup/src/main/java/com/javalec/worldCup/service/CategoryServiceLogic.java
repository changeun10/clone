package com.javalec.worldCup.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.javalec.worldCup.dao.IWorldCupDao;
import com.javalec.worldCup.dto.WorldCupDto;

@Service
public class CategoryServiceLogic implements CategoryService {
  
	@Autowired
	private IWorldCupDao IWorldCupDao;

	@Override
	public ArrayList<WorldCupDto> list(int type) {
		if (type == 0) {
			return IWorldCupDao.listByHit();
		} else {
			return IWorldCupDao.listByDate();
		}
	}

	@Override
	public void hit(int id) {
		IWorldCupDao.hit(id);
	}

	@Override
	public ArrayList<WorldCupDto> myList(String id) {

		return IWorldCupDao.myList(id);
	}

	@Override
	public void delete(int id) {
		IWorldCupDao.delete(id);
		IWorldCupDao.deleteContent(id);
	}


	@CacheEvict(value = "statistic",key="#id")
	public void deleteCache(int id ) {
		System.out.println("캐시 삭제");
	}
}
