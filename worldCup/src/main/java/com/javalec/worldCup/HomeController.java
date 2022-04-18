package com.javalec.worldCup;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javalec.worldCup.dto.BoardDto;
import com.javalec.worldCup.dto.ContentDto;
import com.javalec.worldCup.service.BoardService;
import com.javalec.worldCup.service.CategoryService;
import com.javalec.worldCup.service.WorldCupService;

@Controller
public class HomeController {

	@Autowired
	private WorldCupService service;

	private BoardService Bservice;

	@Autowired
	public void setBservice(BoardService Bservice) {
		this.Bservice = Bservice;
	}

	private CategoryService Cservice;

	@Autowired
	public void setCservice(CategoryService Cservice) {
		this.Cservice = Cservice;
	}

	@RequestMapping(value = "/{id}")
	public String worldCup(Model model, ContentDto dto, HttpSession session,
			@RequestParam(value = "index", required = false, defaultValue = "-1") int index, @PathVariable int id,
			@RequestParam(value = "round", required = false, defaultValue = "-1") int round,
			@RequestParam(value = "WorldCup_title", required = true) String WorldCup_title) {
		if (index == -1) {
			Cservice.hit(id);
		}
		
		service.WorldCup(model, dto, index, id, round, session);
		model.addAttribute("WorldCup_title", WorldCup_title);
		model.addAttribute("id", id);
		
		return "worldCup";
	}

	@RequestMapping("/")
	public String home(Model model, @RequestParam(value = "type", required = false, defaultValue = "0") int type) {
		model.addAttribute("list", Cservice.list(type));
		return "home";
	}

	@RequestMapping("/statistic/{id}")
	public String statistic(Model model, @PathVariable int id, String name, String WorldCup_title) {
		System.out.println(name);
		ArrayList<ContentDto> list = service.statistic(id, name);
		model.addAttribute("list", list);
		model.addAttribute("title", WorldCup_title);
		model.addAttribute("name", name);
		return "statistic";
	}

	@RequestMapping("/board")
	public String board(Model model, int id, String name) {
		ArrayList<BoardDto> list = Bservice.list(id);
		model.addAttribute("list", list);
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "board";
	}

	@RequestMapping("/write")
	public String board(Model model,int id, String name, String content, String writer) {
		Bservice.write(id, name, content, writer);
		model.addAttribute("name", name);
		return "redirect:board?id=" + id;
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
		return "redirect:/myWorldCup";
	}
}
