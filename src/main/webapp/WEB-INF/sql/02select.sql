-- 모든 필드
SELECT * FROM Customers;
-- CustomerName 필드만
SELECT CustomerName FROM Customers;
SELECT ContactName FROM Customers;
SELECT Country FROM Customers;
SELECT CustomerName, ContactName FROM Customers;
SELECT CustomerName, ContactName, Country FROM Customers;
SELECT Country, CustomerName FROM Customers;

-- 문제 1) Employees 테이블에서 
-- BirthDate, FirstName, LastName 을 조회
SELECT BirthDate, FirstName, LastName FROM Employees;
SELECT birthDate, firstName, lastname FROM Employees;