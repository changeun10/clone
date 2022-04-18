package com.javalec.worldCup.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.javalec.worldCup.dao.ICreateDao;
import com.javalec.worldCup.dto.ContentDto;

@Transactional
@Service
public class CreateServiceLogic implements CreateService {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private ServletContext servletContext;

	@Override
	public void createNewWroldCup(String title, String[] name,
			MultipartHttpServletRequest mRequest,String maker) {
		List<MultipartFile> fileList = mRequest.getFiles("image");
		MultipartFile file = mRequest.getFile("thumb");
		String thumb_img = file.getOriginalFilename();
		
		ICreateDao dao = sqlSession.getMapper(ICreateDao.class);
		
		int a = dao.createWorldCup("resources/thumb/"+thumb_img, title, maker);
		System.out.println(a);
		
		ArrayList<ContentDto> list = new ArrayList<ContentDto>();
		for(int i=0;i<name.length;i++) {
			String nam = name[i];
			String image = fileList.get(i).getOriginalFilename();
			ContentDto dto = new ContentDto();
			dto.setName(nam);
			dto.setImage("resources/"+title+"/"+image);
			list.add(dto);
		}
		
		dao.insertContent(list);
		
		String path = servletContext.getRealPath("resources");
		try {
			file.transferTo(new File(path+"/thumb", thumb_img));
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		File Folder = new File(path, title);

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
