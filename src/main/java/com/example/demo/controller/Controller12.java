package com.example.demo.controller;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sub12")
public class Controller12 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping("/link1")
	public void method1() {
		String sql = "select LastName from Employees";

		try {
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			try (con; stmt; rs;) {

				System.out.println(rs.next()); // true
				String name1 = rs.getString("LastName");
				System.out.println("name1 : " + name1);

				System.out.println(rs.next()); // true
				String name2 = rs.getString("LastName");
				System.out.println("name2 : " + name2);

				System.out.println(rs.next()); // true
				String name3 = rs.getString("LastName");
				System.out.println("name3 : " + name3);

				System.out.println(rs.next()); // true
				String name4 = rs.getString("LastName");
				System.out.println("name4 : " + name4);

				System.out.println(rs.next()); // true
				String name5 = rs.getString("LastName");
				System.out.println("name5 : " + name5);

				System.out.println(rs.next()); // true
				String name6 = rs.getString("LastName");
				System.out.println("name6 : " + name6);

				System.out.println(rs.next()); // true
				String name7 = rs.getString("LastName");
				System.out.println("name7 : " + name7);

				System.out.println(rs.next()); // true
				String name8 = rs.getString("LastName");
				System.out.println("name8 : " + name8);

				System.out.println(rs.next()); // true
				String name9 = rs.getString("LastName");
				System.out.println("name9 : " + name9);

				System.out.println(rs.next()); // false

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/link2")
	public void method2() {
		String sql = "select LastName from Employees";

		try {
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			try (con; stmt; rs) {
				while (rs.next()) {
					System.out.println(rs.getString("LastName"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// SELECT ShipperName From Shippers;
	// 경로 : link3
	@RequestMapping("/link3")
	public void method3() {
		String sql = "select ShipperName from Shippers";

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				System.out.println(rs.getString("ShipperName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/link4")
	public void method4() {
		String sql = "select * from Customers";

		try {
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			try (con; stmt; rs) {
				rs.next();
				System.out.println(rs.getString("customerName"));
				System.out.println(rs.getString("contactName"));
				System.out.println(rs.getString("country"));

				rs.next();
				System.out.println(rs.getString("customerName"));
				System.out.println(rs.getString("contactName"));
				System.out.println(rs.getString("country"));

				rs.next();
				System.out.println(rs.getString("customerName"));
				System.out.println(rs.getString("contactName"));
				System.out.println(rs.getString("country"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/link5")
	public void method5() {
		String sql = "select * from Customers";

		try {
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			try (con; stmt; rs) {
				while (rs.next()) {
					System.out.println("##################");
					System.out.println(rs.getString("customerName"));
					System.out.println(rs.getString("contactName"));
					System.out.println(rs.getString("country"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/link6")
	public void method6() {
		String sql = "select * from Products where ProductID <= 5";

		try {
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			try (con; stmt; rs) {
				while (rs.next()) {
					System.out.println(rs.getInt("ProductID"));
					System.out.println(rs.getString("ProductName"));
					System.out.println(rs.getDouble("Price"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// SELECT * FROM Customers WHERE CustomerID < 4
	// CustomerID 는 int 타입으로 가져오기
	// CustomerName 은 String 타입으로 가져오기
	// 경로 link7
	@RequestMapping("/link7")
	public void method7(Model model) {
		String sql = "select * from Customers where CustomerID < 4";
		List list = new ArrayList();

		try {
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			try (con; stmt; rs) {
				while (rs.next()) {
					list.add(rs.getInt("CustomerID"));
					list.add(rs.getString("CustomerName"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		model.addAttribute("list", list);
	}

	@RequestMapping("/link8")
	public void method8(Model model) {
		String sql = "select * from Customers where CustomerID < 4";
		List list = new ArrayList();

		try {
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			try (con; stmt; rs) {
				while (rs.next()) {
					list.add(rs.getInt(1));
					list.add(rs.getString(2));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("list", list);
	}

	@RequestMapping("/link9")
	public void method9() throws SQLException {
		String sql = "select LastName, FirstName "
				+ "from Employees where EmployeeID < 4";

		Connection con = DriverManager.getConnection(url, username, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			String lastName = rs.getString(1);
			String firstName = rs.getString(2);

			System.out.println(lastName + " " + firstName);
		}
	}

	@RequestMapping("/link10")
	public void method10() {
		// 고객테이블 조회 쿼리 작성
		// 나머지 코드들도 완성
		String sql = "select CustomerID, CustomerName, Country "
				+ "from Customers where CustomerID <= 10";

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			
			while (rs.next()) {
				int customerId = rs.getInt(1);
				String customerName = rs.getString(2);
				String country = rs.getString(3);

				System.out.println(customerId + ": " + customerName + ", " + country);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
