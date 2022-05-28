package com.javalec.worldCup.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
public class WorldCup {
	
	@Id @Column(name = "worldCup_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String thumb_img;
	private String title;
	private int hit;
	
	@CreatedDate
	private Date regDate;
	private String maker;
	
	@OneToMany(mappedBy = "worldCupId", cascade = CascadeType.REMOVE)
	@JsonManagedReference
	private List<Content> contents = new ArrayList<>();

	@OneToMany(mappedBy = "worldCupId", cascade = CascadeType.REMOVE)
	@JsonManagedReference
	private List<Board> boards = new ArrayList<>();

	
	public WorldCup() {
	}


	public WorldCup(String thumb_img, String title, int hit, String maker, List<Content> contents,List<Board> boards) {
		
		this.thumb_img = thumb_img;
		this.title = title;
		this.hit = hit;
		this.maker = maker;
		this.contents = contents;
		this.boards = boards;
	}



}
