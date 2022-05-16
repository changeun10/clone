package com.javalec.worldCup;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.javalec.worldCup.service.CreateService;

@Controller
@RequestMapping("/worldCup")
public class CreateController {
 
	@Autowired
	private CreateService CrService;

	@RequestMapping(method = RequestMethod.GET, value = "/create")
	public String create(HttpSession session) {
		String id = (String) session.getAttribute("id");
		if (id == null) {
			return "login";
		} else {
			return "create";
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public String createWorldCup(String des, MultipartHttpServletRequest mRequest, String[] name, HttpSession session) {
		String maker = (String) session.getAttribute("id");
		CrService.createNewWroldCup(des, name, mRequest, maker);
		
		return "redirect:/worldCup/";
	}

}
