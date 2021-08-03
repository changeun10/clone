package com.javalec.worldCup;

import java.io.File;
import java.io.IOException;
import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.javalec.worldCup.dao.ICategoryDao;
import com.javalec.worldCup.dao.ICreateDao;
import com.javalec.worldCup.dao.IDao;
import com.javalec.worldCup.dto.BoardDto;
import com.javalec.worldCup.dto.Dto;
import com.javalec.worldCup.dto.testDto;
import com.javalec.worldCup.service.BoardService;
import com.javalec.worldCup.service.CategoryService;
import com.javalec.worldCup.service.CreateService;
import com.javalec.worldCup.service.WorldCupService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	private WorldCupService service;

	@Autowired
	public void setService(WorldCupService service) {
		this.service = service;
	}

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
	
	private CreateService CrService;
	
	@Autowired
	public void setCrService(CreateService CrService) {
		this.CrService=CrService;
	}
	
	@RequestMapping(value = "/{title}", method = RequestMethod.GET)
	public String worldCup(Model model, Dto dto,
			@RequestParam(value = "index", required = false, defaultValue = "-1") int index, 
			@PathVariable String title,
			@RequestParam(value = "round", required = false, defaultValue = "-1") int round,
			@RequestParam(value="WorldCup_title",required=false) String WorldCup_title) {
		Cservice.hit(title);
		service.WorldCup(model, dto, index, title, round);
		model.addAttribute("WorldCup_title",WorldCup_title);

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

	@RequestMapping("/create")
	public String create() {
		return "create";
	}

	@RequestMapping("/createWorldCup")
	public String createWorldCup(String des,MultipartHttpServletRequest mRequest, String[] name) {
		CrService.createNewWroldCup(des, name, mRequest);
		return "redirect:/";
	}
}
