package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;

import lombok.extern.slf4j.*;

@Slf4j
@Controller
@RequestMapping("/sub8")
public class Controller08 {

	@RequestMapping("/link1")
	public String method1(@ModelAttribute("value") Dto04 dto04) {
		dto04.setName("지은탁");
		dto04.setAge(30);
		log.info("dto04={}", dto04);
		return "sub7/link10";
	}

	@RequestMapping("/link2")
	public void method2(@ModelAttribute("product") Dto02 obj) {
		obj.setCompany("apple");
		obj.setModel("ipad");
		obj.setPrice(300);
	}

	@RequestMapping("/link3")
	public void method3(Model model) {
		Dto02 dto02 = new Dto02();
		Dto03 dto03 = new Dto03();
		model.addAttribute("product", dto02);
		model.addAttribute("member", dto03);
	}

	@RequestMapping("/link4")
	public void method4(@ModelAttribute("product") Dto02 dto02,
						@ModelAttribute("member") Dto03 dto03) {
		// 3. add attribute?
		// 4. forward
	}
	
	// model attribute의 이름을 생략하면 클래스이름을 lowerCamelCase로 바꿔서 등록
	// 예) CompanyManager -> companyManager, Hello -> hello
	@RequestMapping("/link5")
	public void method5(@ModelAttribute("dto02") Dto02 dto02,
						@ModelAttribute("dto03") Dto03 dto03) {
		// 3. add attribute
		dto02.setCompany("microsoft");
		dto03.setName("bill gates");
		// 4. forward
	}
	
	// @ModelAttribute의 이름을 클래스이름 앞글자를 소문자로 바꾼 이름과 동일하게 사용할꺼면 생략 가능
	@RequestMapping("/link6")
	public String method6(@ModelAttribute Dto02 dto02,
						@ModelAttribute Dto03 dto03) {
		// 3. add attribute
		dto02.setCompany("apple");
		dto03.setName("steve jobs");
		// 4. forward
		return "sub8/link5";
	}

}
