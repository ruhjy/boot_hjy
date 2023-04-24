use w3schools;

-- 어제
select CustomerName, ContactName from Customers where CustomerID = 3;

-- 오늘
select CustomerName from Customers;
select lastname from Employees;
desc Employees;
select * from Products;
select * from Customers;

select ProductName from Products where CategoryID = 1;

-- Around the Horn
-- B's Beverages
-- Consolidated Holdings
-- Eastern Connection
-- Island Trading
-- North/South
-- Seven Seas Imports
insert into Customers (CustomerName, Country)
values 
	('박지성', 'Korea'),
	('손흥민', 'Korea'),
	('강백호', 'Korea'),
	('채치수', 'Korea'),
	('정대만', 'Korea');

create table MyTable34 (
	Col1 int,
    Col2 varchar(30)
);

insert into MyTable34  values (99, 'hello');
select * from MyTable34;

create table MyTable35 (
	Col1 dec(7, 2),
    Col2 varchar(50)
);
desc MyTable35;
select * from MyTable35;

alter table MyTable35 change column Col1 Col1 dec(5,1);

create table MyTable36 (
	Col1 int,
    Col2 varchar(50),
    Col3 dec(10, 2));
select * from MyTable36;
insert into MyTable36 (Col1, Col2, Col3) values (22, 'hello', 3.14);

create table MyTable37 (
	Age int,
    name varchar(20),
    score dec(5, 2));
select * from MyTable37;

create table MyTable38 (
	Col1 int,
	Col2 int,
	Col3 varchar(200),
	Col4 varchar(200),
	Col5 dec(10, 3),
	Col6 dec(10, 3));
select * from MyTable38;

create table MyTable39 (
	Col1 int primary key auto_increment,
    Col2 varchar(300),
    Col3 int);
desc MyTable39;
insert into MyTable39 (Col2, Col3) values ('hello', 99);
select * from MyTable39;

create table MyTable40 (
	id int primary key auto_increment,
    age int,
    name varchar(50),
    score dec(10, 2));
select * from MyTable40;

select * from Customers where CustomerID between 1 and 10;

update MyTable39 set Col2 = '수정된 값', Col3 = 99999;

select * from Customers;

select CustomerID as id, CustomerName as name, ContactName, Address, City, PostalCode, Country 
from Customers where CustomerID = 9;

select * from Employees;
desc Employees;

select * from Customers;
select * from Products join Suppliers on Suppliers.SupplierID = Products.ProductID;
select * from Suppliers;
