package com.fastcampus.ch2;

import java.util.Calendar;

// 년월일을 입력하면 요일을 알려주는 프로그램
public class YoilTeller {
	public static void main(String[] args) {
		// 1. 입력
		String year = args[0];
		String month = args[1];
		String day = args[2];

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
		System.out.println(year + "년 " + month + "월 " + day + "일은 ");
		System.out.println(yoil + "요일 입니다.");
		
//		java com.fastcampus.ch2.YoilTeller 2024 4 1
//		java -cp . com.fastcampus.ch2.YoilTeller 2024 4 1
	}
}
