use w3schools;

select lastName, firstName from Employees;

-- FROM절에서 서브쿼리를 사용할때는 별칭이 있어야 한다.
select lastname, firstName 
from (select lastName, firstName from Employees) as emp
where lastName >= 'd' and lastName < 'e';

-- 고객별 소비금액
select AVG(구매금액) 
from (
	select c.CustomerID,
		   c.CustomerName,
		   SUM(p.Price * od.Quantity) as '구매금액'
	from Orders o 
		join OrderDetails od on o.OrderID = od.OrderID
		join Customers c on o.CustomerID = c.CustomerID
		join Products p on od.ProductID = p.ProductID
	group by c.CustomerID
	order by 구매금액 desc) t1;
    
-- (직원별 매출액)의 평균
select AVG(매출) as '평균매출' 
from (
	select e.EmployeeID,
		   SUM(od.Quantity * p.price) '매출' 
	from Orders o
		join Employees e on o.EmployeeID = e.EmployeeID
		join OrderDetails od on o.OrderID = od.OrderID
		join Products p on od.ProductID = p.ProductID
	group by e.EmployeeID) t1;

-- 카테고리별 평균 상품가격 (평균 상품가격이 100.00 달러 이상인 것만)
select CategoryID, AVG(Price) as average
from Products
group by CategoryID
having average >= 30.00;

select CategoryID, average 
from (
	select CategoryID, AVG(Price) as average
	from Products
	group by CategoryID) t1
where average >= 30.00;

--
SELECT T1.CategoryID, c.CategoryName, T1.average
FROM
(SELECT CategoryID, AVG(Price) average
FROM Products
GROUP BY CategoryID) T1 JOIN Categories c ON T1.CategoryId = c.CategoryId
WHERE average >= 30.00;
