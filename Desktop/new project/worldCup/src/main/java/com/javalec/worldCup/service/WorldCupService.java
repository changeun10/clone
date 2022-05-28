package com.javalec.worldCup.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.javalec.worldCup.dto.ContentDto;
import com.javalec.worldCup.model.Content;
import com.javalec.worldCup.model.WorldCup;

public interface WorldCupService {
	public void WorldCup(Model model, ContentDto dto, HttpSession session);

	
	public List<Content> statistic(int id);
	public Map<String,Integer> win(int id);
	public WorldCup load(int id);
}
