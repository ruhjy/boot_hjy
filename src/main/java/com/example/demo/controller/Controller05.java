package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sub5")
public class Controller05 {

	// 경로 : /sub5/link1?name=강백호&age=33&score=33.3
	@RequestMapping("/link1")
	public void method01(@RequestParam("name") String name,
						 @RequestParam("age") int age,
						 @RequestParam("score") double score) {
		System.out.println("name = " + name);
		System.out.println("age = " + age);
		System.out.println("score = " + score);
	}

	// method01에서 @RequestParam 생략
	@RequestMapping("/link2")
	public void method02(String name, int age, double score) {
		System.out.println("name = " + name);
		System.out.println("age = " + age);
		System.out.println("score = " + score);
	}

	// 경로 : /sub5/link3?address=seoul&height=170.7&width=39.1
	// method3 작성
	@RequestMapping("/link3")
	public void method03(String address, double height, double width) {
		System.out.println("address = " + address);
		System.out.println("height = " + height);
		System.out.println("width = " + width);
	}
}