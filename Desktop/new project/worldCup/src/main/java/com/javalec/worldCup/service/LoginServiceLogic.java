package com.javalec.worldCup.service;

import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalec.worldCup.dao.ILoginDao;
import com.javalec.worldCup.dao.JoinRepository;
import com.javalec.worldCup.dto.LoginDto;
 
@Service
public class LoginServiceLogic implements LoginService {

	@Autowired
	private JoinRepository repo;
	
	@Override
	public LoginDto checkId(String id) {
		Optional<LoginDto> dto = repo.findById(id);
		if (dto.isPresent()) {
			return dto.get();
		}	
		return null;
	} 

	@Override
	public void join(LoginDto dto) {
		/*
		 * String id = dto.getId(); String pw = dto.getPw(); String name =
		 * dto.getName(); dao.join(id, pw, name);
		 */
		repo.save(dto);
		
	}

	@Override
	public boolean checkLogin(String id,String pw) {
		Optional<LoginDto> dto = repo.findById(id);

		if(dto.isPresent()) {
			if (dto.get().getPw().equals(pw)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
}
