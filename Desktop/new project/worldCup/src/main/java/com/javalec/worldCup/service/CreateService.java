package com.javalec.worldCup.service;



import org.springframework.web.multipart.MultipartHttpServletRequest;


public interface CreateService {
	public void createNewWroldCup(String des, String[] name,
			MultipartHttpServletRequest mRequest,String maker);
}
