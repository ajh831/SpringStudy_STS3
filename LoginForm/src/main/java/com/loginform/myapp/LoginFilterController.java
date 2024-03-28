package com.loginform.myapp;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/login")
public class LoginFilterController {
	
	@RequestMapping(value = "/board")
	public String board(Locale locale, Model model) {
		System.out.println("board.jsp");
		
		return "/login/board";
	}

	@RequestMapping(value = "/qna")
	public String qna(Locale locale, Model model) {
		System.out.println("qna.jsp");
		
		return "/login/qna";
	}
}
