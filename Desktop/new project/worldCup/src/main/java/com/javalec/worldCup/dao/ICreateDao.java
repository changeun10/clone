package com.javalec.worldCup.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.javalec.worldCup.dto.ContentDto;

@Repository
@Mapper
public interface ICreateDao {
	public int createWorldCup(String thumb_img, String title, String writer_id);

	public void insertContent(ArrayList<ContentDto> list);
}
