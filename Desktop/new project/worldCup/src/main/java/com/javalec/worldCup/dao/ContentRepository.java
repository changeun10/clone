package com.javalec.worldCup.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javalec.worldCup.model.ContentId;
import com.javalec.worldCup.model.Content;

public interface ContentRepository extends JpaRepository<Content, ContentId>{

	@Query(value = "select * from content where content_dto.world_cup_id = ?1 order by win",nativeQuery = true)
	List<Content> findAllById(int id);
	
	@Query(value = "select * from content where content_dto.world_cup_id = ?1 "
			+ "and content_dto.name = ?2",nativeQuery = true)
	Content findByIdandName(int id,String name);
}
