package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TwoDice { // 새로 고침할 때마다 바뀜 -> 동적 리소스
	@RequestMapping("/rollDice")
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		int idx1 = (int)(Math.random() * 6) + 1;
		int idx2 = (int)(Math.random() * 6) + 1;
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<img src='resources/img/dice" + idx1 +".jpg'>"); // 이미지파일은 바뀌는게 아니니까 -> 정적 리소스
		out.println("<img src='resources/img/dice" + idx2 +".jpg'>");
		out.println("</body>");
		out.println("</html>");
	
	}
}
