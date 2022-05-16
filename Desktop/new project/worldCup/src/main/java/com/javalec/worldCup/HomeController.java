package com.javalec.worldCup;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javalec.worldCup.dao.IContentDao;
import com.javalec.worldCup.dto.BoardDto;
import com.javalec.worldCup.dto.ContentDto;
import com.javalec.worldCup.service.BoardService;
import com.javalec.worldCup.service.CategoryService;
import com.javalec.worldCup.service.CategoryServiceLogic;
import com.javalec.worldCup.service.WorldCupService;
import com.javalec.worldCup.service.WorldCupServiceLogic;

@Controller
@RequestMapping("/worldCup")
public class HomeController {

	@Autowired
	private WorldCupService service;

	@Autowired
	private BoardService Bservice;

	@Autowired
	private EhCacheCacheManager cacheManager;

	@Autowired
	private CategoryService Cservice;

	@Autowired
	private IContentDao dao;

	@RequestMapping(value = "/{id}")
	public String worldCup(Model model, ContentDto dto, HttpSession session,
			@RequestParam(value = "index", required = false, defaultValue = "-1") int index, @PathVariable int id,
			@RequestParam(value = "round", required = false, defaultValue = "-1") int round,
			@RequestParam(value = "WorldCup_title", required = true) String WorldCup_title) {
		if (index == -1) {
			Cservice.hit(id);
		}
		service.win(id);
		service.WorldCup(model, dto, index, id, round, session);
		model.addAttribute("WorldCup_title", WorldCup_title);
		model.addAttribute("id", id);

		return "worldCup";
	}

	@RequestMapping("/")
	public String home(Model model, @RequestParam(value = "type", required = false, defaultValue = "0") int type) {
		model.addAttribute("list", Cservice.list(type));
		
		List strArr = cacheManager.getCacheManager().getCache("win").getKeys();
		List strArr1 = cacheManager.getCacheManager().getCache("statistic").getKeys();
		System.out.println(strArr);
		System.out.println(strArr1);

		/*
		 * if (strArr.size() > 0) {
		 * 
		 * System.out.println(cacheManager.getCacheManager().getCache("statistic").get(2
		 * ).getObjectKey()); List<ContentDto> s = (List<ContentDto>)
		 * cacheManager.getCacheManager().getCache("statistic").get(2)
		 * .getObjectValue(); for (ContentDto k : s) {
		 * 
		 * dao.update(k.getWorldCup_id(), k.getName()); } }
		 * Objects.requireNonNull(cacheManager.getCache("statistic")).clear();
		 */
		return "home";
	}

	@RequestMapping("/statistic/{id}")
	public String statistic(Model model, @PathVariable int id, String name, String WorldCup_title) {

		List<ContentDto> list = service.statistic(id);
		model.addAttribute("list", list);
		model.addAttribute("title", WorldCup_title);
		model.addAttribute("name", name);

		return "statistic";
	}

	@RequestMapping("/board")
	public String board(Model model, int id, String name) {
		List<BoardDto> list = Bservice.list(id);
		model.addAttribute("list", list);
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "board";
	}

	@RequestMapping("/write")
	public String board(Model model, BoardDto dto,int id) {
		System.out.println(dto);
		Bservice.write(dto,id);
		//Bservice.write(id, name, content, writer);
		//model.addAttribute("name", name);
		return "redirect:board?id="+id;
	}

	@RequestMapping("/myWorldCup")
	public String myWorldCup(Model model, HttpSession session) {
		String id = (String) session.getAttribute("id");
		model.addAttribute("list", Cservice.myList(id));
		return "myWorldCup";
	}

	@RequestMapping("/delete")
	public String delete(int id) {
		Cservice.delete(id);
		return "redirect:myWorldCup";
	}
}
