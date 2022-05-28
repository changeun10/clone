package com.javalec.worldCup.service;

import java.util.ArrayList;
import java.util.List;

import com.javalec.worldCup.dto.WorldCupDto;
import com.javalec.worldCup.model.WorldCup;
 
public interface CategoryService {
	public List<WorldCup> list(int type);
	public void hit(int id);
	public ArrayList<WorldCup> myList(String id);
	public void delete(int id);
}
