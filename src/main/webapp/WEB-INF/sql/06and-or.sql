use w3schools;

select * from Products;
select * from Employees;
-- AND
SELECT * FROM Customers
WHERE CustomerID > 4 AND Country = 'Germany';

SELECT * FROM Employees
WHERE LastName >= 'M' AND BirthDate >= '1960-01-01';

-- 카테고리 ID가 2이고 가격이 20.00 이상인 상품들 조회
SELECT * FROM Products
WHERE CategoryID = 2 AND Price >= 20;

-- 1950-01-01 ~ 1959-12-31 사이에 태어난 직원들
SELECT * FROM Employees
WHERE BirthDate >= '1950-01-01' AND BirthDate <= '1959-12-31';

select * from Employees where BirthDate like '195%';

-- OR
select * from Customers
where Country = 'Germany';

select * from Customers
where Country = 'France';

select * from Customers
where Country = 'Germany' or Country = 'France';

select * from Customers;
-- 도시가 London 또는 Madrid 에 있는 고객들 조회
select * from Customers
where City = 'London' or City = 'Madrid';

select * from Products
where CategoryID = 1 or CategoryID = 2;