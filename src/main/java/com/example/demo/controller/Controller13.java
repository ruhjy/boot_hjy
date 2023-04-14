package com.example.demo.controller;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;

@Controller
@RequestMapping("/sub13")
public class Controller13 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping("/link1")
	public void method1(Model model) {
		String sql = "select CustomerID, CustomerName "
				+ "from Customers where CustomerID < 4";

		List<Customer> obj = new ArrayList<>();

		// 1.
		// 2.
		try (
				Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				int id = rs.getInt("CustomerID");
				String name = rs.getString("CustomerName");

				Customer customer = new Customer();
				customer.setId(id);
				customer.setName(name);
				obj.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 3. add attribute
		model.addAttribute("customerList", obj);

		// 4. forward
	}

	// 메서드 완성
	// Employee 클래스 작성
	// 프로퍼티 (id, lastName, firstName)
	// jsp 작성
	@RequestMapping("/link2")
	public void method2(Model model) {
		String sql = "select EmployeeID, LastName, FirstName "
				+ "from Employees";
		List<Employee> employeeList = new ArrayList<>();

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt("EmployeeID"));
				employee.setLastName(rs.getString("LastName"));
				employee.setFirstName(rs.getString("FirstName"));
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		model.addAttribute("employeeList", employeeList);
	}

	// 고객 주소 추가
	// 전체 고객 출력
	// jsp에서 테이블 형식으로 보여주기
	@RequestMapping("/link3")
	public void method3(Model model) {
		String sql = "select CustomerID, CustomerName, Address "
				+ "from Customers";

		List<Customer3> customers = new ArrayList<>();

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Customer3 customer = new Customer3();
				customer.setId(rs.getInt("CustomerID"));
				customer.setName(rs.getString("CustomerName"));
				customer.setAddress(rs.getString("Address"));

				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		model.addAttribute("customers", customers);
	}

	// 경로 : /sub13/link4?id=
	@RequestMapping("/link4")
	public String method4(@RequestParam String id, Model model) {
		List<Customer3> list = new ArrayList<>();
		String sql = "select CustomerID, CustomerName, Address "
				+ "from Customers where CustomerID = ";
		sql += id;

		System.out.println(sql);

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

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

		model.addAttribute("customers", list);

		return "/sub13/link3";
	}

	@RequestMapping("/link5")
	public String method5(@RequestParam String id, Model model) throws SQLException {
		List<Customer3> list = new ArrayList<>();
		String sql = "select CustomerID, CustomerName, Address "
				+ "from Customers where CustomerID = ?";

		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);

		ResultSet rs = pstmt.executeQuery();

		try (con; pstmt; rs;) {

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

		model.addAttribute("customers", list);

		return "sub13/link3";
	}

	// /sub13/link6?id=3
	@RequestMapping("/link6")
	public String method6(@RequestParam String id, Model model) {
		// 사용자에게 직원 id 입력 받아서
		// 쿼리 완성하고 실행 후에
		// /sub13/link2로 포워드해서 직원 1명 정보 출력
		List<Employee> list = new ArrayList<>();
		String sql = "select EmployeeID, LastName, FirstName "
				+ "from Employees where EmployeeID = ?";

		try {
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			{
				try (con; pstmt; rs;) {

					if (rs.next()) {
						Employee employee = new Employee();
						employee.setId(rs.getInt("EmployeeID"));
						employee.setLastName(rs.getString("LastName"));
						employee.setFirstName(rs.getString("FirstName"));
						list.add(employee);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		model.addAttribute("employeeList", list);

		return "sub13/link2";
	}

	@RequestMapping("/link11")
	public String method11(@RequestParam String id, Model model) {
		List<Customer3> customers = new ArrayList<>();
		String sql = "select CustomerID, CustomerName, Address from Customers where CustomerID = ?";

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = getPreparedStatement(sql, con, id);
				ResultSet rs = pstmt.executeQuery();) {

			if (rs.next()) {
				Customer3 customer = new Customer3();
				customer.setId(rs.getInt("CustomerID"));
				customer.setName(rs.getString("CustomerName"));
				customer.setAddress(rs.getString("Address"));
				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		model.addAttribute("customers", customers);

		return "sub13/link3";
	}

	private PreparedStatement getPreparedStatement(String sql, Connection con, String id) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt;
	}
}