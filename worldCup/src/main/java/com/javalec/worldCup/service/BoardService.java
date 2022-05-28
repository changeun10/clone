package com.javalec.worldCup.service;

import java.util.ArrayList;

import com.javalec.worldCup.dto.BoardDto;

public interface BoardService {
	public ArrayList<BoardDto> list(int worldCup_id);
	public void write(int id,String name,String content,String writer);
}
