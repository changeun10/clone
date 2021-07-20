package com.javalec.spring_ex_pjt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalec.spring_ex_pjt.command.ContentViewCommand;
import com.javalec.spring_ex_pjt.command.DeleteCommand;
import com.javalec.spring_ex_pjt.command.ListCommand;
import com.javalec.spring_ex_pjt.command.ModifyCommand;
import com.javalec.spring_ex_pjt.command.ReplyCommand;
import com.javalec.spring_ex_pjt.command.ReplyViewCommand;
import com.javalec.spring_ex_pjt.command.WriteCommand;
import com.javalec.spring_ex_pjt.command.BCommand;
import com.javalec.spring_ex_pjt.dto.BoardDTO;
import com.javalec.spring_ex_pjt.util.Constant;

@Controller
public class MainController {
	
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	@RequestMapping("list")
	public String view(Model model) {
		BCommand command = new ListCommand();
		command.execute(model);
		return "list";
	}
	
	@RequestMapping("write")
	public String write(BoardDTO dto, Model model) {
		BCommand command = new WriteCommand();
		model.addAttribute("dto",dto);
		command.execute(model);
	
		return "redirect:list";
	}
	
	@RequestMapping("write_view")
	public String write_view() {
		return "write_view";
	}
	
	@RequestMapping("content_view")
	public String content_view(HttpServletRequest request,Model model) {
		
		BCommand command = new ContentViewCommand();
		model.addAttribute("request",request);
		command.execute(model);
		return "content_view";
	}
	
	@RequestMapping("modify")
	public String modify(BoardDTO dto, Model model) {
		
		BCommand command = new ModifyCommand();
		model.addAttribute("dto",dto);
		command.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request,Model model) {
		
		BCommand command = new DeleteCommand();
		model.addAttribute("request",request);
		command.execute(model);
		
		return "redirect:list"; 
	}
	
	@RequestMapping("reply_view")
	public String reply_view(HttpServletRequest request,Model model) {
		
		BCommand command = new ReplyViewCommand();
		model.addAttribute("request",request);
		command.execute(model);
		
		return "reply_view";
	}
	
	@RequestMapping("reply")
	public String reply(BoardDTO dto, Model model) {
		
		BCommand command = new ReplyCommand();
		model.addAttribute("dto",dto);
		command.execute(model);
		
		return "redirect:list";
	}
	
}
