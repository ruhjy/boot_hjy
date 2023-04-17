-- null : 값이 없음
-- null vs '' : 데이터베이스 마다 다름 (mysql은 다름)

-- is null : 값이 null 인가?
select * from Suppliers where ContactName = ''; -- 0개 조회
select * from Suppliers where ContactName is null; -- 1개 조회

-- is not null : 값이 null 아닌 컬럼 조회
select * from Suppliers where not ContactName is null order by 1 desc;
select * from Suppliers where ContactName is not null order by 1 desc;

-- Customers 테이블에서 Address 컬럼이 null인 레코드 조회
select * from Customers where Address is null;

-- Customers 테이블에서 Address 컬럼이 null이 아닌 레코드 조회
select * from Customers where Address is not null order by 1 desc;

-- 집계함수에서 null은 제외
select COUNT(CustomerID) from Customers; -- 94
select COUNT(Address) from Customers; -- 93 
select COUNT(*) from Customers; -- 94 모든 레코드의 개수 조회

-- 공급자 테이블에서 SupplierID 컬럼의 값 수 구하기
select COUNT(SupplierID) from Suppliers; -- 31
-- 공급자 테이블에서 ContactName 컬럼의 값 수 구하기
select COUNT(ContactName) from Suppliers; -- 30
-- 모든 레코드의 수 구하기
select COUNT(*) from Suppliers;

select * from Products order by 1 desc;
insert into Products
values
	(78, 'Cake', 12, 2, '조각', null);

insert into Products
(ProductID, ProductName, SupplierID, CategoryID, Unit)
values
	(79, 'Pizza', 12, 2, '조각');
    
select * from Products where CategoryID = 2 order by 1 desc; -- 14
select SUM(Price) from Products where CategoryID = 2; -- 276.75

select AVG(Price) from Products where CategoryID = 2; -- null을 제외하고 그 개수만큼 평균을 구함. 276.75 / 12