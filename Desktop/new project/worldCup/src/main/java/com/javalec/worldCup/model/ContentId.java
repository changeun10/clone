package com.javalec.worldCup.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class ContentId implements Serializable{
	
	private Long worldCupId;
	private String zImage;
}
