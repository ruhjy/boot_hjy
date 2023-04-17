package com.example.demo.controller;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;

@Controller
@RequestMapping("/sub14")
public class Controller14 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;

	// /sub14/link1?keyword=or
	@RequestMapping("/link1")
	public String method1(@RequestParam String keyword, Model model) throws SQLException {
		List<Customer3> list = new ArrayList<>();
		String sql = "select CustomerID, CustomerName, Address "
				+ "from Customers where CustomerName like ?";

		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + keyword + "%");
		
		ResultSet rs = pstmt.executeQuery();

		try (con; pstmt; rs) {

			while (rs.next()) {
				Customer3 customer = new Customer3();
				customer.setId(rs.getInt("CustomerID"));
				customer.setName(rs.getString("CustomerName"));
				customer.setAddress(rs.getString("Address"));
				list.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("customerList", list);

		return "sub13/link1";
	}
	
	// 추가업무 : ContactName에도 키워드 조회 추가
	// 1. 쿼리 수정
	// 2. pstmt에 2번째 물음표에 set 하는 코드 추가
	// 3. Customer 자바빈의 contactName 프로퍼티 추가
	// 4. /sub13/link1 뷰에 contactName 속성 출력하는 테이블 열 추가
	
	// /sub14/link2?keyword=or
	@RequestMapping("/link2")
	public String method2(@RequestParam String keyword, Model model) throws SQLException {
		List<Customer3> list = new ArrayList<>();
		String sql = "select CustomerID, CustomerName, Address, ContactName "
				+ "from Customers where CustomerName like ? "
				+ "or ContactName like ?";

		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + keyword + "%");
		pstmt.setString(2, "%" + keyword + "%");
		
		ResultSet rs = pstmt.executeQuery();

		try (con; pstmt; rs) {

			while (rs.next()) {
				Customer3 customer = new Customer3();
				customer.setId(rs.getInt("CustomerID"));
				customer.setName(rs.getString("CustomerName"));
				customer.setContactName(rs.getString("ContactName"));
				customer.setAddress(rs.getString("Address"));
				list.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("customerList", list);

		return "sub13/link1";
	}
}
