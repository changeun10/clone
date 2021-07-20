package com.javalec.spring_ex_pjt.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.spring_ex_pjt.dao.BoardDAO;
import com.javalec.spring_ex_pjt.dto.BoardDTO;

public class ContentViewCommand implements BCommand {

	@Override
	public void execute(Model model) {
		
		BoardDAO dao = new BoardDAO();
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		int id = Integer.parseInt(request.getParameter("bid"));
		
		BoardDTO dto = dao.content_view(id);
		
		model.addAttribute("content_view",dto);	
	}
	
}
