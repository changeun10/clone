package com.javalec.worldCup.service;

import java.util.ArrayList;

import com.javalec.worldCup.dto.BoardDto;

public interface BoardService {
	public ArrayList<BoardDto> list(String title);
	public void write(String title,String name,String content,String writer);
}
