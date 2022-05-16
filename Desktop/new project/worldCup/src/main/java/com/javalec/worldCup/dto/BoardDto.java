package com.javalec.worldCup.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BoardDto {

	@Id
	@Column(name = "board_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String content;
	private Date regDate;
	private String writer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "worldCup_id")
	@JsonBackReference
	private WorldCupDto worldCupId;

	public BoardDto() {
		
	}
	public BoardDto(String name, String content, Date regDate, String writer, WorldCupDto worldCupId) {
		
		this.name = name;
		this.content = content;
		this.regDate = regDate;
		this.writer = writer;
		this.worldCupId = worldCupId;
	}

}
