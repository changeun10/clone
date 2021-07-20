package com.javalec.spring_ex_pjt.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.javalec.spring_ex_pjt.dao.BoardDAO;
import com.javalec.spring_ex_pjt.dto.BoardDTO;

public class ModifyCommand implements BCommand {

	@Override
	public void execute(Model model) {
		
		Map<String,Object> map = model.asMap();
		BoardDTO dto = (BoardDTO) map.get("dto");
		System.out.println(dto.getBcontent());
		BoardDAO dao = new BoardDAO();
		dao.modify(dto.getBid(), dto.getBname(), dto.getBtitle(), dto.getBcontent());
	}

}
