create table MyTable30 (
	Col1 int,
    Col2 varchar(20)
);

insert into MyTable30 (Col1, Col2) values (30, 'java'); -- ok
insert into MyTable30 (Col1) values ('33'); -- ok
insert into MyTable30 (Col1) values ('Three'); -- xxx
insert into MyTable30 (Col2) values (77); -- ok

select * from MyTable30;

--
create table MyTable31 (
	Col1 date,
    Col2 datetime
);
-- DATE : YYYY-MM-DD
-- DATETIME : YYYY-MM-DD HH:mm:SS
insert into MyTable31 (Col1, Col2) values ('2023-04-20','2023-04-20 09:01:01');
select * from MyTable31;

create table MyTable32 (
	Name varchar(30),
    Age int,
    Price dec(10, 2),
    Birth date,
    inserted datetime
);
desc MyTable32;
select * from MyTable32;

create table MyTable33 (
	Title varchar(300),
    Published date,
    Price int,
    Updated datetime,
    Weight dec(10, 3)
);
select * from MyTable33;

insert into MyTable33 values ('이것이자바다', '2001-01-01', 30000, '2022-01-01 14:20:01', 3.14);
