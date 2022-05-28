package com.javalec.worldCup.dto;

import java.util.Date;

public class BoardDto {
	private int id;
	private String name;
	private String content;
	private Date regDate;
	private String writer;
	private int worldCup_id;

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getWorldCup_id() {
		return worldCup_id;
	}

	public void setWorldCup_id(int worldCup_id) {
		this.worldCup_id = worldCup_id;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

}
