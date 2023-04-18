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

	public List<Test1> test123() {
		String sql = "select Country, City, COUNT(SupplierID) as Count from Suppliers group by Country, City";

		List<Test1> list = new ArrayList<>();

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Test1 t = new Test1();
				t.setCountry(rs.getString("Country"));
				t.setCity(rs.getString("City"));
				t.setCount(rs.getInt("Count"));
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public List<Supplier> findAllSuppliers() {
		List<Supplier> list = new ArrayList<>();
		
		String sql = "select * from Suppliers";
		
		try (
				Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			
			while (rs.next()) {
				Supplier supplier = new Supplier();
				supplier.setId(rs.getLong("SupplierID"));
				supplier.setName(rs.getString("SupplierName"));
				supplier.setContactName(rs.getString("ContactName"));
				supplier.setAddress(rs.getString("Address"));
				supplier.setCity(rs.getString("City"));
				supplier.setPostalCode(rs.getString("PostalCode"));
				supplier.setCountry(rs.getString("Country"));
				supplier.setPhone(rs.getString("Phone"));
				list.add(supplier);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Supplier supplierSave(Supplier supplier) {
		String sql = "insert into Suppliers "
				+ "(SupplierID, SupplierName, ContactName, Address, City, PostalCode, Country, Phone) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?)";

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setLong(1, supplier.getId());
			pstmt.setString(2, supplier.getName());
			pstmt.setString(3, supplier.getContactName());
			pstmt.setString(4, supplier.getAddress());
			pstmt.setString(5, supplier.getCity());
			pstmt.setString(6, supplier.getPostalCode());
			pstmt.setString(7, supplier.getCountry());
			pstmt.setString(8, supplier.getPhone());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return supplier;
	}

	public static class Supplier {
		private Long id;
		private String name;
		private String contactName;
		private String address;
		private String city;
		private String postalCode;
		private String country;
		private String phone;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getContactName() {
			return contactName;
		}

		public void setContactName(String contactName) {
			this.contactName = contactName;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getPostalCode() {
			return postalCode;
		}

		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}
	}

	public static class Test1 {
		private String country;
		private String city;
		private Integer count;

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			this.count = count;
		}

	}

}
