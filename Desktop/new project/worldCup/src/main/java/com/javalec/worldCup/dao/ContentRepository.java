package com.javalec.worldCup.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javalec.worldCup.dto.ContentDto;
import com.javalec.worldCup.dto.ContentId;

public interface ContentRepository extends JpaRepository<ContentDto, ContentId>{

	@Query(value = "select * from content_dto where content_dto.world_cup_id = ?1 order by win",nativeQuery = true)
	List<ContentDto> findAllById(int id);
	
	@Query(value = "select * from content_dto where content_dto.world_cup_id = ?1 "
			+ "and content_dto.name = ?2",nativeQuery = true)
	ContentDto findByIdandName(int id,String name);
}
