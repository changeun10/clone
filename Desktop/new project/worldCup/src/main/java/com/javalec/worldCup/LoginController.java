package com.javalec.worldCup;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.worldCup.dto.LoginDto;
import com.javalec.worldCup.service.LoginService;

@Controller
@RequestMapping("/worldCup")
public class LoginController {

	@Autowired
	private LoginService Lservice;

	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public String doLogin(String id, String pw, HttpSession session) {
		if (Lservice.checkLogin(id, pw)) {
			session.setAttribute("id", id);
			return "redirect:/worldCup/";
		} else {
			return "login";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("id");
		return "redirect:/worldCup/";
	}
}
