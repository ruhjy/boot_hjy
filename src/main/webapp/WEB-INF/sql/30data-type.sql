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
-- DATE 날짜 (YYYY-MM-DD)
-- DATETIME 날짜시간 (YYYY-MM-DD hh:mm:ss)
create table MyTable08 (
	Col1 date,
    Col2 datetime
);
desc MyTable08;
insert into MyTable08(Col1) values ('2023-04-19');
insert into MyTable08(Col1) values ('9999-12-31'); -- 최대
insert into MyTable08(Col1) values ('1000-01-01'); -- 최소

select * from MyTable08;

insert into MyTable08(Col2) values ('2023-04-19 11:41:50');
insert into MyTable08(Col2) values ('2023-04-19 23:42:10');
insert into MyTable08(Col2) values ('9999-12-31 23:59:59'); -- 최대
insert into MyTable08(Col2) values ('1000-01-01 00:00:00'); -- 최소

select now(); -- 현재 datetime

insert into MyTable08(Col1, Col2) values (now(), now());

select * from MyTable08;

-- 예제) MyTable09 (학생 정보)
-- 학생이름, 성별, 생년월일, 기타정보, 시험성적 ...
create table MyTable09 (
	Name varchar(20),
    Gender varchar(1),
    BirthDate date,
    Score dec(5, 2),
    Extra varchar(1000)
);
desc MyTable09;
insert into MyTable09(Name, Gender, BirthDate, Score, Extra)
values
	('손흥민', '남', '2000-02-02', 99.99, '축구선수'),
    ('김연아', '여', '2002-02-02', 100, '피겨선수');
select * from MyTable09;

-- 연습) 내가 가지고 있는 교재정보 저장 MyTable10
create table MyTable10 (
	BookName varchar(255),
    Author varchar(100),
    Price int,
    Quantity int,
    PublicationDate date
);
insert into MyTable10(BookName, Author, Price, Quantity, PublicationDate)
values
	('코드로 배우는 스프링 웹 프로젝트(개정판)', '구멍가게 코딩단', 38000, 1, '2018-09-13'); 

select * from MyTable10;

-- 연습) 내가 가지고 있는 교재정보 저장 MyTable11
-- 책제목, 저자, 출판사, 출판일, 가격, 기타
create table MyTable11 (
	Title varchar(100),
    Writer varchar(20),
    Publisher varchar(50),
    Published date,
    Price int,
    Extra varchar(1000)
);
desc MyTable11;
insert into MyTable11(Title, Writer, Publisher, Published, Price, Extra)
values
	('이것이 자바다', '신용권', '한빛', '2022-01-01', 30000, '평점 좋음');
select Title, Writer, Publisher as '출판사', Published as '출판일', Price, Extra from MyTable11;

update MyTable11 set
Price = 35000
where Title = '이것이 자바다';