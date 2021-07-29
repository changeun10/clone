package com.javalec.worldCup.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.javalec.worldCup.dto.CategoryDto;

public interface ICategoryDao {
	public ArrayList<CategoryDto> listByDate();
	public ArrayList<CategoryDto> listByHit();
	public void hit(@Param("title") String title);
}
