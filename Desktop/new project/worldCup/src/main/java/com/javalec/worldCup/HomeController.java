package com.javalec.worldCup;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javalec.worldCup.dto.BoardDto;
import com.javalec.worldCup.dto.ContentDto;
import com.javalec.worldCup.dto.WorldCupDto;
import com.javalec.worldCup.service.BoardService;
import com.javalec.worldCup.service.CategoryService;
import com.javalec.worldCup.service.SearchService;
import com.javalec.worldCup.service.WorldCupService;

@Controller
@RequestMapping("/worldCup")
public class HomeController {

	@Autowired
	private SearchService Sservice;

	@Autowired
	private WorldCupService service;

	@Autowired
	private BoardService Bservice;

	@Autowired
	private EhCacheCacheManager cacheManager;

	@Autowired
	private CategoryService Cservice;

	@RequestMapping(value = "/{id}")
	public String worldCup(Model model, ContentDto dto, HttpSession session,
			@RequestParam(value = "index", required = false, defaultValue = "-1") int index, @PathVariable int id,
			@RequestParam(value = "round", required = false, defaultValue = "-1") int round,
			@RequestParam(value = "WorldCup_title", required = true) String WorldCup_title) {
		if (index == -1) {
			Cservice.hit(id);
		}
		service.load(id);
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
	public String board(Model model, BoardDto dto, int wid) {
		
		Bservice.write(dto, wid);
		return "redirect:board?id=" + wid;
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

	@RequestMapping("/search")
	public String search(String keyword, Model model) {
		System.out.println(keyword);
		model.addAttribute("list", Sservice.search(keyword));
		return "home";
	}
}
