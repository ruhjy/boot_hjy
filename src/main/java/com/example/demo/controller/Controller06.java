package com.example.demo.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sub6")
public class Controller06 {

	@RequestMapping("/link1")
	public String method01() {
		System.out.println("link1 메서드 일함");
		return "forward:/sub6/link2";
	}

	@RequestMapping("/link2")
	public void method02() {
		System.out.println("link2 메서드 일함");
	}

	// 경로 : /sub6/link3
	// method03 작성
	// forward : /sub6/link2
	@RequestMapping("/link3")
	public String method03() {
		System.out.println("link3 메서드 일함");
		return "forward:/sub6/link2";
	}

	@RequestMapping("/link4")
	public void method04(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("link4 에서 일함");

		String view = "/WEB-INF/views/abc.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}

	@RequestMapping("/link5")
	public String method05() {
		System.out.println("link5 에서 일함");
		return "forward:/WEB-INF/views/abc.jsp";
	}

	// application.properties에서 prefix, suffix 작성
	@RequestMapping("/link6")
	public String method06() {
		System.out.println("link6 에서 일함");
		return "abc";
	}

	@RequestMapping("/link7")
	public String method07() {
		System.out.println("link7 에서 일함");
		return "def";
	}

	@RequestMapping("/link8")
	public String method08() {
		System.out.println("8번 메서드 일함");
		// default view name : /sub6/link8
		return "/sub6/link8";
	}
//	return "forward:/WEB-INF/views/abc.jsp";

	@RequestMapping("/link9")
	public void method09() {
		System.out.println("9번 메서드 일함");
		// default view name : /sub6/link9
	}

	@RequestMapping("/link10")
	public String method10() {
		System.out.println("10번 메서드 일함");
		return null; // forward default view name
	}

	// 경로 : /sub6/link11
	// method11 작성
	// /WEB-INF/views/sub6/link11.jsp로 포워드
	@RequestMapping("/link11")
	public String method11() {
		System.out.println("11번 메서드 일함");
		return "sub6/link11"; // return null; 같은 의미
	}

	// 경로 : /sub6/link12?name=park&age=33
	// method12 작성
	// 1. request param 수집/가공
	// 2. business logic (생략)
	// 3. add attribute(생략)
	// 4. /WEB-INF/views/sub6/link12.jsp 로 포워드
	@RequestMapping("/link12")
	public void method12(String name, int age) {
		
	}
	
}
