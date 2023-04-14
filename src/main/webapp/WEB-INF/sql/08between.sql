select * from Customers where CustomerID >= 10 and CustomerID <= 19;

-- BETWEEN
select * from Customers where CustomerID between 10 and 19; -- 지정된 값 포함

 -- 직원 전체 조회
select * from Employees;
-- 50년대생 직원들 조회
select * from Employees where BirthDate between '1950-01-01' and '1959-12-31';
-- 50년대생이 아닌 직원들 조회
select * from Employees where not (BirthDate between '1950-01-01' and '1959-12-31');

-- 상품 전체 조회
select * from Products;
-- 가격이 10달러대 (10.00 ~ 19.99) 상품들 조회
select * from Products where price between 10.00 and 19.99;
select * from Products where price >= 10.00 and price < 20.00;