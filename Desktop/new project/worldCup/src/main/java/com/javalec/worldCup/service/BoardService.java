package com.javalec.worldCup.service;

import java.util.ArrayList;
import java.util.List;

import com.javalec.worldCup.dto.BoardDto;
import com.javalec.worldCup.model.Board;

public interface BoardService {
	public List<Board> list(int worldCup_id);
	public void write(Board dto,int id );
}
