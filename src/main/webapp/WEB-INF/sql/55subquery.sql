use w3schools;
select * from Products;

select ProductName, CategoryID from Products;

select ProductName, (
	select CategoryName from Categories 
    where CategoryID = p.CategoryID
	) as CategoryName 
from Products p;

-- 상품명, 상품을 공급하는 공급자명 서브쿼리를 사용하여 조회
select * from Products;
select * from Suppliers;

-- 서브쿼리
select ProductName, (
	select SupplierName from Suppliers where SupplierID = p.SupplierID
    ) as SupplierName
from Products p;

-- 조인
select p.ProductName, s.SupplierName
from Products p
	join Suppliers s on p.SupplierID = s.SupplierID;
