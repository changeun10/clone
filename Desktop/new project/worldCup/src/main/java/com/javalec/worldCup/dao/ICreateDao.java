package com.javalec.worldCup.dao;

import java.util.ArrayList;
import com.javalec.worldCup.dto.ContentDto;

public interface ICreateDao {
	public int createWorldCup(String thumb_img, String title, String writer_id);

	public void insertContent(ArrayList<ContentDto> list);
}
