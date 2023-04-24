select count(*) from Products; -- 77 rows
select count(*) from Categories; -- 8 rows
select count(*) from Suppliers; -- 29 rows
desc Products; -- 6개 열
desc Categories; -- 3개 열
desc Suppliers; -- 8개 열

select count(*) from Products join Categories join Suppliers; -- 17,864 rows

select * from
Products p join Categories c on p.CategoryID = c.CategoryID
		   join Suppliers s on p.SupplierID = s.SupplierID; -- 77개 행          
           
-- 예) 1번 상품의 상품명, 카테고리명, 공급자명
select p.ProductName, c.CategoryName, s.SupplierName
from Products p join Categories c on p.CategoryID = c.CategoryID
			    join Suppliers s on p.SupplierID = s.SupplierID
where p.ProductID = 1;

-- 예제) 1996-07-04에 주문한 상품명 조회
select * from Orders;
select * from OrderDetails;
select * from Products;

select p.ProductName from Orders o 
	join OrderDetails od on o.OrderID = od.OrderID
	join Products p on od.ProductID = p.ProductID
where o.OrderDate = '1996-07-04';

-- '1996-07-04'의 매출 조회
select SUM(od.Quantity * p.price) as '매출' from Orders o
	join OrderDetails od on o.OrderID = od.OrderID
	join Products p on od.ProductID = p.ProductID
where o.OrderDate = '1996-07-04';

select od.Quantity, p.price from Orders o
	join OrderDetails od on o.OrderID = od.OrderID
	join Products p on od.ProductID = p.ProductID
where o.OrderDate = '1996-07-04';

-- 일별 매출 조회 (날짜 순으로 결과 조회)
select o.OrderDate, 
	   SUM(od.Quantity * p.Price) as '일별 매출' 
from Orders o
	join OrderDetails od on o.OrderID = od.OrderID
    join Products p on od.ProductID = p.ProductID
group by o.OrderDate
order by o.OrderDate;

-- 직원별 처리금액
select * from Orders;
select * from Employees;
select * from OrderDetails;
select * from Products;

select e.EmployeeID,
	   e.LastName,
       e.FirstName,
	   SUM(od.Quantity * p.price) '매출' 
from Orders o
	join Employees e on o.EmployeeID = e.EmployeeID
    join OrderDetails od on o.OrderID = od.OrderID
    join Products p on od.ProductID = p.ProductID
group by e.EmployeeID;
--
select e.EmployeeID,
	   e.LastName,
       e.FirstName,
	   SUM(od.Quantity * p.price) '매출' 
from Orders o
	join Employees e on o.EmployeeID = e.EmployeeID
    join OrderDetails od on o.OrderID = od.OrderID
    join Products p on od.ProductID = p.ProductID
where o.OrderDate between '1997-01-01' and '1997-01-31'
group by e.EmployeeID
order by 매출 desc;

-- 상품별 판매금액
select p.ProductID, 
	   p.ProductName, 
       SUM(od.Quantity * p.Price) as '판매금액' 
from Orders o
	join OrderDetails od on o.OrderID = od.OrderID
    join Products p on od.ProductID = p.ProductID
group by p.ProductID
order by 판매금액 desc;

-- 고객별 소비금액
select c.CustomerID,
	   c.CustomerName,
       SUM(p.Price * od.Quantity) as '구매금액'
from Orders o 
	join OrderDetails od on o.OrderID = od.OrderID
	join Customers c on o.CustomerID = c.CustomerID
	join Products p on od.ProductID = p.ProductID
group by c.CustomerID
order by 구매금액 desc;
