package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. 원격 호출가능한 프로그램으로 등록
@Controller
public class Hello {
	int iv = 10; // 인스턴스 변수
	static int cv = 20; // static 변수
	// 2. URL과 메서드를 연결
	@RequestMapping("/hello")
	public void main() {
		System.out.println("Hello");
		System.out.println(cv); // ok
		System.out.println(iv); // ok
	}
	
	@RequestMapping("/hello2")
	public static void main2() {
		System.out.println("Hello - static");
		System.out.println(cv); // ok
//		System.out.println(iv); // error
	}
	
	@RequestMapping("/hello3")
	private void main3() {
		System.out.println("Hello - private");
		System.out.println(cv); // ok
		System.out.println(iv); // ok
	}
}
