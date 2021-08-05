package com.javalec.worldCup.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.javalec.worldCup.dto.Dto;

public interface ICreateDao {
	public void insertCategory(@Param("title")String title,
			@Param("des")String des,@Param("thumb_image")String thumb_image, @Param("maker")String maker);
	public void createTable(@Param("title")String title);
	public void createTableSeq(@Param("title")String title);
	
	public void insertCreatedTable(@Param("title")String title,@Param("list")ArrayList<Dto> list);
	
	public void createBoard(@Param("title")String title);
	public void createBoardSeq(@Param("title")String title);
}
