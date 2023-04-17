use w3schools;
-- order by : 결과의 순서를 정할 때 사용

select CustomerID, CustomerName, ContactName -- column 명들
from Customers 					 -- table
where CustomerID < 10 			 -- 선택할 records의 조건
order by ContactName asc;

select CustomerID, CustomerName, ContactName -- column 명들
from Customers 					 -- table
where CustomerID < 10 			 -- 선택할 records의 조건
order by ContactName desc;

select * from Customers order by CustomerName desc;
select * from Customers order by Country asc;
select * from Customers order by Country; -- asc 생략가능(기본값)

-- 모든 상품을 가격순으로 조회 (낮은 가격이 먼저 조회)
select * from Products order by Price asc;

-- 모든 직원을 생년월일순 조회 (어린 직원이 먼저 조회)
select * from Employees order by BirthDate desc;

-- 컬럼 index 사용 가능
select * from Products order by Price; -- 컬럼 name 사용
select * from Products order by 6; -- 컬럼 index 사용

select * from Products order by 6 desc;

-- 컬럼 index 사용해서 모든 고객을 도시 이름 순 정렬 조회
select * from Customers order by 5;

select CustomerID, CustomerName, City
from Customers order by 3; -- 컬렘 index 사용시 select 절에 맞게 사용할 것.
select CustomerID, CustomerName, City
from Customers order by City;

-- 여러컬럼 기준 정렬 가능
select * from Customers order by Country, City;
select * from Customers order by 7, 5;
select CustomerID, CustomerName, Country, City
from Customers order by Country, City;
select CustomerID, CustomerName, Country, City
from Customers order by 4, 3;

-- 여러 컬럼 기준으로 정렬시 컬럼당 오름차순, 내림차순 지정 가능 -- asc 키워드는 생략 가능
select * from Customers order by Country asc, city desc;
select * from Customers order by Country desc, city asc;
select * from Customers order by Country desc, city desc;

-- 상품을 카테고리(오름차순) 가격(내림차순)으로 정렬 조회
select * from Products order by CategoryID asc, Price desc;
