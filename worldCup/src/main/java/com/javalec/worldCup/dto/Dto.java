package com.javalec.worldCup.dto;

import java.util.List;

public class Dto {
	private int id;
	private String image;
	private String name;
	private int win;
	
	private List<Dto> dtoList;
	
	public List<Dto> getDtoList() {
		return dtoList;
	}
	public void setDtoList(List<Dto> dtoList) {
		this.dtoList = dtoList;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
