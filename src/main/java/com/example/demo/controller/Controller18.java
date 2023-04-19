package com.example.demo.controller;

import java.sql.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.*;

@Slf4j
@Controller
@RequestMapping("/sub18")
public class Controller18 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;

	// 트랜잭션 없이 모두 실행
	@RequestMapping("/link1")
	public void method1() {
		String sql1 = "update Bank set money = money - 5000 where customerName = 'A'";
		String sql2 = "update Bank set money = money + 5000 where customerName = 'B'";

		try (
				Connection con = getConnection();
				Statement stmt1 = con.createStatement();
				Statement stmt2 = con.createStatement()) {

			stmt1.executeUpdate(sql1);
			stmt2.executeUpdate(sql2);

			log.info("이체 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 트랜잭션 설정없이 중간에 exception 발생
	@RequestMapping("/link2")
	public void method2() {
		String sql1 = "update Bank set money = money - 5000 where customerName = 'A'";
		String sql2 = "update Bank set money = money + 5000 where customerName = 'B'";

		try (
				Connection con = getConnection();
				Statement stmt1 = con.createStatement();
				Statement stmt2 = con.createStatement()) {

			stmt1.executeUpdate(sql1);

			// exception 발생
			int a = 3 / 0;

			stmt2.executeUpdate(sql2);

			log.info("이체 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			log.error("이체 실패", e);
		}
	}

	// 트랜잭션 설정 후 모두 성공
	@RequestMapping("/link3")
	public void method3() {
		String sql1 = "update Bank set money = money - 5000 where customerName = 'A'";
		String sql2 = "update Bank set money = money + 5000 where customerName = 'B'";

		try (
				Connection con = getConnection();
				Statement stmt1 = con.createStatement();
				Statement stmt2 = con.createStatement()) {
			con.setAutoCommit(false);

			stmt1.executeUpdate(sql1);
			stmt2.executeUpdate(sql2);

			con.commit();

			log.info("이체 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 트랜잭션 설정 후 모두 실패 (중간에 exception 발생시)
	@RequestMapping("/link4")
	public void method4() {
		String sql1 = "update Bank set money = money - 5000 where customerName = 'A'";
		String sql2 = "update Bank set money = money + 5000 where customerName = 'B'";

		Connection con = getConnection();

		try (
				con;
				Statement stmt1 = con.createStatement();
				Statement stmt2 = con.createStatement()) {
			con.setAutoCommit(false);

			stmt1.executeUpdate(sql1);

			// exception 발생
			int a = 5 / 0;

			stmt2.executeUpdate(sql2);

			con.commit();

			log.info("이체 완료");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				log.error("rollback 실패", e1);
			}
			log.error("이체 실패", e);
		}
	}

	private Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			log.error("getConnection error", e);
		}
		return connection;
	}
}
