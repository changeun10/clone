package com.javalec.worldCup.dto;

public class ContentDto {
	private int worldCup_id;
	private String Image;
	private String name;
	private int win;

	public int getWorldCup_id() {
		return worldCup_id;
	}

	public void setWorldCup_id(int worldCup_id) {
		this.worldCup_id = worldCup_id;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}
}
