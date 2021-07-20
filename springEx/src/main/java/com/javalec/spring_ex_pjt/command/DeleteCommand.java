package com.javalec.spring_ex_pjt.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.spring_ex_pjt.dao.BoardDAO;

public class DeleteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int id = Integer.parseInt(request.getParameter("bid"));
		
		BoardDAO dao = new BoardDAO();
		dao.delete(id);
	}

}
