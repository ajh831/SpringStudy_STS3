package com.loginform.myapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.loginform.dao.UserDAO;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	@Autowired
	UserDAO userDao;

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

	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public String login(String id, String pwd, String checkBox, String toURL, HttpServletRequest request,
			HttpServletResponse response, Model model) throws ServletException, IOException {

		System.out.println("LoginController toURL 확인중 : " + toURL);
		System.out.println("LoginController checkBox 여부 확인중 : " + checkBox);

		if (toURL == null || toURL.equals("null")) {
			toURL = "/";
		}

		boolean login = false;

//		model.addAttribute("id", id); // userInfo에서 사용자 정보 확인하기 위함
//		model.addAttribute("pwd", pwd); // userInfo에서 사용자 정보 확인하기 위함

		System.out.println("LoginCon id : " + id);
//		if (id != null && pwd != null && id.equals("asdf") && pwd.equals("1234")) {
		if (loginCheck(id, pwd)) {

			System.out.println("로그인 성공");
			login = true;

			// 세션 불러오기
			HttpSession session = request.getSession();
			session.setAttribute("id", id);

//			model.addAttribute("id", id);
//			model.addAttribute("pwd", pwd);

			cookieCheck(login, response, checkBox, id);

			return "redirect:" + toURL;
		} else {
			System.out.println("로그인 실패");

			cookieCheck(login, response, checkBox, id);

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

	public boolean filter(HttpSession session) {
		boolean login = false;
		if (session != null) {
			if (session.getAttribute("id") != null) {
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
		if (login != true) {
			return "redirect:/login?toURL=board";
		}

		return "redirect:/board/list";
	}

	@RequestMapping(value = "/qna")
	public String qna(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("qna.jsp");
		HttpSession session = request.getSession();
		boolean login = filter(session);
		if (login != true) {
			return "redirect:/login?toURL=qna";
		}

		return "/login/qna";
	}

	private boolean loginCheck(String id, String pwd) {
		User user = null;

		try {
			user = userDao.selectUser(id);
			System.out.println("LoginController user.getId : " + user.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return user != null && user.getPwd().equals(pwd);
//        return "asdf".equals(id) && "1234".equals(pwd);
	}

}