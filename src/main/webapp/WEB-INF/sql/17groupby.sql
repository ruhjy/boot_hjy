-- group by : 집계함수를 그룹별로 리턴할 때 사용

select SUM(Price) from Products;
select CategoryID, SUM(Price) from Products group by CategoryID; -- 카테고리id 별 상품값 합계
select Country, COUNT(CustomerID) from Customers group by Country; -- 나라별 고객 수

-- 나라별 고객 수를 나라이름 역순으로 조회
select Country, COUNT(CustomerID) from Customers group by Country order by Country desc;
select Country, COUNT(CustomerID) from Customers group by Country order by 2 desc;

-- 고객이 가장 많은 나라 조회
select Country, COUNT(CustomerID) from Customers group by Country order by 2 desc limit 0, 1;

-- 카테고리별 상품 가격의 평균 조회
select CategoryID, AVG(Price) from Products group by CategoryID;
-- 카테고리별 가장 비싼 상품의 가격 조회
select CategoryID, MAX(Price) from Products group by CategoryID;
-- 카테고리별 가장 싼 상품의 가격 조회
select CategoryID, MIN(Price) from Products group by CategoryID;
-- 상품 가격의 평균이 가장 높은 카테고리 조회
select CategoryID, AVG(Price) from Products group by CategoryID order by AVG(Price) desc limit 0, 1;

-- 여러 컬럼으로 그룹
select * from Customers;
select COUNT(CustomerID) from Customers;
select Country, COUNT(CustomerID) from Customers group by Country;
select Country, City, COUNT(CustomerID) from Customers group by Country, City;

-- 나라별, 도시별 공급자 수 조회
select * from Suppliers;
select Country, City, COUNT(SupplierID) from Suppliers group by Country, City;