package com.javalec.worldCup.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.javalec.worldCup.dao.ICreateDao;
import com.javalec.worldCup.dto.Dto;

@Service
public class CreateServiceLogic implements CreateService {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private ServletContext servletContext;

	@Override
	public void createNewWroldCup(String des, String[] name,
			MultipartHttpServletRequest mRequest,String maker) {
		List<MultipartFile> fileList = mRequest.getFiles("image");
		MultipartFile file = mRequest.getFile("thumb");
		String thumb_Image = file.getOriginalFilename();
		String title = "B"+UUID.randomUUID().toString().replace("-", "").substring(15);
		
		ICreateDao dao = sqlSession.getMapper(ICreateDao.class);

		dao.insertCategory(title, des, "resources/thumb/"+thumb_Image,maker);
		dao.createTable(title);
		dao.createTableSeq(title);
		ArrayList<Dto> list = new ArrayList<Dto>();
		for(int i=0;i<name.length;i++) {
			String nam = name[i];
			String image = fileList.get(i).getOriginalFilename();
			Dto dto = new Dto();
			dto.setName(nam);
			dto.setImage("resources/"+title+"/"+image);
			list.add(dto);
		}
		dao.insertCreatedTable(title,list);
		dao.createBoard(title);
		dao.createBoardSeq(title);
		
		
		String path = servletContext.getRealPath("resources");
		try {
			file.transferTo(new File(path+"/thumb", thumb_Image));
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		File Folder = new File(path, title);
//
		if (!Folder.exists()) {
			try {
				Folder.mkdir();
			} catch (Exception e) {
				e.getStackTrace();
			}
		} else {
		}
		path = path +"/"+title;
		

		for (MultipartFile mf : fileList) {
			String originFileName = mf.getOriginalFilename(); // 원본 파일 명
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
