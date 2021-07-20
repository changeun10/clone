package com.javalec.spring_ex_pjt.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.javalec.spring_ex_pjt.dao.BoardDAO;
import com.javalec.spring_ex_pjt.dto.BoardDTO;

public class WriteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		BoardDAO dao = new BoardDAO();
		Map<String,Object> map = model.asMap();
		BoardDTO dto = (BoardDTO)map.get("dto");
		dao.write(dto.getBname(), dto.getBtitle(), dto.getBcontent());
	}

}
