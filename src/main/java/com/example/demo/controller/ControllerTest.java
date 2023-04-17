package com.example.demo.controller;

import java.sql.*;
import java.util.*;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;
import com.example.demo.repository.*;

@Controller
public class ControllerTest {
	
	private final RepositoryTest repository;
	
	public ControllerTest(RepositoryTest repository) {
		this.repository = repository;
	}

	@GetMapping("/test")
	public String method0(Model model) {
		List<Customer3> list = repository.findAll();
		
		model.addAttribute("customers", list);

		return "sub13/test";
	}

	@PostMapping("/test")
	public String method1(@RequestParam String keyword, Model model) throws SQLException {
		List<Customer3> list = repository.findByName(keyword);

		model.addAttribute("customers", list);

		return "sub13/test";
	}
	
}
