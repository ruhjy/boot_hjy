create database leetcode181;
use leetcode181;

create table Employee (
	id int primary key,
    name varchar(200),
    salary int,
    managerId int
);

insert into Employee
values 
	(1, 'Joe', 70000, 3),
	(2, 'Henry', 80000, 4),
	(3, 'Sam', 60000, Null),
	(4, 'Max', 90000, Null)
;
select * from Employee;

-- 문제) 매니저보다 많은 연봉받는 직원 이름 조회
select e1.name as Employee
from Employee e1 
	join Employee e2 on e1.managerId = e2.id
where e1.salary > e2.salary;

-- 서브 쿼리
select name as Employee
from Employee e1
where salary > (select salary 
				from Employee e2
                where e2.id = e1.managerId);