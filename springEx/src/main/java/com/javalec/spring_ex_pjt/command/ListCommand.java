package com.javalec.spring_ex_pjt.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.javalec.spring_ex_pjt.dao.BoardDAO;
import com.javalec.spring_ex_pjt.dto.BoardDTO;

public class ListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> dtos = dao.list();
		model.addAttribute("list", dtos);
		
	}

}
