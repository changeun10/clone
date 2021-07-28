package com.javalec.worldCup.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.javalec.worldCup.dto.BoardDto;

public interface IBoardDao {
	public ArrayList<BoardDto> list(String title);
	public void write(@Param("title")String title, @Param("name")String name,@Param("content")String content);
}
