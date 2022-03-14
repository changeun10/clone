package com.javalec.worldCup.service;

import com.javalec.worldCup.dto.LoginDto;

public interface LoginService {
	public LoginDto checkId(String id);
	public void join(LoginDto dto);
	public boolean checkLogin(String id,String pw);
}
