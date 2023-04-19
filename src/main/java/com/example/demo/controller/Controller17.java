package com.example.demo.controller;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;

import lombok.extern.slf4j.*;

@Slf4j
@Controller
@RequestMapping("/sub17")
public class Controller17 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;

	// 경로 : /sub17/link1?id=33&name=서태웅
	@RequestMapping("/link1")
	public void method1(@RequestParam("id") int supplierId,
			@RequestParam("name") String supplierName) {
		String sql = "update Suppliers "
				+ "set SupplierName = ? "
				+ "where SupplierID = ?";
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, supplierName);
			pstmt.setInt(2, supplierId);

			int result = pstmt.executeUpdate();
			log.info("{} row(s) affected", result);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 경로 : /sub17/link2?id=33&address=seoul
	// SupplierID 가 33번인 공급자 주소(address)를 seoul로 바꾸는 메서드
	@RequestMapping("/link2")
	public void method2(@RequestParam("id") int supplierId,
			@RequestParam String address) {
		String sql = "update Suppliers set "
				+ "Address = ? "
				+ "where SupplierID = ?";

		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, address);
			pstmt.setInt(2, supplierId);

			int result = pstmt.executeUpdate();
			log.info("{} row(s) affected", result);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/link3")
	public void method3(@ModelAttribute Supplier supplier) {
		String sql = "update Suppliers set "
				+ "SupplierName = ?, "
				+ "ContactName = ?, "
				+ "Address = ?, "
				+ "City = ?, "
				+ "PostalCode = ?, "
				+ "Country = ?, "
				+ "Phone = ? "
				+ "where SupplierID = ?";

		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, supplier.getName());
			pstmt.setString(2, supplier.getContactName());
			pstmt.setString(3, supplier.getAddress());
			pstmt.setString(4, supplier.getCity());
			pstmt.setString(5, supplier.getPostalCode());
			pstmt.setString(6, supplier.getCountry());
			pstmt.setString(7, supplier.getPhone());
			pstmt.setInt(8, supplier.getId());
			int result = pstmt.executeUpdate();

			log.info("{} row(s) affected", result);
			log.info("{} 번 공급자 수정됨...", supplier.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 경로 : /sub17/link4?id=65
	@RequestMapping("/link4")
	public void method4(@RequestParam int id, Model model) {
		String sql = "select SupplierID, SupplierName, ContactName, Address, City, PostalCode, Country, Phone "
				+ "from Suppliers where SupplierID = ?";

		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery();) {

				if (rs.next()) {
					Supplier supplier = new Supplier();
					supplier.setId(rs.getInt("SupplierID"));
					supplier.setName(rs.getString("SupplierName"));
					supplier.setContactName(rs.getString("ContactName"));
					supplier.setAddress(rs.getString("Address"));
					supplier.setCity(rs.getString("City"));
					supplier.setPostalCode(rs.getString("PostalCode"));
					supplier.setCountry(rs.getString("Country"));
					supplier.setPhone(rs.getString("Phone"));
					model.addAttribute("supplier", supplier);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 고객조회 (method4 참고)
	@RequestMapping("/link5")
	public void method5(@RequestParam("id") int customerId, Model model) {
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
	}

	// 고객정보 수정 (method3 참고)
	@RequestMapping("/link6")
	public void method6(@ModelAttribute Customer customer) {
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

	}
	
	private Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
}
