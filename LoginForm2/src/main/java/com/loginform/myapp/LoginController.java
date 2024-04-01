package com.loginform.myapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	public void cookieCheck(boolean login, HttpServletResponse response, String checkBox, String id) {
		int time = 60 * 5;
		System.out.println("LoginContoroller checkBox : " + checkBox);
		if (checkBox == null) { // id 기억 안할 경우
			id = "";
			time = 0;
			System.out.println("id 기억 안함");
		}
		Cookie cookie = new Cookie("cookieId", id);
		System.out.println("LoginContoroller cookieId : " + id);
		cookie.setMaxAge(time);
		response.addCookie(cookie);

	}

	@RequestMapping(value = "/loginCheck")
	public String login(String id, String pwd, String checkBox, String toURL, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("LoginController toURL 확인중 : " + toURL);
		System.out.println("LoginController checkBox 여부 확인중 : " + checkBox);

		if (toURL == null || toURL.equals("null")) {
			toURL = "/";
		}

		boolean login = false;

		request.setAttribute("id", id); // userInfo에서 사용자 정보 확인하기 위함
		request.setAttribute("pwd", pwd); // userInfo에서 사용자 정보 확인하기 위함

		System.out.println("LoginCon id : " + id);
		if (id != null && pwd != null && id.equals("asdf") && pwd.equals("1234")) {

			System.out.println("로그인 성공");
			login = true;

			// 세션 불러오기
			HttpSession session = request.getSession();
			session.setAttribute("id", id);

			request.setAttribute("id", id);
			request.setAttribute("pwd", pwd);

			cookieCheck(login, response, checkBox, id);

			return "redirect:" + toURL;
		} else {
			System.out.println("로그인 실패");

			cookieCheck(login, response, checkBox, id);

//			return "redirect:/loginForm?toURL=" + toURL;
			return "redirect:/login?toURL=" + toURL;
		}
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		// 1. 세션을 종료
		session.invalidate();
		// 2. 홈으로 이동
//        return "redirect:/";
		return "index";
	}


}