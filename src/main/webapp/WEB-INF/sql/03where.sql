-- WHERE : 특정 레코드를 선택하는 조건절
SELECT * FROM Customers
WHERE Country = 'Mexico';
SELECT * FROM Customers
WHERE Country = 'UK';
SELECT * FROM Customers
WHERE Country = 'France'; -- 문자열 필드값은 작은 따옴표
SELECT * FROM Customers
WHERE CustomerID = 3; -- 수 필드값은 따옴표 생략 가능
SELECT * FROM Customers
WHERE CustomerID = '3';
SELECT * FROM Customers
WHERE Country = 'france'; -- 대소문자 구분 안함
SELECT CustomerName FROM Customers
WHERE Country = 'France';

-- Country 가 USA 인  
-- 공급자이름(SupplierName) 과 주소(Address)를
-- 공급자(Suppliers) 테이블에서 조회
SELECT SupplierName, Address
FROM Suppliers
WHERE Country = 'USA';
