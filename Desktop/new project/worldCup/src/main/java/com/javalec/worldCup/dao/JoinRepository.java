package com.javalec.worldCup.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javalec.worldCup.dto.LoginDto;


public interface JoinRepository extends JpaRepository<LoginDto, String>{


}
