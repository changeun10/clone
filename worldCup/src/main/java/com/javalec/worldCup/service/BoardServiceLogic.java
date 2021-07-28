package com.javalec.worldCup.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalec.worldCup.dao.IBoardDao;
import com.javalec.worldCup.dto.BoardDto;

@Service
public class BoardServiceLogic implements BoardService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<BoardDto> list(String title) {
		IBoardDao dao = sqlSession.getMapper(IBoardDao.class);
		return dao.list(title);
	}

	@Override
	public void write(String title, String name, String content) {
		IBoardDao dao = sqlSession.getMapper(IBoardDao.class);
		dao.write(title,name,content);
	}
	

}
