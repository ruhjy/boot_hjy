package com.example.demo.controller;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;

import com.example.demo.domain.*;
import com.example.demo.domain.test.*;
import com.example.demo.repository.*;

import lombok.extern.slf4j.*;

@Slf4j
@Controller
public class ControllerTest2 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;

	@GetMapping("/test/customers/save")
	public String saveForm() {
		return "test/saveForm";
	}

	@PostMapping("/test/customers/save")
	public String saveCustomer(@ModelAttribute Customer customer) {
		String sql = "insert into Customers(CustomerName, ContactName, Address, City, PostalCode, Country) "
				+ "values (?, ?, ?, ?, ?, ?)";

		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getContactName());
			pstmt.setString(3, customer.getAddress());
			pstmt.setString(4, customer.getCity());
			pstmt.setString(5, customer.getPostalCode());
			pstmt.setString(6, customer.getCountry());

			int result = pstmt.executeUpdate();
			log.info("{} row(s) affected", result);

		} catch (SQLException e) {
			log.error("insert error", e);
		}
		return "redirect:/test/customers";
	}

	@GetMapping("/test/customers")
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

	@GetMapping("/test/customers/{customerId}/edit")
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

	@PostMapping("/test/customers/{customerId}/edit")
	public String editCustomer(@PathVariable int customerId, @ModelAttribute Customer customer) {
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
	
	@GetMapping("/test/customers/{customerId}/delete")
	public String deleteCustomer(@PathVariable int customerId, RedirectAttributes redirectAttributes) {
		String sql = "delete from Customers where CustomerID = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setInt(1, customerId);
			
			int result = pstmt.executeUpdate();
			log.info("{} row(s) affected", result);
		} catch (SQLException e) {
			log.error("delete error", e);
		}
		redirectAttributes.addAttribute("deleteStatus", true);
		return "redirect:/test/customers";
	}

	private Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
}
