-- IFNULL : null이면 다른 값으로 변경
select IFNULL(0, 100); -- 0
select IFNULL('kim', 'lee'); -- kim
select IFNULL(null, 100); -- 100
select IFNULL(null, 'park'); -- park

select ProductID, ProductName, SupplierID, CategoryID, Unit, Price from Products order by 1 desc;
select ProductID, ProductName, SupplierID, CategoryID, Unit, 
IFNULL(Price, 0) as Price from Products order by 1 desc;

select SUM(Price) as Sum from Products where CategoryID = 2; -- 276.75
select AVG(IFNULL(Price, 0)) as Average from Products where CategoryID = 2; -- 276.75 / 14
select AVG(Price) as Average from Products where CategoryID = 2; -- 276.75 / 12

select COUNT(Price) from Products; -- 77
select COUNT(IFNULL(Price, 0)) from Products; -- 79

select * from Customers order by 1 desc;
-- 문제1) 고객테이블에서 CustomerID, CustomerName, ContactName, Address 조회
-- ContactName이 NULL 이면 'Anonymous'로 Address가 NULL 이면 'Homeless'로 조회
select 
	CustomerID, 
	CustomerName, 
	IFNULL(ContactName, 'Anonymous') as ContactName, 
	IFNULL(Address, 'Homeless') as Address
from Customers order by 1 desc;
