-- PRIMARY KEY : NOT NULL + UNIQUE
create table MyTable25 (
	Col1 int primary key -- NOT NULL + UNIQUE
);

desc MyTable25;
desc MyTable24;

create table MyTable26 (
	Col1 int,
    primary key (Col1)
);
desc MyTable26;

create table MyTable27 (
	Col1 int,
    Col2 int,
    primary key (Col1, Col2) -- 두 컬럼을 조합한 primary key
);
desc MyTable27;
insert into MyTable27 (Col1, Col2) values (1, 1); -- ok
insert into MyTable27 (Col1, Col2) values (2, 2); -- ok
insert into MyTable27 (Col1, Col2) values (1, 2); -- ok
insert into MyTable27 (Col1, Col2) values (2, 2); -- xxx, 두 컬럼의 조합이 유일
select * from MyTable27; 

-- Primary Key : 하나의 테이블에 하나
create table MyTable28 (
	Col1 int,
    Col2 int,
    primary key(Col1),
    primary key(Col2)
); -- xxx

-- 제약사항 (CONSTRAINTS)
-- DEFAULT, UNIQUE, NOT NULL, PRIMARY KEY