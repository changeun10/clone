package com.javalec.worldCup.service;


import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Transactional
public interface CreateService {
	public void createNewWroldCup(String des, String[] name,
			MultipartHttpServletRequest mRequest,String maker);
}
