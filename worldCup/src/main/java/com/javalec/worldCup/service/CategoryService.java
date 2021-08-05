package com.javalec.worldCup.service;

import java.util.ArrayList;

import com.javalec.worldCup.dto.CategoryDto;

public interface CategoryService {
	public ArrayList<CategoryDto> list(int type);
	public void hit(String title);
	public ArrayList<CategoryDto> myList(String id);
	public void delete(int id);
	public void deleteTalbes(String title);
}
