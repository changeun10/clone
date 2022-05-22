package com.javalec.worldCup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalec.worldCup.dao.BoardRepository;
import com.javalec.worldCup.dao.WorldCupRepository;
import com.javalec.worldCup.dto.BoardDto;
import com.javalec.worldCup.dto.WorldCupDto;

@Service
public class BoardServiceLogic implements BoardService {

	@Autowired
	private WorldCupRepository wRepo;

	@Autowired
	private BoardRepository bRepo;

	@Override
	public List<BoardDto> list(int worldCup_id) {
		WorldCupDto wDto = wRepo.findById(Long.valueOf(worldCup_id));

		return wDto.getBoards();
	}

	@Override
	public void write(BoardDto dto, int id) {
		WorldCupDto wDto = wRepo.findById(Long.valueOf(id));
		dto.setWorldCupId(wDto);
		bRepo.save(dto);

	}

}
