package com.javalec.worldCup.dao;

import com.javalec.worldCup.dto.LoginDto;

public interface ILoginDao {
	public LoginDto checkId(String id);
	public void join(String id,String pw,String name);
}
