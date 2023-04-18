-- update : 레코드 수정

select * from Customers where CustomerID = 1;
update Customers 			-- 테이블 명
set CustomerName = '서태웅'   -- 변경할 컬럼과 값
where CustomerID = 1;		-- 변경할 레코드의 조건

update Customers 
set 						-- 변경할 컬럼과 값 (,)
	CustomerName = '정대만',
    City = 'Seoul',
    Country = 'Korea'
where CustomerID = 1;

select * from Suppliers;
-- 문제1) 1번 공급자의 이름, 도시, 나라 변경
select * from Suppliers where SupplierID = 1;
update Suppliers
set
	SupplierName = '강백호',
	City = 'Seoul',
    Country = 'Korea'
where SupplierID = 1;

--
select * from Suppliers where Country = 'France';
update Suppliers
set 
	SupplierName = '채치수',
	Country = 'France'
where Country = 'USA';

--
select * from Suppliers;
update Suppliers
set
	ContactName = '북산',
    City = 'Seoul';

--
select * from Suppliers where Country = 'Japan';
update Suppliers
set
	PostalCode = concat('J', PostalCode)
where Country = 'Japan';

--
select * from Products;
insert into Products
values
	(1, 'cake', null, null, null, 300),
    (2, 'pizza', null, null, null, 100);
    
update Products set Price = Price * 1300; -- 현재 가격에 1300 곱한 값으로 데이터 수정(업데이트)