package com.javalec.worldCup;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javalec.worldCup.dto.Dto;
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
	
	@RequestMapping(value = "/{title}", method = RequestMethod.GET)
	public String worldCup(Model model,Dto dto,@RequestParam(value="index", required=false,defaultValue="-1") int index,@PathVariable String title,
			@RequestParam(value="round", required=false,defaultValue="-1") int round) {
		service.WorldCup(model,dto, index,title,round);

		return "worldCup";
	}
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/statistic/{title}")
	public String statistic(Model model,@PathVariable String title,int id) {
		ArrayList<Dto> list = service.statistic(title, id);
		model.addAttribute("list",list);
		return "statistic";
	}
}
