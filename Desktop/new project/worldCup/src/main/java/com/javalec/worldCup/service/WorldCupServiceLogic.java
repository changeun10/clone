package com.javalec.worldCup.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;

import com.javalec.worldCup.dao.IContentDao;
import com.javalec.worldCup.dto.ContentDto;

@Service
public class WorldCupServiceLogic implements WorldCupService {

	@Autowired 
	private IContentDao dao;

	@Autowired
	private EhCacheCacheManager cacheManager;

	@Override
	public void WorldCup(Model model, ContentDto dto, int index, int id, int round, HttpSession session) {

		int length;

		List<ContentDto> list;
		ArrayList<ContentDto> temp;

		if (index == -1) {
			list = new ArrayList<ContentDto>();
			temp = new ArrayList<ContentDto>();
			session.setAttribute("temp", temp);
			session.setAttribute("list", list);

		} else {
			list = (List<ContentDto>) session.getAttribute("list");
			temp = (ArrayList<ContentDto>) session.getAttribute("temp");
		}

		if (dto.getName() != null) {
			temp = (ArrayList<ContentDto>) session.getAttribute("temp");
			temp.add(dto);
			session.setAttribute("temp", temp);
		} else {

			list = dao.list(id);
			Collections.shuffle(list);
			list = list.subList(0, round);

			session.setAttribute("list", list);
		}
		length = list.size();

		if (index + 2 == length) {
			index = -2;
			list = new ArrayList<ContentDto>(temp);
			Collections.shuffle(list);
			temp.clear();
			length = length / 2;
			session.setAttribute("list", list);
			session.setAttribute("temp", temp);
		}

		if (index == -1) {
			model.addAttribute("index", 0);
		} else {
			model.addAttribute("index", index + 2);
		}
		if (length < 1) {
			model.addAttribute("list", temp);
		} else {
			model.addAttribute("list", list);
			model.addAttribute("length", length);
		}

		if (length == 1) {
			//dao.update(id, list.get(0).getName());
			
			System.out.println(cacheManager.getCacheManager().getCache("win").get(id).getObjectKey());
			System.out.println(cacheManager.getCacheManager().getCache("win").get(id).getObjectValue());
			Map<String,Integer> m = (Map)cacheManager.getCacheManager().getCache("win").get(id).getObjectValue();
			m.put(list.get(0).getName(), m.getOrDefault(list.get(0).getName(), 0) + 1);
			System.out.println(m);
		}
	}

	@Override
	@Cacheable(value = "statistic", key = "#id")
	public ArrayList<ContentDto> statistic(int id) {
		return dao.list(id);
	}
	
	@Override
	@Cacheable(value = "win",key = "#id")
	public Map<String,Integer> win(int id) {
		System.out.println("asdf");
		Map<String,Integer> map = new HashMap<>();
		return map;
	}
	
}
