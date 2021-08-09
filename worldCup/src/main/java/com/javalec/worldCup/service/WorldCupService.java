package com.javalec.worldCup.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.javalec.worldCup.dto.Dto;

public interface WorldCupService {
	public void WorldCup(Model model,Dto dto,int index,String title,int round,HttpSession session);
	public ArrayList<Dto> statistic(String title,int id);
}
