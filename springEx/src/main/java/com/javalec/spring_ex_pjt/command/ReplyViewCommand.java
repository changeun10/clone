package com.javalec.spring_ex_pjt.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.spring_ex_pjt.dao.BoardDAO;
import com.javalec.spring_ex_pjt.dto.BoardDTO;

public class ReplyViewCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int id = Integer.parseInt(request.getParameter("bid"));
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.content_view(id);
		model.addAttribute("reply_view",dto);
	}

}
