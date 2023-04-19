package com.example.demo.controller;

import java.sql.*;
import java.util.*;
import java.util.Date;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;

import lombok.extern.slf4j.*;

@Slf4j
@Controller
@RequestMapping("/sub15")
public class Controller15 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping("/link1")
	public void method1() {
		// 새 고객데이터 추가
		String sql = "insert into Customers (CustomerID, CustomerName, City) "
				+ "values (93, '서태웅', '부산')";

		// INSERT, UPDATE, DELETE 는
		// Statement의 executeUpdate 메서드 사용
		// 리턴값은 영향을 미친 레코드 수(int)

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement()) {

			int count = stmt.executeUpdate(sql);
			System.out.println(count + " 개 행 추가됨...");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 경로 : /sub15/link2
	// 10번째 직원 추가
	// 컬럼 : EmployeeID, LastName, FirstName
	@RequestMapping("/link2")
	public void method2() {
		String sql = "insert into Employees (EmployeeID, LastName, FirstName) "
				+ "values (10, '백호', '강')";

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement()) {

			int count = stmt.executeUpdate(sql);
			System.out.println(count + " 개 행 추가됨...");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// /sub15/link3?customerName=송태섭&city=부산&country=한국
	@RequestMapping("/link3")
	public void method3(
			@RequestParam("customerName") String customerName,
			@RequestParam("city") String city,
			@RequestParam("country") String country) {
		String sql = "insert into Customers (CustomerName, City, Country) "
				+ "values (?, ?, ?)";

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, customerName);
			pstmt.setString(2, city);
			pstmt.setString(3, country);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// /sub15/link4?firstName=박지성&lastName=두개의심장
	// 직원정보 추가
	@RequestMapping("/link4")
	public void method4(@RequestParam String firstName,
			@RequestParam String lastName) {
		String sql = "insert into Employees (FirstName, LastName) "
				+ "values (?, ?)";

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			int count = pstmt.executeUpdate();

			log.info("{} 행 추가됨", count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/link5")
	public void method5() {
		// form 이 있는 view로 포워드
		// view : /WEB-INF/views/sub15/link5.jsp
	}

	@RequestMapping("/link6")
	public void method6(
			@RequestParam String firstName,
			@RequestParam String lastName) {

		String sql = "insert into Employees (FirstName, LastName) "
				+ "values (?, ?)";

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			int count = pstmt.executeUpdate();
			log.info("{} row(s) affected", count);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 경로 : /sub15/link7
	// 폼이 있는 jsp로 포워드
	@RequestMapping("/link7")
	public void method7() {

	}

	// 경로 : /sub15/link8
	@RequestMapping("/link8")
	public void method8(
			@RequestParam("name") String name,
			@RequestParam("city") String city,
			@RequestParam("country") String country) {

		// 3개 메서드 파리미터 활용해서
		// suppliers 테이블에 레코드 추가
		String sql = "insert into Suppliers (SupplierName, City, Country) "
				+ "values (?, ?, ?)";

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, name);
			pstmt.setString(2, city);
			pstmt.setString(3, country);

			int count = pstmt.executeUpdate();
			log.info("{} row(s) affected", count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/link9")
	public void method9() {

	}

	@RequestMapping("/link10")
	public void method10(@ModelAttribute("customer") Customer3 customer) {
		String sql = "insert into Customers (CustomerName, ContactName, Address) "
				+ "values (?, ?, ?)";

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getContactName());
			pstmt.setString(3, customer.getAddress());

			int count = pstmt.executeUpdate();
			log.info("{} row(s) affected", count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 경로 : /sub15/link11
	@RequestMapping("/link11")
	public void method11() {

	}

	// 경로 : /sub15/link12
	@RequestMapping("/link12")
	@ResponseBody
	public String method12(Supplier supplier) {
		// 공급자 테이블에 데이터 입력
		String sql = "insert into Suppliers "
				+ "(SupplierName, ContactName, Address, City, PostalCode, Country, Phone) "
				+ "values "
				+ "		(?, ?, ?, ?, ?, ?, ?)";

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstmt.setString(1, supplier.getName());
			pstmt.setString(2, supplier.getContactName());
			pstmt.setString(3, supplier.getAddress());
			pstmt.setString(4, supplier.getCity());
			pstmt.setString(5, supplier.getPostalCode());
			pstmt.setString(6, supplier.getCountry());
			pstmt.setString(7, supplier.getPhone());

			int count = pstmt.executeUpdate();

			// 자동생성된 컬럼(키) 값 얻기
			ResultSet key = pstmt.getGeneratedKeys();
			int keyValue = 0;
			if (key.next()) {
				keyValue = key.getInt(1);
			}

			log.info("{} row(s) affected", count);
			log.info("{} 번 공급자 데이터 입력됨", keyValue);

			return keyValue + "번 공급자 데이터 입력됨";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
