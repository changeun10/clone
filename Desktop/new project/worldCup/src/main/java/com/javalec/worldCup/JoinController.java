package com.javalec.worldCup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javalec.worldCup.dto.LoginDto;
import com.javalec.worldCup.service.LoginService;

@Controller
@RequestMapping("/worldCup")
public class JoinController {

	@Autowired
	private LoginService Lservice;

	@RequestMapping(method = RequestMethod.GET, value = "/join")
	public String join() {
		return "join";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/join")
	public String doJoin(LoginDto dto) {
		Lservice.join(dto);
		return "login";
	}

	@ResponseBody
	@RequestMapping("/checkId")
	public String checkId(String id) {
		LoginDto dto = Lservice.checkId(id);
		if (dto == null) {
			return "ok";
		} else {
			return "no";
		}
	}
}
