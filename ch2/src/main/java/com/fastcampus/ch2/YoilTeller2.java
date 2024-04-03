package com.fastcampus.ch2;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTeller2 {
	@RequestMapping("/getYoil")
	public static void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("/getYoil 호출");
		// 1. 입력
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");

//		String year = "2024";
//		String month = "4";
//		String day = "1";
		
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		// 2. 작업
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm - 1, dd);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:일요일, 2:월요일 ...
		char yoil = " 일월화수목금토".charAt(dayOfWeek);
		
		// 3. 출력
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
//		System.out.println(year + "년 " + month + "월 " + day + "일은 ");
//		System.out.println(yoil + "요일 입니다.");
		PrintWriter out = response.getWriter(); // response객체에서 브라우저로의 출력 스트림을 얻음
		
		out.print("<p>" + year + "년 " + month + "월 " + day + "일은 </p>");
		out.print("<p>" + yoil + "요일 입니다.</p>");
		

		// 1. request line
		String requestLine = request.getMethod();       // GET 또는 POST
		requestLine += " " + request.getRequestURI();   // /ch2/requestMessage
		
		String queryString = request.getQueryString();  // year=2021&month=10&day=1
		requestLine += queryString == null ? "" : "?"+queryString;  
		requestLine += " " + request.getProtocol();     // HTTP/1.1
		System.out.println(requestLine);		

		
		// 2. request headers
		Enumeration<String> e = request.getHeaderNames();

		while (e.hasMoreElements()) {
			String name = e.nextElement();
			System.out.println(name + ":" + request.getHeader(name));
		}
		
		// 3. request body - POST일 때만 해당, GET은 body가 없음(CONTENT_LENGTH=0)
		final int CONTENT_LENGTH = request.getContentLength();
//		System.out.println("content length="+CONTENT_LENGTH);
		
		System.out.println("------------------------------------------------");
		
		if(CONTENT_LENGTH > 0) {
			byte[] content = new byte[CONTENT_LENGTH];

			InputStream in = request.getInputStream();
			in.read(content, 0, CONTENT_LENGTH);
			
			System.out.println(); // empty line
			System.out.println(new String(content, "utf-8")); // year=2024&month=4&day=3 -> 글자 깨짐
		}  // if
//			String decodedContent = URLDecoder.decode(new String(content, StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8); // year=2024&month=4&day=3
//			System.out.println("Request body: " + decodedContent);
	}
	
}
