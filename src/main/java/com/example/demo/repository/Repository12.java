package com.example.demo.repository;

import java.sql.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Repository
public class Repository12 {
	
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;

	public void findAll() {
		String sql = "select ShipperName from Shippers";
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			try (con; stmt; rs) {
				while(rs.next()) {
					System.out.println(rs.getString("ShipperName"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void test() {
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
}
