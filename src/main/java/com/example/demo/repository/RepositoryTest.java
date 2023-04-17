package com.example.demo.repository;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.example.demo.domain.*;

import lombok.extern.slf4j.*;

@Slf4j
@Repository
public class RepositoryTest {

	
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;

	public List<Customer3> findAll() {
		String sql = "select CustomerID, CustomerName, ContactName, Address from Customers";

		List<Customer3> list = new ArrayList<>();

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				Customer3 customer = new Customer3();
				customer.setId(rs.getInt("CustomerID"));
				customer.setName(rs.getString("CustomerName"));
				customer.setContactName(rs.getString("ContactName"));
				customer.setAddress(rs.getString("Address"));
				list.add(customer);
			}
			
		} catch (SQLException e) {
			log.error("db error", e);
		}
		return list;
	}

	public List<Customer3> findByName(String keyword) throws SQLException {
		String sql = "select CustomerID, CustomerName, ContactName, Address "
				+ "from Customers where CustomerName like ?";

		List<Customer3> list = new ArrayList<>();

		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, keyword + "%");
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
			log.error("db error", e);
		}
		return list;
	}

}
