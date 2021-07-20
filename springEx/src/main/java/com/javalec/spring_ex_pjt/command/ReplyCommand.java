package com.javalec.spring_ex_pjt.command;

import java.util.Date;
import java.util.Map;

import org.springframework.ui.Model;

import com.javalec.spring_ex_pjt.dao.BoardDAO;
import com.javalec.spring_ex_pjt.dto.BoardDTO;

public class ReplyCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String,Object> map = model.asMap();
		BoardDTO dto = (BoardDTO) map.get("dto");
		String content = dto.getBcontent();
		int group = dto.getBgroup();
		int hit = dto.getBhit();
		int id = dto.getBid();
		int indent = dto.getBindent();
		String name = dto.getBname();
		int step = dto.getBstep();
		String title = dto.getBtitle();
		
		BoardDAO dao = new BoardDAO();
		dao.reply(id,name,title,content, hit, group,step,indent);
	}

}
