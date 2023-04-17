-- MIN, MAX

select MIN(CustomerID) from Customers;
select MAX(CustomerID) from Customers;
select MAX(Price) from Products;
select MIN(Price) from Products;

-- 가장 나이 많은 직원의 생년월일
select MIN(BirthDate) from Employees;
-- 가장 어린 직원의 생년월일
select MAX(BirthDate) from Employees;

-- 3번 카테고리에 가장 비싼 상품의 가격
select MAX(Price) from Products where CategoryID = 3;
-- 5번 카테고리에 가장 싼 상품의 가격
select MIN(Price) from Products where CategoryID = 5;