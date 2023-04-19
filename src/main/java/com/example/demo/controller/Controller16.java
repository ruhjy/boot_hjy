package com.example.demo.controller;

import java.sql.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.*;

@Slf4j
@Controller
@RequestMapping("/sub16")
public class Controller16 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;

	// /sub16/link1?id=30
	@RequestMapping("/link1")
	public void method1(@RequestParam("id") int supplierId) {
		String sql = "delete from Suppliers where SupplierID = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setInt(1, supplierId);
			int result = pstmt.executeUpdate();
			log.info("{} row(s) affected", result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 경로 : /sub16/link2?id=30
	// 고객테이블의 데이터 삭제 메서드 작성
	@RequestMapping("/link2")
	public void method2(@RequestParam("id") int customerId) {
		String sql = "delete from Customers where CustomerID = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setInt(1, customerId);
			int result = pstmt.executeUpdate();
			log.info("{} row(s) affected", result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
}
