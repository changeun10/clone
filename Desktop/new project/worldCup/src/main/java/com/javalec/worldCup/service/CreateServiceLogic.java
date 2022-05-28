package com.javalec.worldCup.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.javalec.worldCup.dao.ContentRepository;
import com.javalec.worldCup.dao.WorldCupRepository;
import com.javalec.worldCup.dto.NewWorldCupDto;
import com.javalec.worldCup.model.Board;
import com.javalec.worldCup.model.Content;
import com.javalec.worldCup.model.WorldCup;

@Service
public class CreateServiceLogic implements CreateService {
	
	@Autowired
	private ServletContext servletContext;

	@Autowired
	private WorldCupRepository wRepo;
	
	@Autowired
	private ContentRepository cRepo;
	
	@Override
	public void createNewWroldCup(String title, String[] name, String maker,MultipartHttpServletRequest mRequest) {
		
		
		List<MultipartFile> fileList = mRequest.getFiles("image");
		MultipartFile file = mRequest.getFile("thumb");
		String thumb_img = file.getOriginalFilename();
		System.out.println("ttitle"+title);
		
		WorldCup k = new WorldCup("resources/thumb/"+thumb_img,title,0,maker,new ArrayList<Content>(), new ArrayList<Board>());
		
		
		wRepo.save(k);
	
		for(int i=0;i<name.length;i++) {
			String image = fileList.get(i).getOriginalFilename();
			Content content = new Content(k,"resources/"+title+"/"+image,name[i],0);
		
			cRepo.save(content);
		}
	
		String path = servletContext.getRealPath("resources");
		System.out.println(path);
		try {
			file.transferTo(new File(path+"/thumb", thumb_img));
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		File Folder = new File(path, title);
		System.out.println(Folder);
		if (!Folder.exists()) {
			try {
				Folder.mkdir();
			} catch (Exception e) {
				e.getStackTrace();
			}
		} else {
		}
		path = path +"/"+title;
		System.out.println(path);
		for (MultipartFile mf : fileList) {
			String originFileName = mf.getOriginalFilename(); //
			File saveFile = new File(path, originFileName);
			try {
				mf.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
