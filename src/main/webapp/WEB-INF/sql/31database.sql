-- DATABASE(Schema) : 테이블이 있는 곳

-- CREATE DATABASE : database 만들기
create database mydb;
use mydb;
create table MyTable12 (
	Title varchar(10),
    Price int
);
desc MyTable12;
select * from MyTable12;

-- DROP DATEBASE databasename; -> 데이터베이스 지우기
-- 주의*10000000000 복구 불가
drop database mydb;

use w3schools;

-- mydb1 데이터베이스 만들기
create database mydb1;
-- mydb1 에 새로운 테이블 만들기
use mydb1;
create table MyTable00 (
	Name varchar(255),
    Price int
);
select * from MyTable00;
-- mydb1 데이터베이스 삭제하기
drop table MyTable00;
drop database mydb1;
-- w3schools 데이터베이스 사용하기
use w3schools;

--
select * from w3schools.MyTable11;
select Title, Price from w3schools.MyTable11;

use test;
select * from MyTable10; -- 현재 데이터베이스 테이블 조회
select * from w3schools.MyTable10; -- 다른 데이터베이스의 테이블 조회