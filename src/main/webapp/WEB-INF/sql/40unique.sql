-- UNIQUE : 중복 허용 안함
create table MyTable22 (
	Col1 int,
    Col2 int unique
);
insert into MyTable22 (Col1, Col2) values (10, 20); -- ok
insert into MyTable22 (Col1, Col2) values (20, 30); -- ok
insert into MyTable22 (Col1, Col2) values (30, 40); -- ok
insert into MyTable22 (Col1, Col2) values (30, 50); -- ok
insert into MyTable22 (Col1, Col2) values (40, 40); -- xxx, Col2 40이 존재함.
desc MyTable22;
select * from MyTable22;

-- 예제
create table MyTable23 (
	ssn varchar(13) unique, -- 중복되지 않는 값을 가짐. -> key 
    name varchar(20)
);

desc MyTable23;
select * from MyTable23;
insert into MyTable23 (ssn, name) values (null, null);
insert into MyTable23 (ssn, name) values ('1', '정대만'); -- ok
insert into MyTable23 (ssn, name) values ('1', '송태섭'); -- xxx
insert into MyTable23 (ssn, name) values (null, '채소연'); -- ok
insert into MyTable23 (ssn, name) values (null, '강백호'); -- ok

create table MyTable24 (
	Col1 varchar(20) not null unique default ''
);
desc MyTable24;