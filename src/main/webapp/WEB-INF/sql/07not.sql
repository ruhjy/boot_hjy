-- NOT
select * from Customers; -- 91
select * from Customers where Country = 'Germany'; -- 11
select * from Customers where not Country = 'Germany'; -- 80

-- London에 있지 않는 고객들 조회
select * from Customers where not City = 'London';

-- 50년대 생이 아닌 직원들 조회
select * from Employees where BirthDate >= '1950-01-01' and BirthDate <= '1959-12-31';
select * from Employees 
where not (BirthDate >= '1950-01-01' and BirthDate <= '1959-12-31');

select * from Employees
where BirthDate < '1950-01-01' or BirthDate > '1959-12-31';

-- 1,2번 카테고리가 아닌 상품들
select * from Products where CategoryID = 1 or CategoryID = 2;
select * from Products where not (CategoryID = 1 or CategoryID = 2);
select * from Products where CategoryID <> 1 and CategoryID <> 2;