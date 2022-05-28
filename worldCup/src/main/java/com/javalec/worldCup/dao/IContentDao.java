package com.javalec.worldCup.dao;

import java.util.ArrayList;

import com.javalec.worldCup.dto.ContentDto;

public interface IContentDao {
	public ArrayList<ContentDto> list(int worldCup_id);
	
	public void update(int id,String name);
}
