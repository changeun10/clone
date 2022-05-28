package com.javalec.worldCup.service;




import org.springframework.web.multipart.MultipartHttpServletRequest;


public interface CreateService {
	public void createNewWroldCup(String title,String[] name,String maker, MultipartHttpServletRequest mRequest);
}
