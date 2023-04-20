package com.example.demo.controller;

import java.sql.*;
import java.time.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.format.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.*;

@Slf4j
@Controller
@RequestMapping("/sub19")
public class Controller19 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping("/link1")
	public void method1() {
		String sql = "insert into MyTable30 (Col1, Col2) values (?, ?)";

		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setInt(1, 99);
			pstmt.setString(2, "hello");

			int result = pstmt.executeUpdate();
			log.info("{}개 행 입력됨.", result);

		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

	@RequestMapping("/link2")
	public void method2() {
		String sql = "insert into MyTable30 (Col1, Col2) values (?, ?)";

		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, "888");
			pstmt.setInt(2, 12345);

			int result = pstmt.executeUpdate();
			log.info("{}개 행 입력됨.", result);

		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

	@RequestMapping("/link3")
	public void method3() {
		String sql = "insert into MyTable31 (Col1, Col2) values (?, ?)";

		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, "1923-05-05");
			pstmt.setString(2, "1900-01-01 23:00:00");

			int result = pstmt.executeUpdate();
			log.info("{}개 행 입력됨.", result);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/link4")
	public void method4() {
		String sql = "insert into MyTable31 (Col1, Col2) values (?, ?)";

		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setDate(1, Date.valueOf("2011-11-11"));
			pstmt.setTimestamp(2, Timestamp.valueOf("2000-12-12 23:59:59"));

			int result = pstmt.executeUpdate();
			log.info("{}개 행 입력됨.", result);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 경로 : /sub19/link5
	// MyTable32에 새 레코드 추가하는 메서드 완성
	@RequestMapping("/link5")
	public void method5() {
		String sql = "insert into MyTable32 (name, age, price, birth, inserted) "
				+ "values (?, ?, ?, ?, ?)";

		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, "강백호"); // varchar(20)
			pstmt.setInt(2, 20); // int
			pstmt.setDouble(3, 1234567.89); // dec(10,2)
			pstmt.setDate(4, Date.valueOf("2000-03-03")); // date
			pstmt.setTimestamp(5, Timestamp.valueOf("2000-01-05 23:02:03")); // datetime

			int result = pstmt.executeUpdate();
			log.info("{}개 행 입력됨.", result);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/link6")
	public void method6() {
		// forward to form
		// /WBE-INF/views/sub19/link6.jsp
	}

	@RequestMapping("/link7")
	public void method7(@RequestParam("name") String name,
						@RequestParam("age") String age,
						@RequestParam("price") String price,
						@RequestParam("birth") String birth,
						@RequestParam("inserted") String inserted) {

		String sql = "insert into MyTable32(name, age, price, birth, inserted) "
				+ "values (?, ?, ?, ?, ?)";

		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, name);
			pstmt.setString(2, age);
			pstmt.setString(3, price);
			pstmt.setString(4, birth);
			pstmt.setString(5, inserted);

			int result = pstmt.executeUpdate();
			log.info("{} row(s) affected", result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/link8")
	public void method8(@RequestParam("name") String name,
						@RequestParam("age") Integer age,
						@RequestParam("price") Double price,
						@RequestParam("birth") LocalDate birth,
						@RequestParam("inserted") LocalDateTime inserted) {

		String sql = "insert into MyTable32(name, age, price, birth, inserted) "
				+ "values (?, ?, ?, ?, ?)";
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setDouble(3, price);
			pstmt.setDate(4, Date.valueOf(birth));
			pstmt.setTimestamp(5, Timestamp.valueOf(inserted));

			int result = pstmt.executeUpdate();
			log.info("{} row(s) affected", result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// method9 : form이 있는 view로 포워드
	@RequestMapping("/link9")
	public void method9() {

	}

	// method10 : 전송된 데이터를 MyTable33에 추가
	@RequestMapping("/link10")
	public void method10(@RequestParam("title") String title,
						 @RequestParam("published") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate published,
						 @RequestParam("price") Integer price,
						 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime updated,
						 @RequestParam("weight") Double weight) {
		
		String sql = "insert into MyTable33 (title, published, price, updated, weight) "
				+ "values (?, ?, ?, ?, ?)";

		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, title);
			pstmt.setDate(2, Date.valueOf(published));
			pstmt.setInt(3, price);
			pstmt.setTimestamp(4, Timestamp.valueOf(updated));
			pstmt.setDouble(5, weight);

			int result = pstmt.executeUpdate();
			log.info("{} row(s) affected", result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/link11")
	public void method11() {
		String sql = "select title, published, price, updated, weight from MyTable33";
		
		try (
				Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			
			if (rs.next()) {
				String title = rs.getString("title");
				String published = rs.getString("published");
				String price = rs.getString("price");
				String updated = rs.getString("updated");
				String weight = rs.getString("weight");
				
				System.out.println("제목: " + title);
				System.out.println("출판일: " + published);
				System.out.println("가격: " + price);
				System.out.println("수정일시: " + updated);
				System.out.println("무게: " + weight);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/link12")
	public void method12() {
		String sql = "select title, published, price, updated, weight from MyTable33";
		
		try (
				Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			
			while (rs.next()) {
				String title = rs.getString("title");
				LocalDate published = rs.getDate("published").toLocalDate();
				Integer price = rs.getInt("price");
				LocalDateTime updated = rs.getTimestamp("updated").toLocalDateTime();
				Double weight = rs.getDouble("weight");
				
				System.out.println("==============================");
				System.out.println("제목: " + title);
				System.out.println("출판일: " + published);
				System.out.println("가격: " + price);
				System.out.println("수정일시: " + updated);
				System.out.println("무게: " + weight);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// MyTable32의 데이터 조회 후 출력하는
	// 13번 메서드 작성
	@RequestMapping("/link13")
	public void method13() {
		String sql = "select name, age, price, birth, inserted from MyTable32";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			
			while (rs.next()) {
				String name = rs.getString("name");
				Integer age = rs.getInt("age");
				Double price = rs.getDouble("price");
				LocalDate birth = rs.getDate("birth").toLocalDate();
				LocalDateTime inserted = rs.getTimestamp("inserted").toLocalDateTime();
				
				System.out.println("########################");
				System.out.println("이름 : " + name);
				System.out.println("나이 : " + age);
				System.out.println("가격 : " + price);
				System.out.println("생일 : " + birth);
				System.out.println("입력일시 : " + inserted);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}
