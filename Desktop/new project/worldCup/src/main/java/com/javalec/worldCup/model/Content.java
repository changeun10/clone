package com.javalec.worldCup.model;

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
public class Content {
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="worldCup_id")
	@JsonBackReference
	private WorldCup worldCupId;
	@Id
	private String zImage;
	
	private String name;
	private int win;
	
	public Content() {
		
	}
	public Content(WorldCup worldCupId, String zImage, String name, int win) {
		
		this.worldCupId = worldCupId;
		this.zImage = zImage;
		this.name = name;
		this.win = win;
	}
}
