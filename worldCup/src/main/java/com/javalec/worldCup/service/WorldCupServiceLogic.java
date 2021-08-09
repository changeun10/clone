package com.javalec.worldCup.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.javalec.worldCup.dao.IDao;
import com.javalec.worldCup.dto.Dto;

@Service
public class WorldCupServiceLogic implements WorldCupService {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	
	@Override
	public void WorldCup(Model model,Dto dto,int index,String title,int round,HttpSession session) {
		model.addAttribute("title",title);
		
		int length;
		
		List<Dto> list;
		ArrayList<Dto> temp;
		
		
		if(index==-1) {
			list = new ArrayList<Dto>();
			temp = new ArrayList<Dto>();
			session.setAttribute("temp", temp);
			session.setAttribute("list", list);
			
		} else {
			list = (List<Dto>)session.getAttribute("list");
			temp = (ArrayList<Dto>)session.getAttribute("temp");
		}
		
		if(dto.getName()!=null) {
			temp = (ArrayList<Dto>)session.getAttribute("temp");
			temp.add(dto);
			session.setAttribute("temp", temp);
		} else {
			IDao dao = sqlSession.getMapper(IDao.class);
			list = dao.list(title);
			Collections.shuffle(list);
			list = list.subList(0, round);
			
			session.setAttribute("list", list);
		}
		length=list.size();
		
		if (index+2==length) {
			index = -2;
			list = new ArrayList<Dto>(temp);
			Collections.shuffle(list);
			temp.clear();
			length = length/2;
			session.setAttribute("list", list);
			session.setAttribute("temp", temp);
		}
		
		
		if(index==-1) {
			model.addAttribute("index",0);
		} else {
			model.addAttribute("index",index+2);
		}
		if(length<1) {
			model.addAttribute("list",temp);
		} else {
			model.addAttribute("list",list);
			model.addAttribute("length",length);
		}
	}

	@Override
	public ArrayList<Dto> statistic(String title, int id) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.update(title, id);
		
		return dao.list(title);
	}
}
