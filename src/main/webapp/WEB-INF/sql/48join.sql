desc Orders;
select * from Orders;
select * from Customers;

select * from Orders o join Customers c
on o.CustomerID = c.CustomerID; -- 830 rows
select * from Orders o right join Customers c
on o.CustomerID = c.CustomerID; -- 832 rows

select * from Orders o right join Customers c
on o.CustomerID = c.CustomerID where o.OrderID is null; -- 주문한 적 없는 고객 2 rows

-- 예) 주문을 처리한 적 없는 직원 조회
desc Orders;
select e.LastName, e.FirstName from Orders o right join Employees e
on o.EmployeeID = e.EmployeeID where o.OrderID is null;
