-- Character(String) 문자형
-- VARCHAR(길이)

create table MyTable02 (
	Col1 varchar(3),
    Col2 varchar(5)
);
select * from MyTable02;

insert into MyTable02(Col1, Col2) values ('abc', 'abcde'); -- ok
insert into MyTable02(Col1, Col2) values ('ab', 'abcd'); -- ok
insert into MyTable02(Col1, Col2) values ('abcd', 'abcdef'); -- xxx

-- 연습)
-- MyTable03
-- 3개의 컬럼
-- 첫번째 컬럼 type : 문자열 10개까지 저장가능
-- 두번째 컬럼 type : 문자열 100개까지 저장가능
-- 세번째 컬럼 type : 문자열 1000개까지 저장가능
create table MyTable03 (
	Col1 varchar(10),
    Col2 varchar(100),
    Col3 varchar(1000)
);

select * from MyTable03;

-- Numeric (수)
-- int 정수형
-- decimal, dec 실수형
create table MyTable04 (
	Col1 int
);
desc MyTable04;
insert into MyTable04(Col1) values (33); -- ok
insert into MyTable04(Col1) values (123456789); -- ok
insert into MyTable04(Col1) values (1234567891); -- ok
insert into MyTable04(Col1) values (999999999); -- ok
insert into MyTable04(Col1) values (3.14); -- 소수점 이하 생략 후 3 이 저장됨.
select * from MyTable04;

-- 연습) MyTable05 만들기
-- 두개의 컬럼이 모두 정수 저장 가능
create table MyTable05 (
	Col1 INT,
    Col2 INTEGER
);
desc MyTable05;
select * from MyTable05;
insert into MyTable05(Col1, Col2) values (2147483647, -2147483648); -- ok
insert into MyTable05(Col1, Col2) values (2147483648, -2147483648); -- xxx

-- DEC 실수형
-- DEC(총길이, 소수점이하길이)
create table MyTable06 (
	Col1 dec(5, 2),
    Col2 dec(3, 1)
);
desc MyTable06;
insert into MyTable06(Col1) values (999.99); -- ok
insert into MyTable06(Col1) values (-999.99); -- ok
insert into MyTable06(Col1) values (1000.99); -- xxx
insert into MyTable06(Col1) values (999.999); -- xxx
select * from MyTable06;

-- 연습) MyTable07 만들기
-- 두개 컬럼 (실수형), 총길이 소수점이하길이 직접 작성
create table MyTable07 (
	Col1 dec(10, 2),
    Col2 dec(5, 4)
);
insert into MyTable07(Col1, Col2) values (123456.12, 1.2345);
insert into MyTable07(Col1, Col2) values (12345678.12, 1.2345);
desc MyTable07;
select * from MyTable07;

-- 날짜시간