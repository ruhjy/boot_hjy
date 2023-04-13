package com.example.demo.controller;

import java.sql.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sub11")
public class Controller11 {

	@RequestMapping("/link1")
	public void method1() {
		// 2. business logic
		String url = "jdbc:mariadb://13.209.81.252:3306/w3schools";
		String username = "root";
		String passward = "RQwrtXrBgmQ4";
		// SELECT CustomerName FROM Customers WHERE CustomerId = 1;
		String sql = "SELECT CustomerName FROM Customers WHERE CustomerId = 1";
		// db 연결 -> 
		Connection con = DriverManager.getConnection(url, name, passward);
		// Statment 객체 생성 ->
		Statement stmt = con.createStatement();
		// 쿼리실행 -> 
		// 쿼리실행 결과 얻고 -> 
		ResultSet rs = stmt.executeQuery(sql);
		// 쿼리실행 결과 가공
		if (rs.next()) {
			String name = rs.getString("CustomerName");
		}
	}
}
