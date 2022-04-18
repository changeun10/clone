package com.javalec.worldCup.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalec.worldCup.dao.IWorldCupDao;
import com.javalec.worldCup.dto.WorldCupDto;

@Service
public class CategoryServiceLogic implements CategoryService {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public ArrayList<WorldCupDto> list(int type) {
		IWorldCupDao dao = sqlSession.getMapper(IWorldCupDao.class);
		if (type==0) {
			return dao.listByHit();
		} else {
			return dao.listByDate();
		}
	}

	@Override
	public void hit(int id) {
		IWorldCupDao dao = sqlSession.getMapper(IWorldCupDao.class);
		dao.hit(id);	
	}

	@Override
	public ArrayList<WorldCupDto> myList(String id) {
		IWorldCupDao dao = sqlSession.getMapper(IWorldCupDao.class);
		return dao.myList(id);
	}

	@Override
	public void delete(int id) {
		IWorldCupDao dao = sqlSession.getMapper(IWorldCupDao.class);
		dao.delete(id);
		dao.deleteContent(id);
	}

	
	


}
