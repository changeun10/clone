package com.javalec.worldCup.dao;

import java.util.ArrayList;

import com.javalec.worldCup.dto.Dto;

public interface IDao {
	public ArrayList<Dto> list(String title);
	public void update(String title,int id);
}
