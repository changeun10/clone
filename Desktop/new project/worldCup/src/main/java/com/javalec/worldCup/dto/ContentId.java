package com.javalec.worldCup.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ContentId implements Serializable{
	
	private Long worldCupId;
	private String zImage;
}
