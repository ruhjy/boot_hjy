use w3schools;
select Country from Suppliers;
select distinct Country from Suppliers;
select * from Customers
where Country in (
	select distinct Country from Suppliers
);

-- '1996-07-04' 에 주문한 상품명 조회
select * from Orders;
select * from OrderDetails;
select * from Products;

select OrderID from Orders where OrderDate = '1996-07-04';
select ProductID from OrderDetails where OrderID in (10248);
select ProductName from Products where ProductID in (11, 42, 72);

select ProductName
from Products where ProductID in (
	select ProductID from OrderDetails where OrderID in (
		select OrderID from Orders where OrderDate = '1996-07-04'
	)
);