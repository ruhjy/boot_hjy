package com.example.demo.repository;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.example.demo.domain.test.*;

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
	
	public Category add(Category form) {
		String sql = "insert into Categories (CategoryName, Description) "
				+ "values (?, ?)";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setString(1, form.getCategoryName());
			pstmt.setString(2, form.getDescription());
			pstmt.executeUpdate();
			return form;
		} catch (SQLException e) {
			log.error("db error", e);
		}
		return null;
	}
	
	

	public List<Category> findAll() {
		
		List<Category> categories = new ArrayList<>();
		
		String sql = "select * from Categories";
		
		try (
				Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			
			while (rs.next()) {
				Category category = new Category();
				category.setCategoryId(rs.getInt("CategoryID"));
				category.setCategoryName(rs.getString("CategoryName"));
				category.setDescription(rs.getString("Description"));
				categories.add(category);
			}
			
		} catch (SQLException e) {
			log.error("db error", e);
		}
		
		return categories;
	}
	
	private Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
