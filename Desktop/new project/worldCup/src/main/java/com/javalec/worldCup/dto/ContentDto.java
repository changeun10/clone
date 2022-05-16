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

@Entity
@Setter
@Getter
@IdClass(ContentId.class)
public class ContentDto {
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="worldCup_id")
	@JsonBackReference
	private WorldCupDto worldCupId;
	@Id
	private String zImage;
	
	private String name;
	private int win;
	
	public ContentDto() {
		
	}
	public ContentDto(WorldCupDto worldCupId, String zImage, String name, int win) {
		
		this.worldCupId = worldCupId;
		this.zImage = zImage;
		this.name = name;
		this.win = win;
	}
}
