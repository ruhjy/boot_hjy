-- INSERT : 테이블에 새 레코드 입력
select * from Customers;
insert into Customers
(CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country)
values
	(92, '박지성', '두개의 심장', 'London', 'Seoul', '1234567', 'Korea');

select * from Customers order by CustomerID desc;

-- 모든 컬럼에 값을 넣을 때 컬럼명 생략 가능
insert into Customers
values
	(93, '차범근', '차붐', '프랑크푸르트', 'Seoul', '1234123', 'Korea');
    
-- 특정 컬럼에만 값을 넣을 때 컬럼명 작성해야함
insert into Customers
(CustomerID, CustomerName, City, Country)
values
	(94, '송태섭', 'Tokyo', 'Japan');
    
select * from Suppliers order by 1 desc;
-- 문제1) Supplier 테이블에 30번째 공급자 추가(모든 열)
insert into Suppliers
values
	(30, '강백호', 'kang baek ho', 'Tokyo', 'Seoul', '987654', 'Japan', '010-1234-5678');

-- 문제2) Supplier 테이블에 31번째 공급자 추가
-- SupplierID, SupplierName, City, Country
insert into Suppliers
(SupplierID, SupplierName, City, Country)
values 
	(31, '채치수', 'Seoul', 'Korea');