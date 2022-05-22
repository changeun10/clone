package com.javalec.worldCup.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.javalec.worldCup.dto.ContentDto;
import com.javalec.worldCup.dto.WorldCupDto;

public interface WorldCupService {
	public void WorldCup(Model model, ContentDto dto, int index, int id, int round, HttpSession session);

	
	public List<ContentDto> statistic(int id);
	public Map<String,Integer> win(int id);
	public WorldCupDto load(int id);
}
