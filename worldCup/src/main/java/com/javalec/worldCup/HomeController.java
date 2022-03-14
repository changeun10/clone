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
import com.javalec.worldCup.dto.Dto;
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


	@RequestMapping(value = "/{title}")
	public String worldCup(Model model, Dto dto, HttpSession session,
			@RequestParam(value = "index", required = false, defaultValue = "-1") int index, @PathVariable String title,
			@RequestParam(value = "round", required = false, defaultValue = "-1") int round,
			@RequestParam(value = "WorldCup_title", required = false) String WorldCup_title) {
		if (index == -1) {
			Cservice.hit(title);
		}

		service.WorldCup(model, dto, index, title, round, session);
		model.addAttribute("WorldCup_title", WorldCup_title);
		model.addAttribute("model", model);

		return "worldCup";
	}

	@RequestMapping("/")
	public String home(Model model, @RequestParam(value = "type", required = false, defaultValue = "0") int type) {
		model.addAttribute("list", Cservice.list(type));
		return "home";
	}

	@RequestMapping("/statistic/{title}")
	public String statistic(Model model, @PathVariable String title, int id, String name) {
		ArrayList<Dto> list = service.statistic(title, id);
		model.addAttribute("list", list);
		model.addAttribute("title", title);
		model.addAttribute("name", name);
		return "statistic";
	}

	@RequestMapping("/board")
	public String board(Model model, String title, String name) {

		ArrayList<BoardDto> list = Bservice.list(title);
		model.addAttribute("list", list);
		model.addAttribute("title", title);
		model.addAttribute("name", name);
		return "board";
	}

	@RequestMapping("/write")
	public String board(String title, String name, String content, String writer) {
		Bservice.write(title, name, content, writer);
		return "redirect:board?title=" + title + "&name=" + name;
	}


	@RequestMapping("/myWorldCup")
	public String myWorldCup(Model model, HttpSession session) {
		String id = (String) session.getAttribute("id");
		model.addAttribute("list", Cservice.myList(id));
		return "myWorldCup";
	}

	@RequestMapping("/delete")
	public String delete(int id, String title) {
		Cservice.delete(id);
		Cservice.deleteTalbes(title);
		return "redirect:/myWorldCup";
	}
}
