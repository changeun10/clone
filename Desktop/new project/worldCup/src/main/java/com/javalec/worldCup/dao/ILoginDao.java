package com.javalec.worldCup.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.javalec.worldCup.dto.LoginDto;

@Repository
@Mapper
public interface ILoginDao {
	public LoginDto checkId(String id);
	public void join(String id,String pw,String name);
}
