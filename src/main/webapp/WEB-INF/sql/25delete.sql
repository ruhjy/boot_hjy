-- DELETE : 테이블의 record 지우기
-- 매우 주의!!!!! 5번 고민 후 실행!!!!!
select * from Products;
select * from Customers;
delete 
from Customers -- 지울 테이블 명
where CustomerID = 94; -- 지울 레코드의 조건

-- 지우기 전에 같은 테이블 같은 조건으로 select 하기!!!
select * from Customers where CustomerID = 94; -- 지우기 전에 같은 테이블명, 레코드명을 조회(select) 후 할 것!

-- 93번 고객 지우기
select * from Customers where CustomerID = 93;
delete from Customers where CustomerID = 93;
-- 78번 상품 지우기
select * from Products where ProductID = 78;
delete from Products where ProductID = 78;
-- 79번 상품 지우기
select * from Products where ProductID = 79;
delete from Products where ProductID = 79;

select * from Products where CategoryID = 1;

delete from Products where CategoryID = 1;

select * from Products;
delete from Products;

select * from Customers;
-- 문제1) 고객테이블에서 USA에 사는 고객들 지우기
select * from Customers where Country = 'USA';
delete from Customers where Country = 'USA';
-- 문제2) 모든 직원 지우기
select * from Employees;
delete from Employees;