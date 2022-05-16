package com.javalec.worldCup.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.javalec.worldCup.dao.BoardRepository;
import com.javalec.worldCup.dao.IBoardDao;
import com.javalec.worldCup.dao.WorldCupRepository;
import com.javalec.worldCup.dto.BoardDto;
import com.javalec.worldCup.dto.WorldCupDto;

@Service
public class BoardServiceLogic implements BoardService {

	@Autowired
	private WorldCupRepository repo;
	
	@Autowired
	private BoardRepository repo1;
	
	@Override
	public List<BoardDto> list(int worldCup_id) {
		WorldCupDto kk = repo.findById(Long.valueOf(worldCup_id));
		
		//repo.findAllBy
		return kk.getBoards();
	}

	@Override
	public void write(BoardDto dto,int id) {
		WorldCupDto wDto = repo.findById(Long.valueOf(id));
		dto.setWorldCupId(wDto);
		repo1.save(dto);
		
		
	}
	

}
