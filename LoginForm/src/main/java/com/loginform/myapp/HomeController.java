package com.loginform.myapp;

import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		System.out.println("home : index.jsp");
		
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(Locale locale, Model model, HttpServletRequest request) {
		System.out.println("loginForm.jsp");
		
		return "loginForm";
	}

	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public String news(Locale locale, Model model) {
		System.out.println("news.jsp");
		
		return "news";
	}

	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		System.out.println("registerForm.jsp");
		
		return "registerForm";
	}

	@RequestMapping(value = "/registerInfo", method = RequestMethod.GET)
	public String registerInfo(Locale locale, Model model) {
		System.out.println("registerForm.jsp");
		
		return "registerInfo";
	}
	
	
}
