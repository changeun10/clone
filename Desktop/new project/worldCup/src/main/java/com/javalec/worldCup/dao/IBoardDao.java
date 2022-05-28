package com.javalec.worldCup.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.javalec.worldCup.dto.BoardDto;

@Repository
@Mapper
public interface IBoardDao {
	public ArrayList<BoardDto> list(int worldCup_id);

	public void write(int id, String name, String content, String writer);
}
