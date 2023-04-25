create database leetcode183;
use leetcode183;

create table Customers (
	id int primary key,
    name varchar(100)
);
insert into Customers
values 
	(1, 'Joe'),
    (2, 'Henry'),
    (3, 'Sam'),
    (4, 'Max');
select * from Customers;

create table Orders (
	id int primary key,
    customerId int,
    foreign key (customerId) references Customers(id)
);
insert into Orders
values
	(1, 3),
    (2, 1);
select * from Orders;

-- 문제 ) 한번도 주문하지 않은 고객 조회
select c.name as Customers
from Customers c
	left join Orders o on c.id = o.customerId
where o.customerId is null;

-- 서브쿼리로 풀어보기
select * from Customers;
select * from Orders;

select customerId from Orders;
select * from Customers where id not in (1, 3);
select name from Customers
where id not in (
	select customerId from Orders
);

-- w3schools 데이터베이스에서 
-- 서브쿼리 사용해서 주문한적 없는 고객들 조회
use w3schools;
select * from Customers;
select * from Orders;
select CustomerName from Customers
where CustomerID not in (
	select CustomerID from Orders
);