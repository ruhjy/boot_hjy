package com.example.demo.controller;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;
import com.example.demo.domain.test.*;
import com.example.demo.repository.*;

import lombok.extern.slf4j.*;

@Slf4j
@Controller
@RequestMapping("/test")
public class ControllerTest2 {
	
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	
	// 고객조회 (method4 참고)
	@GetMapping("/customers/{customerId}")
	public String editForm(@PathVariable int customerId, Model model) {
		String sql = "select CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country "
				+ "from Customers where CustomerID = ?";

		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setInt(1, customerId);

			try (ResultSet rs = pstmt.executeQuery();) {

				if (rs.next()) {
					Customer customer = new Customer();
					customer.setId(rs.getInt("CustomerID"));
					customer.setName(rs.getString("CustomerName"));
					customer.setContactName(rs.getString("ContactName"));
					customer.setAddress(rs.getString("Address"));
					customer.setCity(rs.getString("City"));
					customer.setPostalCode(rs.getString("PostalCode"));
					customer.setCountry(rs.getString("Country"));
					model.addAttribute("customer", customer);
				} else {
					throw new NoSuchElementException("Not Found Customer, CustomerId = " + customerId);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "test/editForm";
	}

	// 고객정보 수정 (method3 참고)
	@PostMapping("/customers")
	public String editCustomer(@ModelAttribute Customer customer) {
		String sql = "update Customers set "
				+ "CustomerName = ?, "
				+ "ContactName = ?, "
				+ "Address = ?, "
				+ "City = ?, "
				+ "PostalCode = ?, "
				+ "Country = ? "
				+ "where CustomerID = ?";

		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getContactName());
			pstmt.setString(3, customer.getAddress());
			pstmt.setString(4, customer.getCity());
			pstmt.setString(5, customer.getPostalCode());
			pstmt.setString(6, customer.getCountry());
			pstmt.setInt(7, customer.getId());

			int result = pstmt.executeUpdate();
			log.info("{} row(s) affected, {}번 고객 수정됨...", result, customer.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/test/customers";
	}
	
	@GetMapping("/customers")
	public String customerList(Model model) {
		String sql = "select * from Customers";
		
		List<Customer> customers = new ArrayList<>();
		
		try (
				Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("CustomerID"));
				customer.setName(rs.getString("CustomerName"));
				customer.setContactName(rs.getString("ContactName"));
				customer.setAddress(rs.getString("Address"));
				customer.setCity(rs.getString("City"));
				customer.setPostalCode(rs.getString("PostalCode"));
				customer.setCountry(rs.getString("Country"));
				
				customers.add(customer);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("customers", customers);
		return "test/customers";
	}

	private Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
}
