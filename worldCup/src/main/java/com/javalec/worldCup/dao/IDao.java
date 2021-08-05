package com.javalec.worldCup.dao;

import java.util.ArrayList;
import java.util.List;

import com.javalec.worldCup.dto.Dto;
import com.javalec.worldCup.dto.testDto;

public interface IDao {
	public ArrayList<Dto> list(String title);
	public void update(String title,int id);
	public void test(List<String> list);
	public void test2(List<testDto> list);
}
