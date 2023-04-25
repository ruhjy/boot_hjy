create database leetcode175;
use leetcode175;

create table Person (
	personId int primary key,
    lastName varchar(200),
    firstName varchar(200)
);

insert into Person (personId, lastName, firstName)
values 
	(1, 'Wang', 'Allen'),
    (2, 'Alice', 'Bob');
    
select * from Person;

create table Address (
	addressId int primary key,
    personId int,
    city varchar(200),
    state varchar(200)
);

insert into Address (addressId, personId, city, state)
values
	(1, 2, 'New York City', 'New York'),
	(2, 3, 'Leetcode', 'California');
    
select * from Address;

-- 문제) 각 인물의 firstName, lastName, city, state 를 조회
-- 하는 쿼리 작성, 주소가 없으면 city, state에 null로 출력
select p.firstName, p.lastName, a.city, a.state
from Person p 
	left join Address a on p.personId = a.personId;
    
-- 서브쿼리로 풀어보기
select p.firstName, 
	   p.lastName, 
	   (select city from Address where personId = p.personId) as city, 
       (select state from Address where personId = p.personId) as state
from Person p;
