package com.javalec.worldCup.dto;

import java.util.Date;

public class CategoryDto {
	private int id;
	private String title;
	private String des;
	private String thumb_image;
	private int hit;
	private Date regDate;

	public int getId() {
		return id;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getThumb_image() {
		return thumb_image;
	}

	public void setThumb_image(String thumb_image) {
		this.thumb_image = thumb_image;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
}
