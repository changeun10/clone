package com.javalec.worldCup.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.javalec.worldCup.dto.ContentDto;

public interface WorldCupService {
	public void WorldCup(Model model, ContentDto dto, int index, int id, int round, HttpSession session);

	public ArrayList<ContentDto> statistic(int id, String name);
}
