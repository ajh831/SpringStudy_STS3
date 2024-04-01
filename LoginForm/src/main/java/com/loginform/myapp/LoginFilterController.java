package com.loginform.myapp;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/login")
public class LoginFilterController {
	
	public boolean filter(HttpSession session) {
		boolean login = false;
    	if(session != null) {
    		if(session.getAttribute("id") != null) {
    			login = true;
    		}
    	}
    	return login;
	}
	
	
	@RequestMapping(value = "/board")
	public String board(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("board.jsp");
		HttpSession session = request.getSession();
		boolean login = filter(session);
		if(login != true) {
			return "redirect:/login?toURL=board";
		}
		
		return "/login/board";
	}

	@RequestMapping(value = "/qna")
	public String qna(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("qna.jsp");
		HttpSession session = request.getSession();
		boolean login = filter(session);
		if(login != true) {
			return "redirect:/login?toURL=qna";
		}
		
		return "/login/qna";
	}
}
