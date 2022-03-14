package com.javalec.worldCup.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalec.worldCup.dao.ICategoryDao;
import com.javalec.worldCup.dto.CategoryDto;

@Service
public class CategoryServiceLogic implements CategoryService {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public ArrayList<CategoryDto> list(int type) {
		ICategoryDao dao = sqlSession.getMapper(ICategoryDao.class);
		if (type==0) {
			return dao.listByHit();
		} else {
			return dao.listByDate();
		}
		
		
	}

	@Override
	public void hit(String title) {
		ICategoryDao dao = sqlSession.getMapper(ICategoryDao.class);
		dao.hit(title);	
	}

	@Override
	public ArrayList<CategoryDto> myList(String id) {
		ICategoryDao dao = sqlSession.getMapper(ICategoryDao.class);
		return dao.myList(id);
	}

	@Override
	public void delete(int id) {
		ICategoryDao dao = sqlSession.getMapper(ICategoryDao.class);
		dao.delete(id);
	}

	@Override
	public void deleteTalbes(String title) {
		ICategoryDao dao = sqlSession.getMapper(ICategoryDao.class);
		dao.deleteTables(title);
		
	}

}
