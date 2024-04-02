package com.fastcampus.ch2;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTellerMVC {
	// MVC 패턴으로 변경
	// Controller -> Model -> VIEW
	@RequestMapping("/getYoilMVC")
	public String main(int year, int month, int day, Model model) throws Exception {
		// 1. 유효성 검사
		if(!isValidate(year, month, day)) return "yoilError";
		
		// 2. 요일 계산
		char yoil = getYoil(year, month, day);
		
		// 3. 계산 결과 Map에 저장
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		
		return "";
	}
	
	public char getYoil(int year, int month, int day) {
		
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day); 
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:일요일, 2:월요일 ...
		char yoil = " 일월화수목금토".charAt(dayOfWeek);
		
		return yoil;
	}
	
	private boolean isValidate(int year, int month, int day) {
		return true;
	}
}
