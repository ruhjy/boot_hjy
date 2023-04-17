-- operator(연산자) +, -, *, /, %
select * from Products;
select ProductName, Price * 1300 from Products;
select ProductName, Price * 1300 as wonPrice from Products;

select ProductName, Price / 100 from Products;
select ProductName, Price + 100 from Products;
select ProductName, Price - 100 from Products;

-- 문자열 연결
select City + Country from Customers; -- xx
select concat(City, Country) from Customers; -- ok
select concat(City, ",", Country) from Customers; -- ok
select concat(City, " ", Country) from Customers; -- ok
select concat(City, " ", Country) as CityOfCountry from Customers; -- ok

-- 직원이름 "firstName, LastName" 형식으로 조회
select * from Employees;
select concat(FirstName, ", ", LastName) as FullName from Employees;

-- 원화(* 1300)로 10만원 이상인 상품들 조회
select * from Products;
select * from Products where Price * 1300 >= 100000;
select * from Products where Price >= 100000 / 1300;

select ProductID, ProductName, SupplierID, CategoryID, Unit, 
Price as dollor, Price * 1300 as won 
from Products where Price >= 100000 / 1300;

select *, Price * 1300 as won from Products where Price >= 100000 / 1300;
