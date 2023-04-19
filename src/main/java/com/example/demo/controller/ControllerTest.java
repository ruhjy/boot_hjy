package com.example.demo.controller;

import java.util.*;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.test.*;
import com.example.demo.repository.*;

import lombok.extern.slf4j.*;

@Slf4j
@Controller
@RequestMapping("/test")
public class ControllerTest {
	
	private final RepositoryTest repository;
	
	public ControllerTest(RepositoryTest repository) {
		this.repository = repository;
	}
	
	@RequestMapping("/categories")
	public String categories(Model model) {
		List<Category> categories = repository.findAll();
		log.info("categories={}", categories);
		model.addAttribute("categories", categories);
		return "test/categories";
	}

	@RequestMapping(value = "/categories", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category form) {
		repository.add(form);
		return "test/category";
	}
	
}
