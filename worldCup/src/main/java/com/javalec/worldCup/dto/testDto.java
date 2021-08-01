package com.javalec.worldCup.dto;

import java.util.List;

public class testDto {
	private int id;
	private String name;
	private List<testDto> dtoList;
	
	
	public List<testDto> getDtoList() {
		return dtoList;
	}
	public void setDtoList(List<testDto> dtoList) {
		this.dtoList = dtoList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
