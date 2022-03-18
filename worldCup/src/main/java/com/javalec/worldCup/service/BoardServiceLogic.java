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
	public ArrayList<BoardDto> list(int worldCup_id) {
		IBoardDao dao = sqlSession.getMapper(IBoardDao.class);
		return dao.list(worldCup_id);
	}

	@Override
	public void write(int id, String name, String content,String writer) {
		IBoardDao dao = sqlSession.getMapper(IBoardDao.class);
		dao.write(id,name,content,writer);
	}
	

}
