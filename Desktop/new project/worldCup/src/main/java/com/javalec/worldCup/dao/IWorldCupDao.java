package com.javalec.worldCup.dao;

import java.util.ArrayList;

import com.javalec.worldCup.dto.WorldCupDto;

public interface IWorldCupDao {
	public ArrayList<WorldCupDto> listByDate();
	public ArrayList<WorldCupDto> listByHit();
	
	public void hit(int id);
	
	public ArrayList<WorldCupDto> myList(String id);
	public void delete(int id);
	public void deleteContent(int id);
}
