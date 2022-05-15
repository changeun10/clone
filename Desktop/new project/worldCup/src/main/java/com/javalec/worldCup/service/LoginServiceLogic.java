package com.javalec.worldCup.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalec.worldCup.dao.ILoginDao;
import com.javalec.worldCup.dto.LoginDto;
 
@Service
public class LoginServiceLogic implements LoginService {

	@Autowired
	private ILoginDao dao;
	
	@Override
	public LoginDto checkId(String id) {
		return dao.checkId(id);
	}

	@Override
	public void join(LoginDto dto) {
		String id = dto.getId();
		String pw = dto.getPw();
		String name = dto.getName();
		dao.join(id, pw, name);
		
	}

	@Override
	public boolean checkLogin(String id,String pw) {
		LoginDto dto = dao.checkId(id);
		if(dto==null) {
			return false;
		}
		if (dto.getPw().equals(pw)) {
			return true;
		} else {
			return false;
		}
	}
	
}
