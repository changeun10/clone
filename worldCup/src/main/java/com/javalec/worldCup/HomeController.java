package com.javalec.worldCup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.javalec.worldCup.dto.BoardDto;
import com.javalec.worldCup.dto.Dto;
import com.javalec.worldCup.dto.LoginDto;
import com.javalec.worldCup.service.BoardService;
import com.javalec.worldCup.service.CategoryService;
import com.javalec.worldCup.service.CreateService;
import com.javalec.worldCup.service.LoginService;
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
	
	private LoginService Lservice;
	
	@Autowired
	public void setLservice(LoginService Lservice) {
		this.Lservice=Lservice;
	}
	
	@RequestMapping(value = "/{title}")
	public String worldCup(Model model, Dto dto, HttpSession session,
			@RequestParam(value = "index", required = false, defaultValue = "-1") int index, 
			@PathVariable String title,
			@RequestParam(value = "round", required = false, defaultValue = "-1") int round,
			@RequestParam(value="WorldCup_title",required=false) String WorldCup_title) {
		if (index==-1) {
			Cservice.hit(title);
		}
		
		service.WorldCup(model, dto, index, title, round, session);
		model.addAttribute("WorldCup_title",WorldCup_title);
		model.addAttribute("model",model);
		
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
	public String createWorldCup(String des,MultipartHttpServletRequest mRequest, String[] name,HttpSession session) {
		String maker = (String)session.getAttribute("id");
		CrService.createNewWroldCup(des, name, mRequest,maker);
		return "redirect:/";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(String id,String pw,HttpSession session) {
		if(Lservice.checkLogin(id,pw)) {
			session.setAttribute("id", id);
			return "redirect:/";
		} else {
			return "login";
		}
	}
	
	@RequestMapping("/join")
	public String join() {
		return "join";
	}
	
	
	@RequestMapping("/doJoin")
	public String doJoin(LoginDto dto){
		Lservice.join(dto);
		return "login";
	}
	
	@ResponseBody
	@RequestMapping("/checkId")
	public String checkId(String id) {
		LoginDto dto = Lservice.checkId(id);
		if(dto==null) {
			return "ok";
		} else {
			return "no";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("id");
		return "redirect:/";
	}
	
	@RequestMapping("/myWorldCup")
	public String myWorldCup(Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");
		model.addAttribute("list", Cservice.myList(id));
		return "myWorldCup";
	}
	
	@RequestMapping("/delete")
	public String delete(int id,String title) {
		Cservice.delete(id);
		Cservice.deleteTalbes(title);
		return "redirect:/myWorldCup";
	}
	
	@RequestMapping("/test")
	public String test(@RequestParam(value="a",required=false) List<String> kk) {
		if(kk!=null) {
		System.out.println(kk);
		}
		return "test";
	}
}
