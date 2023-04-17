-- 내장 함수
-- COUNT : 레코드 수 리턴
select * from Customers;
select COUNT(CustomerID) from Customers;
select COUNT(CustomerName) from Customers;
select COUNT(Country) from Customers; -- 91개
select COUNT(DISTINCT Country) from Customers; -- 21개
select COUNT(CustomerID) from Customers where Country = 'Brazil';

-- DISTINCT : 중복 제거
select Country from Customers; -- 91개
select distinct Country from Customers; -- 21개

SELECT DISTINCT Country FROM Customers ORDER BY 1;
SELECT DISTINCT Country FROM Customers ORDER BY Country;

-- 전체 직원 수
select COUNT(EmployeeID) from Employees; -- 9개

-- 상파울로에 사는 고객 수
select COUNT(CustomerID) from Customers where City = 'São Paulo'; -- 4개

-- 공급자(Suppliers)가 있는 나라 수(중복 제거)
select COUNT(DISTINCT Country) from Suppliers; -- 15개