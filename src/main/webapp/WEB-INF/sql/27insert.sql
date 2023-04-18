select * from Employees order by 1 desc;

insert into Employees (EmployeeID, LastName, FirstName)
values (11, '박지성', '두개의심장');

-- EmployeeID는 auto_increment 자동 증가 값이여서 입력 안해주어도 됨. 
insert into Employees (LastName, FirstName)
values ('차범근', '차붐');

-- 테이블 정보 보기
desc Employees;

-- Customers 테이블의 자동 증가 컬럼을 찾기
desc Customers;

insert into Customers (CustomerName, ContactName)
values ('정대만', 'daeman');

select * from Customers order by 1 desc;

select * from Suppliers;
-- 문제1) 새 공급자 데이터 추가(SupplierID, SupplierName, City)
-- 자동증가 컬럼은 직접 값을 넣지 않고 추가
desc Suppliers;
insert into Suppliers (SupplierName, City)
values ('heo', 'seoul');