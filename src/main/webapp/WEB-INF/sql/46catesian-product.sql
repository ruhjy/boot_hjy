-- CATESIAN PRODUCT (곱집합) 카테시안 곱
select count(*) from Products; -- 77
select count(*) from Categories; -- 8

select count(*) from Products join Categories; -- 77 * 8 = 616
select * from Products join Categories;

-- ON : 조인 조건
select * from Products join Categories on Products.CategoryID = Categories.CategoryID;

-- 조인 후 컬럼 수 : 왼쪽 테이블 컬럼 수 + 오른쪽 테이블 컬럼 수
desc Products; -- 6개 컬럼
desc Categories; -- 3개 컬럼
select * from Products join Categories 
on Products.CategoryID = Categories.CategoryID; -- 9개 컬럼

select ProductName, CategoryName from Products join Categories
on Products.CategoryID = Categories.CategoryID;

-- 
select * from Products;
select * from Suppliers;
-- 상품명, 그 상품을 공급하는 공급자명
select ProductName, SupplierName from Products join Suppliers 
on Products.SupplierID = Suppliers.SupplierID
order by 1; -- 1 === ProductName, 2 === SupplierName

-- ALIAS(별칭) 사용으로 코드 줄이기
select CustomerName as Name from Customers;

-- as 생략 가능
select ProductName, SupplierName from Products as p join Suppliers as s
on p.SupplierID = s.SupplierID;
select ProductName, SupplierName from Products p join Suppliers s
on p.SupplierID = s.SupplierID;

select p.SupplierID, s.SupplierID from Products p join Suppliers s
on p.SupplierID = s.SupplierID;