package com.example.demo.controller;

import javax.servlet.http.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sub4")
public class Controller04 {
	// method argument(parameter)
	
	// 경로 : /sub4/link1?name=손&age=30
	@RequestMapping("/link1")
	public void method01(HttpServletRequest req) {
		// 1. request parameter 수집/가공
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		
		// 2. business logic
		
		// 3. add attribute
		
		// 4. forward / redirect
	}
	
	// 경로 : /sub4/link2?address=seoul&email=korea@gmail.com
	// address, email 파라미터 출력하는 메서드 작성
	@RequestMapping("/link2")
	public void method02(HttpServletRequest request) {
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		
		System.out.println("address : " + address);
		System.out.println("email : " + email);
	}
	
	// 경로 : /sub4/link3?address=seoul
	@RequestMapping("/link3")
	public void method03(@RequestParam("address") String address) {
		System.out.println("address : " + address);
	}
	
	// 경로 : /sub4/link4?age=999
	// 로 요청 왔을 때 age request param 출력하는 메서드 작성
	@RequestMapping("/link4")
	public void method04(@RequestParam("age") String myAge) {
		System.out.println("age : " + myAge);
		
		int age = Integer.parseInt(myAge);
		
		System.out.println("int age : " + age);
	}

	// 경로 : /sub4/link5?score=80
	@RequestMapping("/link5")
	public void method05(@RequestParam("score") int score) {
		System.out.println("score = " + score);
	}

	/**
	 * 쿼리스트링에 요청 파라미터 이름과 파라미터 변수 이름과 동일하다면 생략 가능("email")
	 * (@RequestParam("email")String email) == (@RequestParam String email)
	 */
	// 경로 : /sub4/link6?email=korea@naver.com
	@RequestMapping("/link6")
	public void method06(@RequestParam("email") String email) {
		System.out.println("email = " + email);
	}

	// 경로 : /sub4/link7?age=33
	// method7 작성
	@RequestMapping("/link7")
	public void method07(@RequestParam int age) {
		System.out.println("age = " + age);
	}

	/**
	 * 기본 타입?은 @RequestParam 생략 가능
	 */
	// 경로 : /sub4/link8?address=seoul
	@RequestMapping("/link8")
	public void method08(String address) {
		System.out.println("address = " + address);
	}

	// 경로 : /sub4/link9?score=99.7 -- String? double?
	// method9 작성
	@RequestMapping("/link9")
	public void method09(double score) {
		System.out.println("score = " + score);
	}

}
