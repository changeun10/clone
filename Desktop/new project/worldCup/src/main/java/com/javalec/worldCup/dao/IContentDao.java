package com.javalec.worldCup.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.javalec.worldCup.dto.ContentDto;

@Repository
@Mapper
public interface IContentDao {
	public ArrayList<ContentDto> list(int worldCup_id);
	
	public void update(int id,String name,int win);
}
