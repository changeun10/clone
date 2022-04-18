package com.javalec.worldCup.service;

import java.util.ArrayList;

import com.javalec.worldCup.dto.WorldCupDto;

public interface CategoryService {
	public ArrayList<WorldCupDto> list(int type);
	public void hit(int id);
	public ArrayList<WorldCupDto> myList(String id);
	public void delete(int id);
}
