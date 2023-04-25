-- 서브쿼리 (쿼리 안의 쿼리) 책 430쪽
-- 1) SELECT 문이다.
-- 2) 괄호 안에 있다.
-- 3) 세미콜론이 없다.

-- 작성 가능 한 위치
-- WHERE, SELECT, FROM, HAVING

use w3schools;
select * from Products;

select CategoryID from Products where ProductID = 1;
select CategoryName from Categories where CategoryID = 1;

-- 서브쿼리
select CategoryName from Categories 
where CategoryID = (
	select CategoryID from Products where ProductID = 1
);

-- 2번 공급자와 같은 나라에 사는 고객 조회
select Country from Suppliers where SupplierID = 2; -- USA
select CustomerName from Customers where Country = 'USA';

-- 서브쿼리
select CustomerName from Customers 
where Country = (
	select Country from Suppliers where SupplierID = 2
);

-- 문제) 평균가격보다 높은 가격의 상품들 조회
select * from Products;
select AVG(price) from Products;

select * from Products
where price > (
	select AVG(price) from Products
);