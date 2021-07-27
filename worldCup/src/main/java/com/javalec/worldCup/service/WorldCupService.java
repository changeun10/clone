package com.javalec.worldCup.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.javalec.worldCup.dto.Dto;

public interface WorldCupService {
	public void WorldCup(Model model,Dto dto,int index,String title,int round);
	public ArrayList<Dto> statistic(String title,int id);
}
