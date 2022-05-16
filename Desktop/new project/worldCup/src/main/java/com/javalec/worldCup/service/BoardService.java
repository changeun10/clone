package com.javalec.worldCup.service;

import java.util.ArrayList;
import java.util.List;

import com.javalec.worldCup.dto.BoardDto;

public interface BoardService {
	public List<BoardDto> list(int worldCup_id);
	public void write(BoardDto dto,int id );
}
