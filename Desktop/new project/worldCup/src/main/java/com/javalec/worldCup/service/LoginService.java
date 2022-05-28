package com.javalec.worldCup.service;

import com.javalec.worldCup.dto.LoginDto;
import com.javalec.worldCup.model.Member;

public interface LoginService {
	public Member checkId(String id);
	public void join(Member dto);
	public boolean checkLogin(String id,String pw);
}
