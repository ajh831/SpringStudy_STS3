package com.loginform.myapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/LoginController")
public class LoginController extends HttpServlet  {
	
	private static final long serialVersionUID = 1L;

		// login : 로그인 성공 여부, checkBox : 체크박스 클릭 여부
		public void cookieCheck(boolean login, HttpServletResponse response, Cookie cookie, String checkBox, String id) {
			int time = 60*5;
			if(checkBox != null && login == true) { // id 기억
			} else {
				id = "";
				time = 0;
			}
			cookie = new Cookie("cookieId", id);
			cookie.setMaxAge(time);
			response.addCookie(cookie);
		}
	      
		public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String checkBox = request.getParameter("checkBox");
			
			System.out.println("id 입력 : " + id);
			System.out.println("pwd 입력 : " + pwd);
			System.out.println("checkbox 입력 확인 : " + checkBox);
			
			/*
			 1. 로그인 성공 시
			 	1.1 checkBox 클릭한 경우
			 	1.2. checkBox 클릭하지 않은 경우
			 2. 로그인 실패 시
			 	2.1. checkBox 무조건 클릭하지 않은 경우로
			 */
			
			String hiddenURL = request.getParameter("hiddenURL");
			
			request.setAttribute("id", id); // userInfo에서 사용자 정보 확인하기 위함
			request.setAttribute("pwd", pwd); // userInfo에서 사용자 정보 확인하기 위함
			
			System.out.println("LoginController hiddenURL 확인중 : " + hiddenURL);
			
			boolean login = false;
			Cookie cookie = null;
			
			if(id != null && pwd != null &&id.equals("asdf") && pwd.equals("1234")) {
				System.out.println("로그인 성공");
				login = true;
				
				// 세션 생성
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				
				request.setAttribute("id", id);
				request.setAttribute("pwd", pwd);
				
				cookieCheck(login, response, cookie, checkBox, id);
				
//				request.getRequestDispatcher(hiddenURL).forward(request, response);
				request.getRequestDispatcher("/").forward(request, response);
			} else {
				System.out.println("로그인 실패");
				
				cookieCheck(login, response, cookie, checkBox, id);
				
				response.sendRedirect("/loginForm?toURL=" + hiddenURL);
			}
		}

}