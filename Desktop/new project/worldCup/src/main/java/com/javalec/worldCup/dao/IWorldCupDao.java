package com.javalec.worldCup.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.javalec.worldCup.dto.WorldCupDto;

@Repository
@Mapper
public interface IWorldCupDao {
	public ArrayList<WorldCupDto> listByDate();
	public ArrayList<WorldCupDto> listByHit();
	
	public void hit(int id);
	
	public ArrayList<WorldCupDto> myList(String id);
	public void delete(int id);
	public void deleteContent(int id);
}
