package com.javalec.worldCup.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ContentDto {
	
	private int id;
	private String zImage;
	private String name;
	private int win;
	private int index;
	private int round;
	//service.WorldCup(model, dto, index, id, round, session);
}
