package com.javalec.worldCup.dto;

import java.util.Date;

public class WorldCupDto {
	private int id;
	private String thumb_img;
	private String title;
	private int hit;
	private Date regDate;
	private String maker_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getThumb_img() {
		return thumb_img;
	}

	public void setThumb_img(String thumb_img) {
		this.thumb_img = thumb_img;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getMaker_id() {
		return maker_id;
	}

	public void setMaker_id(String maker_id) {
		this.maker_id = maker_id;
	}

}
