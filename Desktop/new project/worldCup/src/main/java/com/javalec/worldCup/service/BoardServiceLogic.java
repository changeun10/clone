package com.javalec.worldCup.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.javalec.worldCup.dao.IBoardDao;
import com.javalec.worldCup.dto.BoardDto;

@Service
public class BoardServiceLogic implements BoardService {

	@Autowired
	private IBoardDao IBoardDao;
	
	
	@Override
	public ArrayList<BoardDto> list(int worldCup_id) {
		return IBoardDao.list(worldCup_id);
	}

	@Override
	public void write(int id, String name, String content,String writer) {
		
		IBoardDao.write(id, name, content, writer);
		
	}
	

}
